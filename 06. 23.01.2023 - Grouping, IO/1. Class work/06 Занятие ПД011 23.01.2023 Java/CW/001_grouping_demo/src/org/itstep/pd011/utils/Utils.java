package org.itstep.pd011.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Random;


public class Utils {

    public static Random rand = new Random();

    // генерация случайного числа в диапазоне значений от from до to
    public static int getRandomInt(int from, int to) {
        return from + rand.nextInt(to - from + 1);
    } // getRandomInt

    // пауза в выполнении текущего потока
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // try-catch
    } // sleep

    // проверяем файл на корректность
    // на существование
    // на тип
    // (c) Дорохольский В.
    public static boolean isValidFile(String filename) {
        File file = new File(filename);

        return (file.exists() && file.isFile() && file.length() > 0);
    } // isValid

    // Вывести массив в строку
    public static String arrayToString(int[] array) {
        StringBuffer sbf = new StringBuffer();
        Arrays.stream(array).forEach(t -> sbf.append(String.format("%6d", t)));
        return sbf.toString();
    } // arryToString
}
