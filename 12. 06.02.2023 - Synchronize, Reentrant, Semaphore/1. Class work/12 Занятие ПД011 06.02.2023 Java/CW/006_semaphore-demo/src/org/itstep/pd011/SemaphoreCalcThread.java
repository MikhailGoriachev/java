package org.itstep.pd011;

import java.util.concurrent.Semaphore;

/**
 *
 * Semaphore - класс, реализация семафора в Java
 * ► конструктор - задает количество ресурсов,
 *                 порядок предоставления доступа к ресурсам
 *                 потокам (в порядке очереди (true)/ случайный(false))
 * ► acquire()   - запрос ресурса/нескольких ресурсов
 *                 проверка счетчика ресурсов
 *                 если счетчик == 0 - блокировка потока
 *                 ожидание, пока счетчик не станет > 0
 *                 если счетчик != 0 декремент счетчика и выход из метода
 * ► release()   - освобождение одного/нескольких ресурсов
 *                 инкремент счетчика ресурсов, неблокирующий метод
 *
 * Типичная схема применения семафора
 * семафор.acquire()
 *     ... работа с общим ресурсом ...
 * семафор.release()
 */
public class SemaphoreCalcThread extends Thread {
    CommonRes res;                // ссылка на общий ресурс
    private Semaphore semaphore;  // экземпляр семафора

    // конструктор
    public SemaphoreCalcThread(CommonRes res, Semaphore semaphore) {
        this.res = res;
        this.semaphore = semaphore;
    } // SemaphoreCalcThread

    // поток, считает до 5, используя общий ресурс
    @Override
    public void run() {
        System.out.printf("%s: стартовал\n", getName());

        try {
            semaphore.acquire();  // поставить блокировку - т.к. семафор на 1 ресурс

            System.out.println();
            res.number = 0;
            for (int i = 1; i <= 5; i++) {
                res.number++;
                System.out.printf("%s: res.number = %d\n", getName(), res.number);
                Utils.sleep(200);
            } // for i
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.printf("%s: завершен\n", getName());
            semaphore.release();   // снять блокировку
        } // try-catch-finally
    } // run
} // class SemaphoreCalcThread

