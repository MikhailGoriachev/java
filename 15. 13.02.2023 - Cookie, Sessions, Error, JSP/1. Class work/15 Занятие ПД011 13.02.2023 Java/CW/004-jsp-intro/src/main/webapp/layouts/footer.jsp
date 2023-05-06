<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%--
    Шаблонный файл - футер для использования на страницах
    используем код - для примера :)
--%>
<hr/>
<p> <%= String.format("Сегодня %tD", new Date()) %></p>
