package org.homework.app.models.task02;

import org.homework.app.utils.Utils;

import java.io.IOException;


// Класс Производитель
public class Producer implements Runnable {
    
    // общий ресурс
    private final Store store;
    
    // количество чисел которые нужно произвести
    public final int limit;


    // конструктор инициализирующий
    public Producer(Store store, int limit) {
        this.store = store;
        this.limit = limit;
    }


    // произведение чисел
    public void run() {
        final double min = -10, max = 20;
        try {
            while (store.getCountNumbers() <= limit) {
                var value = Utils.getDouble(min, max);
                store.put(value);
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
