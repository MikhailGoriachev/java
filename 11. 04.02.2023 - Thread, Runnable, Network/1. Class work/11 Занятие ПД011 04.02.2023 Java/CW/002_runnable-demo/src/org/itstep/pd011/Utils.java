package org.itstep.pd011;

import java.util.Random;
import java.util.Scanner;


public class Utils {

    // объект для генерации случайных чисел
    private static Random random = new Random();

    // объект для ввода с клавиатуры
    public static Scanner sc = new Scanner(System.in);

    // пауза в работе потока
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // try
    } // sleep


    // генератор случайных чисел в диапазоне от low до high
    public static int getRandom(int low, int high) {
        int r;
        // do
        r = low + random.nextInt(high - low + 1);
        // while(r == 0);
        return r;
    } // getRandom

    // для данной задачи модифицируем генератор так, чтобы при формировании числа, по модулю
    // меньше 0.3, заменялись бы 0
    public static double getRandom(double low, double high) {
        final double EPS_BOUND = 0.3; // порог округления до 0
        double x = low + (high - low + 1.)*random.nextDouble();
        if (Math.abs(x) < EPS_BOUND) x = 0.;
        return x;
    } // getRandom
} // class Utils
