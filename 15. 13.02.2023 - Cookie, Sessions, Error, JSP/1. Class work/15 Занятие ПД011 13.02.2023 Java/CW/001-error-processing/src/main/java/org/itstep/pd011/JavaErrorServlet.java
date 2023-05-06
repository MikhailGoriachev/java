package org.itstep.pd011;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

// имитация ошибки Java
@WebServlet(name = "javaErrorServlet", value = "/java-error-servlet")
public class JavaErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // получить параметры ответа
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // получаем параметр num
        int num = Integer.parseInt(request.getParameter("num"));

        Random random = new Random();
        int v = random.nextInt(1000);
        int result = v / num;

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("</head>");
            writer.println("<body>");

            // выводим результат
            writer.printf("<h2>v: %d, num: %d, result: %d</h2>\n", v, num, result);

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        }
    } // doGet
}
