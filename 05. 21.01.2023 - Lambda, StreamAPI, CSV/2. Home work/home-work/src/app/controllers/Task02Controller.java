package app.controllers;

import app.interfaces.IController;
import app.models.task02.PeopleList;
import app.models.task02.Person;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 2. Жители городов описываются полями: фамилия, имя, возраст, название города, рост. Требуется хранить 
    коллекцию жителей в текстовом файле в формате CSV (не менее 12 записей), а также составить и выполнить запросы 
    к коллекции (не к текстовому файлу) с использованием StreamAPI:
    
        a.	Выбрать жителей заданного города с заданным диапазоном возраста
        b.	Выбрать жителей с заданной фамилией
        c.	Выбрать города, в которых есть жители с заданной фамилией.
        d.	Выбрать города, в которых есть жители с заданным диапазоном роста
        e.	Вывести список городов, упорядоченный по алфавиту
        f.	Вывести список жителей, упорядоченный по алфавиту
        g.	Вывести список жителей, упорядоченный по убыванию возраста 
        h.	Вывести список жителей по росту
        
    Кроме того, реализуйте добавление записи в коллекцию (с перезаписью файла данных), удаление записи из коллекции 
    (с перезаписью файла данных). Добавляемую запись формируйте фабричным методом, вводить что-либо с клавиатуры 
    не требуется.
*/

// Контроллер Задание 2
public class Task02Controller implements IController {

    // список жителей
    public PeopleList peopleList;


    // конструктор по умолчанию
    public Task02Controller() throws Exception {
        this.peopleList = new PeopleList();
    }


    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Жители",
                "<html>Выбрать по<br>возрасту",
                "<html>Выбрать по<br>фамилии",
                "<html>Выбрать по<br>фамилии<br>города",
                "<html>Выбрать по<br>возрасту<br>города",
                "Города",
                "<html>Сортировка<br>по алфавиту",
                "<html>Сортировка<br>по возрасту",
                "<html>Сортировка<br>по росту",
                "Добавить",
                "Удалить",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 2. Жители";

        IController[] commands = new IController[]{
                
                // все жители
                () -> Utils.showWindow("<html><h1 align='center'>Жители</h1>" + PeopleList.peopleToTable(peopleList.personList),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // жители из заданного города и диапазоном возраста
                () -> {
                    var city = peopleList.personList.get(Utils.getInt(0, peopleList.personList.size())).city;
                    var min = Utils.getInt(20, 30);
                    var max = Utils.getInt(40, 50);
                    Utils.showWindow(
                            "<html><h1 align='center'>Жители из города \"" +
                                    city + "\" с возрастом от " + min + " до " + max + "</h1>" +
                                    PeopleList.peopleToTable(peopleList.selectByCityAndAgeRange(city, min, max)),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                
                // жители с заданной фамилией
                () -> {
                    var surname = peopleList.personList.get(Utils.getInt(0, peopleList.personList.size())).surname;
                    Utils.showWindow(
                            "<html><h1 align='center'>Жители с фамилией \"" + surname + "\"</h1>" +
                                    PeopleList.peopleToTable(peopleList.selectBySurname(surname)),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                
                // города с жителями по заданной фамилии
                () -> {
                    var surname = peopleList.personList.get(Utils.getInt(0, peopleList.personList.size())).surname;
                    Utils.showWindow(
                            "<html><h1 align='center'>Города с жителями по фамилии \"" + surname + "\"</h1>" +
                                    PeopleList.citiesToTable(peopleList.selectCitiesBySurname(surname)),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                
                // города с жителями рост которых в заданном диапазоне
                () -> {
                    var min = Utils.getInt(150, 160);
                    var max = min + Utils.getInt(10, 20);
                    Utils.showWindow(
                            "<html><h1 align='center'>Города с жителями рост которых от " + min + " до " + max + "</h1>" +
                                    PeopleList.citiesToTable(peopleList.selectCitiesByHeightRange(min, max)),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                
                // города в алфавитном порядке
                () -> Utils.showWindow(
                        "<html><h1 align='center'>Города в алфавитном порядке</h1>" +
                                PeopleList.citiesToTable(peopleList.citiesOrderBy()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // жители в алфавитном порядке
                () -> Utils.showWindow(
                        "<html><h1 align='center'>Жители в алфавитном порядке</h1>" +
                                PeopleList.peopleToTable(peopleList.orderByFullName()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // жители по убыванию возраста
                () -> Utils.showWindow(
                        "<html><h1 align='center'>Жители по убыванию возраста</h1>" +
                                PeopleList.peopleToTable(peopleList.orderByAgeDesc()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // жители по возрастанию роста
                () -> Utils.showWindow(
                        "<html><h1 align='center'>Жители по возрастанию роста</h1>" +
                                PeopleList.peopleToTable(peopleList.orderByHeight()),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                
                // добавление жителя
                () -> {
                    peopleList.addPerson(Person.factory(1));
                    Utils.showWindow(
                            "<html><h1 align='center'>Добавлен житель</h1>" + PeopleList.peopleToTable(peopleList.personList),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                
                // удаление жителя
                () -> {
                    var index = Utils.getInt(0, peopleList.personList.size());
                    var id = peopleList.personList.get(index).id;
                    peopleList.removePerson(index);
                    Utils.showWindow(
                            "<html><h1 align='center'>Удалён житель с id: " + id + "</h1>" +
                                    PeopleList.peopleToTable(peopleList.personList),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },

        };
        
        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 2. Библиотека</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }
}
