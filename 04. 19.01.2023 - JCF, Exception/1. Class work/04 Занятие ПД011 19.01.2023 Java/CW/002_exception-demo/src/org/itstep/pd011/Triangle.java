package org.itstep.pd011;

import java.security.InvalidParameterException;
import java.util.Locale;

public class Triangle {
    private double a, b, c;

    // блок инициализации
    {a = b = c = 1.0;}

    public Triangle() { }
    public Triangle(double a, double b, double c) throws InvalidParameterException {
        setSides(a, b, c);
    } // Triangle

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setSides(double a, double b, double c) throws InvalidParameterException {

        if (!isTrinagle(a, b, c)) {
            String strError = String.format(Locale.UK,"Значения %.3f; %.3f; %.3f не образуют стороны треугольника", a, b, c);
            throw new InvalidParameterException(strError);
        } // if

        // корректные значения
        this.a = a;
        this.b = b;
        this.c = c;
    } // setSides

    // проверка треугольника на сущствование
    private boolean isTrinagle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    } // isTrinagle

    // автосгенерированный метод
    @Override
    public String toString() {
        return "Triangle{a = " + a + ", b = " + b +  ", c = " + c + "}";
    } // toString
}
