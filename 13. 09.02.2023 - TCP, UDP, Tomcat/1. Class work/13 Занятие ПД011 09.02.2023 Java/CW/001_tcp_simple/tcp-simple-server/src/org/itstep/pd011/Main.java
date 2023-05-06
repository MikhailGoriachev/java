package org.itstep.pd011;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    // передача клиенту строки
    public static void main(String[] args) {
        System.out.println("старт сервера");

        // ServerSocket - сокет прослушивания запросов клиента
        try (ServerSocket serverSocket = new ServerSocket(2048)) {
            server(serverSocket);
        } catch (IOException e) {
            System.err.println("IO error connection: " + e);
        }

        System.out.println("финиш сервера");
    } // main

    private static void server(ServerSocket serverSocket) throws IOException {
        // цикл получения команд от клиентов
        while(true) {

            try (
                    // Socket - сокет для обмена информации с клиентом
                    Socket socket = serverSocket.accept();

                    // прием команды от клиента
                    Scanner reader = new Scanner(socket.getInputStream());

                    // поток для ответов клиенту
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                // читать строку от сервера целиком
                String inputText = reader.nextLine();

                // читать строку от сервера о первого разделителя
                // String inputText = reader.next();
                System.out.println("\033[1;32m" + inputText + "\033[0m");

                // выход из цикла - по команде shutdown
                if (inputText.equals("shutdown")) {
                    // вывод ответа клиенту в сеть
                    writer.println("завершение работы сервера");
                    writer.flush();
                    break;
                } // if

                if (inputText.equals("quit")) {
                    // вывод ответа клиенту в сеть
                    writer.println("завершение сеанса обмена с клиентом");
                    writer.flush();
                } // if

                // передача данных клиенту
                writer.println("Ответ сервера на запрос \"" + inputText + "\":  Java network is coming...");

                // гарантированная передача буфера
                writer.flush();
            } // try
        } // while
    }
} // class Main
