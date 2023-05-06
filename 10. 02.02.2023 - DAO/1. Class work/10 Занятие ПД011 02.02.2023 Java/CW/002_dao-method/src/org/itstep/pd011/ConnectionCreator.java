package org.itstep.pd011;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// создание подключения к базе данных
public class ConnectionCreator {
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;

    // статический блок инициализации класса
    static {
        try {
            properties.load(new FileReader("assets/database.properties"));
            String driverName = (String) properties.get("db.driver");

            // регистрация драйвера
            Class.forName(driverName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); // fatal exception
        }

        DATABASE_URL = (String) properties.get("db.url");
    }

    private ConnectionCreator() {}

    // фабрика, создающая соединение
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }
}
