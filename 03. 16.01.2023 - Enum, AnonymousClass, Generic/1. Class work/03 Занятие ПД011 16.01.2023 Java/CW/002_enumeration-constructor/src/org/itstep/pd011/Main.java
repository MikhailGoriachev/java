package org.itstep.pd011;

public class Main {

    public static void main(String[] args) {
        // Numbers.values() - возвращает все значения перечисления
        for (Numbers num:Numbers.values()) {
            // используем метод getOrdinal() для полученя порядкового номера значения перечисления
            // используем метод getValue() для полученя значения перечисления
            System.out.printf("%-8s    %3d    \033[34m%3d\033[0m\n", num, num.ordinal(), num.getValue());
        } // foreach


        // альтернатива перечислению
        ClassINumbers a = new ClassINumbers();
        System.out.print("\nАльтернатива перечислению - класс с интерфейсом, содержащим константы: ");
        System.out.printf("\033[34m%d, %d, %d, %d, %d\033[0m\n", a.ONE, a.TWO, a.THREE, a.FOUR, a.FIVE);

    } // main
} // class Main
