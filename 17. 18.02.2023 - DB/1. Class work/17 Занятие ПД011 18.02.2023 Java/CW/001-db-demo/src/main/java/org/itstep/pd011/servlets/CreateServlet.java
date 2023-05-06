package org.itstep.pd011.servlets;

import java.util.ArrayList;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.itstep.pd011.mysql.business.Product;
import org.itstep.pd011.mysql.business.ProductDB;


@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    // отдать форму
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    // обработать форму
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            Product product = new Product(name, price);
            ProductDB.insert(product);

            // переход на сервлет - для чтения измененной табоицы из базы данных
            // !!! такой тип редиректа - и для GET-запроса и для POST-запроса !!!
            response.sendRedirect(request.getContextPath() + "/index-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}
