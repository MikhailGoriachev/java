package org.itstep.pd011;


// обобщенный интерфейс: допустим тип - наследник
// ссылочного типа, реализующего интерфейс Comparable,
// специфицированный типом T
public interface  Minimum <T extends Comparable<T>> {
    T min(T op);
    T min(T op1, T op2);
} // Minimum
