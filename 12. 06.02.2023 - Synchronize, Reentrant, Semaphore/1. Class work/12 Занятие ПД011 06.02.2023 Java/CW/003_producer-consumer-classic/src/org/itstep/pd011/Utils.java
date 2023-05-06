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

    // ввод целого числа в заданном диапазоне значений from, to
    // приглашение ко вводу - в параметре prompt
    public static int getInt(String propmt, int from, int to) {
        int value; // вводимое значение

        // цикл ввода числа и проверки его значения на принадлежность
        // заданному диапазону
        while(true) {
            System.out.print(propmt);   // вывод подсказки
            value = sc.nextInt();       // ввод с клавиатуры
            sc.nextLine();

            // введенное число в заданном диапазоне - выходим из цикла
            if (from <= value && value <= to) break;

            // число вне заданного диапазона - вывод сообщения об ошибке
            // и продолжение цикла ввода
            System.out.printf("\n\t\033[1;31mЗначение должно быть в диапазоне от %d до %d\033[0m\n", from, to);
        } // while

        // вернуть введенное значение
        return value;
    } // getInt

    // ввод числа типа double
    public static double getReal(String prompt) {
        double value;

        do {
            System.out.print(prompt);
            value = sc.nextDouble();
            sc.nextLine();
        } while (value <= 0);

        return value;
    } // getDouble

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
