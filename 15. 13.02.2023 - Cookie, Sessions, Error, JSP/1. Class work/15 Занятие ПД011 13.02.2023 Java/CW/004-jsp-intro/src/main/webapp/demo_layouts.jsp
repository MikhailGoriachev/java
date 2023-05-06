<%-- использование вложенных страниц - страниц компоновки --%>

<%@ page import="org.itstep.pd011.models.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>JSP - Java Server Pages</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
    <%-- использование html-файла, как шаблона, включаемого файла  --%>
    <jsp:include page="layouts/header.jsp" />

    <p>Main Content 1</p>
    <%-- Применение объекта класса Java и его методов --%>
    <%
        Student student = new Student(
                "Ярчевская",
                "Евгения",
                "Арсеньевна",
                1992,
                "Донецк",
                "1C 21-01"
        );
    %>
    <%= student.toHtmlList() %>
    <p>Main Content 3</p>

    <%-- Использование JSP-файла в качестве шаблонного, включаемого файла  --%>
    <jsp:include page="layouts/footer.jsp" />
</body>
</html>
