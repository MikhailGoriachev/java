package app.controllers;

import app.interfaces.IController;
import app.models.task01.*;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 1. Разработайте класс Goods, описывающий товар (наименование товара, количество товара, цена единицы товара)
    и класс Store для хранения коллекции товаров. Требуется выполнение следующих функций:
    •	формирование коллекции (начальное заполнение коллекции, не менее 12 записей);
    •	вывод коллекции в консоль;
    •	упорядочивание коллекции по наименованию товара;
    •	упорядочивание коллекции по убыванию цены единицы товара;
    •	формирование коллекции товаров с минимальной ценой;
    •	формирование коллекции товаров с максимальной ценой.  
*/

// Контроллер Задание 1
public class Task01Controller implements IController {

    // магазин
    public Store store;


    // конструктор по умолчанию
    public Task01Controller() throws Exception {
        this(new Store());
    }

    // конструктор инициализирующий
    public Task01Controller(Store store) {this.store = store;}


    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Новая коллекция",
                "Все товары",
                "Сортировка по наименованию",
                "Сортировка по цене",
                "Самые дешёвые",
                "Самые дорогие",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Товары";

        IController[] commands = new IController[]{
                () -> {
                    store.initialization();
                    Utils.showWindow(
                            "<html><h1 align='center'>Новая коллекция</h1>" + store.goodsToTable(),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                () -> Utils.showWindow("<html><h1 align='center'>Все товары</h1>" + store.goodsToTable(),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Упорядочивание по наименованию</h1>" +
                        Store.goodsToTable(store.orderByName()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Упорядочивание по убыванию цены</h1>" +
                        Store.goodsToTable(store.orderByPrice()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Самые дешёвые</h1>" +
                        Store.goodsToTable(store.goodsByMinPrice()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Самые дорогие</h1>" +
                        Store.goodsToTable(store.goodsByMaxPrice()), title, new Object[]{"Назад"}, initialValue, imageIcon),
        };


        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1. Товары</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage("В приложении произошла ошибка", "Ошибка...");
            }
        }
    }
}
