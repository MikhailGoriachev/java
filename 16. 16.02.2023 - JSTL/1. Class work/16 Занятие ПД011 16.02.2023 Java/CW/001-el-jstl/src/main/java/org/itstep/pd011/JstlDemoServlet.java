package org.itstep.pd011;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.itstep.pd011.models.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// сервлет формирует данные для демонстрации тегов  JSTL
@WebServlet(name = "JstlDemoServlet", value = "/jstl-demo-servlet")
public class JstlDemoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // создать коллекцию и отдать в параметры для JSP
        String[] users = new String[]{"Tom", "Bob", "Ваня", "Ольга", "Алена"};
        request.setAttribute("users", users);

        // передача коллеуии объектов для демонстрации JavaBean
        Student[] students = new Student[]{
                new Student(),
                new Student("Иванова", "ирина", "Ивановна", 1998, "Донецк", "ПД011"),
                new Student("Иванов", "иван", "Иванович", 1993, "Донецк", "ПД011"),
                new Student("Петрова", "ОЛьга", "Ивановна", 1997, "Донецк", "ПД011")
        };
        request.setAttribute("students", students);

        // еще один параметр для демонстрации тега if
        request.setAttribute("visible", false);

        // еще один параметр для демонстрации тега choose
        int val = 2;  // 1 или 2 для демонстрации c:when, 22 для демонстрации c:otherwise
        request.setAttribute("val", val);

        // переход на страницу отображения
        getServletContext()
            .getRequestDispatcher("/jstl_demo.jsp")
            .forward(request, response);
    } // doGet
} // class JstlDemoServlet
