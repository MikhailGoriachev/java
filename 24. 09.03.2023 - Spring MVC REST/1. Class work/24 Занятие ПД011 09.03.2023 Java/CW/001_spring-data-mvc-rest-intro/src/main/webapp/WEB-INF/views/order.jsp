<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<h1>Заказ клиента <u>Фамилия Имя</u></h1>
<table>
  <tr>
    <th>Наименование</th>
    <th>Цена</th>
    <th><a href="${pageContext.request.contextPath}/add-new-order">Добавить элемент заказа</a></th>
  </tr>
  <c:forEach var="order" items="${orderList}">
    <tr>
      <td>${order.title}</td>
      <td>${order.price}</td>
      <td><a href="${pageContext.request.contextPath}/delete-order/${order.id}">Удалить</a></td>
     </tr>
  </c:forEach>
</table>


<%-- подключение шаблона нижней части страницы --%>
<c:import url="layout/footer.jsp"/>