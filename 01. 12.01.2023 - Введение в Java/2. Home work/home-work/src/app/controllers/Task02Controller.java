package app.controllers;

import app.utils.Utils;

import javax.swing.*;
import java.util.Arrays;

/*
    Одномерные массивы. В одномерном массиве из n случайных вещественных чисел выполите обработки 
    (без использования Stream API): 
    •	Заполнение массива случайными числами
    •	Вычисление произведения положительных элементов массива
    •	Вычисление суммы элементов массива, расположенных между минимальным и максимальным элементами
    •	Упорядочить массив по возрастанию.
*/

// Контроллер Задание 2
public class Task02Controller {

    // массив
    static double[] array;


    // работа по заданию
    public static void run() {

        // заполнение массива
        fillArray(Utils.getInt(10, 15));

        // разметка массива до сортировки
        var tableSourceArray = arrayToTable();

        // вычисление произведения положительных элементов массива
        var prodPositive = prodPositiveElems();

        // вычисление суммы элементов массива, расположенных между минимальным и максимальным элементами
        var sumBetweenMinMax = sumBetweenMinMaxElems();

        // упорядочить массив по возрастанию
        sortArray();

        var message = new StringBuilder();

        message.append("<html><h1 align='center'>Результат</h1><h3>Исходные данные:</h3>")
                .append(tableSourceArray)
                .append("<ul>")
                .append(String.format("<li><h3>Произведение положительных элементов: %.5f</h3></li>", prodPositive))
                .append(String.format("<li><h3>Сумма между минимальным и максимальным: %.5f</h3></li>", sumBetweenMinMax))
                .append("</ul><h3>Отсортированный массив по возрастанию:</h3>")
                .append(arrayToTable());

        // вывод результата
        JOptionPane.showOptionDialog(
                null,
                message,
                "Задание 2. Массив",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(),
                new Object[]{"Меню"},
                "Меню");
    }


    // заполнение массива случайными числами
    public static void fillArray(int length) {
//        array = Utils.fillArray(new double[length], -20d, 20d);
        array = Utils.fillArray(new double[length], -5d, 5d);
    }


    // вычисление произведения положительных элементов массива
    public static double prodPositiveElems() {
        var prod = 1d;
        var isPositiveExist = false;

        for (var a : array) {
            if (a > 0) {
                prod *= a;
                isPositiveExist = true;
            }
        }

        return isPositiveExist ? prod : 0;
    }


    // вычисление суммы элементов массива, расположенных между минимальным и максимальным элементами
    public static double sumBetweenMinMaxElems() {

        double minValue = array[0];
        double maxValue = array[0];

        int minIndex = 0;
        int maxIndex = 0;

        // поиск индекса минимального и максимального элементов
        for (int i = 0; i < array.length; i++) {
            var value = array[i];

            if (value < minValue) {
                minValue = value;
                minIndex = i;
            } else if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        double sum = 0;

        if (minIndex > maxIndex) {
            var temp = maxIndex;
            maxIndex = minIndex;
            minIndex = temp;
        }
        
        // суммирование элементов
        for (int i = minIndex + 1; i < maxIndex; i++)
            sum += array[i];


        return sum;
    }


    // упорядочить массив по возрастанию
    public static void sortArray() {
        Arrays.sort(array);
    }


    // вывод массива в строку
    public static String arrayToTable() {
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
