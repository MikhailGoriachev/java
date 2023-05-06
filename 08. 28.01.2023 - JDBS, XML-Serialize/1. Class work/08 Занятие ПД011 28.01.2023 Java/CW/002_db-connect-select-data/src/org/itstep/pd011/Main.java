package org.itstep.pd011;

import java.sql.*;

/*
 * Страница драйвера JDBC для SQLite
 * https://github.com/xerial/sqlite-jdbc
 *
 * jar файл драйвера JDBC для SQLite с этой страницы тут:
 * https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.36.0.3/
 *
 * Microsoft о JDBC
 * https://docs.microsoft.com/ru-ru/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
 *
 * *  Демонстрация работы с базами данных через  JDBC
 * 1. Скачать драйвер JDBC https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.36.0.3/
 *    это будет jar-файл
 * 2. В пункте File -> Project Structure -: Libraries добавьте ссылку на jar-файл
 *    скачанного драйвера
 *    Project Settings -> Libraries -> + -> Java добавить .jar-файл
 *
 * */
public class Main {
    public static void main(String[] args) {
        showClients();
    } // main

    // Константа, в которой хранится адрес подключения
    //                                     jdbc:драйвер:имяФайлаБазыДанных
    private static final String CON_STR = "jdbc:sqlite:app_data/insurance.db";

    // пример операции выборки данных из таблицы
    public static void showClients() {
        // Выполняем подключение к базе данных, создаем оператор для выборки данных
        try (Connection connection = DriverManager.getConnection(CON_STR);
             Statement statement = connection.createStatement()) {

            System.out.print(
                "\t+-----+--------------+--------------+--------------+----------+----------+\n"+
                "\t| id  | Surname      | Name         | Patronymic   | Passport | Discount +\n"+
                "\t+-----+--------------+--------------+--------------+----------+----------+\n"
            );

            // выполнить выборку данных
            ResultSet resultSet = statement.executeQuery("select * from clients");

            // Проходим по выборке и выводим данные в консоль
            while (resultSet.next()) {
                System.out.printf("\t| %3d | %-12s | %-12s | %-12s | %-8s | %8.2f |\n",
                    resultSet.getInt(1),    resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getDouble(6)
                );
            } // while
            System.out.println(
                "\t+-----+--------------+--------------+--------------+----------+----------+\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } // try-catch
    } // showClients
}