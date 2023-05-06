package org.itstep.pd011;

import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;

// основы синтаксиса Java
public class Main {
    public static void main(String[] args) {
        System.out.println("Привет, мир Java!");

        /*
        * \033 [3 b g r m - цвет текста
        *         0 0 0    черный     \033[30m
        *         1 0 0    синий      \033[34m
        *         0 1 0    зеленый    \033[32m
        *         0 0 1    красный    \033[31m
        * \033 [3
        * \033 [0m - сброс форматирования
        * \033 [4 b r g m - цвет фона
        * 1 - bold   3 - italic
        * http://microsin.net/adminstuff/xnix/ansivt100-terminal-control-escape-sequences.html
        *    0 Сбросить все атрибуты
        *    1 Bright (повышенная яркость)
        *    2 Dim (затемнение)
        *    3 Underscore (нижнее подчеркивание)
        *    4 Blink (мигание)
        *    5 Reverse (инверсия)
        *    6 Hidden (скрыть текст)
        *
        * Foreground Colours (цвет пера, этим цветом выводится текст):
        *    30 Black (черный)
        *    31 Red (красный)
        *    32 Green (зеленый)
        *    33 Yellow (желтый)
        *    34 Blue (синий)
        *    35 Magenta (пурпурный)
        *    36 Cyan (голубой)
        *    37 White (белый)
        *
        * Background Colours (цвет бумаги, или цвет фона):
        *    40 Black (черный)
        *    41 Red (красный)
        *    42 Green (зеленый)
        *    43 Yellow (желтый)
        *    44 Blue (синий)
        *    45 Magenta (пурпурный)
        *    47 White (белый)
        *    46 Cyan (голубой)
        * */

        System.out.println("\n \t \\\"Привет-\033[1;34mпривет\033[0m\", \033[31mмир \033[32mJava\033[34m!!!\033[0m");
        System.out.println("\n\t\\\"Привет-\033[2m\033[34mпривет\033[0m\", \033[31mмир \033[32mJava\033[34m!!!\033[0m");
        System.out.println("\n\t\\\"Привет-\033[3m\033[34mпривет\033[0m\", \033[31mмир \033[32mJava\033[34m!!!\033[0m");
        System.out.println("\n\t\\\"Привет-\033[1;47;34mпривет\033[0m\", \033[31mмир \033[32mJava\033[34m!!!\033[0m");
        System.out.println("\n\t\\\"Привет-\033[1;3;34mпривет\033[0m\", \033[31mмир \033[32mJava\033[34m!!!\033[0m");

        // Типы данных
        // Object - базовый класс для всех классов

        // Примитивные типы
        // byte, short, int, long - 1, 2, 4, 8 байт, целое со знаком
        // char                   - 2 байта, символ Unicode
        // boolean                - 1 байт, логический, не совместим с byte,
        //                          true не заменятся 1, false не заменяется 0
        // float, double          - 4, 8 байт IEEE-754 числа с плавающей запятой

        // int    -- Integer объектный тип-оболочка
        // float  -- Float объектный тип-оболочка
        // double -- Double объектный тип-оболочка

        // объявление переменных можетсовмещаться или не совмещаться с инициализацией
        // тип имя1, имя2, ..., имяN;
        // тип имя1=значение1, имя2, ..., имяN=значениеN;
        int f, g;
        int h = -1, k = 2;

        // для объявляения переменных с обязательной инициализацией есть
        // ключевое слово var
        var u = 42;
        var x = 4.2f;
        System.out.println(" h = " + h + ", k = " + k + ", u = " + u + ", x = " + x);

        // Особый объектный тип
        // String - объект, не изменяемый, создается не только конструктором, но
        //          и присваиванием
        String str = "Это строка в Java";
        var str1 = "Это тоже строка в Java";
        var str2 = """
                Многострочная строка 
                в Java
                """;
        System.out.println("\n\"" + str + "\"\n\"" + str1 + "\"\n" + str2 + "\n");

        // изменяемые строки в Java:
        // StringBuffer - потоко-безопасная изменяемая строка
        // StringBuilder - потоко-небезопасный аналог StringBuffer
        StringBuffer sb = new StringBuffer(str);
        sb.setCharAt(0, 'э');
        System.out.println("\nStringBuffer: \\\"" + sb.toString() + "\"\\\n");


        // массивы (объявление и создание можно разнести) - это тоже
        // объекты, длина массива не меняется, память после выхода массива
        // из области видимости освобождается сборщиком мусора виртуальной
        // машины Java
        // тип[] имя = new тип[размер];
        // тип[] имя = {список занчений для инициализации};
        // int[] arr0;
        int[] arr1 = new int[10];
        // var arr1 = new int[10];
        int[] arr2 = {2, 5, 6, -1, 2, 3, 7, 9, 11, 88};

        // операторы
        // присваивание: = (и составное и сложное присутствуют)
        //     составное x = t = v = 1;
        //     сложное   x += 6;
        // арифметические
        //     унарные: + - ++ --
        //     бинарные: + - * / %
        // сравнение: < <= == != >= > (тип результата boolean)
        // логические:
        //     !  (отрицание), & (И, полная схема вычисления)
        //     && (И, краткая схема вычисления)
        //     |  (ИЛИ, полная схема вычисления)
        //     || (ИЛИ, краткая схема вычисления)
        // тернарная операция: ?:
        // индексирование: []
        // объектный доступ: .
        // конкатенация строк: +

        // Для инженерных расчетов есть класса Math с набором констант и функций
        double y = Math.abs(-Math.PI);

        // константы в Java:
        // final тип ИМЯ = значение;
        final String DEF_STR = "Привет, мир";
        final var DEF_VALUE = 9.81;
        System.out.println("\nКонстанты: DEF_STR = " + DEF_STR + ", DEF_VALUE = " + DEF_VALUE + "\n");

        // Форматный вывод:
        // System.out.printf(форматнаяСтрока, списокЗначений);
        // String имя = String.format(форматнаяСтрока, списокЗначений);

        // форматы: %n.mS
        //           n - необязательная общая длина поля вывода
        //           m - количество знаков после запятой (в дробной части)
        //           S - спецификация типа, %d - целые типы, %f - вещественные
        //               типы, %b - boolean, %c - char, %s - String
        String fmt = "Форматированный вывод. Значение ПИ: %.15f;  строка: \"%s\"\n";
        System.out.printf(fmt, y, DEF_STR);

        str = String.format(fmt, y, DEF_STR);
        System.out.println(str);


        int a;

        /*
        // Ввод с клавиатуры при помощи объекта класса Scanner
        // Scanner sc = new Scanner(System.in);
        // аналог using, try с ресурсами
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите целое и вещественное число (целая и дробная части отделяются запятой)> ");
            a = sc.nextInt();
            y = sc.nextDouble();  // целая и дробная части отделяются запятой

            System.out.printf("\nВы ввели: %d и %f\n", a, y);

            // %k$n.mS  k$ - порядковый номер (начинается с 1) для переменной в списке вывода
            System.out.printf("\nВы ввели: %1$d и %2$f или %2$.3f\n", a, y);

            // закрытие автоматическое, из-за использования try с ресурсами
            // sc.close();
        } // try-with-resources
        */

        /*
        // Ввод при помощи диалоговых окон класса JOptionPane
        // Integer - класс-оболочка над примитивным типом int
        a = 42;
        str = JOptionPane.showInputDialog(null, "Введите целое число", a);
        a = Integer.parseInt(str);

        // пример формирования строки и вывода ее и в консоль и в диалоговое окно
        str = String.format("Вы ввели: %d\n", a);
        System.out.println(str);
        JOptionPane.showMessageDialog(null, str, "К сведению", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "<html><h3 style='color: blue;'>" + str, "К сведению", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "<html><h3>" + str, "К сведению", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "<html><h3>" + str, "К сведению", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "<html><h3>" + str, "К сведению", JOptionPane.PLAIN_MESSAGE);
        */

        
        // Диалоговое окно ввода данных - buttons
        int cmd = JOptionPane.showOptionDialog(null,
                "<html><h3>Выберите <u>команду</u>:</h3>",
                "Выбор",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(Main.class.getResource("cat.png")),
                new Object[] {"команда 1", "команда 2", "команда 3"},
                "команда 1");
        System.out.printf("Вы выбрали команду номер %d\n", cmd+1);
        

        /*
        // Диалоговое окно ввода данных - combo-box
        Object result = JOptionPane.showInputDialog(null,
                "<html><h3>Выберите <u>любимый</u> напиток:</h3>",
                "Выбор напитка",
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(Main.class.getResource("leopard.png")),
                new Object[] {"чай", "кофе", "вода", "кока-кола", "спрайт"},
                "кофе");
        System.out.printf("Вы выбрали напиток \033[1;4m  %s  \033[0m\n", result);
        */

        /*
        // Ввод вещественного числа при помощи диалоговых окон класса JOptionPane
        // ‼ при вводе целая часть от дробной отделяется точкой
        str = JOptionPane.showInputDialog(null, "Введите вещественное число (целое.дробное)", y);
        y = Double.parseDouble(str);
        str = String.format("Вы ввели: %f\n", y);
        System.out.println(str);
        JOptionPane.showMessageDialog(null, str, "К сведению", JOptionPane.INFORMATION_MESSAGE);
        */

        // -------------------------------------------------------------------------------------------------

        // Управляющие операторы
        // if (условие) оператор1;
        // if (условие) оператор1; else оператор2;
        // switch(выражение) {case значение: операторы; break; ... default: ...}
        // for(exp1; exp2; exp3) оператор;
        // for(тип имя:имяКонтейнера) оператор;
        // while(exp) оператор;
        // do оператор; while(exp);
        // break, continue - аналогичны C#, C++, JS, PHP
        // goto - ключевое слово есть, оператора нет

        // Исключения
        // try { ... } catch (Тип1 имя1) { ... } ... catch (ТипN имяN) { ... } finally ( ... )
        // throw выражение; или throw;
        // выражение - объект исключения, готовый или создается при помощи new
        // форма throw; используется при повторных выбросах исключений
        // исключения - иерархия классов от класса Throwable, чаще всего
        // ограничиваются Exception (исключения более общего типа ставятся
        // последними в списке catch)

        // Методы - передача параметров только по значению, возможна
        // перегрузка методов, есть конструкция для передачи списка
        // параметров неограниченной длины
        // нет параметров по умолчанию
        try {
            a = 42;
            foo();
            bar(a, y, arr1);
            bar(23, Math.E, arr2);

            // Генерация случайных чисел
            Random rand = new Random();
            a = -50 + rand.nextInt(101);  // int:   -50 ... 50
            y = -5 + 10 * rand.nextDouble();     // double: -5 ...  5
            bar(a, y, arr2);

            // вызовет исключение :)
            bar(a, y, null);
        } catch (Exception ex) {
            // обработка исключения
            // System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            System.out.println("Обязательный к выполнению код");
        } // try-cach-finally
    } // main

    // метод без параметров
    private static void foo() {
        System.out.println("foo: работа метода\n");
    } // foo

    // метод с параметрами
    private static void bar(int a, double y, int[] arr) {
        System.out.println("bar: работа метода\n");
        System.out.printf("a = %d, y = %.3f\n", a, y);

        // если массива нет - выброс исключения
        if (arr == null) {
            throw new InvalidParameterException("bar: Нет массива для обработки");
        } // if

        // Цикл типа "Для каждого" - только чтение
        System.out.print("bar: массив данных ");
        for (var x:arr) {
            System.out.printf("%6d", x);
        } // for
        System.out.println();
    } // bar

} // class Main
