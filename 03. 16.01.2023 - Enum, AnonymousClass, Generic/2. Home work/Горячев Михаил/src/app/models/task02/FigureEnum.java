package app.models.task02;

public enum FigureEnum {

    // прямоугольник
    RECTANGLE(7000),

    // квадрат
    SQUARE(1705),

    // ромб
    RHOMBUS(1425),

    // прямоугольная трапеция
    TRAPEZOID(1210);

    // значение
    private final int value;

    public int value() {
        return value;
    }


    // конструктор
    FigureEnum(int value) {
        this.value = value;
    }


    // стороны
    public double[] sides;


    // периметр
    public double perimeter() {

        if (sides.length == 0)
            return Double.NaN;

        return switch (this) {
            case RECTANGLE, RHOMBUS -> sides[0] * sides[1];
            case SQUARE -> sides[0] * sides[0];
            case TRAPEZOID -> sides[0] + sides[1] + sides[2] + sides[3];
        };
    }

    // площадь
    public double area() {

        if (sides.length == 0)
            return Double.NaN;

        return switch (this) {
            case RECTANGLE, RHOMBUS -> (sides[0] + sides[1]) * 2;
            case SQUARE -> sides[0] * 4;
            case TRAPEZOID -> (1d / 2d) * (sides[0] + sides[2]) * sides[1];
        };
    }

    // строковое представление
    @Override
    public String toString() {
        return switch (this) {
            case RECTANGLE -> "Прямоугольник";
            case SQUARE -> "Квадрат";
            case RHOMBUS -> "Ромб";
            case TRAPEZOID -> "Прямоугольная трапеция";
        };
    }

    // вывод в строку таблицы
    public String toTableRow(int n) {

        var sides = switch (this) {
            case RECTANGLE, RHOMBUS -> "<td>" + this.sides[0] + "</td><td>"
                    + this.sides[1] + "</td><td style='center'>———</td><td style='center'>———</td>";
            case SQUARE -> "<td>" + this.sides[0]
                    + "</td><td style='center'>———</td><td style='center'>———</td><td style='center'>———</td>";
            case TRAPEZOID -> "<td>" + this.sides[0] + "</td><td>" + this.sides[1] + "</td><td>" + this.sides[2]
                    + "</td><td>" + this.sides[3] + "</td>";
        };

        return "<tr>" +
                "<th>" + n + "</td>" +
                "<td>" + this + "</td>" +
                sides +
                "<td>" + perimeter() + "</td>" +
                "<td>" + area() + "</td>" +
                "</tr>";
    }
}
