package app.models.task01;

public abstract class Vehicle {

    // название транспортного средства
    protected String name;

    public String name() {
        return name;
    }

    public String name(String name) {
        return this.name = name;
    }

    // географические координаты
    protected Coord coord;

    public Coord coord() {
        return coord;
    }

    public Coord coord(Coord coord) {
        return this.coord = coord;
    }

    // цена
    protected int price;

    public int price() {
        return price;
    }

    public int price(int price) throws Exception {
        if (price > 0)
            return this.price = price;
        
        throw new Exception("Vehicle: значение Price должно быть больше 0");
    }

    // скорость (км/ч)
    protected int speed;

    public int speed() {
        return speed;
    }

    public int speed(int speed) throws Exception {
        if (speed > 0)
            return this.speed = speed;

        throw new Exception("Vehicle: значение Speed должно быть больше 0");
    }

    // год выпуска
    protected int year;

    public int year() {
        return year;
    }

    public int year(int year) throws Exception {
        if (year > 1900)
            return this.year = year;

        throw new Exception("Vehicle: значение Year должно быть больше 1900");
    }


    // конструктор по умолчанию
    public Vehicle() {
    }

    // конструктор инициализирующий
    public Vehicle(String name, Coord coord, int price, int speed, int year) throws Exception {
        this.name(name);
        this.coord(coord);
        this.price(price);
        this.speed(speed);
        this.year(year);
    }
    
    
    // вывод в таблицу
    public abstract String toTableRow(int n);
}
