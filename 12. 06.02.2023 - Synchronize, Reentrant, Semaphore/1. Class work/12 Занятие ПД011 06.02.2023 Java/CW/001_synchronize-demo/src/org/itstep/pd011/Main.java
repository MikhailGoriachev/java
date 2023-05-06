package org.itstep.pd011;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // количество обрабатываемых потоков
    private static final int n = 5;

    public static void main(String[] args) {
        // символ с кодом Alt+0151
        final String SPLITTER = "\n———————————————————————————————————————\n";

        try {

            // работа без синхронизации
            // nonSynchronize();
            // System.out.println(SPLITTER);

            // синхронизация в блоке
            // blockSynchronize();
            // System.out.println(SPLITTER);

            // синхронизация в методе
            methodSynchronize();
            System.out.println(SPLITTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // main

    // работа без синхронизации
    private static void nonSynchronize() throws InterruptedException {
        // общий ресурс для потоков
        CommonResource res = new CommonResource();
        List<ThreadA> threads = new ArrayList<>();

        // формирование коллекции потоков
        for (int i = 0; i < n; i++) {
            threads.add(new ThreadA(res, "nonsynchro" + (i + 1)));
        } // for i

        // запуск потоков
        threads.forEach(Thread::start);

        // ожидание завершения потоков
        for (ThreadA thread : threads) thread.join();
    } // nonSynchronize

    // синхронизация по блоку данных - общему ресурсу
    private static void blockSynchronize() throws InterruptedException {
        CommonResource res = new CommonResource();
        List<ThreadB> threads = new ArrayList<>();

        // формирование коллекции потоков
        for (int i = 0; i < n; i++) {
            threads.add(new ThreadB(res, "block" + i));
        } // for i

        // запуск потоков
        threads.forEach(Thread::start);

        // ожидание завершения потоков
        for (ThreadB thread : threads) {
            thread.join();
        } // for each
    } // blockSynchronize

    // синхронизация по методу
    private static void methodSynchronize() throws InterruptedException {
        CommonResMethod res = new CommonResMethod();
        List<ThreadC> threads = new ArrayList<>();

        // формирование коллекции потоков
        for (int i = 0; i < n; i++) {
            threads.add(new ThreadC(res, "method" + i));
        } // for i

        // запуск потоков
        threads.forEach(Thread::start);

        // ожидание завершения потоков
        for (ThreadC thread : threads) {
            thread.join();
        } // for each
    } // methodSynchronize
} // class Main
