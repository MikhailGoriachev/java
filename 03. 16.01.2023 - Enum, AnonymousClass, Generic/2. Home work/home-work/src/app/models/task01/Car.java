package app.models.task01;


// Класс Автомобиль
public class Car extends Vehicle {

    // конструктор по умолчанию
    public Car() {
    }

    // конструктор инициализирующий
    public Car(String name, Coord coord, int price, int speed, int year) throws Exception {
        super(name, coord, price, speed, year);
    }

    // вывод в строку талицы
    @Override
    public String toTableRow(int n) {
        return "<tr>" +
                "<th>" + n +"</td>" +
                "<td>" + name + "</td>" +
                "<td>" + coord + "</td>" +
                "<td>" + price + "$</td>" +
                "<td>" + speed + "</td>" +
                "<td>" + year + "</td>" +
                "<td align='center'>———</td>" +
                "<td align='center'>———</td>" +
                "<td align='center'>———</td>" +
                "</tr>";
    }
}
