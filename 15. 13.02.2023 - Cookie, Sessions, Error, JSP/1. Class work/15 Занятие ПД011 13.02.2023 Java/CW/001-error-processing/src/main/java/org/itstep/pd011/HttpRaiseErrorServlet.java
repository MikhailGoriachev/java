package org.itstep.pd011;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

// генерация ошибки 404 HTTP-протокола при форвардинге
// страница реакции на ошибку определена в WEB-INF/web.xml
@WebServlet("/http-raise-error")
public class HttpRaiseErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // пример перехода на существующий сервлет, ошибка не генерируется
        // String path = "/hello-servlet";

        // пример перехода на существующую JSP-страницу, ошибка не генерируется
        // String path = "/index.jsp";

        // обращение к несуществующей странице
        String path = "/меня_нет_и_не_создавайте.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);

        requestDispatcher.forward(request, response);
    } // doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
