package app.models.task01;

import app.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

/*
    Вариант 14. В одномерном массиве, состоящем из п вещественных элементов:
            1.	Вычислить количество элементов массива, равных нулю
            2.	Вычислить сумму элементов массива, расположенных после минимального элемента
            3.	Упорядочить элементы массива по возрастанию модулей
*/


// Класс Обработка по заданию 1 вариант 14
public class Var14 {

    // массив
    public double[] array;


    // конструктор по умолчанию
    public Var14() {
        initialization(Utils.getInt(12, 16));
    }


    // инициализация массива
    public void initialization(int n) {
        array = Arrays
                .stream(new double[n])
                .map(a -> Utils.getDoubleWithZero(-5d, 5d))
                .toArray();
    }

    // вычислить количество элементов массива, равных нулю
    public int amountZeroElems() {
        return (int) Arrays
                .stream(array)
                .reduce(0, (prev, cur) -> prev + (Utils.doubleEquals(cur, 0d) ? 1 : 0));
    }

    // вычислить сумму элементов массива, расположенных после минимального элемента
    public double sumAfterMinElem() {
        var min = Arrays.stream(array).min().getAsDouble();
        var indexMin = Arrays.stream(array).boxed().toList().indexOf(min);
        return Arrays.stream(array).skip(indexMin + 1).reduce(0d, Double::sum);
    }

    // упорядочить элементы массива по возрастанию модулей
    public double[] orderByAbsAsc() {
        return Arrays
                .stream(array)
                .boxed()
                .sorted(Comparator.comparingDouble(Math::abs))
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    // вывод данных в виде таблицы
    public static String arrayToTable(double[] array) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>");

        var values = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            table.append("<th>" + i + "</th>");
            values.append(String.format("<td style='color: %s'>%.3f</td>", (array[i] > 0 ? "red" : "blue"), array[i]));
        }

        table.append("</tr></thead><tbody><tr>");
        table.append(values);
        table.append("</tr></tbody></table>");

        return table.toString();
    }
}
