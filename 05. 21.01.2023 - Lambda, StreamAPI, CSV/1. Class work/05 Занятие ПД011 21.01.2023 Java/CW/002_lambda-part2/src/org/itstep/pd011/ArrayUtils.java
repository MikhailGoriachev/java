package org.itstep.pd011;

import java.util.Random;
import java.util.function.Predicate;

public class ArrayUtils {
    // объект для генерации случайных чисел
    static private final Random random = new Random();

    // генератор случайных чисел в диапазоне от low до high
    public static int getRandom(int low, int high) {
        int r;
        return low + random.nextInt(high - low + 1);
    } // getRandom

    // Создание целочисленного массива размерности n, заполнение массива
    // случайными числами с диапазоном значений from, to
    public static int[] createArray(int n, int from, int to) {
        int[] array = new int[n];
        fillArray(array, from, to);

        return array;
    } // createArray

    // Заполнение целочисленного массива array[] случайными числами
    // с диапазоном значений from, to
    public static void fillArray(int[] array, int from, int to) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = getRandom(from, to);
        } // for i
    } // fillArray

    // вывод массива array[] в консоль с сообщением title перед массивом
    public static void showArray(String title, int[] array) {
        final int PER_LINE = 15;  // количество выводимых в строку чисел
        int n = array.length;

        // вывод заголовка перед массивом
        System.out.print(title);
        for (int i = 0; i < n; ++i) {
            System.out.printf("%8d", array[i]);
            // перевод строки после вывода очередных PER_LINE элементов
            if ((i+1) % PER_LINE == 0) System.out.println();
        } // for
        // перевод строки при незаполненной последней выводимой строке
        if (n % PER_LINE != 0) System.out.println();
    } // showArray

    // вывод массива array с выделением цветом color элементов для котороых
    // выполняется предикат
    public static void showArray(String title, Integer[] array, String color, Predicate<Integer> predicate) {
        final int PER_LINE = 15;   // количество выводимых в строку чисел

        // вывод заголовка перед массивом
        System.out.print(title);

        // Цикл вывода элемнтов массива по PER_LINE в строку
        for (int i = 0; i < array.length; ++i) {
            // если для очередного элемента массива предикат выдал true,
            // то выводить строку цвета, если нет - пустую строку
            // всегда выводим команду отключения цвета \033[0m
            int item = array[i];   // для минимизации количества индексирований
            System.out.printf("%s%8d\033[0m", predicate.test(item)?color:"", item);

            // перевод строки после вывода очередных PER_LINE элементов
            if ((i+1) % PER_LINE == 0) System.out.println();
        } // for

        // перевод строки при незаполненной последней выводимой строке
        if (array.length % PER_LINE != 0) System.out.println();
    } // showArray

} // class ArrayUtils
