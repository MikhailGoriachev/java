package app.controllers;

import app.interfaces.IController;
import app.models.task01.Vehicle;
import app.models.task02.FigureEnum;
import app.utils.Utils;

import javax.swing.*;

/*
    Классы String, StringBuilder, StringTokenizer. Дана строка, состоящая из слов, разделенных пробелами и/или
    знаками препинания (одним или несколькими). Вывести строку, содержащую эти же слова, разделенные одним пробелом 
    и расположенные в порядке, обратном алфавитному, определить и вывести самое короткое и самое длинное слово в 
    строке. Учтите, таких слов может быть несколько.
*/

// Контроллер Задание 2
public class Task02Controller implements IController {

    // фигуры
    public FigureEnum[] figures;

    // работа по заданию
    public void run() {

        Initialization();

        var message = "<html>" +
                "<h1 align='center'>Фигуры</h1>" +
                figuresToTable(figures);

        showMessage(message, "Задание 2. Фигуры");
    }

    // инициализация массива
    public void Initialization() {
        figures = new FigureEnum[Utils.getInt(10, 12)];

        for (var i = 0; i < figures.length; i++) {
            switch (Utils.getInt(0, 4)) {
                case 0 -> {
                    figures[i] = FigureEnum.RECTANGLE;
                    figures[i].sides = new double[]{Utils.getDouble(5d, 10d), Utils.getDouble(5d, 10d)};
                }
                case 1 -> {
                    figures[i] = FigureEnum.SQUARE;
                    figures[i].sides = new double[]{Utils.getDouble(5d, 10d)};
                }
                case 2 -> {
                    figures[i] = FigureEnum.RHOMBUS;
                    figures[i].sides = new double[]{Utils.getDouble(5d, 10d), Utils.getDouble(5d, 10d)};
                }
                default -> {
                    figures[i] = FigureEnum.TRAPEZOID;
                    figures[i].sides = new double[]{Utils.getDouble(15d, 20d), Utils.getDouble(5d, 10d), Utils.getDouble(5d, 10d), Utils.getDouble(5d, 10d)};
                }
            }
        }
    }

    // вывод транспортных средств в таблицу
    public String figuresToTable(FigureEnum[] data) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>" +
                        "<th>№</th>" +
                        "<th>Название</th>" +
                        "<th>Сторона A</th>" +
                        "<th>Сторона B</th>" +
                        "<th>Сторона C</th>" +
                        "<th>Сторона D</th>" +
                        "<th>Периметр</th>" +
                        "<th>Площадь</th>" +
                        "</tr></thead><tbody>");

        for (int i = 0; i < data.length; i++) {
            table.append(data[i].toTableRow(i + 1));
        }

        table.append("</tbody></table>");

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
