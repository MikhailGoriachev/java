<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<h1>Главная страница</h1>

<ul>
    <li><a href="${pageContext.request.contextPath}/order-list">Заказ</a></li>
</ul>
<h3>
    REST, в браузере без проблем делаем GET-запрос, PUT, DELETE, POST проверяем
    в <a href="https://www.postman.com/downloads/">Postman</a>
</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/rest/repeat/4224">REST: GET-запрос числа, формат XML</a></li>
    <li><a href="${pageContext.request.contextPath}/rest/repeat-json/4224">REST: GET-запрос числа, формат JSON</a></li>
    <li><a href="${pageContext.request.contextPath}/rest/order/2">REST: GET-запрос записи из таблицы БД в формате XML</a></li>
    <li><a href="${pageContext.request.contextPath}/rest/order-json/2">REST: GET-запрос записи из таблицы БД в формате JSON</a></li>
    <li><a href="${pageContext.request.contextPath}/rest/order-list">REST: GET-запрос записей из таблицы БД в формате XML</a></li>
    <li><a href="${pageContext.request.contextPath}/rest/order-list-json">REST: GET-запрос записей из таблицы БД в формате JSON</a></li>
</ul>
</body>
</html>
