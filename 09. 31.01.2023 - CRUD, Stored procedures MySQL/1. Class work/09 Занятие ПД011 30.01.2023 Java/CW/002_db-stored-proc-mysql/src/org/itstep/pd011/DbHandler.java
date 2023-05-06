package org.itstep.pd011;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class DbHandler {

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
        this.connection = loadConnection();
    } // DbHandler

    // чтение параметров подклчения из конфигурационного файла
    private static Connection loadConnection() throws Exception {
        // Properties - представление, хранение свойств в формате "ключ" - "значение"
        // свойства могут читаться из файла
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("app_data/database.properties"))){
            props.load(in);
        }

        // сохранение свойств
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    } // loadConnection

    // пример операции выборки данных из таблицы - получить и вывести всех клиентов
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        // Выполняем подключение к базе данных, создаем оператор для выборки данных
        try (Statement statement = connection.createStatement()) {

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


    // демо вызов хранимой процедуры с выходным параметром
    public int demoOutParams() {
        int clientsTotal = -1;

        // вызов хранимой процедуры
        String sql = "{call clientsCounter (?)}";
        try (CallableStatement callableStatement = connection.prepareCall(sql)) {

            // регистрация выходного параметра
            callableStatement.registerOutParameter(1, Types.INTEGER);

            // выполнить процедуру
            callableStatement.execute();

            // прочитали значение выходного параметра
            clientsTotal = callableStatement.getInt(1);

        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch

        return clientsTotal;
    } // demoOutParams

    // демо вызов хранимой процедуры с входным параметром
    public Client demoInParams(int id) {
        Client client = new Client();

        // вызов хранимой процедуры
        String sql = "{call getClient(?)}";
        try (CallableStatement callableStatement = connection.prepareCall(sql)) {

            // задать входного параметра
            callableStatement.setInt(1, id);

            // выполнить процедуру
            callableStatement.execute();

            // прочитали значение выходного параметра
            ResultSet rs = callableStatement.getResultSet();

            // если запись есть в выборке - прочитать эту запись
            if (rs.next()) {
                client.id = rs.getInt("id");
                client.surname = rs.getString("surname");
                client.name = rs.getString("name");
                client.patronymic = rs.getString("patronymic");
                client.passport = rs.getString("passport");
                client.discount = rs.getDouble("discount");
            } // if
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try-catch

        return client;
    } // demoInParams

} // class DbHelper