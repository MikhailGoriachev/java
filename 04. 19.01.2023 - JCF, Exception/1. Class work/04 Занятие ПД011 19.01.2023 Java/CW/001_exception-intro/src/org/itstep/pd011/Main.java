package org.itstep.pd011;

import javax.swing.*;
import java.security.InvalidParameterException;

public class Main {

	/*
	* Исключения. Иерархия исключений
	*
	*    Throwable   --- производный Error - внутренние ошибки JVM,
	*                    это непроверяемые исключения
	*                --- производный Exception это проверяемые исключения
	*                               -----  RuntimeException - ошибки в процессе работы приложения
	*                               -----  IOException      - ошибки ввода-вывода
	*
	*
    * Error     - ошибки времени исполнения JVM - не перехватываются, не обрабатываются
    * Exception - ошибки приложений
    *     ☼ проверяемые исключения (наследуют от Exception) - возможность их возникновения
    *       проверяется компилятором (например, возможность выхода за пределы массива...)
     *      компилятор требует try {} в теле метода или throws в заголовке метода
    *     ☼ непроверямые исключения (наследуют от RuntimeException) - компилятор не
    *       проверяет возможность их возникновения
    * */
    public static void main(String[] args) /* throws ArrayStoreException */  {
        System.out.println("☼ ☼ ☼ ☼ ☼");
        // throw  new ArrayStoreException("Пример исключения");

        try {
            // throw  new Exception("Пример исключения");

            // ArrayIndexOutOfBoundsException наследуется от  IndexOutOfBoundsException =>
            // обрабатывается ув блоке IndexOutOfBoundsException
           //  throw  new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException: Пример исключения");

            foo();
            // throw  new ArithmeticException("Пример исключения");
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
            // throw ex;
        } catch (IndexOutOfBoundsException | ArithmeticException | MyException ex ) {
            System.out.println(ex.getClass() + ": " + ex.getMessage());
            throw ex; // повторная генерация исключения
        } catch (Exception ex) {

            // При обработке тоже могут возникать исключения
            try {
                // ex.printStackTrace(); // вывод в параллельном потоке исполнения

                System.out.println("отработал catch");
                System.out.println(ex.getMessage());
                System.out.println(ex.getLocalizedMessage());

                JOptionPane.showMessageDialog(null, "foo - " + ex.getMessage());
            } catch (Exception e) {
                // эту цепочку можно продолжать и дальше, но можно и прервать
                // исключение будет передано на уровень вверх - в точку вызова метода
                // и продолжит обработку там, если предусмотрен код обработки
                // если кода нет, увидим сообщение JVM
                JOptionPane.showMessageDialog(null, "foo - Exception - " + e.getMessage());
                throw new ArithmeticException("И еще - еще одно исключение!");
            } // try-catch
        } finally {  // блок кода, выполняемый всегда
            System.out.println("отработал finally");
            Utils.sc.close();
        } // try-catch-finally

        // пример символов, набираемых с Alt+code
        System.out.println("☺ ☻ ♥ ♦ ♣ ► • ◘ ○ ◙ ♂ ♀ ♪ ♫ ► ◄ ↕ ‼ ¶ § ▬");
    } // main

    // метод в котором возникает исключение
    // обработка: нет обработки, обработка выше по стеку, обработка в методе
    private static void foo() /* throws InvalidParameterException */ {
        try {
            int a, b;
            System.out.print("Два целых через пробел: ");
            a = Utils.sc.nextInt();
            b = Utils.sc.nextInt();
            if (b == 0) throw new InvalidParameterException("Знаменатель не может быть равен нулю");

            int c = a / b;
            System.out.println("c = " + c);
            throw new MyException("Это наше исключение");
         } catch (MyException ex) {
            System.out.println("foo: частичная обработка исключения");
            throw ex;
         } // try-catch
    } // foo
} // class Main
