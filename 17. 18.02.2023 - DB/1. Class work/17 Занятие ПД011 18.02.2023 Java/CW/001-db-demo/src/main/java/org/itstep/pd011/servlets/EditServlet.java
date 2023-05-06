package org.itstep.pd011.servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import  org.itstep.pd011.mysql.business.ProductDB;
import  org.itstep.pd011.mysql.business.Product;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    // отдать форму
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = ProductDB.getById(id);

            if(product!=null) {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    } // doGet


    // обработать форму
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            ProductDB.update( new Product(id, name, price));

            // переход на сервлет - для чтения измененной табоицы из базы данных
            // !!! такой тип редиректа - и для GET-запроса и для POST-запроса !!!
            response.sendRedirect(request.getContextPath() + "/index-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}