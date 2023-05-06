package app.models.task01;

// Класс Координаты
public class Coord {

    private double x;

    public double x() {
        return x;
    }

    public double x(double value) throws Exception {
        if (value >= -90d && value <= 90d)
            return this.x = value;

        throw new Exception("Coord: значение X должно быть больше или равно -90 и меньше или равно 90");
    }

    private double y;

    public double y() {
        return y;
    }

    public double y(double value) throws Exception {
        if (value >= -180d && value <= 180d)
            return this.y = value;

        throw new Exception("Coord: значение X должно быть больше или равно -180 и меньше или равно 180");
    }


    // конструктор по умолчанию
    public Coord() {
    }

    // конструктор инициализирующий
    public Coord(double x, double y) throws Exception {
        this.x(x);
        this.y(y);
    }

    @Override
    public String toString() {
        return String.format("[%.7f;%.7f]", x, y);
    }
}
