package app.controllers;

import app.interfaces.IController;
import app.interfaces.task04.IBody;
import app.models.task03.Mobile;
import app.models.task04.Conoid;
import app.models.task04.Cylinder;
import app.models.task04.Pyramid;
import app.models.task04.Sphere;
import app.utils.Utils;

import javax.swing.*;
import java.util.Arrays;

/*
    •	Наследование, полиморфизм. Разработайте производные от абстрактного класса Body классы для работы с усеченным 
        конусом, цилиндром, шаром и правильной треугольной пирамидой. Предусмотрите хранение наименования тела (строки
        усеченный конус», «цилиндр» и т.д.), размеры тел. Используйте интерфейс IBody для задания методов вычислений 
        площади поверхности, объема и вывода в строку таблицы (консольной или HTML – по Вашему выбору). Создайте 
        полиморфный массив из объемных тел этих классов при помощи фабричного метода. Реализовать обработки (не 
        использовать StreamAPI):
        o	сформировать и вывести массив объектов (не менее 12 элементов)
        o	найти средний объем тел в массиве, среднюю площадь поверхности тел в массиве
        o	вывести тела с минимальной и максимальной площадью поверхности
        o	упорядочить массив тел по убыванию объема (используйте лямбда-выражение для сравнения элементов)
        o	упорядочить массив тел по возрастанию площади поверхности
*/

// Контроллер Задание 2
public class Task04Controller implements IController {

    // телефоны
    public IBody[] figures;


    // конструктор по умолчанию
    public Task04Controller() {
        initialization(Utils.getInt(12, 15));
    }

    // конструктор
    public Task04Controller(IBody[] figures) {
        this.figures = figures;
    }


    // работа по заданию
    public void run() {
        var message = "<html>" +
                "<h1 align='center'>Фигуры</h1>" +
                figuresToTable(figures) +
                String.format("<h3>Среднее значение площади: %.5f</h3>", avgArea()) +
                String.format("<h3>Среднее значение объёма: %.5f</h3>", avgVolume());

        showMessage(message, "Задание 4. Фигуры");
        
        message = "<html>" +
                "<h1 align='center'>Фигуры с минимальной площадью</h1>" +
                figuresByMinArea();

        showMessage(message, "Задание 4. Фигуры");
        
        message = "<html>" +
                "<h1 align='center'>Фигуры с максимальной площадью</h1>" +
                figuresByMaxArea();
        
        showMessage(message, "Задание 4. Фигуры");
        
        message = "<html>" +
                "<h1 align='center'>Сортировка по убыванию объёма</h1>" +
                figuresToTable(sortByVolumeDesc());
        
        showMessage(message, "Задание 4. Фигуры");
        
        message = "<html>" +
                "<h1 align='center'>Сортировка по возрастанию площади</h1>" +
                figuresToTable(sortByAreaAsc());

        showMessage(message, "Задание 4. Фигуры");
    }

    // инициализация коллекции
    public void initialization(int n) {
        figures = new IBody[n];

        for (int i = 0; i < n; i++)
            figures[i] = factoryFigure();
    }

    // найти среднюю площадь поверхности тел в массиве
    public double avgArea() {
        var avg = 0d;

        for (var figure : figures)
            avg += figure.area();

        return avg / figures.length;
    }

    // найти средний объем тел в массиве
    public double avgVolume() {
        var avg = 0d;

        for (var figure : figures)
            avg += figure.volume();

        return avg / figures.length;
    }

    // вывести фигуры с минимальной площадью поверхности в строку
    public String figuresByMinArea() {

        var minArea = figures[0].area();
        for (var figure : figures)
            minArea = Math.min(minArea, figure.area());

        return figuresByArea(minArea);
    }

    // вывести фигуры с максимальной площадью поверхности в строку
    public String figuresByMaxArea() {
        var maxArea = figures[0].area();
        for (var figure : figures)
            maxArea = Math.max(maxArea, figure.area());

        return figuresByArea(maxArea);
    }

    // вывод фигуры с заданной площадью в строку
    public String figuresByArea(double area) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>" +
                        "<th>№</th>" +
                        "<th>Название</th>" +
                        "<th>Радиус / верхний радиус</th>" +
                        "<th>Нижний радиус</th>" +
                        "<th>Высота</th>" +
                        "<th>Сторона</th>" +
                        "<th>Площадь</th>" +
                        "<th>Объём</th>" +
                        "</tr></thead><tbody>");

        for (int i = 0, k = 1; i < figures.length; i++) {
            if (Math.abs(figures[i].area() - area) < 1e-7)
                table.append(figures[i].toTableRow(k++));
        }

        table.append("</tbody></table>");

        return table.toString();
    }

    // упорядочить массив тел по убыванию объема (используйте лямбда-выражение для сравнения элементов)
    // возвращает массив, для поддержки Fluent API
    public IBody[] sortByVolumeDesc() {
        Arrays.sort(figures, (a, b) -> Double.compare(b.volume(), a.volume()));
        return figures;
    }
    
    // упорядочить массив тел по возрастанию площади поверхности
    public IBody[] sortByAreaAsc() {
        Arrays.sort(figures, (a, b) -> Double.compare(a.area(), b.area()));
        return figures;
    }
    
    // вывод в таблицу
    public String figuresToTable(IBody[] data) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>" +
                        "<th>№</th>" +
                        "<th>Название</th>" +
                        "<th>Радиус / верхний радиус</th>" +
                        "<th>Нижний радиус</th>" +
                        "<th>Высота</th>" +
                        "<th>Сторона</th>" +
                        "<th>Площадь</th>" +
                        "<th>Объём</th>" +
                        "</tr></thead><tbody>");

        for (int i = 0; i < data.length; i++) {
            table.append(data[i].toTableRow(i + 1));
        }

        table.append("</tbody></table>");

        return table.toString();
    }

    // фабричный метод создания фигуры
    public IBody factoryFigure() {
        var figureType = Utils.getInt(0, 4);

        return switch (figureType) {
            case 0 -> new Conoid(Utils.getDouble(10d, 20d), Utils.getDouble(30d, 40d), Utils.getDouble(30d, 40d));
            case 1 -> new Cylinder(Utils.getDouble(30d, 40d), Utils.getDouble(30d, 40d));
            case 3 -> new Pyramid(Utils.getDouble(30d, 40d), Utils.getDouble(30d, 40d));
            default -> new Sphere(Utils.getDouble(30d, 40d));
        };
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
