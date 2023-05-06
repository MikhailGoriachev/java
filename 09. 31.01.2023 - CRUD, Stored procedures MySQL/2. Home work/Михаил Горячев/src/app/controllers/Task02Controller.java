package app.controllers;

import app.interfaces.IController;
import app.models.task02.ExamsDb;
import app.utils.Utils;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;


// Контроллер Задание 2
public class Task02Controller implements IController {

    // поликлиника
    ExamsDb examsDb = ExamsDb.getInstance();

    public Task02Controller() throws Exception {
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
        var title = "Задание 2. Экзамены";

        IController[] commands = new IController[]{
                // данные
                this::dataMenu,

                // запросы
                this::queriesMenu
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 2. Экзамены</h1>", title, buttons, initialValue, imageIcon);

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
                "Экзамены",
                "Экзаменаторы",
                "Студенты",
                "Персоны",
                "Типы экзаменов",
                "Учебные предметы",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 2. Экзамены > Данные";

        IController[] commands = new IController[]{

                // экзамены
                () -> Utils.showWindow(examsDb.examsToTable(examsDb.exams(), "Экзамены"),
                        title + " > Экзамены", new Object[]{"Назад"}, initialValue, imageIcon),

                // экзаменаторы
                () -> Utils.showWindow(examsDb.examinersToTable(examsDb.examiners(), "Экзаменаторы"),
                        title + " > Экзаменаторы", new Object[]{"Назад"}, initialValue, imageIcon),

                // студенты
                () -> Utils.showWindow(examsDb.studentsToTable(examsDb.students(), "Студенты"),
                        title + " > Студенты", new Object[]{"Назад"}, initialValue, imageIcon),

                // персоны
                () -> Utils.showWindow(examsDb.peopleToTable(examsDb.people(), "Персоны"),
                        title + " > Персоны", new Object[]{"Назад"}, initialValue, imageIcon),

                // типы экзаменов
                () -> Utils.showWindow(examsDb.examTypesToTable(examsDb.examTypes(), "Типы экзаменов"),
                        title + " > Типы экзаменов", new Object[]{"Назад"}, initialValue, imageIcon),

                // учебные предметы
                () -> Utils.showWindow(examsDb.academicSubjectsToTable(examsDb.academicSubjects(), "Учебные предметы"),
                        title + " > Учебные предметы", new Object[]{"Назад"}, initialValue, imageIcon),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 2. Экзамены</h1>", title, buttons, initialValue, imageIcon);

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
                "Запрос 8",
                "Запрос 9",
                "Запрос 10",
                "Выход"
        };

        var initialValue = "Выход";
        var imageIcon = new ImageIcon();
        var title = "Задание 2. Экзамены > Запросы";

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
                
                // запрос 08
                () -> query08(title),
                
                // запрос 09
                () -> query09(title),
                
                // запрос 10
                () -> query10(title),
        };

        int select;
        while (true) {
            try {
                select = Utils.showWindow("<html><h1 align='center'>Задание 2. Экзамены</h1>", title, buttons, initialValue, imageIcon);

                if (select >= commands.length || select == -1)
                    return;

                commands[select].run();
            } catch (Exception exception) {
                Utils.showErrorMessage(exception.getMessage(), "Ошибка...");
            }
        }
    }

