<%-- Обработчик исключений, производных от класса Throwable --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     // скриплет с Java-кодом
     Exception exception = pageContext.getException();

     String typeException = exception.getClass().toString();
     String message = exception.getMessage();
%>
<!DOCTYPE html>
<html lang="ru">

<head>
    <title>Exception</title>
    <meta charset="UTF-8">
    <link href="resources/style.css" rel="stylesheet"/>
</head>
<body>
    <h2>При обработке запроса возникло исключение</h2>
    <ul>
        <li>Тип исключения: <%= typeException %></li>
        <li>Сообщение, локальная переменная: <%= message %></li>
        <li>Сообщение, геттер getMessage(): <%= exception.getMessage() %></li>
        <li>Сообщение, геттер getLocalizedMessage(): <%= exception.getLocalizedMessage() %></li>
    </ul>
    <br>
    <hr>
    <h3><a href="index.jsp">На главную</a></h3>
</body>
</html>
