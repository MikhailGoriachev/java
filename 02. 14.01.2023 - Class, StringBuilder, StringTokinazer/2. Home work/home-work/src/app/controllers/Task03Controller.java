package app.controllers;

import app.interfaces.IController;
import app.models.task03.Mobile;

import javax.swing.*;
import java.util.Arrays;

/*
    •	Классы. Создать класс Mobile, описывающий мобильный телефон (фирма-разработчик, название модели, стоимость, 
        год выпуска). Создайте и проинициируйте массив из 12 элементов класса Mobile (коллекцию мобильных телефонов).
        Реализовать обработки для массива объектов класса Mobiles (не использовать StreamAPI):
        o	сформировать и вывести массив объектов (не менее 12 элементов)
        o	найти суммарную стоимость телефонов в массиве
        o	вывести модели с минимальной и максимальной ценой
        o	упорядочить коллекцию телефонов по убыванию года выпуска (используйте лямбда-выражение для 
            сравнения элементов)
        o	упорядочить коллекцию телефонов по возрастанию стоимости (используйте лямбда-выражение для 
            сравнения элементов)
*/

// Контроллер Задание 2
public class Task03Controller implements IController {

    // телефоны
    public Mobile[] mobiles;


    // конструктор по умолчанию
    public Task03Controller() {
        initialization();
    }

    // конструктор
    public Task03Controller(Mobile[] mobiles) {
        this.mobiles = mobiles;
    }


    // работа по заданию
    public void run() {
        var message = "<html>" +
                "<h1 align='center'>Телефоны</h1>" +
                mobilesToTable(mobiles) +
                "<h3>Стоимость всех телефонов: " + mobilesCost() + "&#8381;</h3>";
        
        showMessage(message, "Задание 3. Телефоны");
        
        message = "<html>" +
                "<h1 align='center'>Самые дешёвые телефоны</h1>" +
                mobilesToTable(mobilesByMinPrice());
        
        showMessage(message, "Задание 3. Телефоны");
        
        message = "<html>" +
                "<h1 align='center'>Самые дорогие телефоны</h1>" +
                mobilesToTable(mobilesByMaxPrice());
        
        showMessage(message, "Задание 3. Телефоны");
        
        message = "<html>" +
                "<h1 align='center'>Сортировка по убыванию года выпуска</h1>" +
                mobilesToTable(sortByYearDesc());
        
        showMessage(message, "Задание 3. Телефоны");
        
        message = "<html>" +
                "<h1 align='center'>Сортировка по возрастанию цены</h1>" +
                mobilesToTable(sortByPriceAsc());
        
        showMessage(message, "Задание 3. Телефоны");
    }
    
    // инициализация коллекции
    public void initialization() {
        mobiles = new Mobile[]{
                new Mobile("Samsung", "A71", 28_000, 2019),
                new Mobile("Samsung", "A51", 24_000, 2017),
                new Mobile("LG", "G5", 34_000, 2015),
                new Mobile("Apple", "12 Pro", 123_000, 2020),
                new Mobile("Apple", "13 Pro", 140_000, 2021),
                new Mobile("Pixel", "7 Pro 5G", 120_000, 2022),
                new Mobile("Xiaomi", "Poco X3", 24_000, 2019),
                new Mobile("LG", "W41", 60_000, 2021),
                new Mobile("LG", "W41", 60_000, 2021),
                new Mobile("SONY", "Xperia 10", 43_000, 2019)
        };
    }

    // стоимость телефонов
    public int mobilesCost() {
        int cost = 0;

        for (var mobile : mobiles)
            cost += mobile.price;

        return cost;
    }

    // телефоны с минимальной ценой
    public Mobile[] mobilesByMinPrice() {

        var minPrice = mobiles[0].price;

        for (var mobile : mobiles)
            minPrice = Math.min(minPrice, mobile.price);

        return mobilesByPrice(minPrice);
    }

    // телефоны с максимальной ценой
    public Mobile[] mobilesByMaxPrice() {
        var maxPrice = mobiles[0].price;

        for (var mobile : mobiles)
            maxPrice = Math.max(maxPrice, mobile.price);

        return mobilesByPrice(maxPrice);
    }

    // выборка телефонов по цене
    public Mobile[] mobilesByPrice(int price) {
        var count = 0;

        for (var mobile : mobiles)
            count += price == mobile.price ? 1 : 0;

        var mobileList = new Mobile[count];
        var i = 0;

        for (var mobile : mobiles)
            if (mobile.price == price)
                mobileList[i++] = mobile;

        return mobileList;
    }

    // упорядочить коллекцию телефонов по убыванию года выпуска (используйте лямбда-выражение для
    // сравнения элементов)
    // возвращает ссылку на массив для поддержки FluentAPI
    public Mobile[] sortByYearDesc() {
        Arrays.sort(mobiles, (a, b) -> Integer.compare(b.year, a.year));
        return mobiles;
    }

    //	упорядочить коллекцию телефонов по возрастанию стоимости (используйте лямбда-выражение для
    //  сравнения элементов)
    public Mobile[] sortByPriceAsc() {
        Arrays.sort(mobiles, (a, b) -> Integer.compare(a.price, b.price));
        return mobiles;
    }

    // вывод в таблицу
    public String mobilesToTable(Mobile[] data) {
        StringBuilder table = new StringBuilder(
                "<table border='2' cellspacing='0' cellpadding='8'>" +
                        "<thead><tr>" +
                        "<th>№</th>" +
                        "<th>Бренд</th>" +
                        "<th>Модель</th>" +
                        "<th>Цена</th>" +
                        "<th>Бренд</th>" +
                        "<th>Год</th>" +
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
                new Object[] {"Далее"},
                "Далее"
        );
    }
}
