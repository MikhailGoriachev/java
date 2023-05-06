<%--
  Использование Java Bean
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL, JSTL</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
    <nav>
        <a href="index.jsp">На главную</a>
    </nav>

    <br>
    <hr>
    <br>

    <h3>Использование Java Bean - бин получен из сервлета</h3>
    <h4>Обращения к "свойствам" бина</h4>
    <ul>
        <!-- в сервлете отдавали объект student, это Java Bean,
          он доступен по свойствам в JSP (благодаря JSTL)
          -->
        <li>${student.surname}</li>
        <li>${student.patronymic}</li>
        <li>${student.birthYear}</li>
        <li>${student.city}</li>
        <li>${student.group}</li>
    </ul>
    <hr>
    <%-- использование метода бина  --%>
    <h4>Обращение к методу бина</h4>
    ${student.toHtmlList()}
</body>
</html>
