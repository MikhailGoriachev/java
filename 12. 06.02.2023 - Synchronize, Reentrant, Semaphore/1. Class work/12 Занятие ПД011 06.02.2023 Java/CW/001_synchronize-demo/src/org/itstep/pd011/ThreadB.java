package org.itstep.pd011;

/**
 * Поток с синхронизацией по общему ресурсу
 */
public class ThreadB extends Thread {
    // ссылка на общий ресурс
    CommonResource res;

    public ThreadB(CommonResource res, String name) {
        super(name);     // имя потока передали конструктору базового класса
        this.res = res;  // получили общий ресурс
    } // ThreadB

    // Исполняемая логика потока
    // Монитор - ячейка памяти, отражающая состояние ресурса:
    //     значение равное 1 - ресурс свободен
    //     значение равное 0 - ресурс занят
    // Ключевое слово synchronized(имяРесурсаСсылочныйТип) { операторы }
    // проверяется монитор ресурса, выполняется блокировка ресурса, если ресурс свободен
    // если ресурс занят, то сам поток блокируется до освобождения ресурса,
    // т.е. освобождения монитора
    // по выходу из блока и ресурс и монитор освобождаются
    @Override public void run() {
        // логика обработки та же, что в методе без синхронизации - увеличиваем
        // общий ресурс от 1 до 5

        // блокировка ресурса - захват "монитора" ресурса
        synchronized (res) {
            res.counter = 0;
            for (int i = 0; i < 5; i++) {

                // доступ к общему ресурсу
                ++res.counter;

                // имитация сложной обработки
                Utils.sleep(300);
                System.out.printf("%s: res.counter = %d\n", getName(), res.counter);
            } // for i
            System.out.println();
        } // synchronized
    } // run
} // class ThreadB
