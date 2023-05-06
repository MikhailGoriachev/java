<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta charset="utf-8">
    <link href="resources/style.css" rel="stylesheet"/>
</head>
<body>
<%-- комментарий JSP --%>
<h1><%= "Hello World!" %>
</h1>
<br>
<a href="hello-servlet">Hello, сервлет</a>
<br>
<ul>
    <li><a href="get-data?id=1001">Получение данных сервлетом, один парамтер</a></li>
    <li><a href="get-many-data?id=1001&name=Василина Павлова&age=33">Получение данных сервлетом,
        несколько парамтеров</a></li>
    <li><a href="get-array?numbers=1&numbers=3&numbers=42&numbers=-66&numbers=108">Получение
        данных сервлетом, массив</a></li>
    <li><a href="forma.jsp">Форма ввода</a></li>
</ul>
</body>
</html>
