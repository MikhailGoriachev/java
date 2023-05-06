package app.utils;

import javax.swing.*;
import java.util.Random;

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
    
}
