<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="tablesActive" value="active" scope="request"/>
<c:set var="title" value='${isAdd ? "Добавление" : "Редактирование"} продажи' scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">${isAdd ? "Добавление" : "Редактирование"} продажи</h4>

        <form:form action='${pageContext.request.contextPath}/crud/sales/${isAdd ? "store" : "update"}'
                   mode="post"
                   modelAttribute="item">

            <!-- id -->
            <form:input path="id" type="hidden"/>


            <!-- Закупка -->
            <div class="form-floating my-3">
                <form:select path="purchaseId" items="${purchaseList}" itemValue="id" itemLabel="toString" 
                             cssClass="form-select" required="required"/>
                <form:label path="purchaseId" cssClass="form-label">Закупка</form:label>
            </div>

            <!-- Единицы измерения -->
            <div class="form-floating my-3">
                <form:select path="unitId" items="${unitList}" itemValue="id" itemLabel="shortName"
                             cssClass="form-select" required="required"/>
                <form:label path="unitId" cssClass="form-label">Единицы измерения</form:label>
            </div>
            
            <!-- Продавец -->
            <div class="form-floating my-3">
                <form:select path="sellerId" items="${sellerList}" itemValue="id" itemLabel="toString"
                             cssClass="form-select" required="required"/>
                <form:label path="sellerId" cssClass="form-label">Продавец</form:label>
            </div>
            
            <!-- Дата продажи -->
            <div class="form-floating my-3">
                <form:input path="saleDate" type="date" cssClass="form-control" required="required"/>
                <form:label path="saleDate" cssClass="form-label">Дата продажи</form:label>
            </div>
            
            <!-- Цена -->
            <div class="form-floating my-3">
                <form:input path="price" cssClass="form-control" type="number" min="1" required="required"/>
                <form:label path="price" cssClass="form-label" for="height">Цена (&#8381;)</form:label>
            </div>
            
            <!-- Количество -->
            <div class="form-floating my-3">
                <form:input path="amount" cssClass="form-control" type="number" min="1" required="required"/>
                <form:label path="amount" cssClass="form-label" for="height">Количество</form:label>
            </div>

            <div class="mt-5 text-center">
                <input class="btn btn-primary w-10rem me-2" type="submit"
                       value='${isAdd ? "Добавить" : "Сохранить"}'>
                <a class="btn btn-secondary w-10rem" href="${pageContext.request.contextPath}/tables/sales">Назад</a>
            </div>
        </form:form>
    </section>
</div>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>