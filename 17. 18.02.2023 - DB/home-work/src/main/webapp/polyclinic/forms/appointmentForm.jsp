<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.homework.app.utils.Utils" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% request.setAttribute("path", "../../"); %>
<% request.setAttribute("title", (((boolean) request.getAttribute("isCreate")) ? "Добавление" : "Изменение") + " приёма"); %>

<!DOCTYPE html>
<html lang="ru">
<c:import url="../../layout/head.jsp"/>
<body>

<% request.setAttribute("tablesActive", true); %>
<c:import url="../../layout/navigation.jsp"/>
    
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

    <form method="post" class="w-50 mx-auto">
        <h4 class="text-center">${isCreate ? "Добавление" : "Изменение"} приёма</h4>
        <input type="hidden" name="id" value="${item.id}">

        <div class="form-floating my-2">
            <select name="idDoctor" class="form-select">
                <c:forEach var="p" items="${doctors}">
                    <option value='${p.id}' ${p.id == item.doctorId ? "selected" : ""}>
                            ${p.id}. ${p.surname} ${p.name} ${p.patronymic} ${p.specialityName} ${item.appointmentDate}
                    </option>
                </c:forEach>
            </select>
            <label class="form-label">Доктор</label>
        </div>

        <div class="form-floating my-2">
            <select name="idPatient" class="form-select">
                <c:forEach var="p" items="${patients}">
                    <option value='${p.id}' ${p.id == item.patientId ? "selected" : ""}>
                            ${p.id}. ${p.surname} ${p.name} ${p.patronymic} ${p.passport} ${item.patientId}
                    </option>
                </c:forEach>
            </select>
            <label class="form-label">Пациент</label>
        </div>

        <div class="form-floating my-2">
            <input type="date" name="appointmentDate" class="form-control" placeholder=""
                   value="${Utils.formatFormDate(item.appointmentDate)}" required>
            <label class="form-label">Дата приёма</label>
        </div>

        <div class="col my-auto">
            <button class="btn btn-success w-8rem my-auto me-2" name="appointmentForm"
                    type="submit">${isCreate ? "Добавить" : "Сохранить"}</button>
            <a class="btn btn-danger my-auto w-8rem"
               href="../../tables/appointments">Назад</a>
        </div>
    </form>
</section>

<c:import url="../../layout/footer.jsp"/>

</body>
</html>