package org.itstep.pd011;

import java.util.concurrent.locks.Lock;

/*
 * Демонстрация использования блокировщика в другом объекте,
 * не в объекте создания блокировщика
 * */
public class CommonResMethod {
    // переменная, играющая роль общего ресурса
    private int counter;

    // ссылка на блокировщик
    private Lock locker;

    public CommonResMethod(Lock locker) {
        this.locker = locker;
    }

    // доступ к общему ресурсу выполняется в этом методе
    // !! это один и тот же locker для всех потоков, т.е. выполняется повторный
    // !! в этот код - reenter - реентратнтный вход
    public void calc() {
        // вход в критическую секцию - первый оператор
        locker.lock();

        // обращение к общему ресурсу
        counter = 0;
        for (int i = 1; i <= 5; i++) {
            // обращение к общему ресурсу
            ++counter;

            // имитация сложной обработки
            Utils.sleep(300);

            System.out.printf("%s: res.counter = %d\n", Thread.currentThread().getName(), counter);
        } // for i
        System.out.println();

        // выход из критической секции - последний оператор
        locker.unlock();
    } // calc

    public void setCounter(int counter) {
        this.counter = counter;
    } // setCounter
    public int getCounter() {
        return counter;
    }
} // class CommonResMethod