    // 1	Хранимая процедура	Выбирает информацию об абитуриентах с заданной фамилией, серией/номером паспорта
    public void query01(String startTitle) throws SQLException, ParseException {
        var item = Utils
                .getItem(examsDb.students());

        var info = "Выбирает информацию об абитуриентах с заданной фамилией \"" + item.lastName() + "\"" +
                   "и серией/номером паспорта \"" + item.passport() + "\"";

        Utils.showWindow(examsDb.studentsToTable(examsDb.query01(item.lastName(), item.passport()), info),
                startTitle + " > Запрос 1", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 2	Хранимая процедура	Выбирает информацию об экзаменах, которые были приняты экзаменатором с заданной фамилией
    public void query02(String startTitle) throws SQLException, ParseException {

        var surname = Utils
                .getItem(examsDb.exams())
                .examinerLastName();

        var info = "Выбирает информацию об экзаменах, которые были приняты экзаменатором с фамилией \"" + surname + "\"";

        Utils.showWindow(examsDb.examsToTable(examsDb.query02(surname), info),
                startTitle + " > Запрос 2", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 3	Хранимая процедура	Выбирает информацию об экзаменах, сданных абитуриентом с заданным номером/серией 
    //                          паспорта
    public void query03(String startTitle) throws SQLException, ParseException {

        var passport = Utils
                .getItem(examsDb.exams())
                .studentPassport();

        var info = "Выбирает информацию об экзаменах, сданных абитуриентом с заданным номером/серией \"" + passport + "\"";

        Utils.showWindow(examsDb.examsToTable(examsDb.query03(passport), info),
                startTitle + " > Запрос 3", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 4	Хранимая процедура	Выбирает информацию об абитуриенте с заданным номером/серией паспорта.
    public void query04(String startTitle) throws SQLException, ParseException {
        var passport = Utils
                .getItem(examsDb.students())
                .passport();

        var info = "Выбирает информацию об абитуриентах с серией/номером паспорта\"" + passport + "\"";

        Utils.showWindow(examsDb.studentsToTable(examsDb.query04(passport), info),
                startTitle + " > Запрос 4", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 5	Хранимая процедура	Вычисляет для каждого экзамена размер налога (Налог=Размер оплаты*13%) и зарплаты 
    //                          экзаменатора (Зарплата=Размер оплаты - Налог). Сортировка по полю Код экзаменатора
    public void query05(String startTitle) throws SQLException, ParseException {

        var info = "Вычисляет для каждого экзамена размер налога и зарплаты экзаменатора";

        Utils.showWindow(examsDb.query05ToTable(examsDb.query05(), info),
                startTitle + " > Запрос 5", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 6	Хранимая процедура	Выполняет группировку по полю Год рождения в таблице АБИТУРИЕНТЫ. Для каждой группы 
    //                          определяет количество абитуриентов (итоги по полю Код абитуриента)
    public void query06(String startTitle) throws SQLException, ParseException {

        var info = "Выполняет группировку по полю Год рождения.<br>Для каждой группы определяет количество абитуриентов";

        Utils.showWindow(examsDb.query06ToTable(examsDb.query06(), info),
                startTitle + " > Запрос 6", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 7	Хранимая процедура	Выполняет группировку по полю Дата сдачи экзамена в таблице ЭКЗАМЕНЫ. Для каждой даты 
    //                          определяет среднее значения по полю Оценка
    public void query07(String startTitle) throws SQLException, ParseException {

        var info = "Выполняет группировку по полю Дата сдачи.<br>Для каждой даты определяет среднее значения по полю Оценка";

        Utils.showWindow(examsDb.query07ToTable(examsDb.query07(), info),
                startTitle + " > Запрос 7", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 8	Хранимая процедура	Добавить в таблицу базы данных запись о сдаче экзамена абитуриентом
    public void query08(String startTitle) throws SQLException, ParseException {

        var idExamType = Utils.getItem(examsDb.examTypes()).id();
        var idExaminer = Utils.getItem(examsDb.examiners()).id();
        var idStudent = Utils.getItem(examsDb.students()).id();
        var date = LocalDate.now();
        var score = Utils.getInt(20, 70);

        examsDb.query08(idExamType, idExaminer, idStudent, date, score);

        var info = "Добавить в таблицу базы данных запись о сдаче экзамена абитуриентом";

        Utils.showWindow(examsDb.examsToTable(examsDb.exams(), info),
                startTitle + " > Запрос 8", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 9	Хранимая процедура	Изменить запись в таблице базы данных о сдаче экзамена абитуриентом – указать новую 
    //                          оценку, дату проведения экзамена и экзаменатора
    public void query09(String startTitle) throws SQLException, ParseException {

        var idExam = Utils.getItem(examsDb.exams()).id();
        var idExamType = Utils.getItem(examsDb.examTypes()).id();
        var idExaminer = Utils.getItem(examsDb.examiners()).id();
        var idStudent = Utils.getItem(examsDb.students()).id();
        var date = LocalDate.now();
        var score = Utils.getInt(20, 70);

        examsDb.query09(idExam, idExamType, idExaminer, idStudent, date, score);

        var info = "Изменить запись в таблице базы данных о сдаче экзамена абитуриентом – указать новую " +
                   "оценку, дату проведения экзамена и экзаменатора. Id: " + idExam;

        Utils.showWindow(examsDb.examsToTable(examsDb.exams(), info),
                startTitle + " > Запрос 9", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }

    // 10	Хранимая процедура	Удаление из таблицы базы данных записи о сдаче экзамена абитуриентом
    public void query10(String startTitle) throws SQLException, ParseException {

        var idExam = Utils.getItem(examsDb.exams()).id();

        examsDb.query10(idExam);

        var info = "Удаление из таблицы базы данных записи о сдаче экзамена абитуриентом. Id: " + idExam;

        Utils.showWindow(examsDb.examsToTable(examsDb.exams(), info),
                startTitle + " > Запрос 10", new Object[]{"Назад"}, "Выход", new ImageIcon());
    }
}