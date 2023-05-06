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
<c:set var="queriesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Продавец</th>
            <th>Паспорт</th>
            <th>Минимальная цена (&#8381;)</th>
            <th>Максимальная цена (&#8381;)</th>
            <th>Количество</th>
            <th>Суммарная стоимость (&#8381;)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.person.surname} ${item.person.name.charAt(0)}. ${item.person.patronymic.charAt(0)}.</td>
                <td>${item.person.passport}.</td>
                <td>${item.minPrice}</td>
                <td>${item.maxPrice}</td>
                <td>${item.count}</td>
                <td>${item.sumPrice}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>