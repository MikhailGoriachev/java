<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.homework.app.utils.Utils" %>

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
            <th>Id</th>
            <th>Дата приёма</th>
            <th>Доктор</th>
            <th>Специальность</th>
            <th>Стоимость приёма</th>
            <th>Проценты</th>
            <th>Зарплата</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${data}">
            <tr>
                <th>${item.id}</th>
                <td>${Utils.getFormatDate(item.appointmentDate)}</td>
                <td>${item.surname} ${item.name.charAt(0)}. ${item.patronymic.charAt(0)}.</td>
                <td>${item.specialityName}</td>
                <td>${item.price}</td>
                <td>${item.percent}</td>
                <td>${item.salary}</td>
            </tr
        </c:forEach>
        </tbody>
    </table>

</section>

<c:import url="../../layout/footer.jsp"/>

</body>
</html>