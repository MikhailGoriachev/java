package org.itstep.pd011;

// пример анонимных классов в перечислении
public enum Shape {
    RECTANGLE,
    SQUARE,

    // анонимный класс
    TRIANGLE {
        public double area() {
            return a * b / 2;
        }
    },

    // еще один анонимный класс
    CIRCLE {
        public double area() {
            return Math.PI * a * a;
        }

        public void setShape(double a, double b) {
            this.a = a;
            this.b = a;
        } // setShape
    };

    // ----------------------------------------------------

    public double a;
    public double b;

    // ----------------------------------------------------

    public double a() {
        return a;
    }

    public double b() {
        return b;
    }

    public void setShape(double a, double b) {
        this.a = a;
        this.b = b;
    } // setShape

    // ----------------------------------------------------

    // вычисления для RECTANGLE, SQUARE
    public double area() { return a * b; }

    // -----------------------------------------------------

    @Override
    public String toString() {
        return String.format("%s->{a=%.3f; b=%.3f}", name(), a, b);
    } // toString
}
