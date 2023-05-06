package org.itstep.pd011;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

// запросы к БД
public class DbHandler {

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:app_data/insurance.db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    // потокобезопасное создание подключения
    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    // приватный конструктор - требование синглтона
    private DbHandler() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite (регистрация драйвера в д.с. не обязательна)
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    } // DbHandler

    // пример операции выборки данных из таблицы - получить и вывести всех клиентов
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        // создаем оператор для выборки данных
        try (Statement statement = connection.createStatement()) {

            // выполнить выборку данных
            ResultSet resultSet = statement.executeQuery("select * from clients");

            // Проходим по выборке и выводим данные в консоль
            while (resultSet.next()) {
                clients.add(new Client(
                    resultSet.getInt("id"), resultSet.getString("surname"),
                    resultSet.getString("name"), resultSet.getString("patronymic"),
                    resultSet.getString("passport"), resultSet.getDouble("discount")
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
            // Locale.UK - обеспечивает точку между целой и дробной частью вещественного числа
            statement.executeUpdate(String.format(Locale.UK,
                sql,
                client.surname, client.name, client.patronymic, client.passport, client.discount));
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch
    } // addClient

    // читать запись о клиенте по id - Read C(R)UD
    public Client getClientById(int id) {
        Client client = new Client();

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
                client.id = rs.getInt("id");
                client.surname = rs.getString("surname");
                client.name = rs.getString("name");
                client.patronymic = rs.getString("patronymic");
                client.passport = rs.getString("passport");
                client.discount = rs.getDouble("discount");
            } // if

        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return client;
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
            counterUpdated = statement.executeUpdate(String.format(Locale.UK, sql, client.surname, client.name,
                    client.patronymic, client.passport, client.discount, client.id));
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

} // class DbHelper