package org.itstep.pd011;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

// получение клиентом строки
public class Main {

    public static void main(String[] args) {
        System.out.println("старт клиента");
        String[] commands = {"hello", "привет, сервер", "date", "quit", "shutdown"};

        InetAddress ipServer = null;
        int port = 2048;

        try {
            ipServer = InetAddress.getLocalHost();

            // передача на сервер строки - команды
            // для чтения команд на сервере при помощи Scanner завершаем строку \n
            for (String command : commands) {
                client(ipServer, port, command);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        System.out.println("финиш клиента");
    }

    private static void client(InetAddress localHost, int port, String command) {
        // подключение к серверу - по IP и порту, подготовка к чтению
        // InetAddress.getLocalHost() - имеется в виду IP сервера
        try (Socket socket = new Socket(localHost, port);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // отправить запрос на сервер
            writer.write(command);
            writer.newLine();  // передать признак конца строки
            writer.flush();

            // получить ответ на запрос от сервера,
            // чтение строки, полученной от сервера
            String message = reader.readLine();
            System.out.println("от сервера получено: \033[34;1m" + message + "\033[0m");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
