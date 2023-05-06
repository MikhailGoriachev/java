<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>EL, JSTL</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

<nav>
    <a href="java-bean-servlet">Использование Java Bean</a> |
    <a href="el_param.jsp?name=Василий&phone=2128506&phone=12333214445&phone=7778787777">
        Встроенные объекты EL: param, paramValues - строка запроса
    </a> |
    <a href="user_form.html">Встроенные объекты EL: param, paramValues - форма</a> |
    <a href="set-cookie-servlet">Запись куки</a>
    <br>
    <a href="injection-servlet">Защита от внедрения кода</a> |
    <a href="jstl-demo-servlet">Демо JSTL</a>
</nav>

<main>
    <br>
    <hr>
    <br>
    <h3>Демонстрация встроенных объектов EL</h3>
    <%-- использование встроенных объектов EL --%>
    <h3>Чтение куки (вывод значений после записи, конечно же)</h3>
    <%-- выражение ${name} работает благодаря JSTL --%>
    <p>${cookie.nowDate.value}</p>
    <h3>Получение заголовков (некоторых)</h3>
    <p>User-Agent: ${header["User-Agent"]}</p>
    <p>Host: ${header.host}</p>
</main>
</body>
</html>