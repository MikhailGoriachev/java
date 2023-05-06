package app;

import app.controllers.Task01Controller;
import app.controllers.Task02Controller;
import app.controllers.Task03Controller;
import app.utils.Utils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        var task01Controller = new Task01Controller();
        var task02Controller = new Task02Controller();
        var task03Controller = new Task03Controller();

        while (true) {

            try {
                switch (showMenu()) {

                    // задание 1
                    case 0 -> task01Controller.run();

                    // задание 2
                    case 1 -> task02Controller.run();

                    // задание 3
                    case 2 -> task03Controller.run();

                    // выход
                    default -> System.exit(0);
                }
            } catch (Exception exception) {
                Utils.showErrorMessage("В приложении произошла ошибка", "Ошибка...");
            }
        }
    }

    // вывод окна меню
    public static int showMenu() {
        return JOptionPane.showOptionDialog(
                null,
                "<html><h1>Меню</h1>",
                "Домашнее задание на 14.01.2022",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Main.class.getResource("../images/menu.png")),
                new Object[]{"Задание 1", "Задание 2", "Задание 3", "Задание 4", "Выход"},
                "Выход"
        );
    }
}