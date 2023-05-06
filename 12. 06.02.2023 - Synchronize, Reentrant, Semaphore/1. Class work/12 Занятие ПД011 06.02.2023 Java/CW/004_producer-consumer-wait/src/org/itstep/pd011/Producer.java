package org.itstep.pd011;

/**
 * Класс - производитель общего ресурса, товара
 */
public class Producer extends Thread {
    private final int LIMIT_PRODUCER = 18; // ограничение по производимому товару (15 + 3)
                                           // 3 - неснижаемый остаток на складе (к сведению)
    private int product = 0;   // счетчик произведенного товара
    private Store store;       // ccылка на общий ресурс - на склад

    public Producer(Store store) {
        this.store = store;
    }

    // имитация работы производителя
    @Override
    public void run() {
        while (product < LIMIT_PRODUCER) {
            Utils.sleep(700);  // имитация производтсва продукта (товара)
            store.put();           // поместить товар на склад -- это метод с ожиданием (синхронизация)
            product++;             // увеличиваем счетчик произведенного товара
            System.out.printf("\033[34mПроизводитель\033[0m: всего произведено %35s: %2d\n", " ", product);
        } // while
    } // run
}
