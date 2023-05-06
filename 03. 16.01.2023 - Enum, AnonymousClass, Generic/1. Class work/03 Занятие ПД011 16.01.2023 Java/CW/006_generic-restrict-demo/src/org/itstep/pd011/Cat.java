package org.itstep.pd011;

/**
 * Класс, реализующий интерфейс Comparable
 */
public class Cat implements Comparable<Cat> {
    String name;
    int age;
    double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // метод - реализация интерфейса Comparable
    public int compareTo(Cat t) { return age - t.age; /* Integer.compare(age, t.age); */}

    @Override
    public String toString() {
        return "Cat {" + name + ", возрвст (лет): "  + age + ", вес (кг): " + weight + "}";
    }
}
