<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.homework.app.utils.Utils" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="../layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="tablesActive" value="active" scope="request"/>
<c:import url="../layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">${title}</h4>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Товар</th>
            <th>Единица измерения</th>
            <th>Продавец</th>
            <th>Дата</th>
            <th>Цена закупки (&#8381;)</th>
            <th>Цена продажи (&#8381;)</th>
            <th>Количество</th>
            <th>Прибыль (&#8381;)</th>
            <th>
                <a href="${pageContext.request.contextPath}/crud/sales/store" class="btn btn-success">Добавить</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr class="align-middle">
                <td>${item.id}</td>
                <td>${item.purchase.goods.name}</td>
                <td>${item.unit.shortName}</td>
                <td>
                        ${item.seller.person.surname}
                        ${item.seller.person.name.charAt(0)}.
                        ${item.seller.person.patronymic.charAt(0)}.
                </td>
                <td>${Utils.dateToFormat(item.saleDate)}</td>
                <td>${item.purchase.price}</td>
                <td>${item.price}</td>
                <td>${item.amount}</td>
                <td>${item.income()}</td>
                <td>
                    <!-- Изменение -->
                    <a href="${pageContext.request.contextPath}/crud/sales/update/${item.id}" class="btn btn-warning">
                        <i class="bi bi-pencil-square"></i>
                    </a>

                    <!-- Удаление -->
                    <a href="${pageContext.request.contextPath}/crud/sales/delete/${item.id}" class="btn btn-danger">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Подвал -->
<c:import url="../layout/footer.jsp"/>

</body>
</html>