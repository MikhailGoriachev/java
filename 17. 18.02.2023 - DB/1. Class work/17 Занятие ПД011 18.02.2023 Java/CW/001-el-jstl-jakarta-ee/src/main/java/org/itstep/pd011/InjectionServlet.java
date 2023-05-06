package org.itstep.pd011;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

// Защита от внедрения клиентского кода
@WebServlet(name = "InjectionServlet", value = "/injection-servlet")
public class InjectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "<script>alert('Hello, этот код внедрен в сервлете')</script>");
        getServletContext()
            .getRequestDispatcher("/jstl_injection.jsp")
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
