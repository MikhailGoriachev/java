package org.homework.app.models;

// тип, производитель, год выпуска, операционная система, цена

// Класс Цилиндр
public class Tablet {

    // id
    public int id;
    
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
    public Tablet(int id, String type, String manufacture, int year, String system, int price) {
        this.id = id;
        this.type = type;
        this.manufacture = manufacture;
        this.year = year;
        this.system = system;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s; %s; Год выпуска: %d; %s; Цена: %d",
                type, manufacture, year, system, price);
    }

    // вывод в строку таблицы
    public String toTableRow() {
        return String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td><td colspan='2'>%d</td></tr>",
                id, manufacture, type, year, system, price);
    }
}
