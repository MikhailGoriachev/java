package org.itstep.pd011.models;

import java.security.InvalidParameterException;

/**
 * Класс для создания коллекции данных для выполнения запросов StreamAPI
 */
public class Person {
    private String name;   // имя персона
    private int    age;    // возраст в годах
    private String city;   // город проживания
    private double weight; // вес в кг

    // ансамбль конструкторов
    public Person() { }
    public Person(String name, int age, double weight, String city) {
        setName(name);
        this.age = age;
        this.weight = weight;
        this.city = city;
    } // Person

    // стандартный набор геттеров и сеттеров
    public double getWeight() { return weight;  }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null) throw new NullPointerException("Имя персоны не может быть null");
        if (name.isEmpty()) throw new InvalidParameterException("Имя персоны не может быть пустым");
        this.name = name;
    } // setName

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age <= 0) throw new InvalidParameterException("Возраст не может быть отрицательным");
        this.age = age;
    } // setAge

    public String getCity() { return city; }
    public void setCity(String city) {
        if (city == null) throw new NullPointerException("Название города не может быть null");
        if (city.isEmpty()) throw new InvalidParameterException("Название города не может быть пустым");
        this.city = city;
    } // setCity

    @Override public String toString() {
        return String.format("| %-11s | %13d | %7.2f | %-15s |", name, age, weight, city);
    } // toString

    // вывод шапки таблицы
    private static final String SPLITTER = "+—————————————+———————————————+—————————+—————————————————+\n";
    private static final String HEADER   = "| Имя         | Возраст, лет  | Вес, кг | Город           |\n";
    public static String header() {
        return SPLITTER + HEADER + SPLITTER;
    } // header

    // вывод подвала таблицы
    public static String footer() {
        return SPLITTER;
    } // footer
} // class Person
