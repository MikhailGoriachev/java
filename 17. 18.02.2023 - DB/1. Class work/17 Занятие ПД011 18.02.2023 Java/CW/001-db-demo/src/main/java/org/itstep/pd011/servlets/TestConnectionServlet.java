package org.itstep.pd011.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

// проверка подключения к базе данных
// БД productdb
@WebServlet(name = "TestConnectionServlet", value = "/test-connection")
public class TestConnectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            try{
                String url = "jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "___sP123456890...";

                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    writer.println("<h1>Подключение ProductDB выполнено!</h1>");
                }
            }
            catch(Exception ex){
                writer.println("<h1>Connection failed.../Сбой подключения..<h1>");
                writer.println(ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
