<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - обработка ошибок</title>
    <meta charset="utf-8">
    <link href="resources/style.css" rel="stylesheet"/>
</head>
<body>
    <h1><%= "Привет, все. Дата: " + new Date().toLocaleString() %></h1>
    <br/>

    <a href="hello-servlet">Hello Servlet</a> |
    <a href="http-raise-error">Обработка ошибки HTTP</a> |
    <a href="java-error-servlet?num=0">Обработка ошибки Java - исключение в классе</a>

</body>
</html>