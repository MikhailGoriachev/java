package org.itstep.pd011;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;

// передача файла через UDP - запускать это приложение вторым, после запуска
// udp_receiver
public class Main {

    public static void main(String[] args) {
        String fileName = "app_data/kengooro.jpg";

        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            byte[] data = new byte[1024];

            // UDP - работа с датаграммами
            DatagramSocket datagramSocket = new DatagramSocket();

            // адрес и порт получателя
            InetAddress address = InetAddress.getLocalHost();
            int port = 8033;

            DatagramPacket packet;

            System.out.println("отправка файла...");
            while (inputStream.read(data) != -1) {                             // data reading...
                packet = new DatagramPacket(data, data.length, address, port); // packet making...
                datagramSocket.send(packet);                                   // data sending
            }

            System.out.println("файл успешно отправлен");
        } catch (UnknownHostException e) {
            e.printStackTrace(); // invalid recipient address
        } catch (SocketException e) { // errors during data transfer
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
