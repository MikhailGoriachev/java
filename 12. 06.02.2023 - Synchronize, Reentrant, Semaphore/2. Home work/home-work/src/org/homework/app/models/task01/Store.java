package org.homework.app.models.task01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Класс Общий ресурс
public class Store<T> {
    
    // число
    private T data;
    
    // локер
    private final Lock locker;
    
    // состояние
    private final Condition condition;

    
    // конструктор инициализирующий
    public Store() {
        this.locker = new ReentrantLock();
        this.condition = locker.newCondition();
    }

    
    // запись данных
    public void put(T value) throws InterruptedException {
        locker.lock();
        
        while (data != null)
            condition.await();
    
        data = value;
        condition.signalAll();
        
        locker.unlock();
    }
    
    // получение данных
    public T get() throws InterruptedException {
        locker.lock();
        
        while (data == null)
            condition.await();
        
        var value = data;
        data = null;
        
        condition.signalAll();
        locker.lock();
        
        return value;
    }
}
