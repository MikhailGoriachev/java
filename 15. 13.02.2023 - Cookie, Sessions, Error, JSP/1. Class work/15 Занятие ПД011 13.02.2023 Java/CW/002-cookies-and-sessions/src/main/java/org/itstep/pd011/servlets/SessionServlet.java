package org.itstep.pd011.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.itstep.pd011.models.Student;
import java.io.IOException;
import java.io.PrintWriter;

// основные операции с сессией
@WebServlet(name = "sessionServlet", value = "/session-servlet")
public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // получить сессию, пытаемся прочитать данные из сессии
        HttpSession session = request.getSession();

        // читаем данные из сессии
        String keyCipher = (String) session.getAttribute("keyCipher");  // простые данные
        Student student = (Student) session.getAttribute("student");    // сложные данные

        String studentInfo;
        if(student == null) {
            student = new Student(
                    "Сидоров",
                    "Борис",
                    "Валентинович",
                    2002,
                    "Донецк",
                    "ПД011"
            );
            // запись в сессию
            session.setAttribute("keyCipher", "123321456654");
            session.setAttribute("student", student);
            studentInfo = String.format("<h3>Данные студента %s %s сохранены в сессии</h3>",
                    student.getSurname(), student.getName());
        } else {
            studentInfo = student.toHtmlList();
            // удаление данных из сессии
            session.removeAttribute("student"); // удалять необязательно
        } // if

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("<link href='resources/style.css' rel='stylesheet'/>");
            writer.println("</head>");
            writer.println("<body>");

            // выводим результат
            writer.printf("<h3>Ключ шифрования: %s</h3>\n", keyCipher);
            writer.println(studentInfo);

            writer.println("<p><a href='index.jsp'>На главную</a></p>");
            writer.println("</body>");
            writer.println("</html>");
        } // try
    } // doGet

}
