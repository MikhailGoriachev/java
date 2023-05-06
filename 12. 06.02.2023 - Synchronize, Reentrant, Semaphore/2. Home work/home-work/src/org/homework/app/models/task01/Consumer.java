package org.homework.app.models.task01;

import org.homework.app.utils.Utils;


// Класс Потребитель
public class Consumer implements Runnable {

    // производитель
    public Store<Number> store;

    // id потребителя
    public final int id;


    // конструктор инициализирующий
    public Consumer(Store<Number> store, int id) {
        this.store = store;
        this.id = id;
    }


    // вычисление и вывод данные (потребление)
    public void run() {
        try {
            while (true) {
                var a = this.store.get().doubleValue();
                show(a, z1(a), z2(a));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // вычисление z1
    public double z1(double a) {
        var temp = Math.sqrt(2 * a);
        return (((a + 2) / temp) - (a / (temp + 2)) + (2 / (a - temp))) * ((Math.sqrt(a) - Math.sqrt(2)) / (a + 2));
    }

    // вычисление z2
    public double z2(double a) {
        return 1 / (Math.sqrt(a) + Math.sqrt(2));
    }

    // вывод результата в консоль
    public void show(double a, double z1, double z2) {
        if (Double.isNaN(z1) || Double.isNaN(z2) || !Utils.doubleEquals(z1, z2))
            System.out.format("\n\t\u001B[31m| Потребитель: %3d | a: %10.5f | Ошибка вычислений |\u001B[0m\n", id, a);
        else
            System.out.format("\n\t\u001B[31m| Потребитель: %3d | a: %10.5f | z1: %10.5f | z2: %10.5f |\u001B[0m\n", id, a, z1, z2);
    }
}
