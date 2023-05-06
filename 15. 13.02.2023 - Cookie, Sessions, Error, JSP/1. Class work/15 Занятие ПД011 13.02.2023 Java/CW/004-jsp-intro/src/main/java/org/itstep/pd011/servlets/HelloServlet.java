package org.itstep.pd011.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// просто сервлет, для индикации работы web-приложения
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // вызов JSP-страницы
        getServletContext()
                .getRequestDispatcher("/java_classes_in_jsp.jsp")
                .forward(request, response);
    }

    public void destroy() {
    }
}