package org.homework.app.servlets.queries;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.middleware.PolyclinicDb;

@WebServlet("/queries/query03")
public class Query03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().query03());
            req.setAttribute("title", "Запрос 3");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/queries/proc03.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
