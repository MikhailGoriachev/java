package org.itstep.pd011;

import java.io.Serializable;

//  implements Serializable - условие сериализации
public class ClassA implements Serializable {

    // не сериализуются поля static и transient
    // transient - модификатор, запрещающий сериализацию поля класса

    // исключение из правила, версия файла данных, единственный
    // случай, когда записывается static
    // проверять эту версию при десериализации
    private static final long serialVersionGID = -1;

    // поля класса
    private String str;
    private int anInt;

    private double aDouble;
    transient private double b1;


    // ансамбль конструкторов
    public ClassA() { this(0, "", 0.);}
    public ClassA(int a, String str, double b) {
        this.anInt = a;
        this.str = str;
        this.aDouble = b;
    } // ClassA

    // Геттеры и сеттеры для полей класса
    public int getAnInt() { return anInt; }
    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public double getaDouble() {
        return aDouble;
    }
    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public String getStr() { return str;  }
    public void setStr(String str) {
        this.str = str;
    }

    public double getB1() {  return b1;   }
    public void setB1(double b1) {
        this.b1 = b1;
    }

    // вывод в строку - для всех полей класса
    @Override
    public String toString() {
        return String.format("a = %3d; str = \"%-20s\"; b = %.6f; b1 = %.6f",
                anInt, str, aDouble, b1);
    }
} // class ClassA
