package org.homework.app.models.task02;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;


// Класс Потребитель
public class Consumer implements Runnable {

    // производитель
    public Store store;

    // лимит чисел в файле
    public final int LIMIT;

    
    // конструктор инициализирующий
    public Consumer(Store store, int limit) {
        this.store = store;
        this.LIMIT = limit;
    }


    // вычисление и вывод данные (потребление)
    public void run() {
        try {
            List<Double> data;
            while ((data = this.store.get()).size() <= LIMIT) {
                var sb = new StringBuffer();
                sb.append(toString(data, "Исходные данные. Количество: " + data.size()));
                sb.append(toString(orderByOddEnd(data), "Отсортированные по правилу: нечётные (целая часть) в конце"));

                System.out.println(sb);
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // сортировка по правилу нечётные (целая часть) в конце
    public List<Double> orderByOddEnd(List<Double> data) {
        var list = new java.util.ArrayList<>(data.stream().toList());
        list.sort(Comparator.comparing(a -> ((a.intValue() & 1) == 1) ? 1 : -1));

        return list;
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
    public String toString(List<Double> list, String title) {
        StringBuffer sb = new StringBuffer();

        sb.append(String.format("\n\t\u001B[31m %s \u001B[0m\n", title)).append("|");

        int n = 1;
        final int maxLength = 10;

        for (Double d : list) {
            sb.append(String.format("%s %6.2f \u001B[0m|", ((d.intValue() & 1) == 1) ? "\u001B[34m" : "\u001B[31m", d));

            if ((n++ % maxLength) == 0)
                sb.append("\n|");
        }

        sb.append("\n");

        return sb.toString();
    }
}
