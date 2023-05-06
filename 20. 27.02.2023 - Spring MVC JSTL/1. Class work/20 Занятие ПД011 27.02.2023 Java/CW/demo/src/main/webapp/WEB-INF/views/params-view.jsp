<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>
    <%-- использование языка выражений Spring --%>
    <h2>Привет, сегодня: ${message}</h2>
    <h5><a href="http://localhost:8010/hello_spring_mvc_war/">На главную</a></h5>
</body>
</html>
