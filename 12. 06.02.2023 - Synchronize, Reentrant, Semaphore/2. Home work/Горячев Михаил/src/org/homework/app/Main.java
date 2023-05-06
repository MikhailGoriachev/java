package org.homework.app;

import org.homework.app.controllers.Task01Controller;
import org.homework.app.controllers.Task02Controller;
import org.homework.app.utils.Utils;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        Runnable[] controllers = new Runnable[]{
                new Task01Controller(),
                new Task02Controller(),
                () -> System.exit(0)
        };

        var buttons = new Object[]{"Задание 1. Выражения", "Задание 2. Файл", "Выход"};
        var initialValue = "Выход";
        var imageIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("../../../images/menu.png")));
        var message = "<html><h1>Меню</h1>";
        var title = "Домашнее задание на 09.02.2023";

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