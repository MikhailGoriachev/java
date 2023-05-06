<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.homework.app.utils.Utils" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="cylindersActive" value="active" scope="request"/>
<c:set var="title" value="Цилиндры" scope="request"/>
<c:import url="layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">Цилиндры</h4>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Высота</th>
            <th>Радиус</th>
            <th>Материал</th>
            <th>Название</th>
            <th>Плотность</th>
            <th>Площадь</th>
            <th>Объём</th>
            <th>Масса</th>
            <th>
                <a href="${pageContext.request.contextPath}/cylinders/store" class="btn btn-success">Добавить</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cylinders}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${Utils.doubleFormat(item.height) }</td>
                <td>${Utils.doubleFormat(item.radius) }</td>
                <td>
                    <img class="h-5rem w-8rem"
                         src="${pageContext.request.contextPath}/resources/images/materials/${item.material.file}"
                         alt="${item.material.file}">
                </td>
                <td>${item.material.name}</td>
                <td>${Utils.doubleFormat(item.material.density)}</td>
                <td>${Utils.doubleFormat(item.area())}</td>
                <td>${Utils.doubleFormat(item.volume())}</td>
                <td>${Utils.doubleFormat(item.mass())}</td>
                <td>
                    <!-- Изменение -->
                    <a href="${pageContext.request.contextPath}/cylinders/update/${item.id}" class="btn btn-warning">
                        <i class="bi bi-pencil-square"></i>
                    </a>

                    <!-- Удаление -->
                    <a href="${pageContext.request.contextPath}/cylinders/remove?id=${item.id}" class="btn btn-danger">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                    
<%--                    <!-- Удаление -->--%>
<%--                    <a href="${pageContext.request.contextPath}/cylinders/remove/${item.id}" class="btn btn-danger">--%>
<%--                        <i class="bi bi-trash3-fill"></i>--%>
<%--                    </a>--%>
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