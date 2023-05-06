package org.itstep.pd011;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// получение данных из запроса - один параметр
@WebServlet("/get-data")
public class GetDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // получаем параметр id
        String id = request.getParameter("id");

        // получить параметры ответа
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("<link href=\"resources/style.css\" rel=\"stylesheet\"/>");
            writer.println("</head>");
            writer.println("<body>");

            // выводим полученный параметр id
            writer.printf("<h2>Id: %s</h2>\n", id);

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    } // doGet
} // class GetDataServlet
