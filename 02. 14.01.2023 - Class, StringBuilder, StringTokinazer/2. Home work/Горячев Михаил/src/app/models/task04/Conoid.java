package app.models.task04;

import app.interfaces.task04.IBody;


// Класс Усечённый конус
public class Conoid extends Body implements IBody {

    // верхний радиус
    private double radiusTop;

    public double radiusTop() {
        return radiusTop;
    }

    public double radiusTop(double value) {
        return radiusTop = value > 0d ? value : radiusTop;
    }

    // нижний радиус
    private double radiusBottom;

    public double radiusBottom() {
        return radiusBottom;
    }

    public double radiusBottom(double value) {
        return radiusBottom = value > 0d ? value : radiusBottom;
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
    public Conoid() {
        super("Усечённый конус");
    }

    // конструктор инициализирующий
    public Conoid(double radiusTop, double radiusBottom, double height) {
        super("Усечённый конус");
        this.radiusTop(radiusTop);
        this.radiusBottom(radiusBottom);
        this.height(height);
    }
    

    // площадь
    @Override
    public double area() {
        var l = Math.sqrt((height * height) + Math.pow(radiusBottom - radiusTop, 2));

        return Math.PI * ((radiusBottom * radiusBottom) + (radiusBottom + radiusTop) * l + (radiusTop * radiusTop));
    }

    // объём
    @Override
    public double volume() {
        return (1d / 3d) * Math.PI * height * ((radiusBottom * radiusBottom) + radiusBottom * radiusTop + (radiusTop * radiusTop));
    }

    // вывод в строку таблицы
    @Override
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n +"</td>" +
                "<td>" + name + "</td>" +
                String.format("<td align='right'>%.5f</td>", radiusTop) +
                String.format("<td align='right'>%.5f</td>", radiusBottom) +
                String.format("<td align='right'>%.5f</td>", height) +
                "<td align='center'>———</td>" +
                String.format("<td align='right'>%.5f</td>", area()) +
                String.format("<td align='right'>%.5f</td>", volume()) +
                "</tr>";
    }
}
