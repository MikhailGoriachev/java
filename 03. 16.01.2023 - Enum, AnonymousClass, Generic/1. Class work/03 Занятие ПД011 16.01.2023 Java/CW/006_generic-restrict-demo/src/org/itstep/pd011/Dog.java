package org.itstep.pd011;

/**
 * Класс, реализующий интерфейсы Comparable, Minimum
 */
public class Dog implements Comparable<Dog>, Minimum<Dog> {
    String name;
    int age;
    double weight;

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    } // Dog

    // метод - реализация интерфейса Comparable за счет встроенного в оболочечный
    // класс компаратора
    @Override
    public int compareTo(Dog t) { return Double.compare(weight, t.weight); }

    @Override
    public String toString() {
        return "Dog {" + name + ", возрвст (лет): "  + age + ", вес (кг): " + weight + "}";
    }

    @Override
    public Dog min(Dog op) {
        return weight < op.weight?this:op;
    }

    @Override
    public Dog min(Dog op1, Dog op2) {
        return op1.weight < op2.weight?op1:op2;
    }
}
