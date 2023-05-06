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

    <h2>Обработчик формы, демо получения скалярных и агрегатных параметров</h2>
    <h3>Встроенные объекты EL</h3>
    <%-- объект param - для скалярных значений,
         объект paramValues - для агрегатных
    --%>
    <p>Name: ${param.name}</p>
    <p>Phone 1: ${paramValues.phone[0]}</p>
    <p>Phone 2: ${paramValues.phone[1]}</p>
    <p>Phone 3: ${paramValues.phone[2]}</p>
</body>
</html>
