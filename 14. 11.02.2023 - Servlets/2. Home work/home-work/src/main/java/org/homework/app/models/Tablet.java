package org.homework.app.models;

// тип, производитель, год выпуска, операционная система, цена

// Класс Цилиндр
public class Tablet {

    // тип
    public String type;

    // производитель
    public String manufacture;

    // год выпуска
    public int year;

    // операционная система
    public String system;

    // цена
    public int price;


    // конструктор инициализирующий
    public Tablet(String type, String manufacture, int year, String system, int price) {
        this.type = type;
        this.manufacture = manufacture;
        this.year = year;
        this.system = system;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s; %s; Год выпуска: %d; %s; Цена: %d",
                type,
                manufacture,
                year,
                system,
                price);
    }
}
