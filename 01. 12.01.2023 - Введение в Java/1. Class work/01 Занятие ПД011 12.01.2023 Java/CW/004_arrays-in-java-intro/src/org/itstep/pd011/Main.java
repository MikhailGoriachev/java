package org.itstep.pd011;


import java.util.Arrays;
import java.util.Comparator;

// обратите внимание на статический импорт
import static org.itstep.pd011.Utils.getRandom;

public class Main {

    public static void main(String[] args) {

        System.out.println("Демонстрация работы с массивами в Java - средства языка, не используем Stream API");

        // одномерные массивы
        // arrayDemo();

        // многомерные массивы
        matrixDemo();
    } // main

    private static void arrayDemo() {
        /*
         * Массивы в Java - это объекты, массивы только динамические
         *
         * Объявление:  тип[] имя;
         * Создание: имя = new тип[размер];
         * Можно объединить: тип[] имя = new тип[размер];
         * размер массива - свойство/поле length, размер массива не меняется
         * Инициализация: тип[] имя = {списокИнициализации};
         *
         * Доступ к элементу - операция [] индексирование
         *
         * */

        int[] arr = new int[10];  // инициализация элементов нулем соответствующего типа
        String[] text = {"строка1", "строка2", "строка3", "строка4", "строка5"};

        // доступ как по чтению так и по записи
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100*i + 1;               // запись
            System.out.printf("%6d", arr[i]); // чтение
        } // for i
        System.out.println(); // перевод строки

        // доступ только по чтению - цикл типа "для каждого"
        System.out.println("Массив arr " + arr + ": ");
        for (var item:arr) {
            System.out.printf("%6d", item);
        } // for each
        System.out.println("\n\n"); // перевод строки

        // вывод массива строк
        System.out.println("Массив строк:\033[34m");
        for (var s : text) {
            System.out.println(s);
        }
        System.out.println("\033[0m");

        // работа методов с массивами
        arr = createArray(12);
        fill(arr, -90, 90);
        System.out.println(arrToString(arr, "\nПример вывода массива:\n"));

        // некоторые методы класса Arrays
        System.out.println("\nМассив arr: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(arrToString(arr, "\nМассив отсортирован по возрастанию:\n"));

        // можно сортировать и по убыванию, но для классов-объектных оболочек
        // примитивных типов
        // Integer[] arr1 = new Integer[10];
        // Arrays.sort(arr1, (x, y) -> -x.compareTo(y));
    } // arrayDemo

    // возврат массива из методв
    private static int[]createArray(int n) {
        // коротко, но, может быть не понятно
        // return new int[n];
        int[] arr = new int[n];
        return  arr;
    } // createArray

    // передача массива в метод
    private static void fill(int[] arr, int lo, int hi) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandom(lo, hi);
        } // for i
    } // fill

    // вывод массив в переменную типа String, при помощи объекта
    // класса StringBuilder
    private static String arrToString(int[] arr, String title) {
        StringBuilder sbf = new StringBuilder(title);

        for (int x:arr) {
            // bgr --> 31 это красный
            sbf.append(String.format("\033[%sm%6d\033[0m", (x >= 0?"31;1":"34"), x));
        } // for i
        sbf.append("\n");

        return sbf.toString();
    } // arrToString

    static void matrixDemo() {
        /*
         * Многомерные массивы - матрицы
         * Это м.б. прямоугольные или рваные массивы
         *
         * Объявление: тип[][] имя;
         * создание  : имя = new тип[строки][столбцы];
         * создание  : имя = new тип[строки][столбцы] {список инициализации};
         *
         * доступ к элементу имя[индексСтроки][индексСтолбца]
         *
         * */

        int[][] matrix = new int[3][5];

        fill(matrix, -10, 10);
        show("\nПрямоугольная матрица:\n", matrix);

        System.out.print("\nПример инициализации матрицы:\n");
        int[][] sqr = {{1, 2,  3}, {3, 4, 5}, {5, 6, 7}};  // инициализация матрицы
        show("\nКвадратная матрица\n", sqr);

        // демо вывода матрицы в строку вместе с командами задания цвета
        String str = matrixToString("\n\033[1;34;47m   Квадратная матрица    \033[0m\n", sqr);
        System.out.print(str);
    } // matrixDemo

    // заполнение матрицы случайными числами в диапазоне от lo до hi
    private static void fill(int[][] matrix, int lo, int hi) {
        // получение размерности матрицы
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {       // строк в матрице     matrix.length
            for (int j = 0; j < cols; j++) {   // столбцов в матрице  matrix[0].length
                matrix[i][j] = getRandom(lo, hi);
            } // for j
        } // for i
    } // fill

    // вывод матрицы в консоль, выделяем цветом четные и нечетные элементы
    private static void show(String title, int[][] matrix) {
        System.out.print(title);

        for (int[] row:matrix) {    // для каждой строки матрицы
            for (int item:row) {    // для каждого элемента в строке
                // выводим четные элементы синим цветом, нечетные
                // элементы - зеленым
                // String color = (item % 2 == 0)?"\033[1;34m":"\033[1;32m";
                // System.out.printf("%s%6d", color, item);
                System.out.printf("%s%6d", (item % 2 == 0)?"\033[1;34m":"\033[1;32m", item);
            } // for item
            System.out.println();
        } // for row
        System.out.print("\n\033[0m");  // перевод строки и сброс форматирования
    } // show

    // вывод матрицы в консоль, выделяем цветом четные и нечетные элементы
    // вывод в объект класса StringBuilder
    private static String matrixToString(String title, int[][] matrix) {
        StringBuilder sb = new StringBuilder(title);

        for (var row:matrix) {    // для каждой строки матрицы
            for (var item:row) {    // для каждого элемента в строке
                // выводим четные элементы синим цветом, нечетные
                // элементы - зеленым
                String color = (item % 2 == 0)?"\033[1;34m":"\033[32m";
                sb.append(String.format("%s%6d", color, item));
            } // for item
            sb.append("\n");
        } // for row
        sb.append("\n\033[0m");  // перевод строки и сброс форматирования

        return sb.toString();
    } // matrixToString
} // class Main
