package org.itstep.pd011;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс - имитация общего ресурса
 */
public class Store {
    final int LIMIT = 3;   // неснижаемый остаток на складе
    private int product;   // текущее количество товара на складе

    // блокировка для взаимодействия потоков Производителя и Потребителя
    private Lock locker = new ReentrantLock();           // для замены synchronized
    private Condition condition = locker.newCondition(); // для замены wait(), notify(), notifyAll()

    // Condition     стандарт
    // await()       wait()     ожидание другого потока
    // signal()      notify()
    // signalAll()   notifyAll()

    // положить на склад одну единицу товара - операция для Производителя
    public void put() {
        locker.lock();    // явная блокировка ресурса заменяет synchronized в заголовке метода
        while(product > LIMIT) {
            try {
                // ожидание изменений, выполняемых другим потоком
                // находимся внутри condition.await() пока другой поток не выполнит вызов
                // condition.signal()
                // когда вызов signal() другим потоком выполнен - возвращаемся из await()
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // try-catch
        } // while

        // положить товар на склад, известить другой поток об изменениях на складе
        product++;
        System.out.printf("Склад        : \033[34mПроизводитель\033[0m поместил товар на склад, остаток товара: %2d\n", product);
        condition.signal();  // !!! извещаем другой поток !!! только первый поток в очереди !!!
        // для извещения всех потоков в очереди используется метод signalAll()
        locker.unlock();
    } // put

    // забрать со склада одну единицу товара - операция для Потребителя
    public void get() {
        locker.lock();
        // ожидание пока на складе не появится достаточное количество товара
        while(product <= LIMIT) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // try-catch
        } // while

        product--;
        System.out.printf("Склад        : \033[35mПотребитель\033[0m забрал товар со склада, остаток товара   : %2d\n", product);
        condition.signal();  // извещаем другой поток
        locker.unlock();
    } // get
} // class Store

