package org.itstep.pd011;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class DbHandler {

    // Адрес загрузки драйвера Connector/J для MySQL: https://dev.mysql.com/downloads/connector/j/ 
    // Константы, в которых хранятся параметры подключения
    //                                                              имя БД   | часовой пояс               | отключить SSL
    // private static final String URL       = "jdbc:mysql://localhost/insurance?serverTimezone=Europe/Moscow&useSSL=false";
    // private static final String USER_NAME = "root";
    // private static final String PASSWORD  = "___sP123456890...";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws Exception {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandler() throws Exception {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае MySQL
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        // Выполняем подключение к базе данных
        // this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        this.connection = loadConnection();
    } // DbHandler

    // чтение параметров подключения из конфигурационного файла
    private static Connection loadConnection() throws Exception {
        // Properties - хранение свойств в формате "ключ" - "значение"
        // свойства могут читаться из файла
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("app_data/database.properties"))){
            props.load(in);
        }

        // установка параметров соединения из прочитанных свойств
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    } // loadConnection

    // пример операции выборки данных из таблицы - получить и вывести всех клиентов
    public List<Client> getAllClients() throws Exception {
        List<Client> clients = new ArrayList<>();

        // Выполняем подключение к базе данных, создаем оператор для выборки данных
        // использование локальной переменной connection - только ля
        // демонстрации возможности множественных соединений с БД
        // лучше использовать соединение - поле класса
        try (// Connection connection = loadConnection();
             Statement statement = connection.createStatement()) {

            // выполнить выборку данных
            ResultSet resultSet = statement.executeQuery("select * from clients");

            // Проходим по выборке и выводим данные в консоль
            while (resultSet.next()) {
                clients.add(new Client(
                    resultSet.getInt("id"), resultSet.getString("surname"),
                    resultSet.getString("name"), resultSet.getString("patronymic"),
                    resultSet.getString("passport"), resultSet.getFloat("discount")
                ));
            } // while
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return clients;
    } // getAllClients

    // добавить клиента - Create (C)RUD
    public void addClient(Client client) {
        try (Statement statement = this.connection.createStatement()) {

            String sql = """
                insert into Clients (surname, name, patronymic, passport, discount) 
                values ('%s', '%s', '%s', '%s', %.2f);
            """;
            statement.executeUpdate(String.format(Locale.UK, sql,
                    client.surname(), client.name(),
                    client.patronymic(), client.passport(), client.discount()));

        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch
    } // addClient

    // читать запись о клиенте по id - Read C(R)UD
    public Client getClient(int id) throws Exception {
        try (Statement statement = this.connection.createStatement()) {

            String sql = """
                        select 
                            * 
                        from 
                            Clients 
                        where
                            id = %d;
                    """;
            ResultSet rs = statement.executeQuery(String.format(sql, id));
            if (rs.next()) {
                return new Client(
                        rs.getInt("id"), rs.getString("surname"), rs.getString("name"),
                        rs.getString("patronymic"), rs.getString("passport"), rs.getDouble("discount")
                );
            } // if

            throw new Exception("Запись не найдена");
        }
    } // getClient

    // изменить запись о клиенте - Update CR(U)D
    public int updateClient(Client client) {
        int counterUpdated = 0;

        try (Statement statement = this.connection.createStatement()) {

            String sql = """
                update 
                    Clients  
                set
                    surname = '%s',
                    name = '%s',
                    patronymic = '%s',
                    passport = '%s',
                    discount = %.2f
                where
                    id = %d;
            """;
            counterUpdated = statement.executeUpdate(String.format(Locale.UK, sql,
                    client.surname(), client.name(),
                    client.patronymic(), client.passport(), client.discount(), client.id()));
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return counterUpdated;
    } // updateClient

    // удалить запись о клиенте - Delete CRU(D)
    public int deleteClient(int id) {
        int counterDeleted = 0;

        try (Statement statement = this.connection.createStatement()) {

            String sql = """
                delete from
                    Clients  
                where
                    id = %d;
            """;
            counterDeleted = statement.executeUpdate(String.format(sql, id));
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return counterDeleted;
    } // deleteClient

    // добавить клиента - Create (C)RUD
    public void addClientPs(Client client) {
        String sql = """
            insert into clients (surname, name, patronymic, passport, discount) 
            values (?, ?, ?, ?, ?);
            """;

        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {

            ps.setString(1, client.surname());
            ps.setString(2, client.name());
            ps.setString(3, client.patronymic());
            ps.setString(4, client.passport());
            ps.setDouble(5, client.discount());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch
    } // addClientPs

    // читать запись о клиенте по id - Read C(R)UD
    public Client getClientPs(int id) throws Exception {
        Client client = new Client();
        String sql = """
                select 
                    * 
                from 
                    clients 
                where
                    id = ?
            """;

        // выполнение запроса - получение данных из таблицы
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // если запись есть в выборке - прочитать эту запись
            if (rs.next()) {
                return new Client(
                        rs.getInt("id"), rs.getString("surname"), rs.getString("name"),
                        rs.getString("patronymic"), rs.getString("passport"), rs.getDouble("discount")
                );
            } // if
            throw new Exception("Запись не найдена");
        } // try
    } // getClientPs

    // изменить запись о клиенте - Update CR(U)D
    public int updateClientPs(Client client) {
        // количество измененных элементов
        int counterUpdated = 0;

        // запрос на изменение записи в таблице
        String sql = """
                update 
                    clients  
                set
                    surname    = ?,
                    name       = ?,
                    patronymic = ?,
                    passport   = ?,
                    discount   = ?
                where
                    id = ?;
            """;

        // выполнение запроса на изменение
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            // установить параметры запроса
            ps.setString(1, client.surname());
            ps.setString(2, client.name());
            ps.setString(3, client.patronymic());
            ps.setString(4, client.passport());
            ps.setDouble(5, client.discount());
            ps.setInt(6, client.id());

            // собственно выполнмть запрос
            counterUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return counterUpdated;
    } // updateClientPs

    // удалить запись о клиенте - Delete CRU(D)
    public int deleteClientPs(int id) {
        // количество удаленных записей
        int counterDeleted = 0;

        // запрос на удаление
        String sql = """
            delete from
                clients  
            where
                id = ?;
        """;

        // выполнение запроса
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            counterDeleted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return counterDeleted;
    } // deleteClient

} // class DbHelper