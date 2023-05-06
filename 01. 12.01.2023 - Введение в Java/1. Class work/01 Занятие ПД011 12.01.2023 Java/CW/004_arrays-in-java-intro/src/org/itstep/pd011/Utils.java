package org.itstep.pd011;

import java.util.Random;

public class Utils {
    private static Random rand = new Random();

    // метод, возвращающий случайное вещественное число,
    // передаются нижнее и верхнее значения
    public static double getRandom(double lo, double hi){
        return lo + rand.nextDouble() * (hi - lo);
    } // getRandom

    // перегруженный метод, возвращающий случайное целое число,
    // передаются нижнее и верхнее значения
    public static int getRandom(int lo, int hi) {
        return lo + rand.nextInt(hi - lo);
    } // getRandom
} // class Utils
