package org.homework.app.servlets.tables;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.middleware.PolyclinicDb;

@WebServlet("/tables/specialities")
public class SpecialitiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().specialities());
            req.setAttribute("title", "Специальности");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/tables/specialities.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
