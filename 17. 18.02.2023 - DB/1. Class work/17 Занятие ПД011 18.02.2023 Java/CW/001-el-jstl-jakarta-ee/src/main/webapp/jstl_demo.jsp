<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL, JSTL</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<nav>
    <a href="index.jsp">На главную</a>
</nav>

<br>
<hr>
<br>
    <h3>Тег c:forEach</h3>
    <ul>
        <c:forEach var="user" items="${users}">
            <li><c:out value="${user}" /></li>
        </c:forEach>
    </ul>

    <h3>Вывод всех куки</h3>
    <ul>
        <c:forEach var="item" items="${cookie}">
            <li>
                <p><c:out value="${item.value.name}" /></p>
                <p><c:out value="${item.value.value}" /></p>
            </li>
        </c:forEach>
    </ul>

    <h3>Тег if</h3>
	<%-- test - атрибут, задающий условие --%>
    <c:if test="${visible}">
        <p>Visible</p>
    </c:if>
    <c:if test="${visible == false}">
        <p>Invisible</p>
    </c:if>

    <h3>Тег choose</h3>
    <c:choose>
	    <%-- test - атрибут, задающий условие  когда условие  val == 1 истинно рендери... --%>
        <c:when test="${val == 1}">
            <p>значение val равно 1</p>
        </c:when>
        <c:when test="${val == 2}">
            <p>значение val равно 2</p>
        </c:when>
        <c:otherwise>
            <%-- покажем работу по переадресации, редиректу, для остальных значений --%>
            <c:redirect url="/errors/error.jsp" />
        </c:otherwise>
    </c:choose>

    <hr>
    <a href='<c:url value="/index.jsp" />'>На главную, при помощи тега JSTL</a>
</body>
</html>
