package org.itstep.pd011.servlets;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.itstep.pd011.mysql.business.Product;
import org.itstep.pd011.mysql.business.ProductDB;

// указать в конфигурации запуска, в URL value сервлета для его запуска
// вместе с приложением
// http://localhost:8010/db_demo_war/index-servlet
@WebServlet("/index-servlet")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // получмть все записи из таблицы БД products, передать их на страницу JSP
        List<Product> products = ProductDB.getAll();
        request.setAttribute("products", products);
        request.setAttribute("test", "test");


        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
