package org.client.app.controllers;

import org.client.app.utils.Utils;

import javax.swing.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;


// Контроллер Задание 1
public class Task01Controller implements Runnable {

    // порт сервера
    public final int PORT = 9099;

    // сокет сервера
    Socket server;

    // поток отправки
    PrintStream output;

    // поток приёма
    BufferedReader input;


    // меню данных
    @Override
    public void run() {
        var buttons = new Object[]{
                "time",
                "date",
                "files",
                "sin",
                "solve",
                "quit",
                "udp",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1";

        Runnable[] commands = new Runnable[]{
                this::time,
                this::date,
                this::files,
                this::sin,
                this::solve,
                this::quit,
                this::udp,
        };

        int select;
        try (var server = this.server = new Socket(InetAddress.getLocalHost(), PORT);
             var output = this.output = new PrintStream(server.getOutputStream());
             var input = this.input = new BufferedReader(new InputStreamReader(server.getInputStream()))
        ) {
            while (true) {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();

            }
        } catch (Exception exception) {
            Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
        }
    }

    // time – сервер возвращает время на сервере в формате ЧЧ:ММ:СС
    private void time() {
        Utils.showWindow("<html><h3>Команда time</h3><h4>Ответ: </h4>" + sendAndGetData("time"),
                "Задание 1 > time", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // date – сервер возвращает дату на сервере в формате ДД.ММ.ГГГГ
    private void date() {
        Utils.showWindow("<html><h3>Команда date</h3><h4>Ответ: </h4>" + sendAndGetData("date"),
                "Задание 1 > date", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // files – сервер возвращает имена файлов папки app_data приложения, формат ответа сервера: имена файлов,
    // разделенные символом «;». Если файлов в папке нет – возвращаем строку «:: no files found ::»
    private void files() {
        Utils.showWindow("<html><h3>Команда files</h3><h4>Ответ: </h4>" + sendAndGetData("files"),
                "Задание 1 > files", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // sin a – где a – вещественное число, некоторый угол в градусах, точность 4 знака в дробной части. Сервер
    // возвращает синус угла с точностью 4 знака в дробной части
    private void sin() {
        var num = Utils.getDouble(5, 10);
        Utils.showWindow(String.format("<html><h3>Команда sin %.4f</h3><h4>Ответ: %s</h4>", num,
                        sendAndGetData(String.format("sin %.4f", num))),
                "Задание 1 > sin", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // solve a b c – где a, b, c – вещественные числа, сервер возвращает корни квадратного уравнения ax2 + bx + c = 0 с точностью 4 знака в дробной части в виде:
    // •	если есть два вещественных корня: x1 = корень1, x2 = корень2
    // •	если есть один вещественный корень: x1 = x2 = корень
    // •	если нет вещественных корней: x1 = x2 = none
    // •	при ошибке в формате числовых коэффициентов SOLVE: ILLEGAL DATA
    private void solve() {
        double a = Utils.getDouble(-5, 5), b = Utils.getDouble(10, 20), c = Utils.getDouble(5, 10);
        Utils.showWindow(String.format("<html><h3>Команда solve %.4f %.4f %.4f</h3><h4>Ответ: %s</h4>", a, b, c,
                        sendAndGetData(String.format("solve %.4f %.4f %.4f", a, b, c))),
                "Задание 1 > solve", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // quit – завершение работы сервера
    private void quit() {
        Utils.showWindow("<html><h3>Команда quit</h3><h4>Ответ: </h4>" +
                         sendAndGetData("quit"),
                "Задание 1 > quit", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // дополнительно: udp имяФайла – клиент по протоколу UDP передает из папки app_data файл в формате mp3, сервер его принимает в свою папку app_data. При этом собственно команда передается по TCP протоколу, прием файла выполняется сервером по UDP-протоколу в отдельном потоке исполнения
    private void udp() {
        
        // название файла
        final var FILE_NAME = "song.mp3";

        new Thread(() -> {
            
            // название файла с путём к нему
            final var FILE_PATH_NAME = "app_data/" + FILE_NAME;
            
            try (var stream = new FileInputStream(FILE_PATH_NAME);
                 var socketOutput = new DatagramSocket()) {

                // размер буфера
                final int PACKET_SIZE = 1024;

                // буфер для чтения
                byte[] buffer = new byte[PACKET_SIZE];

                // ip-адрес сервера
                var ip = this.server.getInetAddress();

                // размер файла
                final long FILE_SIZE = new File(FILE_PATH_NAME).length();

                // отправка размера файла и пакетов
                if (sendAndGetData(String.format("%d %d", FILE_SIZE, PACKET_SIZE)).equals("ok")) {

                    // порт сервера
                    final int SERVER_PORT = 9095;

                    // пакет
                    DatagramPacket packet;
                    
                    // чтение данных из файла
                    while (stream.read(buffer) != -1) {
                        // ожидание готовности
                        Thread.sleep(5);
                        
                        // создание пакета
                        packet = new DatagramPacket(buffer, buffer.length, ip, SERVER_PORT);
                        
                        // отправка данных
                        socketOutput.send(packet);
                    }
                }                
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        Utils.showWindow("<html><h3>Команда udp</h3><h4>Начата отправка файла: " + FILE_NAME +
                         "</h4>" + sendAndGetData("udp " + FILE_NAME),
                "Задание 1 > udp", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // отправить и получить данные
    private String sendAndGetData(String query) {
        try {
            output.println(query);
            output.flush();
            return input.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }
}

