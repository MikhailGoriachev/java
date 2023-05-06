package org.itstep.pd011;

/**
 * Пример класса с потоком исполнения, передаем в поток параметр
 * через поле класса и конструктор
 */
public class ClassA extends Thread {
    private String tab; // параметр для потока

    public ClassA() { this("");  }
    public ClassA(String tab) {
        this.tab = tab;
    } // ClassA

    // этот метод запускается в отдельном потоке исполнения
    @Override
    public void run() {
        // получить идентификатор потока
        Thread thread = Thread.currentThread();
        long id = thread.threadId();
        String name = thread.getName();

        // зададим время работы потока - имитация полезных действий
        int wait = Utils.getRandom(1_000, 3_000);

        System.out.printf("%s: Привет! Поток %d стартовал, параметр \"%s\", длительность %d мс\n", name, id, tab, wait);
        Utils.sleep(wait);   // имитация работы потока в течение wait миллисекунд
        System.out.printf("%s: Пока!   Поток %d финишировал\n", name, id);
    } // run
} // class ClassA
