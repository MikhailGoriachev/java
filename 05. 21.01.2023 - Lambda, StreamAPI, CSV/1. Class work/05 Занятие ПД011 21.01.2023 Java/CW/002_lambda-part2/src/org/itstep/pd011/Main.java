package org.itstep.pd011;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {

    // константа в Java
    final static String MAGENTA = "\033[35m";

    public static void main(String[] args) {
        int[] array = new int[] {-1, 2, 3, -2, 0, 3, 0, -2, 1};
        ArrayUtils.showArray("Массив целых чисел: ", array);
        System.out.println();

        int posSum, negSum, posTotal;

        /*
        // суммирование только положительных элементов массива
        // с использованием анонимного класса в стиле "быстро, но грязно"
        posSum = summa(array, new Predicate<Integer>() {
            @Override
            public boolean test(Integer item) {
                return item > 0;
            } // test
        });
        System.out.printf("сумма положительных равна %d\n", posSum);

        // подсчет количество положительных элементов
        posTotal = count(array, new Predicate<Integer>() {
            @Override
            public boolean test(Integer item) {
                return item > 0;
            }
        });
        System.out.printf("\nКоличество положительных элементов: %d\n", posTotal);

        // та же сумма, но реализованная лямбда-выражением
        posSum = summa(array, item -> item > 0);
        System.out.printf("сумма положительных равна %d\n", posSum);

        posTotal = count(array, item -> item > 0);
        System.out.printf("\nКоличество положительных элементов: %d\n", posTotal);

        // та же сумма, но реализованная при помощи ссылки на метод
        // передача в качестве параметра ссылки на метод
        // статический метод -- ИмяКласса::имяМетода
        negSum = summa(array, Main::isNegative); // сумма отрицательных
        System.out.printf("сумма отрицательных равна %d\n", negSum);

        posSum = summa(array, Main::isPositive);
        System.out.printf("сумма положительных равна %d\n", posSum);

        posTotal = count(array, Main::isEven);
        System.out.printf("\nКоличество четных элементов: %d\n", posTotal);
        */


        // передача в качестве параметра ссылки на метод
        // обычный метод -- имяОбъекта::имяМетода
        DemoClass demo = new DemoClass();
        negSum = summa(array, demo::isDemoClassNegative); // сумма отрицательных
        System.out.printf("сумма отрицательных равна %d\n", negSum);

        posSum = summa(array, demo::isDemoClassPositive);
        System.out.printf("сумма положительных равна %d\n", posSum);

        posTotal = count(array, demo::isDemoClassPositive);
        System.out.printf("\nКоличестов положительных элементов: %d\n", posTotal);

        // использование метода анонимного объекта класса DemoClass
        negSum = summa(array, new DemoClass()::isDemoClassNegative); // сумма отрицательных
        System.out.printf("сумма отрицательных равна %d\n", negSum);

        // -------------------------------------------------------------------

        // передача конструкторов
        // DemoClassBuilder builder = str1 -> new DemoClass(str1); // вместо create подставляется ссылка на метод-конструктор
        DemoClassBuilder builder = DemoClass::new;          // вместо create подставляется ссылка на метод-конструктор
        demo = builder.create("строка для работы метода");  // т.е. при вызове create() фактически вызывается конструктор
        // demo = builder.create(122);  // т.е. при вызове create() фактически вызывается конструктор

        negSum = summa(array, demo::isDemoClassNegative);
        System.out.printf("сумма отрицательных равна %d\n", negSum);
        // -------------------------------------------------------------------

        // создание объекта при помощи фабрики классов
        demo = objectDemoClassFactory(DemoClass::new, "Строка - параметр");
        negSum = summa(array, demo::isDemoClassNegative);
        System.out.printf("сумма отрицательных равна %d\n", negSum);

        // еще один вариант передачи конструктора - явная реализация
        // интерфейса DemoClassBuilder  лямбда-выражением
        demo = objectDemoClassFactory(str -> new DemoClass(str), "Строка - параметр");
        negSum = summa(array, demo::isDemoClassNegative);
        System.out.printf("сумма отрицательных равна %d\n", negSum);

        demo = objectDemoClassFactory(DemoClass::new, 123);
        negSum = summa(array, demo::isDemoClassNegative);
        System.out.printf("сумма отрицательных равна %d\n", negSum);

        System.out.println();


        // для работы с компаратором используем массив с оболочечным типом
        Integer[] array1 = new Integer[array.length];
        for(int i = 0; i < array.length; ++i)  array1[i] = array[i];

        ArrayUtils.showArray("Массив для обработки  : ", array1, MAGENTA, item -> item % 2 == 0);
        Arrays.sort(array1, (o1, o2) -> o1 % 2 == 0?-1:1);
        ArrayUtils.showArray("Четные впереди        : ", array1, MAGENTA, Main::isEven);

        Arrays.sort(array1, (o1, o2) -> o1 < 0?-1:1);
        ArrayUtils.showArray("Отрицательные впереди : ", array1, MAGENTA, Main::isNegative);

    } // main


    // Фабрика класса DemoClass
    // Метод, принимающий в качестве параметра ссылку на ФИ
    // ФИ имеет метод, возвращающий объект класса DemoClass,
    // т.е. в качестве фактического параметра можно использовать
    // любой метод, возвращающий ссылку на объект класса DemoClass
    // в т.ч. конструктор класса DemoClass
    private static DemoClass objectDemoClassFactory(DemoClassBuilder builder, String s) {
        return builder.create(s);
    } // objectDemoClassFactory

    private static DemoClass objectDemoClassFactory(DemoClassBuilder builder, int param) {
        return builder.create(param);
    } // objectDemoClassBuilder

    // Метод для демонстрации возможности передачи ссылки на  метод
    // в качестве параметра
    private static int summa(int[] data, Predicate<Integer> filter) {
        int sum = 0;
        for (int datum : data) {
            // вызов метода объекта ФИ
            if (filter.test(datum)) sum += datum;
        } // foreach
        return sum;
    } // summa

    // Метод возвращает количество чисел, удовлетворяющих предикату
    private static int count(int [] data, Predicate<Integer> filter) {
        int counter = 0;
        for (int datum : data) {
            if (filter.test(datum)) ++counter;
        }

        return counter;
    } // count

    // Методы для передачи в метод summa
    private static boolean isNegative(int value) { return value < 0; }
    private static boolean isPositive(int value) { return value > 0; }

    private static boolean isEven(Integer item) { return (item & 1) == 0;  }
} // class Main
