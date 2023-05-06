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
<c:set var="visitsActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>
    
    <div class="row">

        <!-- Фильтр по количеству дней прибывания в стране -->
        <div class="col-auto mt-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#durationModal">
                Длительность прибывания
            </button>
        </div>

        <!-- Полная стоимость с НДС -->
        <div class="col-auto mt-2">
            <a class="btn btn-success" href="${pageContext.request.contextPath}/visits/with-nds">
                Полная стоимость с НДС
            </a>
        </div>

        <!-- Сброс фильтра -->
        <div class="col-auto mt-2">
            <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/visits">Сброс</a>
        </div>

    </div>

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
            <th>
                <a href="${pageContext.request.contextPath}/visits/store" class="btn btn-success">Добавить</a>
            </th>
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
                <td>
                    <!-- Изменение -->
                    <a href="${pageContext.request.contextPath}/visits/update/${item.id}" class="btn btn-warning">
                        <i class="bi bi-pencil-square"></i>
                    </a>

                    <!-- Удаление -->
                    <a href="${pageContext.request.contextPath}/visits/delete/${item.id}" class="btn btn-danger">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

<!-- Фильтр по количеству дней прибывания в стране -->
<div class="modal fade" id="durationModal" tabindex="-1" aria-labelledby="durationModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form action='${pageContext.request.contextPath}/visits/by-duration'
                       mode="post"
                       modelAttribute="filter">

                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="durationModalLabel">
                        Фильтр по количеству дней прибывания в стране
                    </h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-floating">
                        <!-- Длительность прибывания -->
                        <div class="form-floating">
                            <form:input path="duration" type="number" cssClass="form-control w-10rem" required="required"
                                        placeholder="_" min="1"/>
                            <form:label path="duration" cssClass="form-label">Длительность (день)</form:label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Назад</button>
                    <button type="submit" class="btn btn-primary">Выбрать</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>