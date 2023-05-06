package org.itstep.pd011.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "requestContextServlet", value = "/request-context-servlet")
public class RequestContextServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // сформировать данные в контексте запроса для передачи в JSP-страницу
        request.setAttribute("marka", "42б");
        request.setAttribute("driver", "Семенова П.Р.");
        request.setAttribute("length", 23.5);
        request.setAttribute("duration", 83);

        // !!! обратите внимание - не работают выражения EL для вывода переданных данных !!!

        // вызов JSP
        getServletContext()
            .getRequestDispatcher("/get_from_servlet.jsp")
            .forward(request, response);
    } // doGet
}