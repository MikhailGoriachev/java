package org.homework.app.models;

// Класс Цилиндр
public class Cylinder {
    
    // id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // высота
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // радиус
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // материал
    private Material material;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    
    // конструктор по умолчанию
    public Cylinder() {
    }

    // конструктор инициализирующий
    public Cylinder(int id, double height, double radius, Material material) {
        this.setId(id);
        this.setHeight(height);
        this.setRadius(radius);
        this.setMaterial(material);
    }
    

    // площадь поверхности Источник: https://www-formula.ru/2011-09-24-00-29-48
    public double area() {
        return 2 * Math.PI * radius * (height + radius);
    }

    // объем Источник: https://www.calc.ru/obyem-tsilindra.html
    public double volume() {
        return Math.PI * (radius * radius) * height;
    }

    // масса Источник: https://znaika.ru/catalog/7-klass/physics/Raschet-massy-i-obema-veschestva-po-ego-plotnosti.html
    public double mass() {
        return volume() * material.getDensity();
    }
}
