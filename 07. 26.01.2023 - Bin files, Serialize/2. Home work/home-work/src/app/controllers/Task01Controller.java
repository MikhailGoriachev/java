package app.controllers;

import app.interfaces.IController;
import app.models.task01.*;
import app.models.task01.PeopleList;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 1. Для коллекции жителей некоторых городов (фамилия, имя, возраст, название города, профессия, оклад)
    составьте и выполните запросы к коллекции с использованием StreamAPI. Храните коллекцию в текстовом файле 
    в формате CSV:
        1.	статистика по городам – название городов, количество жителей из этих городов в коллекции, средний возраст, 
            минимальный возраст, максимальный возраст жителя
        2.	жители с заданной профессией, фамилия которых начинается с заданной строки 
        3.	список фамилий и жители с такой фамилией
        4.	список профессий и жители с такой профессией
        5.	список городов по убыванию количества проживающих в них людей
        6.	статистика по профессиям – количество жителей с заданной профессией, минимальный оклад, средний оклад, 
            максимальный оклад, сумма окладов
        7.	среднее количество жителей города и города с количеством жителей ниже среднего
*/

// Контроллер Задание 1
public class Task01Controller implements IController {

    // список жителей
    public PeopleList peopleList;


    // конструктор по умолчанию
    public Task01Controller() throws Exception {
        this.peopleList = new PeopleList();
    }


    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Жители",
                "<html>Запрос 1",
                "<html>Запрос 2",
                "<html>Запрос 3",
                "<html>Запрос 4",
                "<html>Запрос 5",
                "<html>Запрос 6",
                "<html>Запрос 7",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Жители";

        IController[] commands = new IController[]{

                // все жители
                () -> Utils.showWindow("<html><h2 align='center'>Жители</h2>" +
                                PeopleList.peopleToTable(peopleList.personList),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // 1. статистика по городам – название городов, количество жителей из этих городов в коллекции, средний возраст,
                // минимальный возраст, максимальный возраст жителя
                () -> Utils.showWindow(
                        "<html><h2 align='center'>Статистики по городам и возрасту</h2>" +
                                PeopleList.point01ToTable(peopleList.point01()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // 2. жители с заданной профессией, фамилия которых начинается с заданной строки 
                () -> {
                    var person = Utils.getItem(peopleList.personList);
                    var profession = person.profession();
                    var startWith = person.surname().substring(0, 2);

                    Utils.showWindow(
                            "<html><h2 align='center'>Жители с заданными данными: профессия - \"" +
                                    person.profession() + "\"; фамилия начинается с — " + startWith + "\"</h2>" +
                                    PeopleList.peopleToTable(peopleList.point02(profession, startWith)),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },

                // 3. жители с заданной профессией, фамилия которых начинается с заданной строки 
                () -> Utils.showWindow(
                        "<html><h2 align='center'>Список жителей по фамилиям</h2>" +
                                PeopleList.point03ToTable(peopleList.point03()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // 4. список профессий и жители с такой профессией 
                () -> Utils.showWindow(
                        "<html><h2 align='center'>Список жителей по профессиям</h2>" +
                                PeopleList.point04ToTable(peopleList.point04()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // 5. список городов по убыванию количества проживающих в них людей 
                () -> Utils.showWindow(
                        "<html><h2 align='center'>Список городов по убыванию людей</h2>" +
                                PeopleList.point05ToTable(peopleList.point05()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // 6. статистика по профессиям – количество жителей с заданной профессией, минимальный оклад, средний оклад,
                // максимальный оклад, сумма окладов 
                () -> Utils.showWindow(
                        "<html><h2 align='center'>Статистика по профессиям</h2>" +
                                PeopleList.point06ToTable(peopleList.point06()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),

                // 7. среднее количество жителей города и города с количеством жителей ниже среднего
                () -> Utils.showWindow(
                        "<html><h2 align='center'>Города со средним количеством жителей ниже среднего: " +
                                String.format("%.2f", peopleList.avgAmountPeople()) +
                                "</h2>" +
                                PeopleList.point07ToTable(peopleList.point07()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1. Жители</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }
}
