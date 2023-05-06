<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.homework.app.utils.Utils" %>
<%@ page import="java.lang.String" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% request.setAttribute("path", "../"); %>

<!DOCTYPE html>
<html lang="ru">
<c:import url="../../layout/head.jsp"/>
<body>

<% request.setAttribute("queriesActive", true); %>
<c:import url="../../layout/navigation.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

    <h4 class="text-center">${title}</h4>

    <table class="table">
        <thead>
        <tr>
        <tr>
            <th>Дата приёма</th>
            <th>Количество</th>
            <th>Минимальная цена</th>
            <th>Средняя цена</th>
            <th>Максимальная цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${data}">
            <tr>
                <td>${Utils.getFormatDate(item.appointmentDate)}</td>
                <td>${item.amount}</td>
                <td>${item.minPercent}</td>
                <td>${String.format("%.2f", item.avgPercent)}</td>
                <td>${item.maxPercent}</td>
            </tr
        </c:forEach>
        </tbody>
    </table>

</section>

<c:import url="../../layout/footer.jsp"/>

</body>
</html>