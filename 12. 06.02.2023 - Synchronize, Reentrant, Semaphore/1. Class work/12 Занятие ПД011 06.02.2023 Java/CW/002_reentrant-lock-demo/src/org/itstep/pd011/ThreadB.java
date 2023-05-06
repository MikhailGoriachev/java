package org.itstep.pd011;

import java.util.concurrent.locks.Lock;

/**
 * Блокировка общего ресурса объектами класса Lock и критической секции
 */
public class ThreadB extends Thread {
    // ссылка на общий ресурс
    private CommonResource res;

    // ссылка на блокировщик
    private Lock locker;

    public ThreadB(CommonResource res, Lock locker, String name) {
        // имя потока передали конструктору базового класса
        super(name);

        // получили общий ресурс и блокировщика
        this.res = res;
        this.locker = locker;
    } // ThreadB

    // исполняемая логика потока, блокировка в самом методе run()
    @Override
    public void run() {
        // тут м.б. произвольный код

        // вызов unlock() на не заблокированном потоке - вызывает исключение
        // locker.unlock();

        locker.lock();   // вход в критическую секцию - захват "монитора" locker'а
        res.counter = 0; // обращение к общему ресурсу
        for (int i = 1; i <= 5; i++) {
            // обращение к общему ресурсу
            res.counter++;
            System.out.printf("%s: res.counter = %d\n", getName(), res.counter);

            // имитация сложной обработки
            Utils.sleep(300);
        } // for i
        System.out.println();

        // выход из критической секции
        locker.unlock();

        // тут м.б. произвольный код
    } // run
} // class ThreadB
