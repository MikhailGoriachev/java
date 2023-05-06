package org.homework.app.models;

// Класс Цилиндр
public class Cylinder {
    
    // высота
    public double height;

    // радиус
    public double radius;

    // плотность 
    public double density;

    
    // конструктор инициализирующий
    public Cylinder(double height, double radius, double density) {
        this.height = height;
        this.radius = radius;
        this.density = density;
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
        return volume() * density;
    }
}
