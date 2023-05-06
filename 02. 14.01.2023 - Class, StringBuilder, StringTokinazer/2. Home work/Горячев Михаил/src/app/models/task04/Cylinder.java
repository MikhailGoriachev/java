package app.models.task04;

import app.interfaces.task04.IBody;


// Класс Цилиндр
public class Cylinder extends Body implements IBody {

    // радиус
    private double radius;

    public double radius() {
        return radius;
    }

    public double radius(double value) {
        return radius = value > 0d ? value : radius;
    }

    // высота
    private double height;

    public double height() {
        return height;
    }

    public double height(double value) {
        return height = value > 0d ? value : height;
    }


    // конструктор по умолчанию
    public Cylinder() {
        super("Цилиндр");
    }

    // конструктор инициализирующий
    public Cylinder(double radius, double height) {
        super("Цилиндр");
        this.radius(radius);
        this.height(height);
    }


    // площадь
    @Override
    public double area() {
        return 2 * Math.PI * radius * (height + radius);
    }

    // объём
    @Override
    public double volume() {
        return Math.PI * (radius * radius) * height;
    }

    @Override
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n +"</td>" +
                "<td>" + name + "</td>" +
                String.format("<td align='right'>%.5f</td>", radius) +
                "<td align='center'>———</td>" +
                String.format("<td align='right'>%.5f</td>", height) +
                "<td align='center'>———</td>" +
                String.format("<td align='right'>%.5f</td>", area()) +
                String.format("<td align='right'>%.5f</td>", volume()) +
                "</tr>";
    }
}
