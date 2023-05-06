package org.homework.app.models.task01;

import org.homework.app.utils.Utils;


// Класс Производитель
public class Producer implements Runnable {
    
    // id производителя
    public final int id;

    // общий ресурс
    private final Store<Number> store;

    // количество чисел которые нужно произвести
    public final int limit;

    // количество произведенных чисел
    private int amount = 0;


    // конструктор инициализирующий
    public Producer(Store<Number> store, int capacity, int id) {
        this.store = store;
        this.limit = capacity;
        this.id = id;
    }


    // произведение чисел
    public void run() {
        final double min = -10, max = 20;
        try {
            while (amount < limit) {
                var value = Utils.getDouble(min, max);
                store.put(value);
                amount++;
                show(value);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.format("\n\t\u001B[32m| Производитель: %3d | Работа завершина | Произведено: %3d | Лимит: %3d |\u001B[0m\n",
                id, amount, limit);
    }

    // вывод результата в консоль
    public void show(double value) {
        System.out.format("\n\t\u001B[34m| Производитель: %3d | Значение: %10.5f | Произведено: %3d | Лимит: %3d |\u001B[0m\n",
                id, value, amount, limit);
    }
}
