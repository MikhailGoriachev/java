package org.itstep.pd011.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "sessionContextServlet", value = "/session-context-servlet")
public class SessionContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // получить контекст сессии и записать значения в атрибуты для передачи в JSP-страницу
        HttpSession session = request.getSession();
        session.setAttribute("marka", "16");
        session.setAttribute("driver", "Деточкин В.Ю.");
        session.setAttribute("length", 19.2);
        session.setAttribute("duration", 26);

        // !!! обратите внимание - не работают выражения EL для вывода переданных данных !!!

        getServletContext()
            .getRequestDispatcher("/get_from_servlet.jsp")
            .forward(request, response);
    } // doGet
} // class SessionContextServlet
