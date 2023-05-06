<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:set var="title" value='${isAdd ? "Добавление" : "Редактирование"} поездки' scope="request"/>
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="visitsActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isAdd ? "Добавление" : "Редактирование"} поездки</h4>

        <form:form action='${pageContext.request.contextPath}/visits/${isAdd ? "store" : "update"}'
                   mode="post"
                   modelAttribute="item">

            <!-- id -->
            <form:input path="id" type="hidden"/>

            <!-- Клиент -->
            <div class="form-floating my-3">
                <form:select path="clientId" items="${clients}" itemValue="id" itemLabel="stringInfo"
                             cssClass="form-select" required="required" placeholder="_"/>
                <form:label path="clientId" cssClass="form-label">Клиент</form:label>
            </div>
            
            <!-- Маршрут -->
            <div class="form-floating my-3">
                <form:select path="routeId" items="${routes}" itemValue="id" itemLabel="stringInfo"
                             cssClass="form-select" required="required" placeholder="_"/>
                <form:label path="routeId" cssClass="form-label">Маршрут</form:label>
            </div>

            <!-- Дата начала поездки -->
            <div class="form-floating my-3">
                <form:input path="dateStart" type="date" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="dateStart" cssClass="form-label">Дата начала поездки</form:label>
            </div>
            
            <!-- Длительность -->
            <div class="form-floating my-3">
                <form:input path="duration" type="number" min="1" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="duration" cssClass="form-label">Длительность</form:label>
            </div>
            
            <!-- Управление -->
            <div class="mt-5 flex flex-row text-center">
                <input class="btn btn-primary w-8rem me-2" type="submit"
                       value='${isAdd ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/visits">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>