<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="routesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <div class="row">

        <!-- Фильтр по цели поездки -->
        <div class="col-auto mt-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#objectiveModal">
                Цель поездки
            </button>
        </div>

        <!-- Фильтр по цели поездки и стоимостью транспортных услуг меньше заданного значения -->
        <div class="col-auto mt-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#objectiveAndCostServiceModal">
                Цель поездки и стоимость трансп. услуг
            </button>
        </div>

        <!-- Фильтр по стране назначения -->
        <div class="col-auto mt-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#countryModal">
                Страна назначения
            </button>
        </div>

        <!-- Статистика -->
        <div class="col-auto mt-2">
            <a class="btn btn-success w-8rem" href="${pageContext.request.contextPath}/routes/statistic-by-objective">
                Статистика
            </a>
        </div>

        <!-- Сброс фильтра -->
        <div class="col-auto mt-2">
            <a class="btn btn-secondary w-8rem" href="${pageContext.request.contextPath}/routes">Сброс</a>
        </div>

    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Страна</th>
            <th>Цель поездки</th>
            <th>Стоимость 1 дня (&#8381;)</th>
            <th>Транспортные услуги (&#8381;)</th>
            <th>
                <a href="${pageContext.request.contextPath}/routes/store" class="btn btn-success">Добавить</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.country.name}</td>
                <td>${item.objective.name}</td>
                <td>${item.dailyCost}</td>
                <td>${item.country.costService}</td>
                <td>
                    <!-- Изменение -->
                    <a href="${pageContext.request.contextPath}/routes/update/${item.id}" class="btn btn-warning">
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

<!-- Фильтр по цели поездки -->
<div class="modal fade" id="objectiveModal" tabindex="-1" aria-labelledby="objectiveModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form action='${pageContext.request.contextPath}/routes/by-objective'
                       mode="post"
                       modelAttribute="filter">

                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="objectiveModalLabel">Фильтр по цели поездки</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-floating">
                        <form:select path="objectiveNameOnly" items="${objectiveList}" itemLabel="name"
                                     itemValue="name"
                                     cssClass="form-select w-15rem" required="required" placeholder="_"/>
                        <form:label path="objectiveNameOnly" cssClass="form-label">Цель поездки</form:label>
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

<!-- Фильтр по цели поездки -->
<div class="modal fade" id="objectiveAndCostServiceModal" tabindex="-1"
     aria-labelledby="objectiveAndCostServiceModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form action='${pageContext.request.contextPath}/routes/by-route-and-cost-service-less-than'
                       mode="post"
                       modelAttribute="filter">

                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="objectiveAndCostServiceModalLabel">Фильтр по цели поездки и
                        стоимостью транспортных услуг меньше заданного значения</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="form-floating">
                                <form:select path="objectiveName" items="${objectiveList}" itemLabel="name"
                                             itemValue="name"
                                             cssClass="form-select w-15rem" required="required" placeholder="_"/>
                                <form:label path="objectiveName" cssClass="form-label">Цель поездки</form:label>
                            </div>
                        </div>

                        <!-- Стоимость транспортных услуг -->
                        <div class="col-auto">
                            <div class="form-floating">
                                <form:input path="costService" type="number" cssClass="form-control w-10rem"
                                            required="required"
                                            placeholder="_" min="1"/>
                                <form:label path="costService"
                                            cssClass="form-label">Трансп. услуги (&#8381;)</form:label>
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

<!-- Фильтр по стране назначения -->
<div class="modal fade" id="countryModal" tabindex="-1" aria-labelledby="countryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form action='${pageContext.request.contextPath}/routes/by-country'
                       mode="post"
                       modelAttribute="filter">

                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="countryModalLabel">Фильтр по цели поездки</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-floating">
                        <!-- Страна -->
                        <form:select path="countryName" items="${countryList}" itemValue="name" itemLabel="name"
                                     cssClass="form-select w-10rem" required="required" placeholder="_"/>
                        <form:label path="countryName" cssClass="form-label">Страна</form:label>
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