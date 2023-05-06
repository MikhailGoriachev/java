<%-- импорт классс для использования в JSP-странице --%>>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - куки и сессии</title>
	<link href="resources/style.css" rel="stylesheet"/>
</head>
<body>
<h1>Работа с куки и сессиями</h1>
<br>
<a href="set-cookie-servlet">Установить куки</a> |
<a href="get-cookie-servlet">Прочитать куки</a> |
<a href="session-servlet">Создание/удаление данных в сессии</a>
<hr>
<h4><%= new Date().toString() %></h4>
</body>
</html>