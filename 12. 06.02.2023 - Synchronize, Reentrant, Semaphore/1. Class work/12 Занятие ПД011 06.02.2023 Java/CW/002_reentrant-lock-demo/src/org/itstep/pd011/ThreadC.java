package org.itstep.pd011;

/**
 *  Пример синхронизации потоков при помощи синхронного метода,
 *  синхронный метод - в общем ресурсе CommonResMethod
 */
public class ThreadC extends Thread {
    // ссылка на общий ресурс
    private CommonResMethod res;

    public ThreadC(CommonResMethod res, String name) {
        // имя потока передали конструктору базового класса
        super(name);

        // получили ссылку на общий ресурс
        this.res = res;
    } // ThreadA

    // исполняемая логика потока
    @Override public void run() {
       res.calc();
    } // run
}
