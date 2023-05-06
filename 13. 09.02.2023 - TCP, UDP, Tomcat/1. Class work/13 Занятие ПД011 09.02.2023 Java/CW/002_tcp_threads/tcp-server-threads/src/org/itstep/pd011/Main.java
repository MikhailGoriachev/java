package org.itstep.pd011;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8071)) {
            System.out.println(serverSocket.getInetAddress() + " server started");

            while (true) {
                // waiting for a new client
                // ожидание входящего запроса клиента
                Socket socket = serverSocket.accept();
                System.out.printf("%s connected", socket.getInetAddress().getHostName());

                // create a separate stream for data exchange with the connected client
                // создание нового потока исполнения для работы с запросом клиента
                ServerThread thread = new ServerThread(socket);
                thread.start();
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        } // try-catch
    } // main
} // class Main


