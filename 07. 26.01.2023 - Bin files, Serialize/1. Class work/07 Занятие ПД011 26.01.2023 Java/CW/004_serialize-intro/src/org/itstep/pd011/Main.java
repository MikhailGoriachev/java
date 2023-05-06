package org.itstep.pd011;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        // файл для сериализации, создание папки при необходимости
        // папка создается только при жестком задании пути "папка/файл"
        String fileName = "app_data/classA.dat";
        File dir = new File(fileName.substring(0, fileName.indexOf("/")));
        if (!dir.exists()) dir.mkdir();

        // Объект выполняющий сохранение/восстановление
        Serializer sz = new Serializer(fileName);

        // восстановить состояние приложения - если есть файл сохранения
        // или создать объект для работы приложения
        ClassA obj;
        File file = new File(fileName);
        if (file.exists()) {
            obj = sz.deserialize();
            System.out.printf("\nВосстановленное состяние obj: %s\n", obj);
        } else {
            // Объект для сохранения/восстановления
            obj = new ClassA(-1, "Это строка", Math.PI);
            System.out.printf("\nИсходное состяние obj       : %s\n", obj);
        } // if

        // сохранение в файл - сериализация
        obj.setB1(10_000.);
        System.out.printf("Поменяли поле b1 в obj      : %s\n", obj);
        sz.serialize(obj);

        // изменение объекта
        obj.setAnInt(102);
        obj.setStr("Это новая строка");
        obj.setaDouble(Math.E);
        obj.setB1(-100.);
        System.out.printf("Измененное состояние obj    : %s\n", obj);

        // восстановить объект из файла - провести десериализацию
        obj = sz.deserialize();
        System.out.printf("Восстановлено состояние obj : %s\n", obj);
    } // main

} // class Main
