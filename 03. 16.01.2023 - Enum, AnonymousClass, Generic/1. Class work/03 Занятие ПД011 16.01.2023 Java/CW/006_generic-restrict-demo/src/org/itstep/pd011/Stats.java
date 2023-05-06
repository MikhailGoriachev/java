package org.itstep.pd011;

import java.util.Arrays;

/**
 * Синтаксис объявления обобщенного класса с заданием ограничений по типу
 * class Имя<ИмяТипа extends ИмяКлассаИлиИнтерфейса & ИмяИнтерфейса1 & ИмяИнтерфйса2  ..., > { ... }
 *
 * В данном примере ограничения задают, что мы работаем всегда с числами (Number)
 * и в типе T реализован интерфейс Comparable
 *
 */
public class Stats<T extends Number & Comparable> {
    private T[] data;   // данные для обработки

    public Stats(T[] data) {
        this.data = data;
    } // Stats

    // геттер для массива
    public T[] getData() { return data; }

    // среднее арифметическое массива
    public double average() {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            // xxxxValue() - получение значения элемента, приведенного к типу xxxx
            sum += data[i].doubleValue();
        } // for i

        return sum / data.length;
    } // average


    // метод сравнивает средние арифметические двух объектов Stats
    // ? - метасимвольный аргумент - означает что типом подстановки может быть любой тип,
    //     удовлетворяющий условию, заданному в заголовке класса
    // т.е. возможна ситуация, когда подстановочный тип класса не совпадает с типом obj
    public boolean sameAverage(Stats<?> obj) {
        return average() == obj.average();
    } // sameAverage

    // Реализация сортировки - обобщенный алгоритм
    public void sort() {
        // пример явного использования Comapable - метод объекта compareTo()
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                // !!! основное отличие - реализация сортировки через compareTo()
                // !!! compareTo - реализация Comparable
                if (data[j].compareTo(data[j+1]) > 0) {
                    T temp = data[j];     // обмен элементов - через переменную типа T
                    data[j] = data[j+1];  // присваивание есть для любого типа данных
                    data[j+1] = temp;
                } // if
            } // for j
        } // for i


        // пример неявного использования Comapable - метод объекта compareTo()
        // рекомендуемый способ сортировки
        // Arrays.sort(data);
    } // sort

    // вывести массив данных в строку (через запятую)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]).append(i == data.length-1?"":", ");
        } // for i
        sb.append("\n");

        return sb.toString();
    } // toString
} // class Stats
