package org.itstep.pd011.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// передача данных в JSP через контекст приложения
@WebServlet(name = "applicationContextServlet", value = "/application-context-servlet")
public class ApplicationContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("marka", "21");
        servletContext.setAttribute("driver", "Васильев А.В.");
        servletContext.setAttribute("length", 11.5);
        servletContext.setAttribute("duration", 33);

        // !!! обратите внимание - не работают выражения EL для вывода переданных данных !!!

        getServletContext()
            .getRequestDispatcher("/get_from_servlet.jsp")
            .forward(request, response);
    }
} // class ApplicationContextServlet
