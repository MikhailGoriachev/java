package org.homework.app.models;

// тип, производитель, год выпуска, операционная система, цена

// Класс Цилиндр
public class Tablet {

    // id
    public int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // тип
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // производитель
    public String manufacture;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    // год выпуска
    public int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // операционная система
    public String system;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    // цена
    public int price;
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    // конструктор по умолчанию
    public Tablet() {
    }

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
