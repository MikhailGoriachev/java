package app.controllers;

import app.interfaces.IController;
import app.models.task02.Book;
import app.models.task02.Library;
import app.utils.Utils;

import javax.swing.*;

/*
    Задача 2. Учет книг в библиотеке. Библиотека имеет название, адрес, максимальное количество хранимых книг, 
    коллекцию сведений о книгах. Сведения о книгах содержат: числовой идентификатор книги, фамилию и инициалы автора, 
    название, год издания, количество экземпляров данной книги в библиотеке. Разработайте классы для представления 
    библиотеки, сведений о книге. Используйте HashMap для хранения книг, используйте методы класса Collections для 
    сортировки книг из коллекции по заданию. Требуется обеспечивать выбор с помощью меню и выполнение одной из следующих 
    функций:
    •	начальное заполнение данных библиотеки, в том числе коллекции книг;
    •	добавление данных о книгах, вновь поступающих в библиотеку;
    •	удаление данных о списываемых книгах;
    •	выдача сведений о всех книгах, упорядоченных по фамилиям авторов;
    •	выдача сведений о всех книгах, упорядоченных по убыванию года издания;
    •	выдача сведений о всех книгах, упорядоченных по возрастанию количества;
    •	выдача сведений о всех книгах, упорядоченных по названию.

*/

// Контроллер Задание 2
public class Task02Controller implements IController {

    // библиотека
    public Library library;

    
    // конструктор по умолчанию
    public Task02Controller() throws Exception {
        this.library = new Library();
    }
    

    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Инициализация",
                "Все книги",
                "По автору",
                "По году",
                "По количеству",
                "По названию",
                "Добавить",
                "Удалить",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 2. Библиотека";

        IController[] commands = new IController[]{
                () -> {
                    library.initialization();
                    Utils.showWindow(
                            "<html><h1 align='center'>Библиотека. Инициализация</h1>" + library.libraryToTable(),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                () -> Utils.showWindow("<html><h1 align='center'>Библиотека. Все книги</h1>" + library.libraryToTable(),
                        title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Сортировка по автору</h1>" +
                        Library.booksToTable(library.orderByAuthor()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Сортировка по убыванию года издания</h1>" +
                        Library.booksToTable(library.orderByYearDesc()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Сортировка по количеству</h1>" +
                        Library.booksToTable(library.orderByAmountAsc()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> Utils.showWindow("<html><h1 align='center'>Сортировка по названию</h1>" +
                        Library.booksToTable(library.orderByName()), title, new Object[]{"Назад"}, initialValue, imageIcon),
                () -> {
                    library.add(new Book(1, "Эрик Фриман", "Паттерны проектирования", 2004, Utils.getInt(10, 15)));
                    Utils.showWindow(
                            "<html><h1 align='center'>Библиотека. Добавлена книга</h1>" + library.libraryToTable(),
                            title, new Object[]{"Назад"}, initialValue, imageIcon);
                },
                () -> {
                    var books = library.books.values().toArray();
                    var id = ((Book) books[Utils.getInt(0, books.length)]).id();
                    library.remove(id);
                    Utils.showWindow(
                            "<html><h1 align='center'>Библиотека. Удалена книга id: " + id + "</h1>" +
                                    library.libraryToTable(),
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
