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
<c:set var="title" value='${isCreate ? "Добавление" : "Редактирование"} цилиндра' scope="request"/>
<c:import url="layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isCreate ? "Добавление" : "Редактирование"} цилиндра</h4>

        <form:form action='${pageContext.request.contextPath}/cylinders/${isCreate ? "store" : "update"}'
                   mode="post"
                   modelAttribute="cylinder">

            <!-- id -->
            <form:input path="id" type="hidden"/>

            <!-- Высота -->
            <div class="form-floating my-3">
                <form:input path="height" cssClass="form-control" type="number" min="0.00001" step="any" required="required"/>
                <form:label path="height" cssClass="form-label" for="height">Высота:</form:label>
            </div>

            <!-- Радиус -->
            <div class="form-floating my-3">
                <form:input path="radius" cssClass="form-control" type="number" min="0.00001" step="any" required="required"/>
                <form:label path="radius" cssClass="form-label" for="height">Радиус:</form:label>
            </div>

            <!-- Материал -->
            <div class="form-floating my-3">
                <form:select path="materialId"
                             items="${materialList}"
                             itemValue="id"
                             itemLabel="name"
                             cssClass="form-select"
                             required="required">
                </form:select>
                <form:label path="materialId" cssClass="form-label">Материал</form:label>
            </div>

            <div class="mt-5 text-center">
                <input class="btn btn-primary w-10rem me-2" type="submit" value='${isCreate ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-10rem" href="${pageContext.request.contextPath}/cylinders">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="layout/footer.jsp"/>

</body>
</html>