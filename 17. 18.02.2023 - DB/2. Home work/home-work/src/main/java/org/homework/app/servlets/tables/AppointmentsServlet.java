package org.homework.app.servlets.tables;

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
public class AppointmentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("data", );
        
        getServletContext()
                .getRequestDispatcher("/pages/cylinderForm.jsp")
                .forward(req, resp);
    }
}
