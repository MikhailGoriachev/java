package app.controllers;

import app.interfaces.IController;
import app.models.task01.*;
import app.utils.Utils;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;


// Контроллер Задание 1
public class Task01Controller implements IController {

    // поликлиника
    PolyclinicDb polyclinic = PolyclinicDb.getInstance();

    public Task01Controller() throws Exception {
    }

    // работа по заданию
    public void run() {
        var buttons = new Object[]{
                "Данные",
                "Запросы",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Поликлиника";

        IController[] commands = new IController[]{
                // данные
                this::dataMenu,

                // запросы
                this::queriesMenu
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1. Поликлиника</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // меню данных
    public void dataMenu() {
        var buttons = new Object[]{
                "Приёмы",
                "Врачи",
                "Пациенты",
                "Персоны",
                "Специальности",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Поликлиника > Данные";

        IController[] commands = new IController[]{

                // приёмы
                () -> Utils.showWindow(polyclinic.appointmentsToTable(polyclinic.appointments(), "Приёмы"),
                        title + " > Приёмы", new Object[]{"Назад"}, initialValue, imageIcon),

                // врачи
                () -> Utils.showWindow(polyclinic.doctorsToTable(polyclinic.doctors(), "Врачи"),
                        title + " > Врачи", new Object[]{"Назад"}, initialValue, imageIcon),

                // пациенты
                () -> Utils.showWindow(polyclinic.patientsToTable(polyclinic.patients(), "Пациенты"),
                        title + " > Пациенты", new Object[]{"Назад"}, initialValue, imageIcon),

                // персоны
                () -> Utils.showWindow(polyclinic.peopleToTable(polyclinic.people(), "Персоны"),
                        title + " > Персоны", new Object[]{"Назад"}, initialValue, imageIcon),

                // специальности
                () -> Utils.showWindow(polyclinic.specialitiesToTable(polyclinic.specialities(), "Специальности"),
                        title + " > Специальности", new Object[]{"Назад"}, initialValue, imageIcon),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1. Поликлиника</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // запросы
    public void queriesMenu() {
        var buttons = new Object[]{
                "Запрос 1",
                "Запрос 2",
                "Запрос 3",
                "Запрос 4",
                "Запрос 5",
                "Запрос 6",
                "Запрос 7",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 1. Поликлиника > Запросы";

        IController[] commands = new IController[]{

                // запрос 01
                () -> query01(title),

                // запрос 02
                () -> query02(title),

                // запрос 03
                () -> query03(title),

                // запрос 04
                () -> query04(title),

                // запрос 05
                () -> query05(title),

                // запрос 06
                () -> query06(title),

                // запрос 07
                () -> query07(title),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 1. Поликлиника</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // 1	Запрос с параметрами	Выбирает информацию о пациентах с фамилиями, начинающимися на заданную
    //                              последовательность символов
    public void query01(String startTitle) throws SQLException, ParseException {

        var surname = Utils
                .getItem(polyclinic.patients())
                .surname()
                .substring(0, 3);

        var info = "Выбирает информацию о пациентах с фамилиями, начинающимися на \"" + surname + "\"";

        Utils.showWindow(polyclinic.patientsToTable(polyclinic.query01(surname), info),
                startTitle + " > Запрос 1", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 2	Запрос с параметрами	Выбирает информацию о врачах, для которых значение в поле Процент отчисления
    //                              на зарплату, больше заданного
    public void query02(String startTitle) throws SQLException {

        var percent = (int) (Utils.getItem(polyclinic.doctors())
                .percent() / 1.2);

        var info = "Выбирает информацию о врачах, для которых процент отчисления больше " + percent + "%";

        Utils.showWindow(polyclinic.doctorsToTable(polyclinic.query02(percent), info),
                startTitle + " > Запрос 2", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 3	Запрос с параметрами	Выбирает информацию о приемах за некоторый период
    public void query03(String startTitle) throws SQLException, ParseException {

        var appointment = Utils.getItem(polyclinic.appointments());

        var date = new Date(appointment.appointmentDate().getTime());

        date.setDate(date.getDate() - 3);
        var begin = new Date(date.getTime());

        date.setDate(date.getDate() + 6);
        var end = new Date(date.getTime());

        var info = String.format("Выбирает информацию о приёмах от %1$td.%1$tm.%1$tY до %2$td.%2$tm.%2$tY",
                begin, end);

        Utils.showWindow(polyclinic.appointmentsToTable(polyclinic.query03(begin, end), info),
                startTitle + " > Запрос 3", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 4	Запрос с параметрами	Выбирает из таблицы информацию о врачах с заданной специальностью
    public void query04(String startTitle) throws SQLException {

        var speciality = Utils
                .getItem(polyclinic.doctors())
                .specialityName();

        var info = "Выбирает из таблицы информацию о врачах со специальностью \"" + speciality + "\"";

        Utils.showWindow(polyclinic.doctorsToTable(polyclinic.query04(speciality), info),
                startTitle + " > Запрос 4", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 5	Запрос с вычисляемыми полями	Вычисляет размер заработной платы врача за каждый прием. Включает поля
    //                                      Фамилия врача, Имя врача, Отчество врача, Специальность врача, Стоимость
    //                                      приема, Зарплата. Сортировка по полю Специальность врача
    public void query05(String startTitle) throws SQLException {

        var info = "Вычисляет размер заработной платы врача для каждого приёма";

        Utils.showWindow(polyclinic.query05ToTable(polyclinic.query05(), info),
                startTitle + " > Запрос 5", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 6	Итоговый запрос     Выполняет группировку по полю Дата приема. Для каждой даты вычисляет
    //                          максимальную стоимость приема
    public void query06(String startTitle) throws SQLException, ParseException {

        var info = "Вычисляет для каждой даты приёма статистику стоимости";

        Utils.showWindow(polyclinic.query06ToTable(polyclinic.query06(), info),
                startTitle + " > Запрос 6", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 7	Итоговый запрос	    Выполняет группировку по полю Специальность. Для каждой специальности вычисляет средний
    //                          Процент отчисления на зарплату от стоимости приема
    public void query07(String startTitle) throws SQLException, ParseException {

        var info = "Вычисляет для специальности статистику процента на зарплату врача";

        Utils.showWindow(polyclinic.query07ToTable(polyclinic.query07(), info),
                startTitle + " > Запрос 7", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }
}