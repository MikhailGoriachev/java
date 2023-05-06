package app;

import app.controllers.Task01Controller;
import app.controllers.Task02Controller;
import app.interfaces.IController;
import app.utils.Utils;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {

        IController[] controllers = new IController[]{
                new Task01Controller(),
                new Task02Controller(),
                () -> System.exit(0)
        };

        var buttons = new Object[]{"Задание 1. Поликлиника","Задание 2. Экзамены", "Выход"};
        var initialValue = "Выход";
        var imageIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("../images/menu.png")));
        var message = "<html><h1>Меню</h1>";
        var title = "Домашнее задание на 02.02.2022";

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