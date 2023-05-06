package app.controllers;

import app.interfaces.IController;
import app.models.task01.PeopleList;
import app.models.task03.Store;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 1. Для коллекции жителей некоторых городов (фамилия, имя, возраст, название города, профессия, оклад)
    составьте и выполните запросы к коллекции с использованием StreamAPI. Храните коллекцию в текстовом файле 
    в формате CSV:
        1.	статистика по городам – название городов, количество жителей из этих городов в коллекции, средний возраст, 
            минимальный возраст, максимальный возраст жителя
        2.	жители с заданной профессией, фамилия которых начинается с заданной строки 
        3.	список фамилий и жители с такой фамилией
        4.	список профессий и жители с такой профессией
        5.	список городов по убыванию количества проживающих в них людей
        6.	статистика по профессиям – количество жителей с заданной профессией, минимальный оклад, средний оклад, 
            максимальный оклад, сумма окладов
        7.	среднее количество жителей города и города с количеством жителей ниже среднего
*/

// Контроллер Задание 2
public class Task03Controller implements IController {

    // товары
    public Store store;


    // конструктор по умолчанию
    public Task03Controller() throws Exception {
        this.store = new Store();
    }


    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Товары",
                "<html>Сортировка по<br>стоимости",
                "<html>Сортировка по<br>наименованию",
                "<html>Сортировка по<br>количеству",
                "<html>Статистика",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 3. Товары";

        IController[] commands = new IController[]{

                // товары
                () -> Utils.showWindow("<html><h2 align='center'>Товары</h2>" +
                                store.toTable(store.goodsList),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // сортировка по убыванию стоимости
                () -> Utils.showWindow("<html><h2 align='center'>Сортировка по убыванию стоимости товара</h2>" +
                                store.toTable(store.orderByCostDesc()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // сортировка по наименованию товара
                () -> Utils.showWindow("<html><h2 align='center'>Сортировка по наименованию товара</h2>" +
                                store.toTable(store.orderByName()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // сортировка по наименованию товара
                () -> Utils.showWindow("<html><h2 align='center'>Сортировка по возрастанию количества товара</h2>" +
                                store.toTable(store.orderByAmount()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // статистика
                () -> Utils.showWindow("<html><h2 align='center'>Статистика</h2>" +
                                store.statisticToTable(store.getStatistic()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 3. Товары</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }
}
