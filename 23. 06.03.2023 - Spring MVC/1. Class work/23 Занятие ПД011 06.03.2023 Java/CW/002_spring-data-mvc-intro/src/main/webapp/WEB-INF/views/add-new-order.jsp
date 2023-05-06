<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<form action="${pageContext.request.contextPath}/add-new-order" method="post">
    <div class="p-10">
        <label>Наименование:</label>
        <input type="text" name="title">
    </div>

    <div class="p-10">
        <label>Цена, руб.:</label>
        <input type="number" name="price">
    </div>

    <input type="submit" value="Добавить">
</form>

<%-- подключение шаблона нижней части страницы --%>
<c:import url="layout/footer.jsp"/>