<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.homework.app.utils.Utils" %> 
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="visitsActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Клиент</th>
            <th>Паспорт</th>
            <th>Страна</th>
            <th>Цель поездки</th>
            <th>Дата начала</th>
            <th>Длительность (день)</th>
            <th>Стоимость с НДС (&#8381;)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.client.surname} ${item.client.name.charAt(0)}. ${item.client.surname.charAt(0)}.</td>
                <td>${item.client.passport}</td>
                <td>${item.route.country.name}</td>
                <td>${item.route.objective.name}</td>
                <td>${item.dateStart}</td>
                <td>${item.duration}</td>
                <td>${Utils.doubleFormat(item.overCostWithNds)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <!-- Управление -->
    <div class="mt-5 text-center">
        <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/visits">Назад</a>
    </div>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>