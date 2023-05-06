package org.itstep.pd011;

// Новые (расширенные) возможности интерфейсов Java (^8)
public interface INewFeatures {
    void foo();  // традиционные возможности
    int twice();

    // реализация метода по умолчанию
    default int summa(int a, int b) { return a + b;}

    // статические методы - вызывается без создания
    // переменной интерфейстного типа
    // INewFeatures.bar()
    static void bar() {
        System.out.println("INewFeatures: это метод bar()");
    }

    // объявление констант
    int N_ITEMS = 7;  // public static final - эти квалификаторы действуют по умолчанию
} // INewFeatures
