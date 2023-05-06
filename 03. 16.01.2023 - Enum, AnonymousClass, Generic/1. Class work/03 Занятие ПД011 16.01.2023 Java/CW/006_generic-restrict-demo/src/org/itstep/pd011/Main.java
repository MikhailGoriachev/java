package org.itstep.pd011;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // пример использования обобщенного класса с ограничениями
        // по типу
        // demoGenericClass();

        // пример использования обобщенного метода в необобщенном классе
        demoGenericMethod();
    } // main

    // пример использования обобщенного класса с ограничениями по типу
    private static void demoGenericClass() {
        // класс для статистических вычислений - тип целый
        Stats<Integer> intArr = new Stats<>(new Integer[] {1, 2, 3, 6, 4});
        System.out.println("Массив Integer: " + Arrays.toString(intArr.getData()));

        double avg = intArr.average();
        System.out.printf("average = %.3f\n", avg);

        System.out.println("\n-------------------------------------------------\n");

        Stats<Double> dblArr = new Stats<>(new Double[] {1., 2., 3., 6., 4.});
        System.out.println("Массив Double:\n" + Arrays.toString(dblArr.getData()));

        avg = dblArr.average();
        System.out.printf("average = %.3f\n", avg);

        System.out.println("\n-------------------------------------------------\n");

        Stats<Integer> intArr2 = new Stats<>(new Integer[] {2, 1, 6, 4, 3});
        System.out.println("Еще массив Integer:\n" + Arrays.toString(intArr2.getData()));

        // пример использования подстановочного метасимвола ?
        System.out.println("Совпадают средние для intArr и intArr1: " + intArr.sameAverage(intArr2));
        System.out.println("Совпадают средние для intArr и dblArr : " + intArr.sameAverage(dblArr));

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("Сортировки массивов:");

        // сортировка и вывод методом класса Arrays
        intArr.sort();
        System.out.println(Arrays.toString(intArr.getData()));

        // сортировка и вывод методом нашего класса Stats
        dblArr.sort();
        System.out.println(dblArr);

        System.out.println("\n-------------------------------------------------\n");
    } // demoGenericClass

    // пример использования обобщенного метода в необобщенном классе
    private static void demoGenericMethod() {

        double a = 1., b = 2.;
        double c = add(a, b);  // вызов обобщенного метода
        System.out.printf("a + b = %.2f + %.2f = %.2f\n", a, b, c);

        int k = -5, v = -6;
        c = add(k, v);
        System.out.printf("k + v = %d + %d = %.2f\n", k, v, c);
        System.out.println();


        // демо сравнения - ограничение типа в методе
        String s1 = "ананас", s2 = "яблоко";
        System.out.println(min(s1, s2));

        int kk = -5, vv = -6;
        // System.out.println(min(new Integer(kk), new Integer(vv)));
        System.out.println(min(kk, vv));

        Cat cat1 = new Cat("Вася", 5, 3);
        Cat cat2 = new Cat("Мурка", 3, 5);
        System.out.println(min(cat1, cat2));

        Dog dog1 = new Dog("Шарик", 5, 3);
        Dog dog2 = new Dog("Жучка", 3, 5);
        System.out.println(min(dog1, dog2));

        // демонстрация вызова исключения - вот вам и безопасность...
        // System.out.println(min(cat1, dog2));

        Dog dog = dog1.min(dog2);
        System.out.println("Собака с минимальным веслм: " + dog);

        dog = dog1.min(dog1, dog2);
        System.out.println("Собака с минимальным веслм: " + dog);
    } // demoGenericInterface

    // можно использовать обобщенные методы в необобщенных классах
    // сумма двух чисел
    // <обобщенные типы с ограничениями> тип имя(параметры) {}
    public static <T extends Number> double add(T a, T b) { return a.doubleValue() + b.doubleValue(); }

    // пример - требуем, чтоб тип T реализовывал интерфйес Comparable, т.е. метод compareTo
    // и возвращаем меньший из двух объектов
    // нетипизированный Comparable потенциально опасен, пример - min(cat1, dog2)
    // проходит компиляцию, но приводит к падению приложения
    // public static <T extends Comparable> T min(T x, T y) {
    public static <T extends Comparable<T>> T min(T x, T y) {
        return x.compareTo(y) <= 0?x:y;
    } // min
} // class Main
