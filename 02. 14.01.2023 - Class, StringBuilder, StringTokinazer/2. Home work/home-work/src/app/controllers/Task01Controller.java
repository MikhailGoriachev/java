package app.controllers;

import app.interfaces.IController;
import app.utils.Utils;

import javax.swing.*;

/*
    •	Класс String. Реализуйте обработки для строк и символов, вводимых с клавиатуры:
        o	Дан символ C и строки S, S0. После каждого вхождения символа C в строку S вставить строку S0.
        o	Даны строки S и S0. Проверить, содержится ли строка S0 в строке S. Если содержится, то вывести 
            TRUE, если не содержится, то вывести FALSE
        o	Даны строки S и S0. Удалить из строки S первую подстроку, совпадающую с S0. Если совпадающих 
            подстрок нет, то вывести строку S без изменений.

*/

// Контроллер Задание 1
public class Task01Controller implements IController {

    // главная строка
    String s;

    // подстрока
    String s0;

    // символ
    char c;


    // работа по заданию
    public void run() {

            // ввод строки S
            s = inputString("Введите строку S:", Utils.getItem(Utils.stringList));

            // ввод строки S0
            s0 = inputString("Введите подстроку S0:", Utils.getItem(Utils.getWords(s)));

            // ввод символа
            c = inputString("Введите символ C (первый введённый символ):", s0.charAt(0));

            var message = "<html>" +
                    "<h1 align='center'>Результат</h1>" +
                    "<h3>Исходная строка (S):</h3>" +
                    "<u>" + s + "</u>" +
                    "<h3>После каждого вхождения символа \"" + c + "\" в строку S вставить строку \"" + s0 + "\":</h3>" +
                    "<u>" + point01() + "</u>" +
                    "<h3>Проверить, содержится ли строка \"" + s0 + "\" в строке S:</h3>" +
                    "<u>" + point02() + "</u>" +
                    "<h3>Удалить из строки S первую подстроку, совпадающую с \"" + s0 + "\":</h3>" +
                    "<u>" + point03() + "</u>";

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
    }

    // Дан символ C и строки S, S0. После каждого вхождения символа C в строку S вставить строку S0.
    public String point01() {

        var ch = Character.toString(c);
        return s.replace(ch, ch + s0);
    }

    // Даны строки S и S0. Проверить, содержится ли строка S0 в строке S. Если содержится, то вывести
    // TRUE, если не содержится, то вывести FALSE
    public String point02() {
        return s.contains(s0) ? "TRUE" : "FALSE";
    }

    // Даны строки S и S0. Удалить из строки S первую подстроку, совпадающую с S0. Если совпадающих
    // подстрок нет, то вывести строку S без изменений.
    public String point03() {
        return s.replaceFirst(s0, "");
    }

    // форма ввода строки
    public static String inputString(String message, String defaultValue) {
        return JOptionPane.showInputDialog(null, message, defaultValue);
    }

    // форма ввода символа
    public static char inputString(String message, char defaultValue) {
        return JOptionPane.showInputDialog(null, message, defaultValue).charAt(0);
    }
}
