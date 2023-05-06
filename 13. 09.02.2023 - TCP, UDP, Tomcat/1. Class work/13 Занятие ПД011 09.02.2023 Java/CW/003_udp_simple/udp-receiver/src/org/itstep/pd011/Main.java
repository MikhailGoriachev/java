package org.itstep.pd011;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

// прием файла по UDP, запускается первым
public class Main {

    // тайм-аут принятия решения о завершении приема
    // если в течение заданного времени нет приема, 
    // выход из цикла приема
    final static int WAIT_TIMEOUT = 10_000;

    public static void main(String[] args) {
        File file = new File("app_data/photo.jpg");

        acceptFile(file, 8033, 1024);
        System.out.println("прием данных завершен");
    } // main

    // получение файла по UDP
    private static void acceptFile(File file, int port, int pacSize) {
        System.out.println("получение данных...");

        byte data[] = new byte[pacSize];
        // построить пакет UDP, в качестве блока данных будет использоваться массив data
        // (пакет использует ссылку на массив)
        DatagramPacket packet = new DatagramPacket(data, data.length);

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            // сокет для получения информации
            DatagramSocket datagramSocket = new DatagramSocket(port);
            datagramSocket.setSoTimeout(WAIT_TIMEOUT);

            while (true) {
                datagramSocket.receive(packet);  // читаем пакет из сети
                outputStream.write(data);        // записать данные пакета в файл
                // System.out.printf("%d\n", data.length);
                outputStream.flush();
            } // while
        } catch (SocketTimeoutException e) {
            System.err.println("Timed out, data reception is finished: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } // try-catch

        System.out.println("работа acceptFile завершена");
    } // acceptFile
} // class Main
