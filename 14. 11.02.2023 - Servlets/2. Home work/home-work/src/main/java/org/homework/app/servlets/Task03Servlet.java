package org.homework.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.models.Cylinder;
import org.homework.app.models.Tablet;
import org.homework.app.models.TabletList;
import org.homework.app.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

// По get-запросу к сервлету выводить коллекцию сведений о гаджетах (тип, производитель, год выпуска, операционная 
// система, цена). По клику на ссылку переходить на страницу JSP с формой ввода данные о гаджете. В сервлете по 
// post-запросу от формы добавить данные о гаджете в коллекцию, отправлять клиенту страницу, с выводом коллекции.
@WebServlet("/task03")
public class Task03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<p>Устройства:</p>");
            
            writer.println("<ul>");
            
            var sb = new StringBuilder();
            TabletList.tablets.forEach(t -> sb.append("<li>").append(t).append("</li>"));
            
            writer.println(sb);
            
            writer.println("</ul>");
            
            writer.println("<p><a href='task03-form'>Добавить запись</a></p>");
            
            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
