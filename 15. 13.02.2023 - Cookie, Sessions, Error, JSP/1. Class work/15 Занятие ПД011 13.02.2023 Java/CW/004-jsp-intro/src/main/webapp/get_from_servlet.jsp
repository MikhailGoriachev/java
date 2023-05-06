<%--
  Получение данных из сервлета - один и тот же способ получения,
  независимо от метода передачи данных сервлетом - в контексте запроса,
  в контексте приложения или в контексте сессии
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

    <div><a href="send_to_jsp.html">На способы передачи данных в JSP из сервлета</a></div>
    <hr>

    <h3>Получение данных из сервлета</h3>
    <%-- Использование EL - expression language ${имяАтрибутаКонтекста} --%>
    <p>Номер маршрута: <b><%= request.getAttribute("marka") %></b></p>
    <p>Номер маршрута: <b>${marka}</b></p>
    <p>Номер маршрута: <b>%{marka}</b></p>
    <p>Водитель: <b><%= request.getAttribute("driver") %></b></p>
    <p>Длина маршрута, км: <b><%= request.getAttribute("length") %></b></p>
    <p>Время в пути, минут: <b><%= request.getAttribute("duration") %></b></p>
</body>
</html>
