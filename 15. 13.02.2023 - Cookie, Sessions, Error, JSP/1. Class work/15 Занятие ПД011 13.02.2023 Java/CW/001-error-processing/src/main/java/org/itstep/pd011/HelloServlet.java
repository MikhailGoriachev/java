package org.itstep.pd011;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// остановлен для индикации нормальной работы сервера
@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Просто тестовое сообщение";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'/>");
        out.println("<link href=\"resources/style.css\" rel=\"stylesheet\"/>");
        out.println("</head>");
        out.println("<body>");

        out.printf("<h1>%s</h1>", message);
        out.println("<p><a href='index.jsp'>На главную</a></p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}