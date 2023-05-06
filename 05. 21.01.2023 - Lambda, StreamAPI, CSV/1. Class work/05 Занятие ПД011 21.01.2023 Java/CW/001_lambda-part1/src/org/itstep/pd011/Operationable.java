package org.itstep.pd011;

/**
 * Функциональный интерфейс - интерфейс объявляющий единственный метод
 * это возможность появилось в Java 8
 *
 */
@FunctionalInterface
public interface Operationable {
    int oper(int a, int b);    // т.к. возвращает значение - обычный метод
    // метод, возвращающий void - терминальный метод

    // методы по умолчанию м.б. в любом интерфейсе
    default int add(int a, int b) { return a + b; }
    default int rem(int a, int b) { return a % b; }

    // константу тоже можно использовать
    int s = 1;
 } // interface
