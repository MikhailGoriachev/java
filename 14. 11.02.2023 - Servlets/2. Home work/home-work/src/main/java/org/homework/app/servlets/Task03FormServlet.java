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
import java.util.Arrays;

@WebServlet("/task03-form")
public class Task03FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/tabletForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var tablet = new Tablet(
                req.getParameter("type"),
                req.getParameter("manufacture"),
                Integer.parseInt(req.getParameter("year")),
                req.getParameter("system"),
                Integer.parseInt(req.getParameter("price"))
        );
        
        TabletList.tablets.add(tablet);

//        getServletContext().getRequestDispatcher("/task03").forward(req, resp);

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
