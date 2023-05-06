package org.homework.app.middleware;

import org.homework.app.utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;


// Класс Соединение с базой данных
public class ConnectionCreator {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/polyclinic_goriachev?serverTimezone=Europe/Moscow&useSSL=true";

    private static final String LOGIN = "root";
    
    private static final String PASSWORD = "aA123456";
//    private static final String PASSWORD = "___sP123456890...";
    
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
        return DriverManager.getConnection(CONNECTION_STRING, LOGIN, PASSWORD);
    }
}
