<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:set var="title" value='${isAdd ? "Добавление" : "Редактирование"} маршрута' scope="request"/>
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="routesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isAdd ? "Добавление" : "Редактирование"} маршрута</h4>

        <form:form action='${pageContext.request.contextPath}/routes/${isAdd ? "store" : "update"}'
                   mode="post"
                   modelAttribute="item">

            <!-- id -->
            <form:input path="id" type="hidden"/>

            <!-- Страна -->
            <div class="form-floating my-3">
                <form:select path="countryId" items="${countries}" itemValue="id" itemLabel="name"
                             cssClass="form-select" required="required" placeholder="_"/>
                <form:label path="countryId" cssClass="form-label">Страна</form:label>
            </div>

            <!-- Цель поездки -->
            <div class="form-floating my-3">
                <form:select path="objectiveId" items="${objectives}" itemValue="id" itemLabel="name"
                             cssClass="form-select" required="required" placeholder="_"/>
                <form:label path="objectiveId" cssClass="form-label">Цель поездки</form:label>
            </div>

            <!-- Стоимость одного дня -->
            <div class="form-floating my-3">
                <form:input path="dailyCost" type="number" min="1" cssClass="form-control" required="required"
                            placeholder="_"/>
                <form:label path="dailyCost" cssClass="form-label">Стоимость одного дня</form:label>
            </div>

            <!-- Управление -->
            <div class="mt-5 text-center">
                <input class="btn btn-primary w-8rem me-2" type="submit"
                       value='${isAdd ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/routes">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>