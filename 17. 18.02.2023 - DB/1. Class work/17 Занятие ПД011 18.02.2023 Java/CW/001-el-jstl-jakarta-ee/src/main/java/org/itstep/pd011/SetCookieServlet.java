package org.itstep.pd011;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// Использование EL (Expression Language)
// установка куки, который затем будет прочитан при помощи встроенного объекта EL
// на JSP-странице (index.jsp)
@WebServlet(name = "setCookieServlet", value = "/set-cookie-servlet")
public class SetCookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // установить значение куки nowDate
        // форматирование даты https://dzone.com/articles/java-string-format-examples
        String key = "nowDate";
        String value =  String.format(Locale.UK, "%1$td-%1$tm-%1$tY", new Date());
        response.addCookie(new Cookie(key, value));

        // возврат на главную страницу
        getServletContext()
            .getRequestDispatcher("/index.jsp")
            .forward(request, response);
    } // doGet

} // class SetCookieServlet