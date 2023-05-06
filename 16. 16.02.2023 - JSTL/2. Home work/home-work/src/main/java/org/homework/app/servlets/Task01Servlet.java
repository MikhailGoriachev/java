package org.homework.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

// По get-запросу в странице HTML сервлет передает дату и время на сервере в JSP-страницу. Записывать дату и время в 
// куки с временем жизни 20 с. При наличии куки на клиенте выводить сообщение с текстом «Еще рано, подождите, ничего 
// не изменилось»

@WebServlet(name = "task01", value = "/task01")
public class Task01Servlet extends HttpServlet {

    // по get-запросу в странице HTML сервлет возвращает дату и время на сервере
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        var nameCookie = "date_time";
        var cookies = req.getCookies();

        var result = cookies != null
                ? Arrays.stream(cookies).filter(c -> c.getName().equals(nameCookie)).findFirst()
                : null;

        var isCookie = !result.isEmpty();
        
        Cookie cookie;

        if (!isCookie) {
            var maxAge = 20;

            cookie = new Cookie(nameCookie, URLEncoder.encode(
                    new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()),
                    StandardCharsets.UTF_8
            ));
            cookie.setMaxAge(20);

            resp.addCookie(cookie);
        }
        else cookie = result.get();

        req.setAttribute("isCookie", isCookie);
        req.setAttribute("cookieDateTime", URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8));

        getServletContext()
                .getRequestDispatcher("/pages/dateTimeServer.jsp")
                .forward(req, resp);
    }
}
