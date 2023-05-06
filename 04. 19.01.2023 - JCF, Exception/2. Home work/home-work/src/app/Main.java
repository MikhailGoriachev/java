package app;

import app.controllers.Task01Controller;
import app.controllers.Task02Controller;
import app.interfaces.IController;
import app.utils.Utils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        IController[] controllers = new IController[]{
                new Task01Controller(),
                new Task02Controller(),
                () -> System.exit(0)
        };
        
        var buttons = new Object[]{"Задание 1", "Задание 2", "Выход"};
        var initialValue = "Выход";
        var imageIcon = new ImageIcon(Main.class.getResource("../images/menu.png"));
        var message = "<html><h1>Меню</h1>";
        var title = "Домашнее задание на 21.01.2022";

        while (true) {
            try {
                controllers[Utils.showWindow(message, title, buttons, initialValue, imageIcon)].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    
}