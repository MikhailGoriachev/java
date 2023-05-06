package org.homework.app.controllers;

import org.homework.app.models.task01.Consumer;
import org.homework.app.models.task01.Producer;
import org.homework.app.models.task01.Store;
import org.homework.app.utils.Utils;

import java.util.ArrayList;
import java.util.List;


// Контроллер Задание 1
public class Task01Controller implements Runnable {

    // работа по заданию
    public void run() {

        try {
            // вариант с одним ресурсом
//        var store = new Store<Number>();
//
//        var consumers = new ArrayList<>(List.of(
//                new Thread(new Consumer(store, 1)),
//                new Thread(new Consumer(store, 2)),
//                new Thread(new Consumer(store, 3))
//        ));
//
//        var producers = new ArrayList<>(List.of(
//                new Thread(new Producer(store, Utils.getInt(10, 50), 1)),
//                new Thread(new Producer(store, Utils.getInt(10, 50), 2)),
//                new Thread(new Producer(store, Utils.getInt(10, 50), 3))
//        ));


            // вариант с тремя ресурсами, для работы по парам 
            var store1 = new Store<Number>();
            var store2 = new Store<Number>();
            var store3 = new Store<Number>();

            var consumers = new ArrayList<>(List.of(
                    new Thread(new Consumer(store1, 1)),
                    new Thread(new Consumer(store2, 2)),
                    new Thread(new Consumer(store3, 3))
            ));

            var producers = new ArrayList<>(List.of(
                    new Thread(new Producer(store1, Utils.getInt(10, 50), 1)),
                    new Thread(new Producer(store2, Utils.getInt(10, 50), 2)),
                    new Thread(new Producer(store3, Utils.getInt(10, 50), 3))
            ));

            // запуск потоков
            consumers.forEach(Thread::start);
            producers.forEach(Thread::start);

            // привязка для ожидания
            for (Thread thread : producers) {
                thread.join();
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}