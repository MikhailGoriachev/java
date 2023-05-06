package org.itstep.pd011;

/**
 * Функциональный интерфейс - интерфейс объявляющий единственный метод
 * это возможность появилось Java 8
 * Функциональный интерфейс может быть обобщенным
 *
 */
@FunctionalInterface
public interface GenericOperationable<T> {
    T oper(T a, T b);
}
