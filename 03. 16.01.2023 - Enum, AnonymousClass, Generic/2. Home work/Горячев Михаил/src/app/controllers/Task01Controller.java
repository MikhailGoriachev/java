package app.controllers;

import app.interfaces.IController;
import app.models.task01.*;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 1. Наследование. Создать абстрактный класс Vehicle (транспортное средство). На его основе реализовать 
    классы Plane (самолет), Саг (автомобиль) и Ship (корабль). 
    Классы должны иметь возможность задавать и получать параметры средств передвижения (географические координаты, 
    цена, скорость, год выпуска) с помощью геттера.
    Дополнительно для самолета должна быть определена высота, для самолета и корабля — количество пассажиров, 
    для корабля — порт приписки. 
    Создайте массив транспортных средств, состоящий из 2х самолетов, 3х кораблей и 5и автомобилей. Вывод массива должен
    быть в формате таблицы. В массиве найти:
    •	самое старое транспортное средство
    •	самое быстрое и самое медленное транспортные средства (может быть найдено больше 1 транспортного средства)
*/

// Контроллер Задание 1
public class Task01Controller implements IController {

    // коллекция транспортных средств
    public Vehicle[] vehicles;


    // конструктор по умолчанию
    public Task01Controller() throws Exception {
        this(new Vehicle[]{
                new Plane("Boeing 777", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(1_000_000, 10_000_000), Utils.getInt(400, 800), Utils.getInt(2005, 2020), Utils.getInt(2_000, 10_000), Utils.getInt(40, 150)),
                new Plane("Boeing 737", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(1_000_000, 10_000_000), Utils.getInt(400, 800), Utils.getInt(2005, 2020), Utils.getInt(2_000, 10_000), Utils.getInt(40, 150)),
                new Plane("Airbus A350", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(1_000_000, 10_000_000), Utils.getInt(400, 800), Utils.getInt(2005, 2020), Utils.getInt(2_000, 10_000), Utils.getInt(40, 150)),
                new Plane("Airbus А321", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(1_000_000, 10_000_000), Utils.getInt(400, 800), Utils.getInt(2005, 2020), Utils.getInt(2_000, 10_000), Utils.getInt(40, 150)),
                new Plane("SuperJet 100", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(1_000_000, 10_000_000), Utils.getInt(400, 800), Utils.getInt(2005, 2020), Utils.getInt(2_000, 10_000), Utils.getInt(40, 150)),
                new Ship("MONTMARTRE", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(50_000_000, 80_000_000), Utils.getInt(30, 40), Utils.getInt(2005, 2020), Utils.getInt(40, 150), "Порт Шанхая"),
                new Ship("JACQUES", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(50_000_000, 80_000_000), Utils.getInt(30, 40), Utils.getInt(2005, 2020), Utils.getInt(40, 150), "Порт Сингапура"),
                new Ship("SORBONNE", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(50_000_000, 80_000_000), Utils.getInt(30, 40), Utils.getInt(2005, 2020), Utils.getInt(40, 150), "Порт Тяньцзиня"),
                new Ship("ELYSEES", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(50_000_000, 80_000_000), Utils.getInt(30, 40), Utils.getInt(2005, 2020), Utils.getInt(40, 150), "Порт Гуанчжоу"),
                new Car("BMW X5", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(5_000_000, 10_000_000), Utils.getInt(60, 120), Utils.getInt(2005, 2020)),
                new Car("BMW X4", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(5_000_000, 10_000_000), Utils.getInt(60, 120), Utils.getInt(2005, 2020)),
                new Car("Mercedes c63", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(5_000_000, 10_000_000), Utils.getInt(60, 120), Utils.getInt(2005, 2020)),
                new Car("Mercedes vito", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(5_000_000, 10_000_000), Utils.getInt(60, 120), Utils.getInt(2005, 2020)),
                new Car("Wolksvagen Golf", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(5_000_000, 10_000_000), Utils.getInt(60, 120), Utils.getInt(2005, 2020)),
                new Car("Wolksvagen Polo", new Coord(Utils.getDouble(-90, 90), Utils.getDouble(-180, 180)), Utils.getInt(5_000_000, 10_000_000), Utils.getInt(60, 120), Utils.getInt(2005, 2020)),
        });
    }

    // конструктор инициализирующий
    public Task01Controller(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }


    // работа по заданию
    public void run() {

        var message = "<html>" +
                "<h1 align='center'>Транспортные средства</h1>" +
                vehiclesToTable(vehicles);

        showMessage(message, "Задание 1. Транспортные средства");
        
        message = "<html>" +
                "<h1 align='center'>Самые старые транспортные средства</h1>" +
                vehiclesToTable(selectByOldest());

        showMessage(message, "Задание 1. Транспортные средства");
        
        message = "<html>" +
                "<h1 align='center'>Самые быстрые транспортные средства</h1>" +
                vehiclesToTable(selectByFasted());

        showMessage(message, "Задание 1. Транспортные средства");
        
        message = "<html>" +
                "<h1 align='center'>Самые медленные транспортные средства</h1>" +
                vehiclesToTable(selectBySlowest());

        showMessage(message, "Задание 1. Транспортные средства");
    }

    // самые старые транспортные средства
    public Vehicle[] selectByOldest() {
        var year = vehicles[0].year();
        var n = 0;

        for (var vehicle : vehicles) {
            var current = vehicle.year();
            if (year > current) {
                year = current;
                n = 1;
            }
            else if (year == current)
                n++;
        }

        var selection = new Vehicle[n];
        var i = 0;
        for (var vehicle : vehicles) {
            if (year == vehicle.year())
                selection[i++] = vehicle;
        }
        
        return selection;
    }

    // самые быстрые транспортные средства
    public Vehicle[] selectByFasted() {
        var speed = vehicles[0].speed();
        var n = 0;

        for (var vehicle : vehicles) {
            var current = vehicle.speed();
            if (speed < current) {
                speed = current;
                n = 1;
            }
            else if (speed == current)
                n++;
        }

        return selectBySpeed(speed, n);
    }

    // самые медленные транспортные средства
    public Vehicle[] selectBySlowest() {
        var speed = vehicles[0].speed();
        var n = 0;

        for (var vehicle : vehicles) {
            var current = vehicle.speed();
            if (speed > current) {
                speed = current;
                n = 1;
            }
            else if (speed == current)
                n++;
        }

        return selectBySpeed(speed, n);
    }
    
    // выбрать транспортные средства по скорости в заданный массив
    // возвращает массив для удобства дальнейшей обработки
    public Vehicle[] selectBySpeed(int speed, int length) {
        var selection = new Vehicle[length];
        
        var i = 0;
        for (var vehicle : vehicles) {
            if (speed == vehicle.speed())
                selection[i++] = vehicle;
        }
        
        return selection;
    }

    // вывод транспортных средств в таблицу
    public String vehiclesToTable(Vehicle[] data) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>" +
                        "<th>№</th>" +
                        "<th>Название</th>" +
                        "<th>Координаты</th>" +
                        "<th>Цена</th>" +
                        "<th>Скорость</th>" +
                        "<th>Год выпуска</th>" +
                        "<th>Пассажиры</th>" +
                        "<th>Высота</th>" +
                        "<th>Порт приписки</th>" +
                        "</tr></thead><tbody>");

        for (int i = 0; i < data.length; i++) {
            table.append(data[i].toTableRow(i + 1));
        }

        table.append("</tbody></table>");

        return table.toString();
    }
    

    // вывод данных в окно
    public static void showMessage(String message, String title) {
        JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(),
                new Object[]{"Далее"},
                "Далее"
        );
    }
}
