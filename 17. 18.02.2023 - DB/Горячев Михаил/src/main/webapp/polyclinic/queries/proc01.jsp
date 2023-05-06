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

    <form method="post">
        <div class="row">
            <div class="col-2">
                <div class="form-floating">
                    <input type="text" name="startSurname" class="form-control" placeholder=" " value="${startSurname}"
                           required>
                    <label class="form-label">Фамилия</label>
                </div>
            </div>
            <div class="col my-auto">
                <button class="btn btn-success my-auto" type="submit">Выбрать</button>
                <a class="btn btn-warning my-auto"
                   href="${path}queries/query01">Сброс</a>
            </div>
        </div>
    </form>

    <h4 class="text-center">${title}</h4>

    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
            <th>Адрес</th>
            <th>Паспорт</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${data}">
            <tr>
                <td>${item.id}</td>
                <td>${item.surname}</td>
                <td>${item.name}</td>
                <td>${item.patronymic}</td>
                <td>${Utils.getFormatDate(item.bornDate)}</td>
                <td>${item.address}</td>
                <td>${item.passport}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section>

<c:import url="../../layout/footer.jsp"/>

</body>
</html>