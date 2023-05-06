package app.controllers;

import app.utils.Utils;
import javax.swing.*;

/*
    Двумерные массивы. Для вещественной матрицы m x n выполните обработки:
    •	Заполнение матрицы случайными числами
    •	Вычисление суммы элементов в тех строках, которые содержат хотя бы один отрицательный элемент, 
        вывести матрицу с этими суммами
    •	Вычисление суммы элементов в тех столбцах, которые содержат хотя бы один положительный элемент, 
        вывести матрицу с этими суммами
*/


// Контроллер Задание 3
public class Task03Controller {

    // матрица
    public static double[][] matrix;


    // работа по заданию
    public static void run() {

        // заполнение матрицы
        fillMatrix(5, Utils.getInt(5, 7));

        // вычисление суммы элементов в тех строках, которые содержат хотя бы один отрицательный элемент
        var sumRows = sumRowsIncludeNegative();

        // вычисление суммы элементов в тех столбцах, которые содержат хотя бы один положительный элемент
        var sumCols = sumColsIncludePositive();

        var message = new StringBuilder();

        message.append("<html><h1 align='center'>Результат</h1>")
                .append("<h3>Суммы элементов в тех строках, которые содержат хотя бы один отрицательный элемент:</h3>")
                .append(matrixToTableWithSumRows(sumRows))
                .append("<h3>Суммы элементов в тех столбцах, которые содержат хотя бы один положительный элемент:</h3>")
                .append(matrixToTableWithSumCols(sumCols));

        // вывод результата
        JOptionPane.showOptionDialog(
                null,
                message,
                "Задание 3. Матрица",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(),
                new Object[]{"Меню"},
                "Меню");
    }


    // заполнение матрица случайными числами
    public static void fillMatrix(int rows, int cols) {
        matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int k = 0; k < cols; k++)
                matrix[i][k] = Utils.getDouble(-3d, 10d);
    }


    // вычисление суммы элементов в тех строках, которые содержат хотя бы один отрицательный элемент
    public static double[] sumRowsIncludeNegative() {

        var sumArray = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            var sum = 0d;
            var isNegative = false;

            for (int k = 0; k < matrix[0].length; k++) {
                var value = matrix[i][k];
                sum += value;

                isNegative = isNegative || (value < 0);
            }

            sumArray[i] = isNegative ? sum : Double.NaN;
        }

        return sumArray;
    }


    // вычисление суммы элементов в тех столбцах, которые содержат хотя бы один положительный элемент
    public static double[] sumColsIncludePositive() {

        var sumArray = new double[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {

            var sum = 0d;
            var isPositive = false;

            for (int k = 0; k < matrix.length; k++) {
                var value = matrix[k][i];
                sum += value;

                isPositive = isPositive || (value > 0);
            }

            sumArray[i] = isPositive ? sum : Double.NaN;

        }

        return sumArray;
    }


    // вывод матрицы с суммами строк в таблицу 
    public static String matrixToTableWithSumRows(double[] sumArray) {
        StringBuilder table = new StringBuilder(
                "<table align='center' border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>" +
                        "<th colspan='" + matrix[0].length + "'>Столбцы</th>" +
                        "<th>Сумма</th>" +
                        "</tr><tbody>");

        for (int i = 0; i < matrix.length; i++) {
            table.append("<tr>");

            for (int k = 0; k < matrix[0].length; k++)
                table.append(String.format("<td style='color: %s'>%.3f</td>", (matrix[i][k] > 0 ? "red" : "blue"), matrix[i][k]));

            table.append("<td style='color: green'>")
                    .append(Double.isNaN(sumArray[i]) ? "—" : String.format("%.3f", sumArray[i]))
                    .append("</td>")
                    .append("</tr>");
        }
        table.append("</tbody></table>");

        return table.toString();
    }


    // вывод матрицы с суммами столбцов в таблицу 
    public static String matrixToTableWithSumCols(double[] sumArray) {
        StringBuilder table = new StringBuilder(
                "<table align='center' border='2' cellspacing='0' cellpadding='8'>" +
                        "<tbody><tr><th rowspan='" + matrix.length + "'>Строки</th>");

        for (int k = 0; k < matrix[0].length; k++)
            table.append(String.format("<td style='color: %s'>%.3f</td>", (matrix[0][k] > 0 ? "red" : "blue"), matrix[0][k]));

        table.append("</tr>");

        for (int i = 1; i < matrix.length; i++) {
            table.append("<tr>");

            for (int k = 0; k < matrix[0].length; k++)
                table.append(String.format("<td style='color: %s'>%.3f</td>", (matrix[i][k] > 0 ? "red" : "blue"), matrix[i][k]));

            table.append("</tr>");
        }

        table.append("<tr>");

        table.append("<td>Сумма</td>");

        for (int i = 0; i < matrix[0].length; i++)
            table.append(String.format("<td style='color: green'>%.3f</td>", sumArray[i]));

        table.append("<tr></tbody></table>");

        return table.toString();
    }
}
 