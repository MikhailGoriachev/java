package org.itstep.pd011;

// пример абстрактного класса Java
public abstract class Base {
    private int a;      // в пределах класса
    protected double b; // в пределах класса и его наследников

    // блок инициализации, выполняется перед любым конструктором
    { a = -1; b = -2; }

    public Base(int a, double b) {
        this.a = a;
        this.b = b;
    } // Base

    public Base() {
        // Вызов другого конструктора класса - д.б. первой строкой
        this(-1, Math.E);

        System.out.println("Base: Конструктор по умолчанию выполнен");
    } // Base

    public int  getA() { return a; }
    public void setA(int a) { this.a = a; }

    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }

    // пример определения абстрактного метода
    abstract public void bar();

    // переопределенный метод суперкласса
    @Override
    public String toString() {
        return String.format("a = %d; b = %.5f", a, b);
    } // toString
} // class Base
