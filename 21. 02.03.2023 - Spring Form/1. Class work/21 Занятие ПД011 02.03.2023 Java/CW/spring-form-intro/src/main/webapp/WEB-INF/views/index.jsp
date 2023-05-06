<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<h1>Пример обработки формы. Передача параметров в маршруте</h1>
<ul>
    <li><a href="student/">Форма ввода данных студента</a></li>
    <%-- формирование маршрута вида student/inc-age//42 --%>
    <li><a href="<c:url value="student/inc-age/${value}" />"/>Увеличить возраст студента на ${value} - параметр маршрута</a></li>
    <li><a href="student/details">Показать данные студента</a></li>
</ul>
</body>
</html>
