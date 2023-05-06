package org.homework.app.servlets.tables;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.middleware.PolyclinicDb;

@WebServlet("/tables/people")
public class PeopleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().people());
            req.setAttribute("title", "Персоны");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/tables/people.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
