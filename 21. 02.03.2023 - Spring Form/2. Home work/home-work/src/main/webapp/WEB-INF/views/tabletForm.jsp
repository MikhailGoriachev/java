<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="cylindersActive" value="active" scope="request"/>
<c:set var="title" value='${isCreate ? "Добавление" : "Редактирование"} устройства' scope="request"/>
<c:import url="layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isCreate ? "Добавление" : "Редактирование"} устройства</h4>

        <form:form action='${pageContext.request.contextPath}/tablets/${isCreate ? "store" : "update"}'
                   mode="post"
                   modelAttribute="cylinder">

            <!-- id -->
            <form:input path="id" type="hidden"/>


            <!-- Тип устройства -->
            <div class="form-floating my-3">
                <form:select path="type" items="${typeList}" cssClass="form-select" required="required"/>
                <form:label path="type" cssClass="form-label">Тип устройства</form:label>
            </div>

            <!-- Производитель -->
            <div class="form-floating my-3">
                <form:input path="manufacture" cssClass="form-control" required="required"/>
                <form:label path="manufacture" cssClass="form-label" for="height">Производитель</form:label>
            </div>

            <!-- Год выпуска -->
            <div class="form-floating my-3">
                <form:input path="year" cssClass="form-control" type="number" min="1970" required="required"/>
                <form:label path="year" cssClass="form-label" for="height">Год выпуска</form:label>
            </div>

            <!-- Операционная система -->
            <div class="form-floating my-3">
                <form:select path="system" items="${systemList}" cssClass="form-select" required="required"/>
                <form:label path="system" cssClass="form-label">Операционная система</form:label>
            </div>

            <!-- Цена -->
            <div class="form-floating my-3">
                <form:input path="price" cssClass="form-control" type="number" min="1" required="required"/>
                <form:label path="price" cssClass="form-label" for="height">Цена</form:label>
            </div>


            <div class="mt-5 text-center">
                <input class="btn btn-primary w-10rem me-2" type="submit"
                       value='${isCreate ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-10rem" href="${pageContext.request.contextPath}/tablets/default">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="layout/footer.jsp"/>

</body>
</html>