package org.server.app.models;


import org.server.app.utils.Colors;
import org.server.app.utils.Utils;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

// Класс Серверный поток обработки
public class ServerThread extends Thread {

    // сокет клиента
    private final Socket client;


    // конструктор инициализирующий
    public ServerThread(Socket client) {
        this.client = client;
    }

    
    @Override
    public void run() {
        try (PrintStream output = new PrintStream(client.getOutputStream());
             BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {

            var ip = client.getInetAddress();

            String query;

            while ((query = input.readLine()) != null) {

                System.out.println(Utils.getTime() + Colors.GREEN_BOLD_BRIGHT + "клиент " + ip + ": " + query + "\n");

                var words = query.split(" ");

                var command = words[0];

                // получение файла по udp
                if (command.equals("udp")) {
                    udp(input, output, words[1]);
                    continue;
                }

                var response = switch (command) {
                    case "time" -> time();
                    case "date" -> date();
                    case "files" -> files();
                    case "sin" -> sin(Double.parseDouble(words[1]));
                    case "solve" ->
                            solve(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
                    case "quit" -> quit();
                    default -> throw new IllegalStateException("Unexpected value: " + command);
                };

                output.println(response);

                if (command.equals("quit")) {
                    System.out.println(Utils.getTime() + Colors.CYAN_BOLD_BRIGHT + "сервер остановлен" + Colors.RESET + "\n");
                    System.exit(0);
                }

                System.out.println(Utils.getTime() + Colors.BLUE_BOLD_BRIGHT + "ответ для " + ip + ": " + response + "\n");
            }

            System.out.println(Utils.getTime() + Colors.RED_BOLD_BRIGHT + "клиент отсоединился: " + ip + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // time – сервер возвращает время на сервере в формате ЧЧ:ММ:СС
    private String time() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    // date – сервер возвращает дату на сервере в формате ДД.ММ.ГГГГ
    private String date() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    // files – сервер возвращает имена файлов папки app_data приложения, формат ответа сервера: имена файлов, 
    // разделенные символом «;». Если файлов в папке нет – возвращаем строку «:: no files found ::»
    private String files() {

        var directory = new File("app_data");

        String[] files = directory.list();

        if (!directory.isDirectory() && (files == null || files.length == 0))
            return ":: no files found ::";

        StringBuffer sb = new StringBuffer();

        Arrays.stream(files)
                .forEach(f -> sb.append(f).append(";"));

        return sb.toString();
    }

    // sin a – где a – вещественное число, некоторый угол в градусах, точность 4 знака в дробной части. Сервер 
    // возвращает синус угла с точностью 4 знака в дробной части
    private String sin(double a) {
        return String.format("%.4f", Math.sin(Math.toRadians(a)));
    }

    // solve a b c – где a, b, c – вещественные числа, сервер возвращает корни квадратного уравнения ax2 + bx + c = 0 с точностью 4 знака в дробной части в виде:
    // •	если есть два вещественных корня: x1 = корень1, x2 = корень2
    // •	если есть один вещественный корень: x1 = x2 = корень
    // •	если нет вещественных корней: x1 = x2 = none
    // •	при ошибке в формате числовых коэффициентов SOLVE: ILLEGAL DATA
    private String solve(double a, double b, double c) {
        if (Utils.doubleEquals(a, 0))
            return "x1 = x2 = none";

        var dis = (b * b) - 4d * a * c;

        var countRoots = dis > 0 ? 2 : dis == 0 ? 1 : 0;

        return switch (countRoots) {
            case 1 -> {
                var x1 = (-b) / (2d * a);
                yield String.format("x1 = x2 = %.4f", x1);
            }
            case 2 -> {
                var x1 = (-b + Math.sqrt(dis)) / (2d * a);
                var x2 = (-b - Math.sqrt(dis)) / (2d * a);
                yield String.format("x1 = %.4f, x2 = %.4f", x1, x2);
            }
            default -> "x1 = x2 = none";
        };
    }

    // quit – завершение работы сервера
    private String quit() {
        return "сервер остановлен\n";
    }

    // дополнительно: udp имяФайла – клиент по протоколу UDP передает из папки app_data файл в формате mp3, сервер
    // его принимает в свою папку app_data. При этом собственно команда передается по TCP протоколу, прием файла 
    // выполняется сервером по UDP-протоколу в отдельном потоке исполнения
    private void udp(BufferedReader inputTcp, PrintStream outputTcp, String fileName) throws IOException {

        // отправляем сигнал, о том, что готовы получить размер файла
        outputTcp.println("ok");

        // получение размера файла и пакетов
        var response = inputTcp.readLine().split(" ");

        // размер файла
        final int sizeFile = Integer.parseInt(response[0]);
        
        // размер пакетов
        final int sizePacket = Integer.parseInt(response[1]);

        // отправляем сигнал, о том, что готовы получить файл
        outputTcp.println("ok");

        // порт UDP, который будет слушать сервер
        final int PORT = 9095; 
        
        // директория для сохранения файла
        final String DIR = "app_data/";
        
        try (var stream = new FileOutputStream(DIR + fileName);
             var socketInput = new DatagramSocket(PORT)) {

            // установка времени ожидания
            socketInput.setSoTimeout(10_000);
            
            // буфер
            var buffer = new byte[sizePacket];

            // пакет для получения данных
            var packet = new DatagramPacket(buffer, buffer.length);

            // количество полученных байт
            var countBytes = 0;

            while (countBytes < sizeFile) {
                
                // получение пакета
                socketInput.receive(packet);
                
                // запись данных в файл
                stream.write(buffer);
                stream.flush();
                
                countBytes += sizePacket;
            }

            // обрезка файла по его оригинальному размеру 
            // (т.к. размер последнего пакета может быть меньше размера буфера)
            try (var file = new RandomAccessFile(new File(fileName), "rw")) {
                file.setLength(sizeFile);
            }

            // вывод сообщения об окончании загрузки файла
            System.out.println(Utils.getTime() + Colors.BLUE_BOLD_BRIGHT + "файл " + fileName + " загружен" + Colors.RESET + "\n");
        }
    }
}