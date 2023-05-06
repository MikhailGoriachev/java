package app.models.task02;

import app.utils.Utils;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExamsDb {

    // файл с параметрами
    public static final String PROPERTIES_FILE = "config/database.properties"; 
    
    // соединение
    private final Connection connection;

    // сущность
    private static ExamsDb instance = null;

    public static synchronized ExamsDb getInstance() throws Exception {
        if (instance == null)
            instance = new ExamsDb();
        return instance;
    }
    

    // конструктор по умолчанию
    private ExamsDb() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        
        var props = Utils.getProperties(PROPERTIES_FILE, "urlExams", "login", "password");
        connection = DriverManager.getConnection(props.get("urlExams"), props.get("login"), props.get("password"));
    }


    // данные об экзаменах
    public List<Exam> exams() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    exams_view
                """;

        try (var state = connection.createStatement()) {
            return toExamList(state.executeQuery(sql));
        }
    }
    
    // данные об экзаменаторах
    public List<Examiner> examiners() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    examiners_view
                """;

        try (var state = connection.createStatement()) {
            return toExaminerList(state.executeQuery(sql));
        }
    }

    // данные о студентах
    public List<Student> students() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    students_view
                """;

        try (var state = connection.createStatement()) {
            return toStudentList(state.executeQuery(sql));
        }
    }
    
    // данные о персонах
    public List<Person> people() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    people
                """;

        try (var state = connection.createStatement()) {
            return toPersonList(state.executeQuery(sql));
        }
    }
    
    // данные о типах экзамена
    public List<ExamType> examTypes() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    exam_types_view
                """;

        try (var state = connection.createStatement()) {
            return toExamTypeList(state.executeQuery(sql));
        }
    }
    
    // данные об учебных предметах
    public List<AcademicSubjects> academicSubjects() throws SQLException, ParseException {
        var sql = """
                select
                    *
                from
                    academic_subjects
                """;

        try (var state = connection.createStatement()) {
            return toAcademicSubjectList(state.executeQuery(sql));
        }
    }
    
    // 1	Хранимая процедура	Выбирает информацию об абитуриентах с заданной фамилией, серией/номером паспорта
    public List<Student> query01(String surname, String passport) throws SQLException, ParseException {
        var sql = "{ call query01_procedure(?, ?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setString(1, surname);
            state.setString(2, passport);
            
            state.execute();
            
            return toStudentList(state.getResultSet());
        }
    }

    // 2	Хранимая процедура	Выбирает информацию об экзаменах, которые были приняты экзаменатором с заданной фамилией
    public List<Exam> query02(String surname) throws SQLException, ParseException {
        var sql = "{ call query02_procedure(?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setString(1, surname);

            state.execute();

            return toExamList(state.getResultSet());
        }
    }
    
    // 3	Хранимая процедура	Выбирает информацию об экзаменах, сданных абитуриентом с заданным номером/серией 
    //                          паспорта
    public List<Exam> query03(String passport) throws SQLException, ParseException {
        var sql = "{ call query03_procedure(?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setString(1, passport);

            state.execute();

            return toExamList(state.getResultSet());
        }
    }
    
    // 4	Хранимая процедура	Выбирает информацию об абитуриенте с заданным номером/серией паспорта.
    public List<Student> query04(String passport) throws SQLException, ParseException {
        var sql = "{ call query04_procedure(?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setString(1, passport);

            state.execute();

            return toStudentList(state.getResultSet());
        }
    }

    // 5	Хранимая процедура	Вычисляет для каждого экзамена размер налога (Налог=Размер оплаты*13%) и зарплаты 
    //                          экзаменатора (Зарплата=Размер оплаты - Налог). Сортировка по полю Код экзаменатора
    public List<Exam> query05() throws SQLException, ParseException {
        var sql = "{ call query05_procedure()}";

        try (var state = connection.prepareCall(sql)) {
            state.execute();

            return toExamList(state.getResultSet());
        }
    }
    
    // 6	Хранимая процедура	Выполняет группировку по полю Год рождения в таблице АБИТУРИЕНТЫ. Для каждой группы 
    //                          определяет количество абитуриентов (итоги по полю Код абитуриента)
    public List<Query06> query06() throws SQLException, ParseException {
        var sql = "{ call query06_procedure()}";

        try (var state = connection.prepareCall(sql)) {
            state.execute();

            return toQuery06List(state.getResultSet());
        }
    }

    // 7	Хранимая процедура	Выполняет группировку по полю Дата сдачи экзамена в таблице ЭКЗАМЕНЫ. Для каждой даты 
    //                          определяет среднее значения по полю Оценка
    public List<Query07> query07() throws SQLException, ParseException {
        var sql = "{ call query07_procedure()}";

        try (var state = connection.prepareCall(sql)) {
            state.execute();

            return toQuery07List(state.getResultSet());
        }
    }

    // 8	Хранимая процедура	Добавить в таблицу базы данных запись о сдаче экзамена абитуриентом
    public void query08(int idExamType, int idExaminer, int idStudent, LocalDate date, int score) throws SQLException {
        var sql = "{ call query08_procedure(?, ?, ?, ?, ?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setInt(1, idExamType);
            state.setInt(2, idExaminer);
            state.setInt(3, idStudent);
            state.setDate(4, java.sql.Date.valueOf(date));
            state.setInt(5, score);
            state.execute();
        }
    }
    
    // 9	Хранимая процедура	Изменить запись в таблице базы данных о сдаче экзамена абитуриентом – указать новую 
    //                          оценку, дату проведения экзамена и экзаменатора
    public void query09(int id, int idExamType, int idExaminer, int idStudent, LocalDate date, int score) throws SQLException, ParseException {
        var sql = "{ call query09_procedure(?, ?, ?, ?, ?, ?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setInt(1, id);
            state.setInt(2, idExamType);
            state.setInt(3, idExaminer);
            state.setInt(4, idStudent);
            state.setDate(5, Date.valueOf(date));
            state.setInt(6, score);
            state.execute();
        }
    }

    // 10	Хранимая процедура	Удаление из таблицы базы данных записи о сдаче экзамена абитуриентом
    public void query10(int id) throws SQLException, ParseException {
        var sql = "{ call query10_procedure(?)}";

        try (var state = connection.prepareCall(sql)) {
            state.setInt(1, id);
            state.execute();
        }
    }

    // чтение данных об экзаменах в коллекцию
    public List<Exam> toExamList(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Exam>();

        while (sqlResult.next()) {
            collection.add(new Exam(
                    sqlResult.getInt("id"),
                    sqlResult.getString("academic_subject_name"),
                    sqlResult.getInt("exam_type_id"),
                    sqlResult.getString("exam_type_name"),
                    sqlResult.getInt("examiner_id"),
                    sqlResult.getString("examiner_last_name"),
                    sqlResult.getString("examiner_first_name"),
                    sqlResult.getString("examiner_patronymic"),
                    sqlResult.getInt("examiner_exam_fee"),
                    sqlResult.getInt("student_id"),
                    sqlResult.getString("student_last_name"),
                    sqlResult.getString("student_first_name"),
                    sqlResult.getString("student_patronymic"),
                    sqlResult.getString("student_address"), 
                    sqlResult.getInt("student_year_of_birth"), 
                    sqlResult.getString("student_passport"),
                    sqlResult.getDate("date"),
                    sqlResult.getInt("score")
            ));
        }

        return collection;
    }

    // чтение данных об экзаменаторе в коллекцию
    public List<Examiner> toExaminerList(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Examiner>();

        while (sqlResult.next()) {
            collection.add(new Examiner(
                    sqlResult.getInt("id"),
                    sqlResult.getString("last_name"),
                    sqlResult.getString("first_name"),
                    sqlResult.getString("patronymic"),
                    sqlResult.getInt("exam_fee")
            ));
        }

        return collection;
    }

    // чтение данных о студентах в коллекцию
    public List<Student> toStudentList(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Student>();

        while (sqlResult.next()) {
            collection.add(new Student(
                    sqlResult.getInt("id"),
                    sqlResult.getString("last_name"),
                    sqlResult.getString("first_name"),
                    sqlResult.getString("patronymic"),
                    sqlResult.getString("address"),
                    sqlResult.getInt("year_of_birth"),
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
                    sqlResult.getString("last_name"),
                    sqlResult.getString("first_name"),
                    sqlResult.getString("patronymic")
            ));
        }

        return collection;
    }
    
    // чтение данных о типах экзаменов в коллекцию
    public List<ExamType> toExamTypeList(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<ExamType>();

        while (sqlResult.next()) {
            collection.add(new ExamType(
                    sqlResult.getInt("id"),
                    sqlResult.getString("academic_subject_name"),
                    sqlResult.getString("name")
            ));
        }

        return collection;
    }
    
    // чтение данных об учебных предметах
    public List<AcademicSubjects> toAcademicSubjectList(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<AcademicSubjects>();

        while (sqlResult.next()) {
            collection.add(new AcademicSubjects(
                    sqlResult.getInt("id"),
                    sqlResult.getString("name")
            ));
        }

        return collection;
    }
    
    // чтение данных запроса 6 в коллекцию
    public List<Query06> toQuery06List(ResultSet sqlResult) throws SQLException {
        var collection = new ArrayList<Query06>();

        while (sqlResult.next()) {
            collection.add(new Query06(
                    sqlResult.getInt("year_of_birth"),
                    sqlResult.getInt("amount")
            ));
        }

        return collection;
    }
    
    // чтение данных запроса 7 в коллекцию
    public List<Query07> toQuery07List(ResultSet sqlResult) throws SQLException, ParseException {
        var collection = new ArrayList<Query07>();

        while (sqlResult.next()) {
            collection.add(new Query07(
                    sqlResult.getDate("date"),
                    sqlResult.getInt("min_score"),
                    sqlResult.getDouble("avg_score"),
                    sqlResult.getInt("max_score"),
                    sqlResult.getInt("amount")
            ));
        }

        return collection;
    }
    
    // вывод данных об экзаменах
    public String examsToTable(Collection<Exam> items, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='11'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Предмет</th>")
                .append("<th>Тип экзамена</th>")
                .append("<th>Экзаменатор</th>")
                .append("<th>Комиссия</th>")
                .append("<th>Студент</th>")
                .append("<th>Адрес</th>")
                .append("<th>Год рождения</th>")
                .append("<th>Паспорт</th>")
                .append("<th>Дата рождения</th>")
                .append("<th>Баллы</th>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных об экзаменаторах
    public String examinersToTable(Collection<Examiner> items, String title) {
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
                .append("<th>Комиссия</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о студентах
    public String studentsToTable(Collection<Student> items, String title) {
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
                .append("<th>Адрес</th>")
                .append("<th>Год рождения</th>")
                .append("<th>Паспорт</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных об персонах
    public String peopleToTable(Collection<Person> items, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='4'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Фамилия</th>")
                .append("<th>Имя</th>")
                .append("<th>Отчество</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных о типах экзаменов
    public String examTypesToTable(Collection<ExamType> items, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='3'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Название предмета</th>")
                .append("<th>Тип</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных об учебных предметах
    public String academicSubjectsToTable(Collection<AcademicSubjects> items, String title) {
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
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных запроса 5
    public String query05ToTable(Collection<Exam> items, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='13'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Id</th>")
                .append("<th>Предмет</th>")
                .append("<th>Тип экзамена</th>")
                .append("<th>Экзаменатор</th>")
                .append("<th>Комиссия</th>")
                .append("<th>Студент</th>")
                .append("<th>Адрес</th>")
                .append("<th>Год рождения</th>")
                .append("<th>Паспорт</th>")
                .append("<th>Дата рождения</th>")
                .append("<th>Баллы</th>")
                .append("<th>Налог</th>")
                .append("<th>Зарплата</th>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRowWithTaxAndSalary()));

        sb.append("</tbody></table>");

        return sb.toString();
    }

    // вывод данных запроса 6
    public String query06ToTable(Collection<Query06> items, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='2'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Год рождения</th>")
                .append("<th>Количество</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
    
    // вывод данных запроса 7
    public String query07ToTable(Collection<Query07> items, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table align='center' border='1' cellspacing='0' cellpadding='8'><thead>")
                .append("<tr>")
                .append("<th colspan='5'>")
                .append(title)
                .append("</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<th>Дата</th>")
                .append("<th>Количество</th>")
                .append("<th>Минимальный балл</th>")
                .append("<th>Средний балл</th>")
                .append("<th>Максимальный балл</th>")
                .append("</tr>")
                .append("</thead><tbody>");

        items.forEach((c) -> sb.append(c.toTableRow()));

        sb.append("</tbody></table>");

        return sb.toString();
    }
}
