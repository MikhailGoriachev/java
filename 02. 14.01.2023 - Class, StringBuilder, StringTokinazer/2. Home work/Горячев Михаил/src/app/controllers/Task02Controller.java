package app.controllers;

import app.interfaces.IController;
import app.utils.Utils;

import javax.swing.*;
import java.util.Arrays;

/*
    Классы String, StringBuilder, StringTokenizer. Дана строка, состоящая из слов, разделенных пробелами и/или
    знаками препинания (одним или несколькими). Вывести строку, содержащую эти же слова, разделенные одним пробелом 
    и расположенные в порядке, обратном алфавитному, определить и вывести самое короткое и самое длинное слово в 
    строке. Учтите, таких слов может быть несколько.
*/

// Контроллер Задание 2
public class Task02Controller implements IController {

    // строка
    String s;

    // работа по заданию
    public void run() {

        // ввод строки S
        s = inputString("Введите строку S:", Utils.getItem(Utils.stringList));

        var message = "<html>" +
                "<h1 align='center'>Результат</h1>" +
                "<h3>Исходная строка (S):</h3>" +
                "<u>" + s + "</u>" +
                "<h3>Разделение слов пробелами и сортировка в обратном алфавитному порядке:</h3>" +
                "<u>" + (s = point01()) + "</u>" +
                "<h3>Самые длинные слова:</h3>" +
                "<u>" + Arrays.toString(point02()) + "</u>" +
                "<h3>Самые короткие слова:</h3>" +
                "<u>" + Arrays.toString(point03()) + "</u>";

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

    // разделение слов пробелами
    public String point01() {
        var words = Utils.getWords(s);
        Arrays.sort(words, (s1, s2) -> s2.compareTo(s1));
        return String.join(" ", words);
    }

    // слова заданной длины
    public String[] wordsByLength(String[] words, int length, int count) {

        var minWords = new String[count];
        var n = 0;
        for (var word : words) {
            if (word.length() == length) {
                minWords[n++] = word;
            }

            if (n >= count)
                break;
        }

        return minWords;
    }

    // самые длинные слова
    public String[] point02() {
        var words = Utils.getWords(s);

        var maxLength = words[0].length();
        var count = 0;

        for (var word : words) {
            if (maxLength < word.length()) {
                maxLength = word.length();
                count = 1;
            } else if (maxLength == word.length())
                count++;
        }

        return wordsByLength(words, maxLength, count);
    }

    // самые короткие слова
    public String[] point03() {
        var words = Utils.getWords(s);

        var minLength = words[0].length();
        var count = 0;

        for (var word : words) {
            if (minLength > word.length()) {
                minLength = word.length();
                count = 1;
            } else if (minLength == word.length())
                count++;
        }

        return wordsByLength(words, minLength, count);
    }

    // форма ввода строки
    public static String inputString(String message, String defaultValue) {
        return JOptionPane.showInputDialog(null, message, defaultValue);
    }
}
