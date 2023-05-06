<%--
получение данных из сложной формы complex_form.html
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Java Server Pages</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
    <%-- Использование шаблонного файла --%>
    <jsp:include page="layouts/header.jsp" />

    <%--
        хотя метод post по прежнему используем request.getParam() для получения
        данных из формы
     --%>
    <%-- получение скалярных параметров --%>
    <p>Имя: <%= request.getParameter("username") %></p>
    <p>Стана: <%= request.getParameter("country") %></p>
    <p>Пол: <%= request.getParameter("gender") %></p>
    <h4>Выбранные курсы</h4>
    <ul>
        <%
            // получение массива-параметра
            String[] courses = request.getParameterValues("courses");

            // вывод элементов массива
            for(String course: courses){
                String str = String.format("<li>%s</li>", course);
                out.println(str);
            }
        %>
    </ul>

    <%-- Использование шаблонного файла --%>
    <jsp:include page="layouts/footer.jsp" />
</body>
</html>
