package org.itstep.pd011.servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.itstep.pd011.mysql.business.ProductDB;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    // удаление по id
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDB.delete(id);

            // переход на сервлет - для чтения измененной таблицы из базы данных
            // !!! такой тип редиректа - для GET-запроса !!!
            // getServletContext().getRequestDispatcher("/index-servlet").forward(request, response);

            // !!! такой тип редиректа - и для GET-запроса и для POST-запроса !!!
            response.sendRedirect(request.getContextPath() + "/index-servlet");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
