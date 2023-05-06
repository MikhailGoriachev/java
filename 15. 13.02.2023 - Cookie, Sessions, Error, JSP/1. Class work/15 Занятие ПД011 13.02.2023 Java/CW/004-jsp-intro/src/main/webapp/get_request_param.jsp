<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Java Server Pages</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
    <%-- Использование шаблонного файла --%>
    <jsp:include page="layouts/header.jsp" />

    <%-- получение параметров из свойства request страницы JSP  --%>
    <h3>Получение данных из строки запроса</h3>
    <p>Имя: <%= request.getParameter("name") %></p>
    <p>Возраст: <%= request.getParameter("age") %></p>
    <p>Оклад: <%= request.getParameter("salary") %></p>
    <p>Город: <%= request.getParameter("city") %></p>

    <%-- Использование шаблонного файла --%>
    <jsp:include page="layouts/footer.jsp" />
</body>
</html>
