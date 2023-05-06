package org.itstep.pd011;

/**
 * Класс - потребитель общего ресурса, товара
 */
public class Consumer extends Thread {
    private final int LIMIT_CONSUMER = 15; // предел потребления
    private int product;                   // счетчик купленного товара
    private Store store;                   // ссылка на общий ресурс

    public Consumer(Store store) {
        this.store = store;
    } // Consumer

    // Метод для имитации потребителя
    @Override
    public void run() {
        while(product < LIMIT_CONSUMER) {
            store.get();     // получить товар со склада -- метод с ожиданием (синхронизация)
            product++;       // увеличить количество полученного товара
            System.out.printf("\033[35mПотребитель\033[0m  : получено единиц товара %30s: %2d\n", " ", product);
            Utils.sleep(300);
        } // while
    } // run
}
