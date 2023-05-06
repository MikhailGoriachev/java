package app.models.task01;


// Класс Судно
public class Ship extends Vehicle {

    // количество пассажиров
    private int passengers;

    public int passengers() {
        return passengers;
    }

    public int passengers(int passengers) throws Exception {
        if (passengers >= 0)
            return this.passengers = passengers;

        throw new Exception("Vehicle: значение Passengers должно быть больше 0");
    }

    // высота
    private String port;

    public String port() {
        return port;
    }

    public String port(String port) {
        return this.port = port;
    }

    // конструктор по умолчанию
    public Ship() {
    }

    
    // конструктор инициализирующий
    public Ship(String name, Coord coord, int price, int speed, int year, int passengers, String port) throws Exception {
        super(name, coord, price, speed, year);
        this.passengers(passengers);
        this.port(port);
    }

    // вывод в строку таблицы
    @Override
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n +"</td>" +
                "<td>" + name + "</td>" +
                "<td>" + coord + "</td>" +
                "<td>" + price + "$</td>" +
                "<td>" + speed + "</td>" +
                "<td>" + year + "</td>" +
                "<td>" + passengers + "</td>" +
                "<td align='center'>———</td>" +
                "<td>" + port + "</td>" +
                "</tr>";
    }
}
