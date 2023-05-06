<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.itstep.pd011.mysql.business.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
    <link rel="stylesheet" href="./resources/style.css">
</head>
<body>
<%-- скриплет полуения товаара, нужен, пока не "починили" JSTL --%>
<% Product product = (Product) request.getAttribute("product"); %>

<h3>Редактирование товара id: <%= product.getId() %></h3>
<form method="post">
<%--    <input type="hidden" value="${product.id}" name="id" />--%>
    <input type="hidden" value="<%= product.getId() %>" name="id" />
    <label>Наименование</label><br>
<%--    <input name="name" value="${prod/uct.name}" /><br><br>--%>
    <input name="name" value="<%= product.getName() %>" /><br><br>
    <label>Цена</label><br>
<%--    <input name="price" value="${product.price}" type="number" min="1" /><br><br>--%>
    <input name="price" value="<%= product.getPrice() %>" type="number" min="1" /><br><br>
    <input type="submit" value="Сохранить" />
    <a href='<c:url value="/index-servlet" />'>На главную</a>
</form>
</body>
</html>