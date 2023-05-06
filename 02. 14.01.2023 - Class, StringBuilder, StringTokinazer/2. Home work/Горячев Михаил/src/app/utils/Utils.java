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

    // массив строк
    public static String[] stringList = {
            "кот ломом колол слона!",
            "на траве дрова на дворе трава, не руби дрова на траве двора",
            "ехал грека через реку, видит грека в реке рак, сунул грека руку в реку"
    };

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
}
