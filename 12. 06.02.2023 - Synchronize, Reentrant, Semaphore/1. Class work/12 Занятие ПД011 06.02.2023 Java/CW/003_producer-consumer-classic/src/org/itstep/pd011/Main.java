package org.itstep.pd011;

/*
 * Взаимодействие двух потоков при помощи synchronized-методов в объекте-посреднике
 * Классическая задача Производитель - Потребитель
 * Взаимодействие потоков при помощи объекта-посредника
 *
 * */
public class Main {

    public static void main(String[] args) {
        try {
            Store store = new Store();   // склад - общий ресурс

            System.out.println("\nНачало цикла работы Производитель - Потребитель");
			
			// так тоже можно запускать потоки...
            // new Consumer(store).start();
            // new Producer(store).start();

            // порядок запуска потоков не важен
            Consumer consumer = new Consumer(store);  // потребитель
            Producer producer = new Producer(store);  // производитель

            producer.start();
            consumer.start();

            consumer.join();
            producer.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch
    } // main
}
