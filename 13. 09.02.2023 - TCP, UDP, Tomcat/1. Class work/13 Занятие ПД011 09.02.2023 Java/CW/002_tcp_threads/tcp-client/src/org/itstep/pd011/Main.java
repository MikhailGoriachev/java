package org.itstep.pd011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    final static int TIMEOUT_IN_MILLIS = 1_000;
    final static int MAX_PING = 10;
    final static String ORIGINAL_MESSAGE = "PING";

    public static void main(String[] args) {

        // Еще один подход для работы с сервером - одно подключение с паузой
        // для готовности сервера
        // InetAddress.getLocalHost() - имеется в виду IP сервера
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8071);
             PrintStream printStream = new PrintStream(socket.getOutputStream());
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // цикл обмена с сервером
            for (int i = 0; i < MAX_PING; i++) {
                // отправка команды серверу
                printStream.println(ORIGINAL_MESSAGE);

                // чтение ответа от сервера
                System.out.println(reader.readLine());

                // тайм-аут для сервера - чтобы сервер был готов к следующей команде
                Thread.sleep(TIMEOUT_IN_MILLIS);
            } // for i
        } catch (UnknownHostException e) {
            System.err.println("Connection refused:" + e); // not connect to the server
        } catch (InterruptedException | IOException e) {   // InterruptedException - Thread.sleep()
            e.printStackTrace();
        } // try-catch
    } // main
} // class Main
