package app.utils;

import javax.swing.*;
import java.util.Random;
import java.util.StringTokenizer;

// Класс Утилиты
public class Utils {

    // случайное целочисленное число
    public static int getInt(int min, int max) {
        return new Random().nextInt(min, max);
    }

    // случайное вещественное число
    public static double getDouble(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }

    // получить случайный элемент массива
    public static <T> T getItem(T[] array) {
        return array[Utils.getInt(0, array.length)];
    }

    // сравнить два значения double
    public static boolean doubleCompare(double a, double b) {
        return Math.abs(a - b) < 1e-7;
    }

    // вывод окна 
    public static int showWindow(String message, String title, Object[] commands, String initialValue, ImageIcon imageIcon) {
        return JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                imageIcon,
                commands,
                initialValue
        );
    }
    
    // заполнение массива случайными вещественными числами
    public static double[] fillArray(double[] array, double min, double max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getDouble(min, max);
        }

        return array;
    }

    // вывод сообщения об ошибке
    public static void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // получить случайный элемент массива строк
    public static String getItem(String[] array) {
        return array[getInt(0, array.length)];
    }

    // получить слова из строки
    public static String[] getWords(String string) {
        var tokenizer = new StringTokenizer(string, " .,!?-\t\n:;");

        String[] words = new String[tokenizer.countTokens()];

        for (int i = 0; tokenizer.hasMoreTokens(); i++)
            words[i] = tokenizer.nextToken();

        return words;
    }

    // получить массив double
    public static Double[] getDoubleArrayRandom(Double min, Double max, int length) {
        var array = new Double[length];

        for (int i = 0; i < length; i++) {
            array[i] = getDouble(-20d, 20d);
        }

        return array;
    }

    // получить массив integer
    public static Integer[] getIntArrayRandom(Integer min, Integer max, int length) {
        var array = new Integer[length];

        for (int i = 0; i < length; i++) {
            array[i] = getInt(-20, 20);
        }

        return array;
    }

    // массив названий товара
    public static String[] goodsNameList = new String[]{
            "свитер",
            "шапка",
            "кроссовки",
            "джинсы",
            "брюки",
            "кепка",
            "шорты",
            "рубашка"
    };
}
