<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

<!-- нет защиты от внедрения кода -->
<h3>нет защиты от внедрения кода</h3>
<p>${message}</p>

<!-- защита от внедрения кода-->
<h3>Защита от внедрения кода за счет JSTL</h3>
<p><c:out value="${message}" /></p>
</body>
</html>