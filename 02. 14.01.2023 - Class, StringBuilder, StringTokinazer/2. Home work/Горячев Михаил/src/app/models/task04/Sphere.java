package app.models.task04;

import app.interfaces.task04.IBody;


// Класс Сфера
public class Sphere extends Body implements IBody {

    // радиус
    private double radius;

    public double radius() {
        return radius;
    }

    public double radius(double value) {
        return radius = value > 0d ? value : radius;
    }


    // конструктор по умолчанию
    public Sphere() {
        super("Сфера");
    }

    // конструктор инициализирующий
    public Sphere(double radius) {
        super("Сфера");
        this.radius = radius;
    }


    // площадь
    @Override
    public double area() {
        return 4d * Math.PI * (radius * radius);
    }

    // объём
    @Override
    public double volume() {
        return (4d / 3d) * Math.PI * Math.pow(radius, 3);
    }

    // вывод в строку таблицы
    @Override
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n + "</td>" +
                "<td>" + name + "</td>" +
                String.format("<td align='right'>%.5f</td>", radius) +
                "<td align='center'>———</td>" +
                "<td align='center'>———</td>" +
                "<td align='center'>———</td>" +
                String.format("<td align='right'>%.5f</td>", area()) +
                String.format("<td align='right'>%.5f</td>", volume()) +
                "</tr>";
    }
}
