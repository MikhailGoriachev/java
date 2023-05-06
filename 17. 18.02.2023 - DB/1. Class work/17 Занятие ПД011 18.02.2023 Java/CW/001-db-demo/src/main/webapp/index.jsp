<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List" %>
<%@ page import="org.itstep.pd011.mysql.business.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="./resources/style.css">
</head>
<body>
<h2>Products List</h2>

<p>
    <a href='<c:url value="test-connection" />'>Тест соединения</a> |
    <a href='<c:url value="create" />'>Новый товар</a>
    <%-- для обработки формы GET-запросом --%>
<%--    <a href='<c:url value="create.jsp" />'>Новый товар</a>--%>
</p>
<ul>
    <%
        List<Product> products = (List<Product>)request.getAttribute("products");
    %>
    <li>Тестовое значение <u><b>${test}</b></u></li>
    <li>Тестовое значение <u><b>${header.host}</b></u></li>
    <li>Тестовое значение <u><b><%= request.getAttribute("test") %></b></u></li>
    <li>Размер коллекции <u><b><%= products.size() %></b></u></li>
</ul>
<table>
    <tr><th>Id</th><th>Name</th><th>Price</th><th></th></tr>
    <%-- собрать тело таблицы в StringBuilder --%>
    <%
        StringBuilder sbr = new StringBuilder();
        for (Product product : products) {
            sbr.append(String.format(
                 "<tr>" +
                 "      <td>%1$d</td><td>%2$s</td><td>%3$d.00</td>" +
                 "      <td><a href=\"edit?id=%1$d\">Изменить</a>|" +
                 "          <a href=\"delete?id=%1$d\">Удалить</a>" +
                 "      </td>" +
                 "  </tr>",               
                    product.getId(), product.getName(), product.getPrice()));
        }
    %>
    <%-- вывод собранного тела таблицы --%>
    <%= sbr %>

<%--    <c:forEach var="product" items="${products}">--%>
<%--        <tr><td>${product.id}</td>--%>
<%--            <td>${product.name}</td>--%>
<%--            <td>${product.price}</td>--%>
<%--            <td>--%>
<%--                <a href='<c:url value="/edit?id=${product.id}" />'>Изменить</a>--%>
<%--                <form method="post" action='<c:url value="/delete" />' style="display:inline;">--%>
<%--                    <input type="hidden" name="id" value="${product.id}">--%>
<%--                    <input type="submit" value="Удалить">--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
</body>
</html>