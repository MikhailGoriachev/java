package org.itstep.pd011;

// класс, реализующий интерфейс Runnable для работы с потоком исполнения кода
public class Demo1Runnable implements Runnable {
    private static final int N = 5; // количество циклов
    // диапазон задержки в мс
    private static final int FROM = 1500;
    private static final int TO = 3500;

    private int counter;  // счетчик
    private String color; // цвет вывода сообщений потока

    public Demo1Runnable(String color) {
        this.color = color;
        counter = 0;
    } // Demo1Runnable

    @Override // реализация интерфейса Runnable - этот метод и есть код потока
    public void run() {
        System.out.printf("%sDemo1Runnable: Поток запущен...\033[0m\n", color);

        for (int i = 0; i < N; i++) {
            counter++;

            System.out.printf("%sDemo1Runnable: Счетчик: %d\033[0m\n", color, counter);

            // имитация оставшейся части работы потока
            Utils.sleep(Utils.getRandom(1_500, 3_500));
        } // for i

        System.out.printf("%sDemo1Runnable: Поток завершен...\033[0m\n", color);
    } // run
} // class Demo1Runnable
