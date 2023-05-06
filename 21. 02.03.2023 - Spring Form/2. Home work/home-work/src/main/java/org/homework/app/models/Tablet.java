package org.homework.app.models;

// тип, производитель, год выпуска, операционная система, цена

// Класс Цилиндр
public class Tablet {

    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // тип
    private String type;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    // производитель
    private String manufacture;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // год выпуска
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // операционная система
    private String system;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    // цена
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    // конструктор
    public Tablet() {
        this.setSystem("none");
    }

    // конструктор инициализирующий
    public Tablet(int id, String type, String manufacture, int year, String system, int price) {
        this.setId(id);
        this.setType(type);
        this.setManufacture(manufacture);
        this.setYear(year);
        this.setSystem(system);
        this.setPrice(price);
    }
}
