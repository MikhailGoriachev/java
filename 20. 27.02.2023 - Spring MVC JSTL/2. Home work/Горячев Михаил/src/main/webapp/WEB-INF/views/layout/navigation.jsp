<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top shadow">
    <div class="container-fluid justify-content-center">

        <!-- Логотип -->
        <a class="navbar-brand mx-2" href="">
            <img class="logo" src="<c:url value="/resources/images/icon.svg"/>" alt="logo">
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">

                <!-- Главная -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${indexActive}' href="${pageContext.request.contextPath}/">
                        Главная
                    </a>
                </li>

                <!-- Задание 1 -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${dateTimeActive}' href="${pageContext.request.contextPath}/dateTime">
                        Дата и время
                    </a>
                </li>
                
                <!-- Задание 2 -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${cylindersActive}' href="${pageContext.request.contextPath}/cylinders">
                        Цилиндры
                    </a>
                </li>
                
                <!-- Задание 3 -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${tabletsActive}' href="${pageContext.request.contextPath}/tablets/default">
                        Гаджеты
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>