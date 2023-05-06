package org.itstep.pd011;

/**
 * Функциональный интерфейс - интерфейс объявляющий единственный метод
 * это возможность появилось Java 8
 *
 */
@FunctionalInterface
public interface Printable {
    void show(String str); // т.к. не возвращает значение - терминальный метод
}
