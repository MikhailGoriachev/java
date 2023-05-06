package org.homework.app.middleware;

import org.homework.app.models.Person;
import org.homework.app.models.Speciality;
import org.homework.app.models.dao.entities.Appointment;
import org.homework.app.models.dao.entities.Doctor;
import org.homework.app.models.dao.entities.Patient;
import org.homework.app.models.dao.entitiesDaoImpl.AppointmentDaoImpl;
import org.homework.app.models.dao.entitiesDaoImpl.DoctorDaoImpl;
import org.homework.app.models.dao.entitiesDaoImpl.PatientDaoImpl;
import org.homework.app.models.queries.*;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class PolyclinicDb {

    // соединение
    private final Connection connection;

    // сущность
    private static PolyclinicDb instance = null;

    public static synchronized PolyclinicDb getInstance() throws Exception {
        if (instance == null)
            instance = new PolyclinicDb();
        return instance;
    }


    // конструктор по умолчанию
    private PolyclinicDb() throws Exception {
        connection = ConnectionCreator.createConnection();
    }


    // данные о приёмах
    public List<Appointment> appointments() throws Exception {
        return new AppointmentDaoImpl().all();
    }

    // данные о врачах
    public List<Doctor> doctors() throws Exception {
        return new DoctorDaoImpl().all();
    }

    // данные о пациентах
    public List<Patient> patients() throws Exception {
        return new PatientDaoImpl().all();
    }

    // данные о персонах
    public List<Person> people() throws SQLException {
        var sql = """
                select
                    *
                from
                    persons
                """;

        try (var state = connection.createStatement()) {
            return toPersonList(state.executeQuery(sql));
        }
    }

    // данные о специальностях
    public List<Speciality> specialities() throws SQLException {
        var sql = """
                select
                    *
                from
                    specialities
                """;

        try (var state = connection.createStatement()) {
            return toSpecialityList(state.executeQuery(sql));
        }
    }

    // 1	Запрос с параметрами	Выбирает информацию о пациентах с фамилиями, начинающимися на заданную 
    //                              последовательность символов
    public List<Patient> query01(String surnameStartWith) throws Exception {
        return new PatientDaoImpl().query01(surnameStartWith);
    }

    // 2	Запрос с параметрами	Выбирает информацию о приемах за некоторый период
    public List<Appointment> query02(Date dateBegin, Date dateEnd) throws Exception {
        return new AppointmentDaoImpl().query02(dateBegin, dateEnd);
    }

    // 3	Запрос с вычисляемыми полями	Вычисляет размер заработной платы врача за каждый прием. Включает поля 
    //                                      Фамилия врача, Имя врача, Отчество врача, Специальность врача, Стоимость 
    //                                      приема, Зарплата. Сортировка по полю Специальность врача
    public List<Query03> query03() throws SQLException {
        var sql = """
                select
                view_appointments.id
                    , view_appointments.appointment_date
                    , view_appointments.doctor_surname
                    , view_appointments.doctor_name
                    , view_appointments.doctor_patronymic
                    , view_appointments.speciality_name
                    , view_appointments.price
                    , view_appointments.percent
                    , (view_appointments.price * (view_appointments.percent / 100)) as salary_appointment
                from
                    view_appointments
                order by
                    view_appointments.speciality_name;
                """;

        try (var state = connection.createStatement()) {
            return toQuery03List(state.executeQuery(sql));
        }
    }

    // 4	Итоговый запрос     Выполняет группировку по полю Дата приема. Для каждой даты вычисляет 
    //                          максимальную стоимость приема
    public List<Query04> query04() throws Exception {
        var sql = """
                select
                    view_appointments.appointment_date
                    , count(*)						as amount
                    , min(view_appointments.price)	as min_price
                    , avg(view_appointments.price)	as avg_price
                    , max(view_appointments.price)	as max_price
                from
                    view_appointments
                group by
                    view_appointments.appointment_date;
                """;

        try (var state = connection.createStatement()) {
            return toQuery04List(state.executeQuery(sql));
        }
    }

    // 5	Итоговый запрос	    Выполняет группировку по полю Специальность. Для каждой специальности вычисляет средний 
    //                          Процент отчисления на зарплату от стоимости приема
    public List<Query05> query05() throws Exception {
        var sql = """
                select
                    view_appointments.speciality_name
                    , count(*)						    as amount
                    , min(view_appointments.percent)	as min_percent
                    , avg(view_appointments.percent)	as avg_percent
                    , max(view_appointments.percent)	as max_percent
                from
                    view_appointments
                group by
                    view_appointments.speciality_name;
                """;

        try (var state = connection.createStatement()) {
            return toQuery07List(state.executeQuery(sql));
        }
    }
    
    // чтение данных о персонах в коллекцию
    public List<Person> toPersonList(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Person>();

        while (sqlResult.next()) {
            collection.add(new Person(
                    sqlResult.getInt("id"),
                    sqlResult.getString("surname"),
                    sqlResult.getString("name"),
                    sqlResult.getString("patronymic")
            ));
        }

        return collection;
    }

    // чтение данных о специальностях в коллекцию
    public List<Speciality> toSpecialityList(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Speciality>();

        while (sqlResult.next()) {
            collection.add(new Speciality(
                    sqlResult.getInt("id"),
                    sqlResult.getString("name")
            ));
        }

        return collection;
    }

    // чтение данных запроса 3 в коллекцию
    public List<Query03> toQuery03List(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Query03>();

        while (sqlResult.next()) {
            collection.add(new Query03(
                    sqlResult.getInt("id"),
                    sqlResult.getDate("appointment_date"),
                    sqlResult.getString("doctor_surname"),
                    sqlResult.getString("doctor_name"),
                    sqlResult.getString("doctor_patronymic"),
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("price"),
                    sqlResult.getInt("percent"),
                    sqlResult.getInt("salary_appointment")
            ));
        }

        return collection;
    }

    // чтение данных запроса 4 в коллекцию
    public List<Query04> toQuery04List(ResultSet sqlResult) throws Exception {
        var collection = new ArrayList<Query04>();

        while (sqlResult.next()) {
            collection.add(new Query04(
                    sqlResult.getDate("appointment_date"),
                    sqlResult.getInt("amount"),
                    sqlResult.getInt("min_price"),
                    sqlResult.getDouble("avg_price"),
                    sqlResult.getInt("max_price")
            ));
        }

        return collection;
    }

    // чтение данных запроса 7 в коллекцию
    public List<Query05> toQuery07List(ResultSet sqlResult) throws Exception {
        var collection = new ArrayList<Query05>();

        while (sqlResult.next()) {
            collection.add(new Query05(
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("amount"),
                    sqlResult.getInt("min_percent"),
                    sqlResult.getDouble("avg_percent"),
                    sqlResult.getInt("max_percent")
            ));
        }

        return collection;
    }
}
