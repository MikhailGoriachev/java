package org.itstep.pd011;

/*
 * Потребитель
 */
public class Consumer extends Thread {
    private Store store;           // ссылка на общий ресурс - склад - буфер для обмена данными
    final int LIMIT_CONSUMER = 5;  // ограничение на потребление
    private int product = 0;       // счетчик потребленного товара

    public Consumer(Store store) {
        this.store = store;
    } // Consumer

    @Override
    public void run() {
        // пока потребили не весь запрошенный товар
        while(product < LIMIT_CONSUMER) {
            // попытка получить товар со склада
            int n = store.get();
            product += n; // получить сможем либо 0 либо 1

            System.out.printf("Потребитель %sполучил товар, осталость получить     : %2d\n",
                    n == 0 ? "\033[1mне\033[0m " : "   ",
                    LIMIT_CONSUMER - product);
            System.out.println("——————————————————————————————————————————————————————————————\n");

            // пауза 
            if (n == 0) Utils.sleep(300);
        } // while
    } // run
}
