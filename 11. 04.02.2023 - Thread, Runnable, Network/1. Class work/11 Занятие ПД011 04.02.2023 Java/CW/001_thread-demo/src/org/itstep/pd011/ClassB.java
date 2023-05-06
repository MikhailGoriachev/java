package org.itstep.pd011;

public class ClassB extends Thread {
    private String tab; // параметр для потока

    public ClassB() { this("");  }
    public ClassB(String tab) {
        this.tab = tab;
    } // ClassB

    // этот метод запускается в отдельном потоке исполнения
    // реентрантный метод - позволяет повторное вхождение из разных потоков
    // !! в методе менять глобальные переменные !!
    @Override
    public void run() {
        // получить идентификатор потока
        Thread thread = Thread.currentThread();
        int id = (int) thread.threadId();
        String name = thread.getName();

        // зададим время работы потока - имитация полезных действий
        int wait = Utils.getRandom(1_000, 3_000);

        System.out.printf("%sПривет! Поток %s(%d) стартовал, длительность %d мс\n", tab, name, id, wait);
        Utils.sleep(wait);   // имитация работы потока в течение wait миллисекунд
        System.out.printf("%sПока!   Поток %s(%d) финишировал\n", tab, name, id);
    } // run
}
