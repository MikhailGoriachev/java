package org.itstep.pd011;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

// сериализация в XML/десериализация из XML
public class Main {

    public static void main(String[] args) {
        System.out.println("XML-сериализация");
        String folderName = "app_data";      // папка для сериализация
        String fileName = "student.xml";     // файл для сериализация

        try {
            File folder = new File(folderName);
            if (!folder.exists()) folder.mkdir();

            // данные для сериализации
            Student student = new Student("Иванов Т.Л.", 555777, "VKL_1410");
            System.out.println(student);

            // Статические поля не сериализуются.
            // Поля со спецификатором transient сериализуются в XML
            try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(folderName + "/" + fileName)))) {

                // запись объекта
                xmlEncoder.writeObject(student);

                // принудительно пишем в накопитель
                xmlEncoder.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } // try-catch

            System.out.println("\nИзменение данных:");
            student = new Student();
            System.out.println(student);

            System.out.println("\nXML-десериализация");
            try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                    new FileInputStream(folderName + "/" + fileName)))) {
                student = (Student) xmlDecoder.readObject();
                System.out.println(student);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } // try-catch

        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // main
} // class Main
