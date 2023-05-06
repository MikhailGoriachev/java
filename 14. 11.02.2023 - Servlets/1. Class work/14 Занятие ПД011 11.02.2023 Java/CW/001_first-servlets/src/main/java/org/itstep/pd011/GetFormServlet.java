package org.itstep.pd011;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// get_many_data?id=1001&name=Василина Павлова&age=33
@WebServlet(name = "formServlet", value = "/get-form")
public class GetFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // получить параметры ответа
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // получить данные из формы (т.е. из заголовка post-запроса
        String name = request.getParameter("username");
        String age = request.getParameter("userage");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");

        // массив значений
        String[] courses = request.getParameterValues("courses");

        // вывод ответа - полученных из формы данных
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println(" <link href=\"resources/style.css\" rel=\"stylesheet\"/>");
            writer.println("</head>");
            writer.println("<body>");

            writer.printf("<p>Name: %s</p>\n", name);
            writer.printf("<p>Age: %s</p>\n", age);
            writer.printf("<p>Gender: %s</p>\n", gender);
            writer.printf("<p>Country: %s</p>", country);
            writer.printf("<h4>Courses:</h4>");

            // вывод массива значений чекбокса
            for(String course: courses)
                writer.printf("<li>%s</li>\n", course);

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    } // doPost
}

