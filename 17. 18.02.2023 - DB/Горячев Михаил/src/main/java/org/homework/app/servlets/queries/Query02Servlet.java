package org.homework.app.servlets.queries;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.middleware.PolyclinicDb;
import org.homework.app.utils.Utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/queries/query02")
public class Query02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("data", PolyclinicDb.getInstance().appointments());
            req.setAttribute("title", "Запрос 2");

            getServletContext()
                    .getRequestDispatcher("/polyclinic/queries/proc02.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {

            var format = new SimpleDateFormat("yyyy-MM-dd");

            var fromDate = format.parse(req.getParameter("fromDate"));
            var toDate = format.parse(req.getParameter("toDate"));
            req.setAttribute("fromDate", fromDate);
            req.setAttribute("toDate", toDate);

            req.setAttribute("data", PolyclinicDb.getInstance().query02(fromDate, toDate));
            req.setAttribute("title", "Запрос 2. Период с: " + Utils.getFormatDate(fromDate) + 
                                      " до " + Utils.getFormatDate(toDate));

            getServletContext()
                    .getRequestDispatcher("/polyclinic/queries/proc02.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
