package org.homework.app.controllers;

import lombok.NoArgsConstructor;
import org.homework.app.entries.*;
import org.homework.app.middleware.Repositories;
import org.homework.app.models.Query05;
import org.homework.app.models.Query06;
import org.homework.app.utils.Utils;

import javax.swing.*;
import java.util.Date;


// Контроллер CRUD
@NoArgsConstructor
public class CrudController implements Runnable {

    // crud
    public void run() {
        var buttons = new Object[]{
                "Добавить продажу",
                "Изменить продажу",
                "Удалить продажу",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Учёт продаж > CRUD";

        Runnable[] commands = new Runnable[]{

                // добавить продажу
                () -> addSale(title),

                // изменить продажу
                () -> editSale(title),

                // удалить продажу
                () -> removeSale(title),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Учёт продаж > CRUD</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // 7	Запрос на добавление	Добавление факта продажи
    public void addSale(String startTitle) {


        var purchase = Utils.getItem(Repositories.getPurchasesRepository().findAll());
        var unit = Utils.getItem(Repositories.getUnitsRepository().findAll());
        var seller = Utils.getItem(Repositories.getSellersRepository().findAll());

        var sale = new Sale(null, purchase, unit, seller, new Date(), Utils.getInt(4, 8) * 100, Utils.getInt(2, 8));

        Repositories
                .getSalesRepository()
                .saveAndFlush(sale);

        var data = Repositories
                .getSalesRepository()
                .findAll();

        sale = data.get(data.size() - 1);
        
        var info = "Добавление продажи";
        
        var title = "Добавление продажи. Запись:<br>" + sale;
        
        Utils.showWindow(Sale.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // 8	Запрос на изменение	    Изменение количества проданного товара для факта продаж, заданного идентификатором
    public void editSale(String startTitle) {

        var info = "Изменение продажи";

        var sale = Utils.getItem(Repositories.getSalesRepository().findAll());

        var oldAmount = sale.getAmount();

        sale.setAmount(oldAmount + Utils.getInt(10, 15));

        Repositories
                .getSalesRepository()
                .saveAndFlush(sale);

        var data = Repositories
                .getSalesRepository()
                .findAll();

        var title = String.format(
                "Изменение количества проданного товара. Id: %d, старое значение: %d, новое значение: %d",
                sale.getId(),
                oldAmount,
                sale.getAmount()
        );

        Utils.showWindow(Sale.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }

    // 9	Запрос на удаление	Удаление факта продаж по идентификатору
    public void removeSale(String startTitle) {

        var info = "Удаление продажи";

        var sale = Utils.getItem(Repositories.getSalesRepository().findAll());

        Repositories
                .getSalesRepository()
                .deleteById(sale.getId());

        var data = Repositories
                .getSalesRepository()
                .findAll();

        var title = String.format("Удаление продажи с id: %d", sale.getId());

        Utils.showWindow(Sale.toTableHtml(data, title),
                startTitle + " > " + info,
                new Object[]{"Назад"},
                "Выход",
                new ImageIcon()
        );
    }
}