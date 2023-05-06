<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>
<h1>${message}</h1>
<h1><%= request.getAttribute("message") %></h1>
<h2>Hello, мир!</h2>

<ul>
    <li><a href="hello">Привет</a></li>
    <li><a href="params">Передать параметры в представление</a></li>
    <li><a href="bye">Пока</a></li>
</ul>
<div>
    <img src="<c:url value="/resources/images/image.png" />" />
</div>
</body>
</html>
