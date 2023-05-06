package org.itstep.pd011;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DbHandler {

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:app_data/insurance.db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandler() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());

        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    } // DbHandler

    // пример операции выборки данных из таблицы - получить и вывести всех клиентов
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        // Выполняем подключение к базе данных, создаем оператор для выборки данных
        try (Statement statement = connection.createStatement()) {

            // выполнить выборку данных
            ResultSet resultSet = statement.executeQuery("select * from clients");

            // Проходим по выборке, формируя коллекцию записей типа Client
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
    public void addClientPs(Client client) {
        String sql = """
            insert into Clients (surname, name, patronymic, passport, discount) 
            values (?, ?, ?, ?, ?);
            """;

        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            // нумерация параметров - с 1
            ps.setString(1, client.surname);
            ps.setString(2, client.name);
            ps.setString(3, client.patronymic);
            ps.setString(4, client.passport);
            ps.setDouble(5, client.discount);

            ps.executeUpdate();
            // ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch
    } // addClientPs

    // читать запись о клиенте по id - Read C(R)UD
    public Client getClientPs(int id) {
        Client client = new Client();
        String sql = """
                select 
                    * 
                from 
                    Clients 
                where
                    id = ?
            """;

        // выполнение запроса - получение данных из таблицы
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // если запись есть в выборке - прочитать эту запись
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

        // вернуть прочитанные данные или пустой объект класса Client
        return client;
    } // getClientPs

    // изменить запись о клиенте - Update CR(U)D
    public int updateClientPs(Client client) {
        // количество измененных элементов
        int counterUpdated = 0;

        // запрос на изменение записи в таблице
        String sql = """
                update 
                    Clients  
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
            ps.setString(1, client.surname);
            ps.setString(2, client.name);
            ps.setString(3, client.patronymic);
            ps.setString(4, client.passport);
            ps.setDouble(5, client.discount);
            ps.setInt(6, client.id);

            // собственно выполнить запрос
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
                Clients  
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