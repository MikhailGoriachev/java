package org.itstep.pd011.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.itstep.pd011.models.Student;

import java.io.IOException;

@WebServlet(name = "сomplexObjectServlet", value = "/сomplex-object-servlet")
public class ComplexObjectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // сложный объект - массив объектов, м.б. ArrayList<>
        Student[] students = new Student[] {
                new Student("Иванов", "Иван", "Иванович", 1998, "Алчевск", "СП-1221"),
                new Student("Федорова", "Феодора", "Федоровна", 1999, "Макеевка", "СП-1233"),
                new Student("Иванский", "Николай", "Иванович", 1996, "Минеральное", "СП-1242")
        };
        request.setAttribute("students", students);
        request
            .getServletContext()
            .getRequestDispatcher("/complex_el.jsp")
            .forward(request, response);
    }
} // class ComplexObjectServlet
