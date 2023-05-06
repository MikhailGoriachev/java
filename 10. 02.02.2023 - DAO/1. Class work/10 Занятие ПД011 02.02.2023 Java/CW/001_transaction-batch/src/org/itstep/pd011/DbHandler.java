package org.itstep.pd011;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class DbHandler {

    // Адрес загрузки драйвера Connector/J для MySQL: https://dev.mysql.com/downloads/connector/j/ 
    // Константы, в которых хранятся параметры подключения
    private static final String URL       = "jdbc:mysql://localhost/insurance?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD  = "_sP1234568_";

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
        // Properties - представление, хранение свойств в формате "ключ" - "значение"
        // свойства могут читаться из файла
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("app_data/database.properties"))){
            props.load(in);
        }

        // получить свойства и выполнить подключение
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    } // loadConnection

    // пример операции выборки данных из таблицы - получить и вывести всех клиентов
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        // Выполняем подключение к базе данных, создаем оператор для выборки данных
        try (Statement statement = this.connection.createStatement()) {

            // выполнить выборку данных
            ResultSet resultSet = statement.executeQuery("select * from clients");

            // Проходим по выборке и выводим данные в консоль
            while (resultSet.next()) {
                clients.add(new Client(
                    resultSet.getInt("id"),
                    resultSet.getString("surname"),
                    resultSet.getString("name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("passport"),
                    resultSet.getFloat("discount")
                ));
            } // while
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch

        return clients;
    } // getAllClients


    // демонстрация транзакции
    public void demoTransaction() throws SQLException {
        try {
            // отключение автоматических транзакций - отмена автоматического выполнения
            // commit после каждого оператора
            this.connection.setAutoCommit(false);

            // начало транзакции
            Statement statement = connection.createStatement();
            int updateCounts1 = statement.executeUpdate("update clients set discount = discount + 0.1 where id > 5");
            int updateCounts2 = statement.executeUpdate("update clients set surname = 'Петров' where surname = 'Иванов'");
            ResultSet rs = statement.executeQuery("select * from clients where surname = 'Петров'");
            // закрыть транзакцию - завершить пакет
            connection.commit();

            System.out.printf("\tТранзакция завершена: %d, %d\n", updateCounts1, updateCounts2);
            // Проходим по выборке и выводим данные в консоль
            Client client = new Client();
            System.out.print(Client.HEADER);
            while (rs.next()) {
                client.id = rs.getInt("id");
                client.surname = rs.getString("surname");
                client.name = rs.getString("name");
                client.patronymic = rs.getString("patronymic");
                client.passport = rs.getString("passport");
                client.discount = rs.getFloat("discount");

                System.out.printf("\t%s\n", client.toTableRow());
            } // while
            System.out.println(Client.FOOTER);
        } catch (SQLException ex) {
            // !! откат транзакции при возникновении ошибок !!
            System.err.println("\t\tОшибки при выполнении транзакции");
            if(connection != null) {
                connection.rollback();
            } // if
        } finally {
            // вернуть автоматические транзакции
            if(connection != null) {
                connection.setAutoCommit(true);
            } // if
        } // try-finally
    } // demoTransaction


    // пакетное выполнение запросов - разновидность транзакции
    public void batchDemo() throws SQLException {
        try {
            // отключение автоматических транзакций - отмена автоматического выполнения
            // commit после каждого оператора
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            // запросы на добавление в таблицу clients, номера паспортов уникальные
            String insert1 = """
                INSERT INTO clients 
                    (surname, name, patronymic, passport, discount) 
                VALUES 
                    ('Иванов', 'Иван', 'Иванович', '15 56 456789', 0.5)
            """;

            String insert2 = """
                INSERT INTO clients 
                    (surname, name, patronymic, passport, discount) 
                VALUES 
                    ('Иванов', 'Иван', 'Иванович', '15 49 678900', 0.5)
            """;

            String insert3 = """
                INSERT INTO clients 
                    (surname, name, patronymic, passport, discount) 
                VALUES 
                    ('Иванов', 'Иван', 'Иванович', '16 78 698900', 0.5)
            """;

            // добавить запросы в пакет - запросы могут выполняться к различным таблицам
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);

            // выполнение пакета, возвращается количество измененных строк 
			// по каждому из запросов пакета
            int[] updateCounts = statement.executeBatch();
            // закрыть транзакцию - завершить пакет
            connection.commit();

            System.out.println("\n\tВставка завершена: " + Arrays.toString(updateCounts));
        } catch (SQLException ex) {
            // !! откат транзакции при возникновении ошибок !!
            System.err.println("\t\tОшибки при выполнении пакета");
            if(connection != null) {
                connection.rollback();
            } // if
        } finally {
            // вернуть автоматические транзакции
            if(connection != null) {
                connection.setAutoCommit(true);
            } // if
        } // try-finally
    } // batchDemo

} // class DbHelper