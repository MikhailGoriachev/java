package org.itstep.pd011.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

// пример чтения куки, полученных в request от клиента
@WebServlet(name = "getCookieServlet", value = "/get-cookie-servlet")
public class GetCookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();
        String cookieName = "group";
        Cookie cookie = null;

        // если куки получены, пытаемся найти в ни куки с именем group
        if(cookies !=null) {
            cookie = Arrays.stream(cookies).filter(c -> c.getName().equals(cookieName)).findFirst().get();
        } // if

        var context = """
            <!DOCTYPE html><html>
            <head>
                <meta charset='UTF-8'/>
                <link href='resources/style.css' rel='stylesheet'/>
            </head>
            <body>
                <h2>Куки '%s' получен, значение куки '%s'</h2>       
                <p><a href='index.jsp'>На главную</a></p>
            </body>
            </html>
         """;

        try (PrintWriter writer = response.getWriter()) {
            // выводим результат - имя и значение найденного куки
            if (cookie != null) {
                writer.printf(context, cookie.getName(), cookie.getValue());
            } else {
                writer.printf(context, "куки не найден", "--''--");
            } // if
        } // try
    } // doGet
}
