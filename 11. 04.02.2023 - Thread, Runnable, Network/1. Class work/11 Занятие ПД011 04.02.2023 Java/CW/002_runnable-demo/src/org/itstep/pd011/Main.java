package org.itstep.pd011;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Работаем с потоками, с использованием объектов, реализующих интерфейс Runnable
public class Main {

    public static void main(String[] args) {
        System.out.println("main: запуск главного потока");
        try {
            // demo1();
            demo2();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
        System.out.println("main: главный поток завершен");
    } // main

    // пример работы с именованными объектами класса Thread, использующими
    // для создания потока объекты, реализующие интерфейс Runnable
    private static void demo1() throws InterruptedException {
        // создаем потоки с использованием объектов, реализующих интерфейс Runnable
        Thread thread1 = new Thread(new Demo1Runnable("\033[34m"));
        Thread thread2 = new Thread(new Demo1Runnable("\033[35m"));
        Thread thread3 = new Thread(new Demo2Runnable());
        Thread thread4 =new Thread(() -> {
            System.out.println("Поток в лямбда-выражении стартовал!");
            Utils.sleep(1_500);
            System.out.println("Поток в лямбда-выражении финишировал!");
        });

        // запуск потоков
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // ожидание завершения работы потоков
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    } // demo1

    // пример работы с анонимными объектами класса Thread, использующими
    // для создания потока объекты, реализующие интерфейс Runnable
    private static void demo2() throws InterruptedException {
        // коллекция анонимных объектов
        List<Thread> threadList = new ArrayList<>(Arrays.asList(
            new Thread(new Demo1Runnable("\033[34m")),
            new Thread(new Demo1Runnable("\033[35m")),
            new Thread(new Demo2Runnable()),
            new Thread(() -> {
                System.out.println("Поток в лямбда-выражении стартовал!");
                Utils.sleep(1_500);
                System.out.println("Поток в лямбда-выражении финишировал!");
            })
        ));

        // запускаем потоки
        for(Thread thread:threadList) thread.start();

        // ждем их завершения
        for(Thread thread:threadList) thread.join();
    } // demo2
}
