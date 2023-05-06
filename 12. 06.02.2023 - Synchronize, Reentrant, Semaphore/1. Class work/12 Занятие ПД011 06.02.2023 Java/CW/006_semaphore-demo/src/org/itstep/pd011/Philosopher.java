package org.itstep.pd011;

import java.util.concurrent.Semaphore;

/**
 * Класс - модель философа для задачи "Обедающие философы"
 */
public class Philosopher extends Thread {
    private Semaphore semaphore;  // ссылка на семафор, семафор создается в другом блоке кода
    private String name;          // имя философа
    int counter = 0;              // счетчик перемен блюд
    final int FOOD_CHANGES = 3;   // количество перемен блюд в обеде

    // конструктор
    public Philosopher(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    } // Philosopher

    // поток, моделирующий поведение философа за обедом из N перемен блюд
    @Override
    public void run() {
        System.out.printf("\033[34m%-10s\033[0m пришел на обед\n", name);
        try {
            for (; counter < FOOD_CHANGES; counter++) {
                // запрос ресурса - места за столом, если места нет (семафор == 0,
                // то ожидаем освобождения ресурса, не покидаем метод acquire)
                semaphore.acquire();

                System.out.printf("\033[34m%-10s\033[0m садится за стол, ест блюдо %d\n", name, counter + 1);
                Utils.sleep(Utils.getRandom(200, 500));  // пауза для принятия пищи...

                if (counter < FOOD_CHANGES-1)
                    System.out.printf("\033[34m%-10s\033[0m пошел погулять, съев блюдо %d\n", name, counter + 1);
                semaphore.release();   // освободить ресурс

                Utils.sleep(Utils.getRandom(3, 7)*100); // имитация прогулки по саду
            } // for i
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
        } // try-catch

        System.out.printf("\033[34m%-10s\033[0m отобедал\n", name);
    } // run
} // class Philosopher 
