package org.homework.app.controllers;

import org.homework.app.models.task02.Consumer;
import org.homework.app.models.task02.Producer;
import org.homework.app.models.task02.Store;
import org.homework.app.utils.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Контроллер Задание 1
public class Task02Controller implements Runnable {

    // работа по заданию
    public void run() {

        try {

            createAndInitialization("app_data/numbers.txt");

            // вариант с тремя ресурсами, для работы по парам 
            var store = new Store();

            final int limit = 64;

            var threads = new ArrayList<>(List.of(
                    new Thread(new Consumer(store, limit)),
                    new Thread(new Producer(store, limit))
            ));

            // запуск потоков
            threads.forEach(Thread::start);

            // привязка для ожидания
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // создание и заполнение файла
    public void createAndInitialization(String fileName) throws IOException {
        try (var stream = new PrintWriter(new FileWriter(fileName))) {
            
            final int min = 12, max = 18;
            
            Arrays.stream(new Double[Utils.getInt(min, max + 1)])
                    .map(d -> Utils.getDouble(10, 20))
                    .forEach(stream::println);
        }
    }
}