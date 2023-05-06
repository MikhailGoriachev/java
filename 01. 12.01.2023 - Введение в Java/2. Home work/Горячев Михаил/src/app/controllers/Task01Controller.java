package app.controllers;

import app.models.Expression;
import app.utils.Utils;
import javax.swing.*;

/*
    Создайте консольное приложение Java для решения задач. 
    Методы класса Math. Исходные данные для пунктов А и В вводите с клавиатуры. Напоминаю, что при правильном 
    кодировании z1 равен z2 с точностью до 7 знаков после запятой.
    
    A. z_1=(sin∝+cos⁡(2β-α))/(cosα-sin⁡(2β-α));z_2=(1+sin2β)/cos2β
    B.  z_1=((a+2)/√2a-a/(2+√2a)+2/(a-√2a))∙(√a-√2)/(a+2); z_2=1/(√a+√2)
*/

// Контроллер Задание 1
public class Task01Controller {

    // вычисление по заданию
    public static void run() {
        try {
            // ввод числа A
            var a = inputNumber("Введите число A:", Utils.getDouble(10d, 20d));

            // ввод числа B
            var b = inputNumber("Введите число B:", Utils.getDouble(10d, 20d));

            // объект для вычислений
            var expr = new Expression(a, b);

            var message = "<html>" +
                    "<h1 align='center'>Результат</h1>" +
                    "<h3>Исходные данные:</h3>" +
                    "<ul>" +
                    String.format("<li><h3>Число A: <span style='color:green'>%.7f</span></h3></li>", a) +
                    String.format("<li><h3>Число B: <span style='color:green'>%.7f</span></h3></li>", b) +
                    "</ul>" +
                    "<h3>Вариант A:</h3>" +
                    "<ul>" +
                    String.format("<li><h3>Число z1: <span style='color:green'>%.7f</span></h3></li>", expr.z1varA()) +
                    String.format("<li><h3>Число z2: <span style='color:green'>%.7f</span></h3></li>", expr.z2varA()) +
                    "</ul>" +
                    "<h3>Вариант B:</h3>" +
                    "<ul>" +
                    String.format("<li><h3>Число z1: <span style='color:green'>%.7f</span></h3></li>", expr.z1varB()) +
                    String.format("<li><h3>Число z2: <span style='color:green'>%.7f</span></h3></li>", expr.z2varB()) +
                    "</ul>";

            // вывод результата
            JOptionPane.showOptionDialog(
                    null,
                    message,
                    "Задание 1. Результат",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(),
                    new Object[]{"Меню"},
                    "Меню"
            );
        } catch (Exception exception) {
            Utils.showErrorMessage("Произошла ошибка при работе задания 1", "Ошибка...");
        }
    }
    
    // форма ввода числа
    public static double inputNumber(String message, double defaultValue) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, message, defaultValue));
    }
}
