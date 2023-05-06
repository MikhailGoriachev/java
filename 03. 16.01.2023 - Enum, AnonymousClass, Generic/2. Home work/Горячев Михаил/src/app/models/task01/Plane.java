package app.models.task01;


// Класс Самолёт
public class Plane extends Vehicle {

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
    private int height;

    public int height() {
        return height;
    }

    public int height(int height) throws Exception {
        if (height >= 0) 
            return this.height = height;

        throw new Exception("Vehicle: значение Height должно быть больше 0");
    }


    public Plane(String name, Coord coord, int price, int speed, int year, int passengers, int height) throws Exception {
        super(name,coord,price,speed,year);
        this.passengers(passengers);
        this.height(height);
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
                "<td>" + height + "</td>" +
                "<td align='center'>———</td>" +
                "</tr>";
    }
}
