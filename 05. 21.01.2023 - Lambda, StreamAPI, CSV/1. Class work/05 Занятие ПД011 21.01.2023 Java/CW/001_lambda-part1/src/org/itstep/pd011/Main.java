package org.itstep.pd011;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// Введение в лямбда-выражения, функциональные интерфейсы
public class Main {

    public static void main(String[] args) {

        // реализация интерфейса анонимным классом
        Operationable oper1 = new Operationable() {
            @Override
            public int oper(int a, int b) {
                return a * b;
            }
        };

        // использование реализации интерфейса
        int x = 10, y = 20;
        int c = oper1.oper(x, y);
        System.out.printf("реализация \"быстро, но грязно\": %d * %d = %d\n", x, y, c);

        // метод по умолчанию из интерфейса конечно же доступен
        c = oper1.add(x, y);
        System.out.printf("метод по умолчанию: %d + %d = %d\n", x, y, c);

        // реализация функционального интерфейса Operationable лямбда-выражением
        Operationable oper2 = (u, v) -> u*v;
        c = oper2.oper(x, y);
        System.out.printf("лямбда-выражение: %d * %d = %d\n", x, y, c);

        // метод по умолчанию - доступен не зависимо от вида реализации интерфейса
        c = oper2.add(x, y);
        System.out.printf("add - метод по умолчанию: %d + %d = %d\n", x, y, c);
        c = oper2.rem(x, y);
        System.out.printf("rem - метод по умолчанию: %d %% %d = %d\n", x, y, c);


        System.out.println("\nТерминальный метод в лямбда-выражении:");
        // лямбда-выражение, возвращающее результат - вычислительное / обычное / промежуточное
        // лямбда-выражение, не возвращающее результат - терминальное
        Printable data = str -> System.out.print(str);  // терминальное выражение

        // свернутый вариант лямбда-выражения - ссылка на метод
        Printable data1 = System.out::println;  // терминальное выражение

        // Использование реализации интерфейса Printable
        data.show(String.format("%d * %d = %d\n", x, y, c));
        data.show("строка для вывода\n");
        data1.show("еще одна строка\n");

        System.out.println("\n——————————————————————————————————————————————————————————————————————————————\n");


        // Синтаксис лямбда-выражений
        // параметры -> реализация;

        // () -> оператор;                            // нет параметров, return или его отсутствие
        // () -> { операторы; return выражение; }     // обычное лямбда-выражение
        // () -> { операторы; }                       // для терминального лямбда-выражения

        // параметр -> оператор;                      // один параметр
        // параметр -> { операторы; return выражение; }
        // параметр -> { операторы; }                 // для терминального лямбда-выражения

        // (параметры) -> оператор;                   // список параметров
        // (параметры) -> { операторы; return выражение; }
        // (параметры) -> { операторы; }              // для терминального лямбда-выражения


        // пример реализации терминального блочного лямбда-выражения
        // Реализация интерфейса Printable - реализация метода show() интерфейса
        Printable print = str -> {
            System.out.print("\nНачинаем...\033[34m ");
            System.out.print(str);
            System.out.print(" \033[0mВсе!\n");
        };

        // вызов метода, реализующего интерфейс Printable
        print.show("Это строка");

        System.out.println("\n——————————————————————————————————————————————————————————————————————————————\n");

        /*
        // пример реализации вычислительного блочного лямбда-выражения
        // реализуем метод oper() интерфейса Operationable
        Operationable oper3 = (v, u) -> {
            int res = v * u;
            return res - 100;
        };
        print.show(String.format("%d", oper3.oper(10, 20)));`
        */

        /*
        // реализация лямбда-выражением обобщенного функционального интерфейса
        // GenericOperationable<Integer> oper4 = (v, u) -> v + u;
        // код упрщается до вызова метода Integer::sum
        GenericOperationable<Integer> oper4 = Integer::sum;
        print.show(String.format("%d", oper4.oper(10, 20)));

        GenericOperationable<String> oper5 = (v, u) -> v + u;
        print.show(String.format("%s", oper5.oper("Кот и ", "Пес")));

        System.out.println("\n——————————————————————————————————————————————————————————————————————————————\n");
        */

        /*
        * Встроенные ФИ (параметризированные):
        * Predicate<T>        boolean test(T t)
        * Consumer<T>         void    accept(T t)
        * Function<T, R>      R       apply(T t)
        * BinaryOperator<T>   T       apply(T v, T u)
        * UnaryOperator<T>    T       apply(T t)
        * Supplier<T>         T       get()
        *
        * */

        // примеры реализации встроенных интерфейсов
        System.out.println("\nПримеры реализации встроенных интерфейсов");
        Supplier<Integer> sup1 = () -> 100;
        System.out.printf("sup1 = %d\n", sup1.get());

        BinaryOperator<Double> dub1 = (o1, o2) -> o2*Math.sin(o1);
        double res = dub1.apply(Math.PI/3, 100.0);
        System.out.printf("res = %.3f\n\n", res);

        Predicate<Double> predicate = z -> z >= 0;
        System.out.println("При условии z >= 0:");
        System.out.printf("Для z = %.5f результат: %b\n", -Math.PI, predicate.test(-Math.PI));
        System.out.printf("Для z = %.5f результат: %b\n", Math.PI, predicate.test(Math.PI));
        System.out.printf("Для z = %.5f результат: %b\n", Math.E, predicate.test(Math.E));

        // Локальные переменные в лямбда-выражениях могут использоваться, но
        // они не могут изменяться, т.е. должны быть фактическими константами
        System.out.println("\n\nЛокальная переменная в лямбда-выражениях:");
        int t = 50;
        System.out.println("t = " + t);
        UnaryOperator<Integer> uno1 = u1 -> 100 + t + u1;  // лок. перем. t - в лямбда-выражении
        System.out.printf("%d", uno1.apply(0));
    } // main
}
