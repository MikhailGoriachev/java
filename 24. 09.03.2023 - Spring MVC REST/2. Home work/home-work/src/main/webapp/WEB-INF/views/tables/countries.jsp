<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="countriesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <div class="row">

        <!-- Фильтр по диапазону стоимости оформления визы -->
        <div class="col-auto mt-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#costVisaRangeModal">
                Стоимость оформления визы
            </button>
        </div>

        <!-- Статистика -->
        <div class="col-auto mt-2">
            <a class="btn btn-success w-8rem" href="${pageContext.request.contextPath}/countries/statistic-by-country">
                Статистика
            </a>
        </div>

        <!-- Сброс фильтра -->
        <div class="col-auto mt-2">
            <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/countries">Сброс</a>
        </div>

    </div>
    
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Стоимость визы (&#8381;)</th>
            <th>Стоимость транспортных услуг (&#8381;)</th>
            <th>
                <a href="${pageContext.request.contextPath}/countries/store" class="btn btn-success">Добавить</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.costVisa}</td>
                <td>${item.costService}</td>
                <td>
                    <!-- Изменение -->
                    <a href="${pageContext.request.contextPath}/countries/update/${item.id}" class="btn btn-warning">
                        <i class="bi bi-pencil-square"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>


<!-- Фильтр по диапазону стоимости оформления визы -->
<div class="modal fade" id="costVisaRangeModal" tabindex="-1"
     aria-labelledby="costVisaRangeLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form action='${pageContext.request.contextPath}/countries/by-cost-visa-range'
                       mode="post"
                       modelAttribute="filter">

                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="costVisaRangeLabel">
                        Фильтр по диапазону стоимости оформления визы
                    </h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Стоимость оформления визы:</p>
                    <div class="row">
                        <div class="col-auto">
                            <div class="form-floating">
                                <form:input path="costVisaMin" type="number" cssClass="form-control w-8rem"
                                            required="required" placeholder="_" min="0"/>
                                <form:label path="costVisaMin" cssClass="form-label">Мин. (&#8381;)</form:label>
                            </div>
                        </div>
                        
                        <div class="col-auto">
                            <div class="form-floating">
                                <form:input path="costVisaMax" type="number" cssClass="form-control w-8rem"
                                            required="required" placeholder="_" min="1"/>
                                <form:label path="costVisaMax" cssClass="form-label">Макс. (&#8381;)</form:label>
                            </div>
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