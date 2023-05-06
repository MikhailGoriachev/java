package org.homework.app.servlets.tables;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.middleware.PolyclinicDb;

@WebServlet("/tables/doctors")
public class DoctorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().doctors());
            req.setAttribute("title", "Доктора");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/tables/doctors.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
