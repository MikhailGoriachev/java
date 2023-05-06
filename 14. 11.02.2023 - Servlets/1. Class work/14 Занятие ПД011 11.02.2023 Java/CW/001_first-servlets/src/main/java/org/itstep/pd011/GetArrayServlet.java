package org.itstep.pd011;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

// пример получения данных сервлетом - получение массива, на примере get-запроса

// http://localhost:8019/first-servlet/get-array?numbers=1&numbers=3&numbers=42&numbers=-66&numbers=108
@WebServlet("/get-array")
public class GetArrayServlet extends HttpServlet {

    // get-запрос
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // настройка ответа сервлета
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // получить данные из запроса
        String[] nums = request.getParameterValues("numbers");
        int[] numbers = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();

        // получить поток вывода для сервлета
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println(" <link href=\"resources/style.css\" rel=\"stylesheet\"/>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h3>Массив</h3>");
            writer.println("<ul>");
            for (int number : numbers) {
                writer.printf("<li>%d</li>", number);
            } // for
            writer.println("</ul>");

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    } // doGet
} // class GetArrayServlet


