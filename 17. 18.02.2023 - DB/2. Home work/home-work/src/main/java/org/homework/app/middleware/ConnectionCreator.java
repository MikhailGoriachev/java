package org.homework.app.middleware;

import org.homework.app.utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;


// Класс Соединение с базой данных
public class ConnectionCreator {
    public static final String PROPERTIES_FILE = "config/database.properties";


    // статический блок инициализации класса
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConnectionCreator() {
    }

    // фабрика, создающая соединение
    public static Connection createConnection() throws Exception {
        var props = Utils.getProperties(PROPERTIES_FILE, "urlPolyclinic", "login", "password");
        return DriverManager.getConnection(props.get("urlPolyclinic"), props.get("login"), props.get("password"));
    }
}
