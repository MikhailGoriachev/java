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
            <th><a href="${pageContext.request.contextPath}/tablets/by-system-asc">Операционная система</a></th>
            <th><a href="${pageContext.request.contextPath}/tablets/by-price-desc">Цена (&#8381;)</a></th>
            <th>
                <a href="${pageContext.request.contextPath}/tablets/store" class="btn btn-success">Добавить</a>
            </th>
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
                <td>
                    <!-- Изменение -->
                    <a href="${pageContext.request.contextPath}/tablets/update/${item.id}" class="btn btn-warning">
                        <i class="bi bi-pencil-square"></i>
                    </a>

                    <!-- Удаление -->
                    <a href="${pageContext.request.contextPath}/tablets/remove/${item.id}" class="btn btn-danger">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="layout/footer.jsp"/>

</body>
</html>