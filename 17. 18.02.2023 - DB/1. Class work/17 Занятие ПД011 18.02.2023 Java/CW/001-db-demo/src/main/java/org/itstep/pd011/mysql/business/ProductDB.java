package org.itstep.pd011.mysql.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Прежде всего класс определяет общие настройки подключения. Переменная url
// задает адрес для подключения к бд MySQL, username представляет логин,
// а password - пароль от сервера MySQL.
//
// Класс определяет все основные операции с базой данных. Метод select()
// получает все данные из таблицы products и создает из них список объектов
// Product.
//
// Метод selectOne() получает один элемент из таблицы по id. Если объект в бд
// не найден, то возвращается null.
//
// Метод insert() добавляет в таблицу один объект Product и возвращает
// количество добавленных строк.

// Метод update() обновляет в таблице один объект Product и возвращает
// количество обновленных строк.

// Метод delete() удаляет один объект Product и возвращает количество удаленных
// строк.
//
// Логика всех методов однотипна: открывается соединение с бд и с помощью
// объектов PreparedStatement или Statement выполняется запрос к базе данных.
public class ProductDB {
    private static String url = "jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "___sP123456890...";


    // получить все записи таблицы
    public static List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    Product product = new Product(id, name, price);

                    products.add(product);
                } // while
            } // try-with-resources
        }   catch(Exception ex){
            System.out.println(ex);
        } // try-catch
        return products;
    } // getAll


    // получение единственной записи из таблицы
    public static Product getById(int id) {

        Product product = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM products WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if(resultSet.next()){
                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int price = resultSet.getInt(3);
                        product = new Product(prodId, name, price);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }


    // добавление одной записи в таблицу БД
    public static int insert(Product product) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO products (name, price) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setInt(2, product.getPrice());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    // изменение одной записи в таблице
    public static int update(Product product) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setInt(2, product.getPrice());
                    preparedStatement.setInt(3, product.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }


    // удаление одной записи в таблице базы данных
    public static int delete(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM products WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                } // try-with-resources
            } // gtry-with-resources
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
