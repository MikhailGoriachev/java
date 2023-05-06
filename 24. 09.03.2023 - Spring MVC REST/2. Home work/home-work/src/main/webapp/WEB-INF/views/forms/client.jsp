<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:set var="title" value='${isAdd ? "Добавление" : "Редактирование"} клиента' scope="request"/>
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="clientsActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isAdd ? "Добавление" : "Редактирование"} клиента</h4>

        <form:form action='${pageContext.request.contextPath}/clients/${isAdd ? "store" : "update"}'
                   mode="post"
                   modelAttribute="item">

            <!-- id -->
            <form:input path="id" type="hidden"/>
            
            <!-- Фамилия -->
            <div class="form-floating my-3">
                <form:input path="surname" type="text" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="surname" cssClass="form-label">Фамилия</form:label>
            </div>

            <!-- Имя -->
            <div class="form-floating my-3">
                <form:input path="name" type="text" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="name" cssClass="form-label">Имя</form:label>
            </div>

            <!-- Отчество -->
            <div class="form-floating my-3">
                <form:input path="patronymic" type="text" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="patronymic" cssClass="form-label">Отчество</form:label>
            </div>

            <!-- Паспорт -->
            <div class="form-floating my-3">
                <form:input path="passport" pattern="^[0-9]{4} [0-9]{6}$" type="text" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="passport" cssClass="form-label">Паспорт (формат: 0123 567890)</form:label>
            </div>

            <!-- Управление -->
            <div class="mt-5 text-center">
                <input class="btn btn-primary w-8rem me-2" type="submit"
                       value='${isAdd ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/clients">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>