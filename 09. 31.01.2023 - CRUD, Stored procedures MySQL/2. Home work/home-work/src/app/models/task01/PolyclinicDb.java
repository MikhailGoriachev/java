package app.models.task01;

import app.utils.Utils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PolyclinicDb {

    // файл с параметрами
    public static final String PROPERTIES_FILE = "config/database.properties"; 
    
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
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        
        var props = Utils.getProperties(PROPERTIES_FILE, "urlPolyclinic", "login", "password");
        connection = DriverManager.getConnection(props.get("urlPolyclinic"), props.get("login"), props.get("password"));
    }


    // данные о приёмах
    public List<Appointment> appointments() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    view_appointments
                """;

        try (var state = connection.createStatement()) {
            return toAppointmentList(state.executeQuery(sql));
        }
    }

    // данные о врачах
    public List<Doctor> doctors() throws SQLException {
        var sql = """
                select
                    *
                from
                    view_doctors
                """;

        try (var state = connection.createStatement()) {
            return toDoctorList(state.executeQuery(sql));
        }
    }

    // данные о пациентах
    public List<Patient> patients() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    view_patients
                """;

        try (var state = connection.createStatement()) {
            return toPatientList(state.executeQuery(sql));
        }
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
    public List<Patient> query01(String surnameStartWith) throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    view_patients
                where
                    view_patients.patient_surname regexp concat('^', ?);
                """;

        try (var state = connection.prepareStatement(sql)) {
            state.setString(1, surnameStartWith);
            return toPatientList(state.executeQuery());
        }
    }


    // 2	Запрос с параметрами	Выбирает информацию о врачах, для которых значение в поле Процент отчисления 
    //                              на зарплату, больше заданного
    public List<Doctor> query02(int percent) throws SQLException {
        var sql = """
                select
                    *
                from
                    view_doctors
                where
                    view_doctors.percent > ?;
                """;

        try (var state = connection.prepareStatement(sql)) {
            state.setInt(1, percent);
            return toDoctorList(state.executeQuery());
        }
    }

    // 3	Запрос с параметрами	Выбирает информацию о приемах за некоторый период
    public List<Appointment> query03(Date dateBegin, Date dateEnd) throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    view_appointments
                where
                    view_appointments.appointment_date between ? and ?;
                """;
        
        try (var state = connection.prepareStatement(sql)) {
            state.setString(1, String.format("%1$tY-%1$tm-%1$td", dateBegin));
            state.setString(2, String.format("%1$tY-%1$tm-%1$td", dateEnd));
            return toAppointmentList(state.executeQuery());
        }
    }

    // 4	Запрос с параметрами	Выбирает из таблицы информацию о врачах с заданной специальностью
    public List<Doctor> query04(String speciality) throws SQLException {
        var sql = """
                select
                    *
                from
                    view_doctors
                where
                    view_doctors.speciality_name like ?;
                """;

        try (var state = connection.prepareStatement(sql)) {
            state.setString(1, speciality);
            return toDoctorList(state.executeQuery());
        }
    }

    // 5	Запрос с вычисляемыми полями	Вычисляет размер заработной платы врача за каждый прием. Включает поля 
    //                                      Фамилия врача, Имя врача, Отчество врача, Специальность врача, Стоимость 
    //                                      приема, Зарплата. Сортировка по полю Специальность врача
    public List<Query05> query05() throws SQLException {
        var sql = """
                select
                view_appointments.id
                    ,view_appointments.doctor_surname
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
            return toQuery05List(state.executeQuery(sql));
        }
    }

    // 6	Итоговый запрос     Выполняет группировку по полю Дата приема. Для каждой даты вычисляет 
    //                          максимальную стоимость приема
    public List<Query06> query06() throws SQLException, ParseException {
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
            return toQuery06List(state.executeQuery(sql));
        }
    }

    // 7	Итоговый запрос	    Выполняет группировку по полю Специальность. Для каждой специальности вычисляет средний 
    //                          Процент отчисления на зарплату от стоимости приема
    public List<Query07> query07() throws SQLException, ParseException {
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

    // чтение данных о приёмах в коллекцию
    public List<Appointment> toAppointmentList(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Appointment>();

        while (sqlResult.next()) {
            collection.add(new Appointment(
                    sqlResult.getInt("id"),
                    sqlResult.getDate("appointment_date"),
//                    new SimpleDateFormat("yyyy-MM-dd").parse(sqlResult.getString("appointment_date")),
                    sqlResult.getString("doctor_surname"),
                    sqlResult.getString("doctor_name"), 
                    sqlResult.getString("doctor_patronymic"),
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("price"),
                    sqlResult.getInt("percent"),
                    sqlResult.getString("patient_surname"),
                    sqlResult.getString("patient_name"),
                    sqlResult.getString("patient_patronymic"),
                    sqlResult.getDate("born_date"),
//                    new SimpleDateFormat("yyyy-MM-dd").parse(sqlResult.getString("born_date")),
                    sqlResult.getString("address"),
                    sqlResult.getString("passport")
            ));
        }

        return collection;
    }

    // чтение данных о врачах в коллекцию
    public List<Doctor> toDoctorList(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Doctor>();

        while (sqlResult.next()) {
            collection.add(new Doctor(
                    sqlResult.getInt("id"),
                    sqlResult.getString("doctor_surname"),
                    sqlResult.getString("doctor_name"),
                    sqlResult.getString("doctor_patronymic"),
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("price"),
                    sqlResult.getInt("percent")
            ));
        }

        return collection;
    }

    // чтение данных о пациентах в коллекцию
    public List<Patient> toPatientList(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Patient>();

        while (sqlResult.next()) {
            collection.add(new Patient(
                    sqlResult.getInt("id"),
                    sqlResult.getString("patient_surname"),
                    sqlResult.getString("patient_name"),
                    sqlResult.getString("patient_patronymic"),
                    sqlResult.getDate("born_date"),
//                    new SimpleDateFormat("yyyy-MM-dd").parse(sqlResult.getString("born_date")),
                    sqlResult.getString("address"),
                    sqlResult.getString("passport")
            ));
        }

        return collection;
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

    // чтение данных запроса 5 в коллекцию
    public List<Query05> toQuery05List(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Query05>();

        while (sqlResult.next()) {
            collection.add(new Query05(
                    sqlResult.getInt("id"),
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

    // чтение данных запроса 6 в коллекцию
    public List<Query06> toQuery06List(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Query06>();

        while (sqlResult.next()) {
            collection.add(new Query06(
                    new SimpleDateFormat("yyyy-MM-dd").parse(sqlResult.getString("appointment_date")),
                    sqlResult.getInt("amount"),
                    sqlResult.getInt("min_price"),
                    sqlResult.getDouble("avg_price"),
                    sqlResult.getInt("max_price")
            ));
        }

        return collection;
    }

    // чтение данных запроса 7 в коллекцию
    public List<Query07> toQuery07List(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Query07>();

        while (sqlResult.next()) {
            collection.add(new Query07(
                    sqlResult.getString("speciality_name"),
                    sqlResult.getInt("amount"),
                    sqlResult.getInt("min_percent"),
                    sqlResult.getDouble("avg_percent"),
                    sqlResult.getInt("max_percent")
            ));
        }

        return collection;
    }
    
    // вывод данных о приёмах
    public String appointmentsToTable(Collection<Appointment> appointments, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='14'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Дата приёма</th>")
                .append("<th>Фамилия доктора</th>")
                .append("<th>Имя доктора</th>")
                .append("<th>Отчество доктора</th>")
                .append("<th>Специальность</th>")
                .append("<th>Стоимость приёма</th>")
                .append("<th>Проценты</th>")
                .append("<th>Фамилия пациента</th>")
                .append("<th>Имя пациента</th>")
                .append("<th>Отчество пациента</th>")
                .append("<th>Дата рождения</th>")
                .append("<th>Паспорт</th>")
                .append("</thead><tbody>");

        appointments.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о врачах
    public String doctorsToTable(Collection<Doctor> doctors, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='7'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Отчество</th>")
                .append("<th>Специальность</th>")
                .append("<th>Стоимость приёма</th>")
                .append("<th>Проценты</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        doctors.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о пациентах
    public String patientsToTable(Collection<Patient> patients, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='7'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Отчество</th>")
                .append("<th>Дата рождения</th>")
                .append("<th>Адрес</th>")
                .append("<th>Паспорт</th>")
                .append("</thead><tbody>");

        patients.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о персонах
    public String peopleToTable(Collection<Person> people, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='5'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Отчество</th>")
                .append("</thead><tbody>");

        people.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о специальностях
    public String specialitiesToTable(Collection<Speciality> specialities, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='2'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Название</th>")
                .append("</thead><tbody>");

        specialities.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных запроса 5
    public String query05ToTable(Collection<Query05> doctors, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='8'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Отчество</th>")
                .append("<th>Специальность</th>")
                .append("<th>Стоимость приёма</th>")
                .append("<th>Проценты</th>")
                .append("<th>Зарплата</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        doctors.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
    
    // вывод данных запроса 6
    public String query06ToTable(Collection<Query06> doctors, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='5'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Дата приёма</th>")
                .append("<th>Количество</th>")
                .append("<th>Минимальная цена</th>")
                .append("<th>Средняя цена</th>")
                .append("<th>Максимальная цена</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        doctors.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
    
    // вывод данных запроса 7
    public String query07ToTable(Collection<Query07> doctors, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='5'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Специальность</th>")
                .append("<th>Количество</th>")
                .append("<th>Минимальная процент</th>")
                .append("<th>Средняя процент</th>")
                .append("<th>Максимальная процент</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        doctors.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
