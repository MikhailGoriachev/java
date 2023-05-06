package app.controllers;

import app.interfaces.IController;
import app.models.task01.*;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 1. При помощи StreamAPI выполните следующие обработки массивов, состоящих из случайных чисел:
     
        Вариант 14. В одномерном массиве, состоящем из п вещественных элементов:
        1.	Вычислить количество элементов массива, равных нулю;
        2.	Вычислить сумму элементов массива, расположенных после минимального элемента.
        3.	Упорядочить элементы массива по возрастанию модулей.
        
        Вариант 17. В одномерном массиве, состоящем из п целочисленных элементов:
        1.	Вычислить количество положительных элементов массива;
        2.	Вычислить сумму элементов массива, расположенных после последнего элемента, равного нулю.
        3.	Преобразовать массив таким образом, чтобы сначала располагались элементы <= 1, а потом — все остальные.
*/

// Контроллер Задание 1
public class Task01Controller implements IController {

    // вариант 14
    public Var14 var14;

    // вариант 17
    public Var17 var17;


    // конструктор по умолчанию
    public Task01Controller() {
        this(new Var14(), new Var17());
    }

    // конструктор инициализирующий
    public Task01Controller(Var14 var14, Var17 var17) {
        this.var14 = var14;
        this.var17 = var17;
    }

    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Вариант 14",
                "Вариант 17",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Массивы";

        IController[] commands = new IController[]{
                
                // вариант 14
                () -> Utils.showWindow(
                        "<html><h1 align='center'>Вариант 14</h1>" +
                                "<h2 align='center'>Массив вещественных чисел</h2>" + Var14.arrayToTable(var14.array) +
                                "<h2 align='center'>Количество нулевых элементов: " + var14.amountZeroElems() + "</h2>" +
                                String.format("<h2 align='center'>Сумма элементов после минимального: %.3f</h2>", var14.sumAfterMinElem()) +
                                "<h2 align='center'>Сортировка по возрастанию модулей:</h2>" + Var14.arrayToTable(var14.orderByAbsAsc())
                        ,
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // вариант 17
                () -> Utils.showWindow(
                        "<html><h1 align='center'>Вариант 17</h1>" +
                                "<h2 align='center'>Массив целых чисел</h2>" + Var17.arrayToTable(var17.array) +
                                "<h2 align='center'>Количество положительных элементов: " + var17.amountPositiveElems() + "</h2>" +
                                "<h2 align='center'>Сумма элементов после последнего нуля: " + var17.sumAfterZeroElem() + "</h2>" +
                                "<h2 align='center'>Сортировка по принципу: сначала &lt;= 1:</h2>" + Var17.arrayToTable(var17.orderByTask())
                        ,
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
        };
        
        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1. Массивы</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select < 0)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage("В приложении произошла ошибка", "Ошибка...");
            }
        }
    }
}
