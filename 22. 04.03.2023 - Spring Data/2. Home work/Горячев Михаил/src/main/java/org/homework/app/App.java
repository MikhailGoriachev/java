package org.homework.app;

import org.homework.app.controllers.CrudController;
import org.homework.app.controllers.QueriesController;
import org.homework.app.controllers.TablesController;
import org.homework.app.utils.Utils;

import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception {
        Runnable[] controllers = new Runnable[]{
                new TablesController(),
                new QueriesController(),
                new CrudController(),
                () -> System.exit(0)
        };

        var buttons = new Object[]{
                "Данные",
                "Запросы",
                "CRUD",
                "Выход"
        };
        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var message = "<html><h1>Меню</h1>";
        var title = "Домашнее задание на 06.03.2023";

        while (true) {
            try {

                var select = Utils.showWindow(message, title, buttons, initialValue, imageIcon);

                if (select >= controllers.length || select < 0)
                    return;

                controllers[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }
}
