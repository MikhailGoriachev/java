package org.homework.app.controllers;

import lombok.NoArgsConstructor;
import org.homework.app.entries.*;
import org.homework.app.middleware.Repositories;
import org.homework.app.models.Query05;
import org.homework.app.models.Query06;
import org.homework.app.utils.Utils;

import javax.swing.*;


// Контроллер Таблиц
@NoArgsConstructor
public class TablesController implements Runnable {

    // меню данных
    public void run() {
        var buttons = new Object[]{
                "Товары",
                "Персоны",
                "Закупки",
                "Продажи",
                "Единицы измерения",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Учёт продаж > Данные";

        Runnable[] commands = new Runnable[]{

                // товары
                () -> sellers(title),

                // персоны
                () -> people(title),

                // закупки
                () -> purchases(title),

                // продажи
                () -> sales(title),

                // единицы измерения
                () -> units(title)
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Учёт продаж > Данные</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // вывод таблицы товары
    public void goods(String startTitle) {

        var info = "Товары";

        var data = Repositories.getGoodsRepository().findAll();

        Utils.showWindow(Goods.toTableHtml(data, info),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // вывод таблицы персоны
    public void people(String startTitle) {

        var info = "Персоны";

        var data = Repositories.getPeopleRepository().findAll();

        Utils.showWindow(Person.toTableHtml(data, info),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // вывод таблицы закупки
    public void purchases(String startTitle) {

        var info = "Закупки";

        var data = Repositories.getPurchasesRepository().findAll();

        Utils.showWindow(Purchase.toTableHtml(data, info),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // вывод таблицы продажи
    public void sales(String startTitle) {

        var info = "Продажи";

        var data = Repositories.getSalesRepository().findAll();

        Utils.showWindow(Sale.toTableHtml(data, info),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // вывод таблицы продавцы
    public void sellers(String startTitle) {

        var info = "Продавцы";

        var data = Repositories.getSellersRepository().findAll();

        Utils.showWindow(Seller.toTableHtml(data, info),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // вывод таблицы единицы измерения
    public void units(String startTitle) {

        var info = "Единицы измерения";

        var data = Repositories.getUnitsRepository().findAll();

        Utils.showWindow(Unit.toTableHtml(data, info),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }
}