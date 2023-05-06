package org.itstep.pd011;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// синхронизация с использованием объектов класса ReentrantLock
public class Main {

    public static void main(String[] args) {
        try {
            // блок синхронизации
            // blockSynchronize();
            // System.out.println("\n————————————————————————————————————————\n");

            // синхронный метод
            methodSynchronize();
            System.out.println("\n————————————————————————————————————————\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // main

    // синхронизация с использованием блока кода - критической секции
    private static void blockSynchronize() throws InterruptedException {
        // создание объекта блокировки
        Lock locker = new ReentrantLock();

        // создание объекта общего ресурса
        CommonResource res = new CommonResource();

        // коллекция ссылок на потоки исполнения, выполняющие, например,
        // запросы к базе данных
        List<ThreadB> threads = new ArrayList<>();

        // создание коллекции потоков, передача потокам ссылки на общий
        // ресурс и блокировщик
        for (int i = 0; i < 5; i++) {
            threads.add(new ThreadB(res, locker, "block" + (i + 1)));
        } // for i

        for (ThreadB thread : threads) {  thread.start(); } // for thread
        for (ThreadB thread : threads) {  thread.join();  } // for thread
    } // blockSynchronize

    // синхронизация с использованием синхронного метода
	// синхронный метод - в общем ресурсе CommonResMethod
    private static void methodSynchronize() throws InterruptedException {
        Lock locker = new ReentrantLock();
        CommonResMethod res = new CommonResMethod(locker);
        List<ThreadC> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            threads.add(new ThreadC(res, "method" + i));
        } // for i

        // запуск всех потоков - параллельное исполнение
        threads.forEach(Thread::start);

        for (ThreadC thread : threads) {
            thread.join();
        } // for each
    } // methodSynchronize
} // class Main
