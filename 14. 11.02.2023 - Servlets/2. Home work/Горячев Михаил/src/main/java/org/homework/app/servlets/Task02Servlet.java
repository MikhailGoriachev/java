package org.homework.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.models.Cylinder;
import org.homework.app.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

// На странице JSP в форме вводить размеры цилиндра, его материал (медь, сталь, базальт, лед). Учтите, что расширения 
// номенклатуры материалов не будет. Выбирать чек-боксами вид расчета: площадь поверхности, объем, масса. В сервлете, 
// обрабатывающем форму, вычислять запрошенные параметры, выводить исходные данные и результаты расчета в HTML-странице

@WebServlet("/task02")
public class Task02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/cylinderForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        var material = req.getParameter("material");
        
        var cylinder = new Cylinder(
                Double.parseDouble(req.getParameter("height")),
                Double.parseDouble(req.getParameter("radius")),
                Utils.getDensity(material)
        );

        var calculateParams = req.getParameterValues("calculate_params");


        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("</head>");
            writer.println("<body>");

            writer.printf("<p>Высота: %.4f</p>\n", cylinder.height);
            writer.printf("<p>Радиус: %.4f</p>\n", cylinder.radius);
            writer.printf("<p>Материал: %s</p>\n", material);
            writer.printf("<p>Плотность: %.4f</p>\n", cylinder.density);

            if (Arrays.asList(calculateParams).contains("area"))
                writer.printf("<p>Площадь: %.4f</p>\n", cylinder.area());

            if (Arrays.asList(calculateParams).contains("volume"))
                writer.printf("<p>Объём: %.4f</p>\n", cylinder.volume());

            if (Arrays.asList(calculateParams).contains("mass"))
                writer.printf("<p>Масса: %.4f</p>\n", cylinder.mass());
            
            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    }
}
