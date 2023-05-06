package org.itstep.pd011;

// простейшая реализация интерфейса Runnable для работы с потоком
public class Demo2Runnable implements Runnable {

    // этот метод и есть код потока
    @Override
    public void run() {
        System.out.println("Demo2Runnable: Поток запущен");
        Utils.sleep(2_500);
        System.out.println("Demo2Runnable: Поток завершен");
    } // run
} // class Demo2Runnable
