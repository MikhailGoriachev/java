package app.models.task04;

import app.interfaces.task04.IBody;


// Класс Правильная треугольная пирамида
public class Pyramid extends Body implements IBody {

    // сторона основания
    private double side;

    public double side() {
        return side;
    }

    public double side(double value) {
        return side = value > 0d ? value : side;
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
    public Pyramid() {
        super("Пирамида");
    }

    // конструктор инициализирующий
    public Pyramid(double side, double height) {
        super("Пирамида");
        this.side = side;
        this.height = height;
    }

    // площадь
    @Override
    public double area() {
        double temp1 = side * side;
        double temp2 = temp1 + height * height;
        return ((side * side) * Math.sqrt(3d) + 6d * side * Math.sqrt(temp2 - temp1 / 4d)) / 4d;
    }

    // объём
    @Override
    public double volume() {
        return height * side * side / (4d * Math.sqrt(3d));
    }

    // вывод в строку таблицы
    @Override
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n + "</td>" +
                "<td>" + name + "</td>" +
                "<td align='center'>———</td>" +
                "<td align='center'>———</td>" +
                String.format("<td align='right'>%.5f</td>", height) +
                String.format("<td align='right'>%.5f</td>", side) +
                String.format("<td align='right'>%.5f</td>", area()) +
                String.format("<td align='right'>%.5f</td>", volume()) +
                "</tr>";
    }
}
