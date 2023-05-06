package org.itstep.pd011;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// В ответ на GET-запрос сервлет возвращает JSP-страницу
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

	@Override
    public void init() {
        message = "Это строка для отображения в JSP-странице";
    }

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // сформировать данные в контексте запроса для передачи в JSP-страницу
        // (это один из способов передавать данные из сервлета в JSP)
        request.setAttribute("message", message);
        request.setAttribute("number", 42);

        // вывод JSP-страницы
        getServletContext()
            .getRequestDispatcher("/hello.jsp")
            .forward(request, response);
    } // doGet

} // class HelloServlet