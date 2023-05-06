package org.itstep.pd011;

/*
 * Производитель
 */
public class Producer extends Thread {
    private Store store;                   // ссылка на общий ресурс - через него ведем обмен
    final int LIMIT_PRODUCT = 5;           // ограничение на производство
    private int product = LIMIT_PRODUCT;   // задание на производство товара

    public Producer(Store store) {
        this.store = store;
    } // Producer

    @Override
    public void run() {
        // пока задание на производство не выполнено
        while(product > 0) {
            // собственно производство имитируем временной задержкой
            Utils.sleep(700);

            // попытка выгрузить товар на склад, получаем количество
            // принятого складом товара
            int n = store.put();

            // уменьшаем задание на изготовление - либо на 1, либо на 0
            product -= n;
            System.out.printf("Производитель %sотгрузил товар, осталость произвести: %2d\n",
                n == 0 ? "\033[1mне\033[0m " : "   ",
                product);
        } // while
    } // run
} // class Producer
