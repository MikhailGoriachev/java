package org.itstep.pd011;

/**
 * Использование синхронизированного метода доступа к общему ресурсу
 */
public class CommonResMethod {
    // общий ресурс
    private int counter;

    // при входе в метод срабатывает блокировка потока, в котором он работает
    // планировщик потоков не может прервать такой метод
    synchronized public void calc() {
        counter = 0;       // доступ к общему ресурсу
        for (int i = 0; i < 5; i++) {
            // доступ к общему ресурсу
            ++counter;
            // имитация сложной обработки
            Utils.sleep(300);
            System.out.printf("%s: res.counter = %d\n", Thread.currentThread().getName(), counter);
        } // for i
        System.out.println();
    } // calc

    // обычные, не синхронизированные, методы
    public int getCounter() { return counter; }
    public void setCounter(int counter) {
        this.counter = counter;
    } // setCounter

} // class CommonResMethod
