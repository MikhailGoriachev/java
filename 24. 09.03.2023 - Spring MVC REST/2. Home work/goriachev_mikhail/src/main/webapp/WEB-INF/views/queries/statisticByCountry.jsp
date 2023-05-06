<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.homework.app.utils.Utils" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="countriesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <table class="table table-hover">
        <thead>
        <tr class="align-middle">
            <th rowspan="2">Страна</th>
            <th colspan="3" class="text-center">Стоимость оформления визы (&#8381;)</th>
            <th rowspan="2">Количество</th>
        </tr>
        <tr>
            <th>Минимум</th>
            <th>Среднее значение</th>
            <th>Максимум</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.countryName}</td>
                <td>${item.minCostService}</td>
                <td>${Utils.doubleFormat(item.avgCostService)}</td>
                <td>${item.maxCostService}</td>
                <td>${item.amount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Управление -->
    <div class="mt-5 text-center">
        <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/countries">Назад</a>
    </div>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>