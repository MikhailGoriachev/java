<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.homework.app.utils.Utils" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% request.setAttribute("path", "../"); %>

<!DOCTYPE html>
<html lang="ru">
<c:import url="../../layout/head.jsp"/>
<body>

<% request.setAttribute("queriesActive", true); %>
<c:import url="../../layout/navigation.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

    <form method="post">
        <div class="row">
            <div class="col-5">
                <div class="row">
                    <div class="col">
                        <div class="form-floating">
                            <input type="date" name="fromDate" class="form-control" placeholder=" "
                                   value="${fromDate != null ? Utils.formatFormDate(fromDate) : null}"
                                   required>
                            <label class="form-label">Мин. дата</label>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-floating">
                            <input type="date" name="toDate" class="form-control" placeholder=" "
                                   value="${toDate != null ? Utils.formatFormDate(toDate) : null}"
                                   required>
                            <label class="form-label">Макс. дата</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col my-auto">
                <button class="btn btn-success my-auto" type="submit">Выбрать</button>
                <a class="btn btn-warning my-auto"
                   href="${path}queries/query02">Сброс</a>
            </div>
        </div>
    </form>

    <h4 class="text-center">${title}</h4>

    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Дата приёма</th>
            <th>Доктор</th>
            <th>Специальность</th>
            <th>Стоимость приёма</th>
            <th>Проценты</th>
            <th>Пациент</th>
            <th>Дата рождения</th>
            <th>Паспорт</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${data}">
            <tr>
                <th>${item.id}</th>
                <td>${Utils.getFormatDate(item.appointmentDate)}</td>
                <td>${item.doctorSurname} ${item.doctorName.charAt(0)}. ${item.doctorPatronymic.charAt(0)}.</td>
                <td>${item.specialityName}</td>
                <td>${item.price}</td>
                <td>${item.percent}</td>
                <td>${item.patientSurname} ${item.patientName.charAt(0)}. ${item.patientPatronymic.charAt(0)}.</td>
                <td>${Utils.getFormatDate(item.bornDate)}</td>
                <td>${item.passport}</td>
            </tr
        </c:forEach>
        </tbody>
    </table>

</section>

<c:import url="../../layout/footer.jsp"/>

</body>
</html>