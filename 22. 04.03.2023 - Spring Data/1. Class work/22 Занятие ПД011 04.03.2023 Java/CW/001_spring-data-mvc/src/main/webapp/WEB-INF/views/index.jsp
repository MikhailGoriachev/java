<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<h1>Главная страница</h1>

<ul>
    <li><a href="${pageContext.request.contextPath}/order-list">Заказ</a></li>
</ul>
</body>
</html>
