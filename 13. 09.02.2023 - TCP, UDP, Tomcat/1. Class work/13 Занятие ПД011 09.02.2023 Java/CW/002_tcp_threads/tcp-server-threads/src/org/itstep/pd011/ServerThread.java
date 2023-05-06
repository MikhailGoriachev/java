package org.itstep.pd011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

class ServerThread extends Thread {
    private PrintStream printStream; // send
    private BufferedReader reader;   // receive
    private InetAddress address;     // client address

    public ServerThread(Socket socket) {
        // TODO: перенести в run() при помощи try() {}
        try {
            printStream = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }  // try-catch

        address = socket.getInetAddress();
    } // ServerThread

    // функционал сервера - в отдельном потоке
    @Override
    public void run() {
        int counter = 0;
        String message;

        try {
            // получение null - признак завершения обмена
            while ((message = reader.readLine()) != null) {
                if ("PING".equals(message)) {
                    printStream.println("PONG #" + ++counter);
                } // if
                System.out.println("PING-PONG #" + counter + " from " + address.getHostName());
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        } // try-catch-finally
    } // run

    // отключение сервера
    private void disconnect() {
        if (printStream != null) {
            printStream.close();
        }

        try {
            if (reader != null) {
                reader.close();
            }
            System.out.println(address.getHostName() + ": disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // disconnect
}

