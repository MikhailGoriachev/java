package org.server.app.controllers;

import org.server.app.models.ServerThread;
import org.server.app.utils.Colors;
import org.server.app.utils.Utils;

import java.net.ServerSocket;

// Класс Контроллер сервера 
public class ServerController implements Runnable {

    @Override
    public void run() {
        try (var server = new ServerSocket(9099)) {
            System.out.println(Utils.getTime() + Colors.CYAN_BOLD_BRIGHT + "сервер запущен. port: " + server.getLocalPort() + Colors.RESET + "\n");

            while (true) {
                var client = server.accept();

                System.out.println(Utils.getTime() + Colors.PURPLE_BOLD_BRIGHT + "клиент присоединился: " + client.getInetAddress() + Colors.RESET + "\n");

                new ServerThread(client).start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
