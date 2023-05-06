<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:set var="title" value='${isAdd ? "Добавление" : "Редактирование"} страны' scope="request"/>
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="countriesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isAdd ? "Добавление" : "Редактирование"} страны</h4>

        <form:form action='${pageContext.request.contextPath}/countries/${isAdd ? "store" : "update"}'
                   mode="post"
                   modelAttribute="item">

            <!-- id -->
            <form:input path="id" type="hidden"/>

            <!-- Название -->
            <div class="form-floating my-3">
                <form:input path="name" type="text" cssClass="form-control" required="required" placeholder="_"/>
                <form:label path="name" cssClass="form-label">Название</form:label>
            </div>

            <!-- Стоимость транспортных услуг -->
            <div class="form-floating my-3">
                <form:input path="costService" type="number" cssClass="form-control" required="required" placeholder="_"
                            min="1"/>
                <form:label path="costService" cssClass="form-label">Стоимость транспортных услуг (&#8381;)</form:label>
            </div>

            <!-- Стоимость оформления визы -->
            <div class="form-floating my-3">
                <form:input path="costVisa" type="number" cssClass="form-control" required="required" placeholder="_"
                            min="1"/>
                <form:label path="costVisa" cssClass="form-label">Стоимость оформления визы (&#8381;)</form:label>
            </div>

            <!-- Управление -->
            <div class="mt-5 text-center">
                <input class="btn btn-primary w-8rem me-2" type="submit"
                       value='${isAdd ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/countries">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>