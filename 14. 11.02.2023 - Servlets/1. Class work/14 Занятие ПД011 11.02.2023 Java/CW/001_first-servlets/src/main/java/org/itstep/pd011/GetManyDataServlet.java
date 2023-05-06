package org.itstep.pd011;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// получение нескольких параметров из строки запроса

// /get-many-data?id=1001&name=Василина Павлова&age=33
@WebServlet("/get-many-data")
public class GetManyDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // получаем параметры id, name, age
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        // получить параметры ответа
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println(" <link href=\"resources/style.css\" rel=\"stylesheet\"/>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h2>Id:" + id + "</h2>");
            writer.println("<h2>Name:" + name + "</h2>");
            writer.println("<h2>Age:" + age + "</h2>");

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    } // doGet
} // class GetManyDataServlet

