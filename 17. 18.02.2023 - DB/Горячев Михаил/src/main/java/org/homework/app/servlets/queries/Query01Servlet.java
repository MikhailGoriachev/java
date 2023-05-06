package org.homework.app.servlets.queries;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.homework.app.middleware.PolyclinicDb;

@WebServlet("/queries/query01")
public class Query01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().patients());
            req.setAttribute("title", "Запрос 1");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/queries/proc01.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            var surname = req.getParameter("startSurname");
            req.setAttribute("startSurname", surname);

            req.setAttribute("data", PolyclinicDb.getInstance().query01(surname));
            req.setAttribute("title", "Запрос 1. Фамилия начинается с: \"" + surname + "\"");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/queries/proc01.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
