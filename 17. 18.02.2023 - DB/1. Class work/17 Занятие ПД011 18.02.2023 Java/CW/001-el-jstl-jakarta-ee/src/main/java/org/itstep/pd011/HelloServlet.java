package org.itstep.pd011;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// приложение создано по шаблону JakartaEE, это автосгенерированный код
// группа приложения - org.itstep.pd011
// имя приложения было удалено из имени пакета вручную
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}