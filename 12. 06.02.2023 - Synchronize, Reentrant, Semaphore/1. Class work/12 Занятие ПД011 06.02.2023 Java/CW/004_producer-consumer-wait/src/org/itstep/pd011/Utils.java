package org.itstep.pd011;

import java.util.Random;

// Вспомогательные методы - вспомогательная библиотека методов
public class Utils {
    // объект для генерации случайных чисел
    private static Random random = new Random();

    // метод-оболочка для удобной организации паузы в работе кода
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // try
    } // sleep

    // генератор случайных чисел в диапазоне от low до high
    public static int getRandom(int low, int high) { // генерация случайных чисел
        return low + random.nextInt(high - low + 1);
    } // getRandom
    public static double getRandom(double low, double high) { return low + (high - low + 1.)*random.nextDouble(); } // getRandom
} // class Utils
