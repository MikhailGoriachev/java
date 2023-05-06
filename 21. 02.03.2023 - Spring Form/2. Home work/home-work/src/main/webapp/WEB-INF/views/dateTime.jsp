<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="dateTimeActive" value="active" scope="request"/>
<c:set var="title" value="Дата и время" scope="request"/>
<c:import url="layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">Дата и время</h4>
    <h5>Дата и время на сервере: ${date}.<br>Полных дней с начала года: ${duration}</h5>
</section>

<!-- Подвал -->
<c:import url="layout/footer.jsp"/>

</body>
</html>