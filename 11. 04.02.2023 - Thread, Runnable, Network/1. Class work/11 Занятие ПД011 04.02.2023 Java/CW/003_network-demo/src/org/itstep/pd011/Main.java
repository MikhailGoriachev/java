package org.itstep.pd011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        // demoInetAddress();

        // пример IP существующего хоста
        byte ip[] = {(byte) 104, (byte) 22, (byte) 7, (byte) 139};

        // пример IP НЕ существующего хоста
        // byte ip[] = {(byte) 14, (byte) 22, (byte) 7, (byte) 250};
        // demoHostNameByIp(ip);

        // чтение документа из интернета
        // String urlName = "https://logging.apache.org/log4j/2.x/download.html";
        // String urlName = "https://www.cbr-xml-daily.ru/daily_utf8.xml";
        // String urlName = "http://lib.ru/";  // удаленный сервер может сам определить имя файла
        // readHtmlDoc(urlName);

        // получение информации об Интернет-ресурсе
        String urlName1 = "https://ya.ru_/";
        // String urlName1 = "https://vk.com/";
        // String urlName1 = "http://lib.ru/";
        demoInfoAboutInetResource(urlName1);
    } // main

    // получение IP-адресов - класс InetAddress
    public static void demoInetAddress() {
        InetAddress currentIp;
        InetAddress itStep;

        try {
            // получить свой IP-адрес
            currentIp = InetAddress.getLocalHost();

            // выводим IP-адрес локального узла
            System.out.println("Текущий IP -> " + currentIp.getHostAddress());

            // получить IP по DNS-имени узла
            itStep = InetAddress.getByName("itstep.org");
            System.out.println("IP удаленного хоста IT Step IP address -> " + itStep.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } // try-catch

        System.out.println();
    } // demoInetAddress

    // назначение фиктивного имени хоста по его ip
    public static void demoHostNameByIp(byte[] ip) {
        try {
            // назначить фиктивное имя хосту по его IP
            InetAddress addr = InetAddress.getByAddress("myname", ip);
            System.out.println(addr.getHostName() + "-> connection: " + addr.isReachable(1_000));
        } catch (UnknownHostException e) {
            System.err.println("address unavailable: " + e);
        } catch (IOException e) {
            System.err.println("I/O exception: " + e);
        } // try-catch

        System.out.println();
    } // demoHostNameByIp

    // чтение документа из Интернета
    public static void readHtmlDoc(String urlName) {
        try {
            // создать объект для работы с URL
            URL url = new URL(urlName);

            // вывести метаданные удаленного узла
            System.out.println("protocol: " + url.getProtocol());
            System.out.println("host: " + url.getHost());
            System.out.println("port: " + url.getDefaultPort());
            System.out.println("file: " + url.getFile() + "\n");

            // открыть поток чтения по URL --> new URL(urlName).openStream()
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {

                // построчное чтение данных, используем Stream API, lines() - поток данных Stream<String>
                reader.lines().forEach(System.out::println); // reading content
            } // try
        } catch (MalformedURLException e) {
            System.out.println("\n\tНекорректный протокол, домен или имя файла\n");;
        } catch (IOException e) {
            e.printStackTrace();
        } // try-catch
    } // readHtmlDoc

    // информация об интернет-ресурсе
    public static void demoInfoAboutInetResource(String urlName) {

        // 10 с
        int timeout = 10_000;
        try {
            // создать объект для работы с URL
            URL url = new URL(urlName);

            // connect() может привести к блокировке, поэтому устанавливаем тайм-аут
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(timeout);//set timeout for connection
            connection.connect();

            System.out.println(urlName + "::content type:"+ connection.getContentType());
            System.out.printf("Размер контента в байтах: %d\n", connection.getContentLengthLong());
            System.out.printf("Заголовок host:  %s\n", connection.getHeaderField("host"));
            System.out.printf("Заголовок server:  %s\n", connection.getHeaderField("server"));
            System.out.printf("Заголовок date:  %s\n", connection.getHeaderField("date"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    } // demoInfoAboutInetResource
}
