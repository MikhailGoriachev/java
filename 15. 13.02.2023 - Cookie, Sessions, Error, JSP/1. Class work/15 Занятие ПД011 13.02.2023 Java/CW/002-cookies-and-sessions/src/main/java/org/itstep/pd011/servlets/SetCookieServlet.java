package org.itstep.pd011.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// пример установки (записи) куки в response, отправляемый клиенту
@WebServlet(name = "setCookieServlet", value = "/set-cookie-servlet")
public class SetCookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // установить значение куки group
        String key = "group";
        String value = "ПД011";

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(100);     // время жизни в секундах, -1: живет до закрытия браузера
        response.addCookie(cookie);

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("<link href='resources/style.css' rel='stylesheet'/>");
            writer.println("</head>");
            writer.println("<body>");

            // выводим результат
            writer.printf("<h2>Куки '%s' установлен в '%s'</h2>\n", key, value);

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    }

}