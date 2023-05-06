package app.main;

import app.controllers.Task01Controller;
import app.controllers.Task02Controller;
import app.controllers.Task03Controller;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        while (true) {
            
            switch (showMenu()) {
                
                // задание 1
                case 0:
                    Task01Controller.run();
                    break;
                    
                // задание 2
                case 1:
                    Task02Controller.run();
                    break;
                    
                // задание 3
                case 2:
                    Task03Controller.run();
                    break;
                    
                // выход
                default:
                    return;
            };
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
                new ImageIcon(Main.class.getResource("../../images/menu.png")),
                new Object[] {"Задание 1", "Задание 2", "Задание 3", "Выход"},
                "Выход"
        );
    }
}