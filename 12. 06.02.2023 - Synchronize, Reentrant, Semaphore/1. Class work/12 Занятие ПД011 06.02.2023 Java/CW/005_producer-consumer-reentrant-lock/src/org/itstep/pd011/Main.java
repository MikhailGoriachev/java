package org.itstep.pd011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Взаимодействие двух потоков Производитель - Потребитель
public class Main {

    public static void main(String[] args) {
        try {
            // Общий ресурс - склад
            Store store = new Store();

            // Создание и запуск двух потоков
            System.out.print("\nНачало деятельности \033[34mПроизводителя\033[0m и \033[35mПотребителя\033[0m\n\n");

            List<Thread> threads = new ArrayList<>(Arrays.asList(
                new Consumer(store),
                new Producer(store)));

            threads.forEach(Thread::start);
            for (Thread t: threads) t.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // main
} // class Main
