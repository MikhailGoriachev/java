package org.homework.app.controllers;

import lombok.NoArgsConstructor;
import org.homework.app.entries.*;
import org.homework.app.middleware.Repositories;
import org.homework.app.models.Query05;
import org.homework.app.models.Query06;
import org.homework.app.utils.Utils;

import javax.swing.*;


// Контроллер Запросов
@NoArgsConstructor
public class QueriesController implements Runnable {
    
    // запросы
    public void run() {
        var buttons = new Object[]{
                "Запрос 1",
                "Запрос 2",
                "Запрос 3",
                "Запрос 4",
                "Запрос 5",
                "Запрос 6",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Учёт продаж > Запросы";

        Runnable[] commands = new Runnable[]{

                // запрос 1
                () -> query01(title),
                
                // запрос 2
                () -> query02(title),

                // запрос 3
                () -> query03(title),

                // запрос 4
                () -> query04(title),

                // запрос 5
                () -> query05(title),

                // запрос 6
                () -> query06(title)
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Учёт продаж > Запросы</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // 1	Запрос с параметрами	Выбирает из информацию о товарах, единицей измерения которых является «шт» (штуки) 
    //                              и цена закупки составляет меньше 200 руб. Значения задавать параметрами
    public void query01(String startTitle) {

        // единица измерения
        var unit = Utils.getItem(
                        Repositories
                                .getUnitsRepository()
                                .findAll())
                .getShortName();

        // цена
        var price = Utils.getInt(3, 10) * 100;

        // данные
        var data = Repositories
                .getPurchasesRepository()
                .findAllByUnitShortNameAndPriceLessThan(unit, price);

        // заголовок таблицы
        var title = String.format(
                "Запрос 1. Закупки в единицах измерения \"%s\"<br>и ценой меньше %d &#8381;",
                unit, price
        );

        var info = "Запрос 1";

        Utils.showWindow(Purchase.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // 2	Запрос с параметрами	Выбирает информацию о товарах, цена закупки которых меньше 500 руб. за единицу 
    //                              товара. Значения задавать параметрами
    public void query02(String startTitle) {

        // цена
        var price = Utils.getInt(3, 10) * 100;

        // данные
        var data = Repositories
                .getPurchasesRepository()
                .findAllByPriceLessThan(price);


        // заголовок таблицы
        var title = String.format(
                "Запрос 2. Закупки с ценой меньше %d &#8381;",
                price
        );

        var info = "Запрос 2";

        Utils.showWindow(Purchase.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // 3	Запрос с параметрами	Выбирает информацию обо всех зафиксированных фактах продажи товаров (Наименование 
    //                              товара, Цена закупки, Цена продажи, дата продажи), для которых Цена продажи 
    //                              оказалась в некоторых заданных границах. Значения задавать параметрами
    public void query03(String startTitle) {

        // цена
        var minPrice = Utils.getInt(3, 5) * 100;
        var maxPrice = minPrice + Utils.getInt(3, 5) * 100;

        // данные
        var data = Repositories
                .getSalesRepository()
                .findAllByPriceBetween(minPrice, maxPrice);


        // заголовок таблицы
        var title = String.format(
                "Запрос 3. Продажи с ценой в диапазоне от %d &#8381; до %d &#8381;",
                minPrice, maxPrice
        );

        var info = "Запрос 3";

        Utils.showWindow(Sale.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // 4	Запрос с вычисляемыми полями	Вычисляет прибыль от продажи за каждый проданный товар. Включает поля 
    //                                      Дата продажи, Наименование товара, Цена закупки, Цена продажи, 
    //                                      Количество проданных единиц, Прибыль. Сортировка по полю Наименование товара
    public void query04(String startTitle) {

        // данные
        var data = Repositories
                .getSalesRepository()
                .findAll();


        // заголовок таблицы
        var title = "Запрос 4. Продажи с вычисленной прибылью";

        var info = "Запрос 4";

        Utils.showWindow(Sale.toTableHtmlWithIncome(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }
    
    // 5	Итоговый запрос	    Выполняет группировку по наименованию закупленного товара. Для каждого наименования 
    //                          вычисляет среднюю цену закупки товара, количество закупок
    public void query05(String startTitle) {

        // данные
        var data = Repositories
                .getGoodsRepository() 
                .groupByName();


        // заголовок таблицы
        var title = "Запрос 5. Группировка по наименованию товара. Статистика по цене закупки";

        var info = "Запрос 5";

        Utils.showWindow(Query05.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }
    
    // 6	Итоговый запрос с левым соединением	    Для всех продавцов вывести сумму и количество продаж, минимальную и 
    //                                              максимальную стоимости продаж
    public void query06(String startTitle) {

        // данные
        var data = Repositories
                .getSellersRepository() 
                .groupBySeller();


        // заголовок таблицы
        var title = "Запрос 6. Группировка по продавцу. Статистика продаж";

        var info = "Запрос 6";

        Utils.showWindow(Query06.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }
}