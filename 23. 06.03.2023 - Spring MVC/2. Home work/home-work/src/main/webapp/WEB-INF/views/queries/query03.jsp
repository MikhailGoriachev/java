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

    <form:form action="${pageContext.request.contextPath}/queries/query03"
               method="post"
               modelAttribute="viewModel">
        <div class="row">

            <div class="col-auto">
                <div class="form-floating my-3">
                    <form:input path="percent" cssClass="form-control" type="number" min="1" required="required"/>
                    <form:label path="percent" cssClass="form-label" for="height">Комиссионные (%)</form:label>
                </div>
            </div>

            <div class="col my-auto">
                <button class="btn btn-success my-auto" type="submit">Выбрать</button>
                <a class="btn btn-warning my-auto"
                   href="${pageContext.request.contextPath}/queries/query03">Сброс</a>
            </div>
        </div>
    </form:form>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Паспорт</th>
            <th>Процент комиссии</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.person.surname}</td>
                <td>${item.person.name}</td>
                <td>${item.person.patronymic}</td>
                <td>${item.person.passport}</td>
                <td>${item.interest}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>