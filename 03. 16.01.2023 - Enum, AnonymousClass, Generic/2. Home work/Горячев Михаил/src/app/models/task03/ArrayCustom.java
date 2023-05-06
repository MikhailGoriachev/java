package app.models.task03;


import app.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

// Класс Массив для обработки по заданию
public class ArrayCustom<T extends Number> {

    // размер массива
    public final int length;

    // массив
    private T[] array;

    public T[] array() {
        return array;
    }

    // тип
    Class<T> type;

    // конструктор инициализирующий
    public ArrayCustom(int length, Class<T> type) {
        this.length = length;
        this.type = type;
    }


    // инициализация массива
    public void initialization(T min, T max) {
        array = type == Double.class
                ? (T[]) Utils.getDoubleArrayRandom((Double) min, (Double) max, length)
                : (T[]) Utils.getIntArrayRandom((Integer) min, (Integer) max, length);
    }

    // максимальное значение в массиве
    public T max() {
        var max = 0d;

        for (T x : array) {
            var item = Math.abs(x.doubleValue());
            if (item > max)
                max = item;
        }

        return (T) (Double) max;
    }

    // вычисление суммы
    public T sumPositiveElems() {
        var sum = 0d;

        for (T x : array) {
            if (x.doubleValue() > 0d)
                sum += x.doubleValue();
        }

        return (T) (Double) sum;
    }

    // упорядочивание массива по убыванию модулей элементов, компаратор реализовать анонимным классом
    public T[] sortByAbsDesc() {
        Arrays.sort(array, new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
                return Double.compare(Math.abs(b.doubleValue()), Math.abs(a.doubleValue()));
            }
        });

        return array;
    }

    // упорядочивание массива по возрастанию модулей элементов, компаратор реализовать анонимным классом
    public T[] sortByAbsAsc() {
        Arrays.sort(array, new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
                return Double.compare(Math.abs(a.doubleValue()), Math.abs(b.doubleValue()));
            }
        });

        return array;
    }
}
