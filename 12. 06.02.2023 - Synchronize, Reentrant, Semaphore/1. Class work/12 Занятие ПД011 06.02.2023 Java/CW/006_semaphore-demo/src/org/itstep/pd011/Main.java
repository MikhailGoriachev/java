package org.itstep.pd011;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    // примеры на семафор
    public static void main(String[] args) {
	    // знакомство с семафором
        // syncSemaphore();

        // классическая задача на семафоры
	    philosopherDinner();
    } // main


    // Пример синхронизации потоков при помощи семафора на 1 ресурс
    // Семафор на 1 ресурс - мьютекс
    /**
     *
     * Semaphore - класс, реализация семафора в Java
     * ► конструктор - задает количество ресурсов,
     *                 порядок предоставления доступа к ресурсам
     *                 потокам (в порядке очереди (true)/ случайный(false))
     * ► acquire()   - запрос ресурса/нескольких ресурсов
     *                 проверка счетчика ресурсов
     *                 если счетчик == 0 - блокировка потока
     *                 ожидание, пока счетчик не станет > 0
     *                 если счетчик != 0 декремент счетчика и выход из метода
     * ► release()   - освобождение одного/нескольких ресурсов
     *                 инкремент счетчика ресурсов, неблокирующий метод
     *
     * Типичная схема применения семафора
     * семафор.acquire()
     *     ... работа с общим ресурсом ...
     * семафор.release()
     */
    private static void syncSemaphore() {
        CommonRes res = new CommonRes();                // создать общий ресурс
        Semaphore semaphore = new Semaphore(1, false);  // создать семафор на 1 ресурс

        // для ожидания завершения потоков
        List<Thread> threads = new ArrayList<>();

        try {
            System.out.println("\nsyncSemaphore: Синхронизация потоков семафором на 1 ресурс");
            for (int i = 1; i <= 5; i++) {
                // создать поток, передать ему ссылку на общий ресурс и на семафор
                Thread t = new SemaphoreCalcThread(res, semaphore);
                t.setName("semaphore" + i);
                threads.add(t);
            } // for i

            threads.forEach(Thread::start);
            for (Thread thread : threads)
                thread.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch

        System.out.println("\nsyncSemaphore: Демонстрация завершена");
    } // syncSemaphore


    // пример использования семафора более, чем на 1 ресурс - классическая
    // задача "Обедающие философы"
    // !! количество объектов, претендующих на ресурсы > кол-ва ресурсов
    private static void philosopherDinner() {
        try {
            System.out.println("\nОбед философов\n");
            final int N_PLACES = 2;   // ограничение по ресурсам - количество мест за столом
            final int N_PHILOS = 5;   // количество претендентов на ограниченный ресурс

            // Массив имен философов
            String[] names = {"Кант", "Ницше", "Геродот", "Сократ", "Конфуций"};

            // семафор на N_PLACES ресурсов, случайный доступ потоков к ресурсу
            // при освобождении ресурса
            Semaphore semaphore = new Semaphore(N_PLACES, false);

            // Стартуем потоки, имитирующие поведение претендентов на ресурс
            List<Thread> listPhilosophers = new ArrayList<>();
            for (int i = 0; i < N_PHILOS; i++) {
                listPhilosophers.add(new Philosopher(names[i], semaphore));
            } // for i

            listPhilosophers.forEach(Thread::start);
            for (Thread t : listPhilosophers) t.join();

            System.out.println("\nВсе - конец обеда...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // philosopherDinner
}
