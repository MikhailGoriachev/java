package org.homework.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.homework.app.utils.Utils;

import java.io.IOException;
import java.util.Arrays;

// На странице JSP в форме вводить размеры цилиндра, его материал (медь, сталь, базальт, лед). Учтите, что расширения 
// номенклатуры материалов не будет. Выбирать чек-боксами вид расчета: площадь поверхности, объем, масса. В сервлете, 
// обрабатывающем форму, вычислять запрошенные параметры, выводить исходные данные и результаты расчета в HTML-странице

@WebServlet("/task02")
public class Task02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/pages/cylinderForm.jsp")
                .forward(req, resp);
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

        req.setAttribute("height", cylinder.height);
        req.setAttribute("radius", cylinder.radius);
        req.setAttribute("density", cylinder.density);
        req.setAttribute("material", material);

        if (calculateParams != null) {

            if (Arrays.asList(calculateParams).contains("area"))
                req.setAttribute("area", cylinder.area());

            if (Arrays.asList(calculateParams).contains("volume"))
                req.setAttribute("volume", cylinder.volume());

            if (Arrays.asList(calculateParams).contains("mass"))
                req.setAttribute("mass", cylinder.mass());
        }
        
        getServletContext()
                .getRequestDispatcher("/pages/cylinderInfo.jsp")
                .forward(req, resp);
    }
}
