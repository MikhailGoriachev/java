package org.itstep.pd011;

/**
 * Поток для доступа к общему ресурсу без синхронизации
 */
public class ThreadA extends Thread {
    // ссылка на общий ресурс
    CommonResource res;

    public ThreadA(CommonResource res, String name) {
        super(name);     // имя потока передали конструктору базового класса
        this.res = res;  // получили общий ресурс - внедрение зависимости
    } // ThreadA

    // исполняемая логика потока - меняем общий ресурс от 0 до 5
    @Override
    public void run() {
        final int n = 5;
        res.counter = 0;       // доступ к общему ресурсу
        for (int i = 1; i <= n; i++) {
            // доступ к общему ресурсу по записи
            res.counter++;

            System.out.printf("%s: res.counter = %d\n", getName(), res.counter);
            Utils.sleep(300); // имитация сложной обработки
        } // for i
    } // run
}
