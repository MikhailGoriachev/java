package org.itstep.pd011;

/**
 * Ограничения по типу
 * Создание обобщенного класса с использованием ограничений типа extends ИмяПараметра
 * допустимы только типы наследующие заданный класс
 *
 * Number - базовый класс для всех числовых оболочечных классов
 * Integer, Float, Double, ...
 */

// !!! ограничение действует на ближаший тип в объявлении !!!
public class GenericTwo<T, V extends Number> {
    private T a;   // поле класса с типом T - тип без ограничений
    private V b;   // поле класса с типом V - тип с ограничением - потомок Number

    public GenericTwo(T a, V b) {
        this.a = a;
        this.b = b;
    } // GenericTwo

    public T getA() { return a; }  // getA
    public void setA(T a) {
        this.a = a;
    } // setA

    public V getB() {
        return b;
    }  // getB
    public void setB(V b) {
        this.b = b;
    } // setB

    // операции с обобщенными типами выполнять трудно и это не
    // всегда возможно - вызов метода получения значения м.б.
    // очень затратным (например, имяОбъекта.doubleValue() может длительно
    // выполянть приведение к типу Double)
    double add(V x) { return b.doubleValue() + x.doubleValue(); } // add
    boolean lt(V x) { return b.doubleValue() < x.doubleValue();}

    @Override
    public String toString() {
        return a.toString() + " " + b.toString();
    } // toString
} // class GenericTwo
