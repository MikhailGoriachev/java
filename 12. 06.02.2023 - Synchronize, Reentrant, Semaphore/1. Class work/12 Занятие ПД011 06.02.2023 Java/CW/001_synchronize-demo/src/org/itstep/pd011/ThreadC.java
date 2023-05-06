package org.itstep.pd011;

/**
 * Поток с синхронизацией по методу - синхронизированный метод предоставляется
 * классом общего ресурса
 */
public class ThreadC extends Thread {
    // ссылка на общий ресурс с синхронизированным методом
    CommonResMethod res;

    public ThreadC(CommonResMethod res, String name) {
        super(name);     // имя потока передали конструктору базового класса
        this.res = res;  // получили общий ресурс
    } // ThreadA

    // исполняемая логика потока
    @Override  public void run() {
        // обращение к синхронизированному методу общего ресурса
        res.calc();
    } // run
}
