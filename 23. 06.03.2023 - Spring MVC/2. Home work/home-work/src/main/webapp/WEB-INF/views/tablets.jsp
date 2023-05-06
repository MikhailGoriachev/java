<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String" %>
<%@ page import="org.homework.app.utils.Utils" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="tabletsActive" value="active" scope="request"/>
<c:import url="layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <table class="table table-hover">
        <thead>
        <tr>
            <th><a href="${pageContext.request.contextPath}/tablets/default">Id</a></th>
            <th><a href="${pageContext.request.contextPath}/tablets/by-type-asc">Тип</a></th>
            <th><a href="${pageContext.request.contextPath}/tablets/by-manufacture-asc">Производитель</a></th>
            <th>Год выпуска</th>
            <th>Операционная система</th>
            <th><a href="${pageContext.request.contextPath}/tablets/by-price-desc">Цена (&#8381;)</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${tablets}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.type}</td>
                <td>${item.manufacture}</td>
                <td>${item.year}</td>
                <td>${item.system}</td>
                <td>${item.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="layout/footer.jsp"/>

</body>
</html>