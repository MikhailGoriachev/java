package org.itstep.pd011;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Thread threadMain = Thread.currentThread();
        long id = threadMain.threadId();
        String name = threadMain.getName();
        System.out.printf("\n\033[34;1m%s(%d): стартовал\033[0m\n\n", name, id);

        // Запуск двух потоков без параметров
        // doTwoThread();

        // запуск анонимных потоков c параметром
        // doManyThreads();

        // запуск потоков с параметром из коллекции
        doListThreads();

        System.out.printf("\n\033[34;1m%s(%d): финишировал\033[0m\n", name, id);
    } // main


    // Запуск двух потоков
    private static void doTwoThread() {
        try {
            // создание объектов, умеющих запускать потоки выполнения
            ClassA thread1 = new ClassA("thread1");
            ClassA thread2 = new ClassA("thread2");

            // сделать потоки фоновыми (C# background)
            // тогда система не ожидает завершения потоков перед
            // завершением приложения
            // thread1.setDaemon(true);
            // thread2.setDaemon(true);

            // старт потоков - параллельная работа потоков
            thread1.start();
            thread2.start();

            // ожидание завершения потоков - не обязательны для потоков
            // переднего плана, чаще всего необходимо для фоновых потокоа
            thread1.join();
            thread2.join();

            // как-бы ожидание завершения фоновых потоков...
            // Thread.sleep(1_000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } // catch
    } // doTwoThread

    // запуск анонимных потоков c параметром
    private static void doManyThreads() {
        String tab = "\t\t";
        for (int i = 0; i < 5; i++) {
            // создать объект класса потока и запустить поток
            new ClassB(tab).start();
            tab += "\t\t";
        } // for i
    } // doManyThreads

    // запуск потоков с параметром из коллекции
    private static void doListThreads() {
        System.out.println("\n\033[32;1mdoListThread: старт\033[0m");
        try {
            List<ClassB> threads = new ArrayList<>();
            String tab = "\t\t";

            for (int i = 0; i < 3; i++) {
                // создать объект класса потока и добавить в коллекцию потоков,
                // параметры потокам передаем через конструктор
                var t = new ClassB(tab);
                t.setDaemon(true);
                threads.add(t);
                tab += "\t\t";
            } // for i

            // запустить все потоки из коллекции
            // threads.forEach(t -> t.start());
            threads.forEach(ClassB::start); // ClassB extends Thread - потому и допустимо вызывать start()

            // присоединиться к потокам - ожидать завершения
            // thread.join() должен быть обернут try-catch, поэтому
            // реализовывать через threads.forEach(t -> t.join()) особого смысла нет
            for (var thread : threads) {
                thread.join();
            } // foreach
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
        System.out.println("\n\033[32;1mdoListThread: финиш\033[0m");
    } // doManyThreads
} // class Main
