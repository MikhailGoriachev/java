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

    <form:form action="${pageContext.request.contextPath}/queries/query01"
               method="post"
               modelAttribute="viewModel">
        <div class="row">

            <div class="col-auto">
                <div class="form-floating my-3 w-10rem">
                    <form:select path="unitShortName" items="${unitsList}" cssClass="form-select" required="required"/>
                    <form:label path="unitShortName" cssClass="form-label">Ед. измерения</form:label>
                </div>
            </div>

            <div class="col-auto">
                <div class="form-floating my-3">
                    <form:input path="price" cssClass="form-control" type="number" min="1" required="required"/>
                    <form:label path="price" cssClass="form-label" for="height">Цена (&#8381;)</form:label>
                </div>
            </div>

            <div class="col my-auto">
                <button class="btn btn-success my-auto" type="submit">Выбрать</button>
                <a class="btn btn-warning my-auto"
                   href="${pageContext.request.contextPath}/queries/query01">Сброс</a>
            </div>
        </div>
    </form:form>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Товар</th>
            <th>Единица измерения</th>
            <th>Дата закупки</th>
            <th>Цена (&#8381;)</th>
            <th>Количество</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.goods.name}</td>
                <td>${item.unit.shortName}</td>
                <td>${Utils.dateToFormat(item.purchaseDate)}</td>
                <td>${item.price}</td>
                <td>${item.amount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>