package org.homework.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.models.Tablet;
import org.homework.app.models.TabletList;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task03")
public class Task03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tablets", TabletList.getTablets());

        getServletContext()
                .getRequestDispatcher("/pages/tabletList.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var tablet = new Tablet(
                0,
                req.getParameter("type"),
                req.getParameter("manufacture"),
                Integer.parseInt(req.getParameter("year")),
                req.getParameter("system"),
                Integer.parseInt(req.getParameter("price"))
        );
        
        TabletList.addItem(tablet);
        
        req.setAttribute("tablets", TabletList.getTablets());
        
        getServletContext()
                .getRequestDispatcher("/pages/tabletList.jsp")
                .forward(req, resp);
    }
}
