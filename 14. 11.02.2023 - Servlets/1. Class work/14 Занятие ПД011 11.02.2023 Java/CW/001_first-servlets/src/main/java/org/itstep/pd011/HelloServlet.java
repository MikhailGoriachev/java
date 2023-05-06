package org.itstep.pd011;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// Имя приложения /first_servlets_war_exploded

// name - имя сервлета для регистрации в Tomcat
// value - маршрут, по которому сервлет будет доступен
// http://localhost:8010/hello-servlet
@WebServlet(name = "helloServlet", value="/hello-servlet")
public class HelloServlet extends HttpServlet {
    // модель данных сервлета
    private String message;

    // рекомендуется для инициализации данных сервлет
    @Override
    public void init() {
        message = "Hello, мир!";
    } // init

    // реакция на get-запрос
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Hello
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'/>");
            out.println(" <link href=\"resources/style.css\" rel=\"stylesheet\"/>");
            out.println("<body>");
            out.println("<h1>Сформировано сервлетом HelloServlet</h1>");
            out.printf("<h3>сообщение от сервлета: %s</h3>", message);
            out.println("<h3>Сейчас: " + new Date() + "</h3>");

            // прямой переход
            // out.println("<h4><a href='index.jsp'>На главную</a></h4>");

            // редирект
            out.println("<h4><a href='forward-index'>На главную, через редирект</a></h4>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // освобождение ресуросв сервлетом
    @Override
    public void destroy() {   }

} // class HelloServlet
