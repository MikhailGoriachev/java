package org.itstep.pd011;

public class Main {

    public static void main(String[] args) {
        System.out.print("\nПять параметров: ");
        int t = foo(-1, 2, 2, 3, 4);
        System.out.printf("\nСумма этих чисел: \033[34;1m%d\033[0m\n", t);

        System.out.print("\nВосемь параметров: ");
        t = foo(1, 1, 1, 1, 2, 2, 2, 3);
        System.out.printf("\nСумма этих чисел: \033[34;1m%d\033[0m\n", t);
    } // main

    // метод принимает любое количество параметров типа int
    // тип имяМетода(тип... имяПарам) { ... имяПарам[i] ... }
    // params - псевдомассив
    private static int foo(/* float a, boolean b, */int... numbers) {
        int sum = 0;

        System.out.print("параметры: ");
        for (int x:numbers) {
            System.out.printf("%5d", x);
            sum += x;
        } // for each

        // слово "debug" выводим красным цветом, полужирным шрифтом
        System.out.printf("\n\033[31;1mdebug:\033[0m первый параметр    = %d\n", numbers[0]);
        System.out.printf("\033[31;1mdebug:\033[0m последний параметр = %d\n", numbers[numbers.length-1]);
        return sum;
    } // foo
} // class Main
