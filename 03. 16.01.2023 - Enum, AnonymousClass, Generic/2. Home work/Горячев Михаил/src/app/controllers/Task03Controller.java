package app.controllers;

import app.interfaces.IController;
import app.models.task03.ArrayCustom;
import app.models.task03.Mobile;

import javax.swing.*;
import java.util.Arrays;

/*
    Задача 3. Обобщенные классы. Анонимные классы. Разработайте обобщенный класс для обработки массивов. 
    Протестируйте этот класс на числах типа int, double (используйте ссылочные типы-обертки). Требуется 
    выполнение следующих функций:
    •	Формирование массива из n случайных чисел в диапазоне от -20 до 20;
    •	Определение максимального по модулю элемента массива;
    •	Вычисление суммы положительных элементов массива;
    •	Упорядочивание массива по убыванию модулей элементов, компаратор реализовать анонимным классом
    •	Упорядочивание массива по возрастанию модулей элементов, компаратор реализовать анонимным классом
*/

// Контроллер Задание 3
public class Task03Controller implements IController {

    // диапазон значений массива
    final int MIN_LENGTH = -20;
    final int MAX_LENGTH = 20;

    // массив вещественных чисел
    public ArrayCustom<Double> arrayDouble;

    // целочисленный массив
    public ArrayCustom<Integer> arrayInteger;


    // конструктор по умолчанию
    public Task03Controller() {
        arrayDouble = new ArrayCustom<>(10, Double.class);
        arrayInteger  = new ArrayCustom<>(10, Integer.class);
        initialization();
    }


    // работа по заданию
    public void run() {
        var message = "<html>" +
                "<h1 align='center'>Массив вещественных чисел</h1>" +
                arrayToTable(arrayDouble.array()) +
                String.format("<h2>Максимум по модулю: %.3f</h2>", arrayDouble.max()) + 
                String.format("<h2>Сумма положительных элементов: %.3f</h2>", arrayDouble.sumPositiveElems()) + 
                "<h2>Сортировка по убыванию модулей:</h2>" +
                arrayToTable(arrayDouble.sortByAbsDesc()) +
                "<h2>Сортировка по возрастанию модулей:</h2>" +
                arrayToTable(arrayDouble.sortByAbsAsc());
        
        showMessage(message, "Задание 3. Массив вещественных чисел");
        
        message = "<html>" +
                "<h1 align='center'>Массив целых чисел</h1>" +
                arrayToTable(arrayInteger.array()) +
                String.format("<h2>Максимум по модулю: %.0f</h2>", arrayInteger.max()) + 
                String.format("<h2>Сумма положительных элементов: %.0f</h2>", arrayInteger.sumPositiveElems()) + 
                "<h2>Сортировка по убыванию модулей:</h2>" +
                arrayToTable(arrayInteger.sortByAbsDesc()) +
                "<h2>Сортировка по возрастанию модулей:</h2>" +
                arrayToTable(arrayInteger.sortByAbsAsc());
        
        showMessage(message, "Задание 3. Массив вещественных чисел");
    }

    // инициализация коллекции
    public void initialization() {
        arrayDouble.initialization((double) MIN_LENGTH, (double) MAX_LENGTH);
        arrayInteger.initialization(MIN_LENGTH, MAX_LENGTH);
    }

    // вывод массива в строку
    public static String arrayToTable(Double[] array) {
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

    // вывод массива в строку
    public static String arrayToTable(Integer[] array) {
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

    // вывод данных в окно
    public static void showMessage(String message, String title) {
        JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(),
                new Object[]{"Далее"},
                "Далее"
        );
    }
}
