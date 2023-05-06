<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="org.homework.app.models.Tablet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- #region Стили -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/style.css">
    <!-- #endregion -->

    <!-- #region Скрипты -->
    <script src="resources/js/bootstrap.bundle.min.js"></script>
    <!-- #endregion -->

    <!-- заголовок -->
    <title>Список устройств</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<% request.setAttribute("task03Active", true); %>
<jsp:include page="../layout/header.jsp"/>

<section class="w-75 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3 min-vh-100">
    <h4 class="text-center">Список устройств</h4>

    <table class="table">
        <thead>
        <tr>
            <th><a href="task03">ID</a></th>
            <th><a href="task03?order-by=manufacture">Производитель</a></th>
            <th><a href="task03?order-by=type">Тип</a></th>
            <th>Год выпуска</th>
            <th>Операционная система</th>
            <th><a href="task03?order-by=price">Цена (&#8381;)</a></th>
            <th>
                <a class="btn btn-success" href="task03-form">Добавить</a>
            </th>
        </tr>
        </thead>
        <tbody>
<%--        <%--%>
<%--            StringBuilder sb = new StringBuilder();--%>
<%--            List<Tablet> tablets = (List<Tablet>) request.getAttribute("tablets");--%>
<%--            tablets.forEach(t -> sb.append(t.toTableRow()));--%>
<%--        %>--%>
<%--        <%= sb.toString() %>--%>
        
        <c:forEach var="item" items="${tablets}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.manufacture}"/></td>
                <td><c:out value="${item.type}"/></td>
                <td><c:out value="${item.year}"/></td>
                <td><c:out value="${item.system}"/></td>
                <td colspan='2'><c:out value="${item.price}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section>

<!-- #endregion Контент -->
<jsp:include page="../layout/footer.jsp"/>

</body>
</html>