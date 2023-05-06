package app.models.task01;

import app.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

/*
    Вариант 17. В одномерном массиве, состоящем из п целочисленных элементов:
            1.	Вычислить количество положительных элементов массива
            2.	Вычислить сумму элементов массива, расположенных после последнего элемента, равного нулю
            3.	Преобразовать массив таким образом, чтобы сначала располагались элементы <= 1, а потом — все остальные
*/


// Класс Обработка по заданию 1 вариант 17
public class Var17 {

    // массив
    public int[] array;


    // конструктор по умолчанию
    public Var17() {
        initialization(Utils.getInt(12, 16));
    }


    // инициализация массива
    public void initialization(int n) {
        array = Arrays
                .stream(new int[n]).map(a -> Utils.getInt(-5, 5))
                .toArray();
    }

    // вычислить количество положительных элементов массива
    public int amountPositiveElems() {
        return Arrays
                .stream(array)
                .reduce(0, (prev, cur) -> prev + (cur > 0 ? 1 : 0));
    }

    // вычислить сумму элементов массива, расположенных после последнего элемента, равного нулю
    public int sumAfterZeroElem() {
        var indexZero = Arrays.stream(array).boxed().toList().lastIndexOf(0);
        return indexZero >= 0
                ? Arrays.stream(array).skip(indexZero + 1).reduce(0, Integer::sum) 
                : 0;
    }

    // преобразовать массив таким образом, чтобы сначала располагались элементы <= 1, а потом — все остальные
    public int[] orderByTask() {
        return Arrays
                .stream(array)
                .boxed()
                .sorted(Comparator.comparing(a -> a > 1))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // вывод массива в строку
    public static String arrayToTable(int[] array) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='12'>" +
                        "<thead><tr>");

        var values = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            table.append("<th>" + i + "</th>");
            values.append(String.format("<td style='color: %s'>%d</td>", (array[i] > 0 ? "red" : "blue"), array[i]));
        }

        table.append("</tr></thead><tbody><tr>");
        table.append(values);
        table.append("</tr></tbody></table>");

        return table.toString();
    }
}
