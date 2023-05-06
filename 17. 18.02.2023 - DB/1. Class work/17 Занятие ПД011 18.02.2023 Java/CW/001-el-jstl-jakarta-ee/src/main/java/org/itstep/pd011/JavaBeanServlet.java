package org.itstep.pd011;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.itstep.pd011.models.Student;

// использование JavaBean: сервлет отдает JavaBean в JSP, в JSP
// свойства бина доступны по упрощенным именам, без явного вызова
// геттеров
@WebServlet(name = "javaBeanServlet", value = "/java-bean-servlet")
public class JavaBeanServlet extends HttpServlet {
    private Student student;

    public void init() {
        student = new Student();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // подготовка данных и передача их в JSP
        request.setAttribute("student", student);

        // вызов JSP
        getServletContext()
            .getRequestDispatcher("/using_jbean.jsp")
            .forward(request, response);
    } // doGet

    public void destroy() {
    }
}