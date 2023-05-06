<%-- Использование Java-классов в Java-странице --%>
<%-- импорт используемого класса/классов --%>
<%@ page import="org.itstep.pd011.models.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>JSP - Java Server Pages</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

    <nav>
        <a href="index.jsp">на главную</a>
    </nav>

    <h3>Использование Java классов в JSP</h3>
    <h4>Взаимодействие классов Java и JSP</h4>
    <h3>Создание объекта класса Student</h3>
    <%
        Student student = new Student(
            "Селиванова",
            "Ирина",
            "Олеговна",
            2002,
            "Ясиноватая",
            "ВПУ911"
        );
    %>

    <%-- Использование объекта класса Student --%>
    <h3>Данные о студенте</h3>
    <%= student.toHtmlList() %>
</body>
</html>
