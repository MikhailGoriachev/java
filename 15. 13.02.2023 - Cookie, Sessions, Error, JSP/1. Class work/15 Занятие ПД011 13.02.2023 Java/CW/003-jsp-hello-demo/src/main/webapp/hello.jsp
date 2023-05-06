<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Приложение JSP</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./resources/style.css">
</head>
<body>
    <h3>Привет, JSP</h3>

    <h4>Данные, полученные от сервлета</h4>
    <ul>
        <%-- Использование EL - expression language ${имяАтрибутаКонтекста} --%>
        <li>JSP-страница получила от сервлета строку: <b><%= request.getAttribute("message") %></b></li>
        <li>JSP-страница получила от сервлета число: <b><%= request.getAttribute("number") %></b></li>
        <li>JSP-страница получила от сервлета число: <b>${number}</b></li>
        <li>JSP-страница получила от сервлета число: <b>%{number}</b></li>
    </ul>
    <hr>
    <a href="./index.jsp">На главную</a>
</body>
</html>
