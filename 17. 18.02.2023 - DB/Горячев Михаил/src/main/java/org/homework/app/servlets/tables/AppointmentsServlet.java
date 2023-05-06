package org.homework.app.servlets.tables;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.homework.app.middleware.PolyclinicDb;

@WebServlet("/tables/appointments")
public class AppointmentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().appointments());
            req.setAttribute("title", "Приёмы");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/tables/appointments.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
