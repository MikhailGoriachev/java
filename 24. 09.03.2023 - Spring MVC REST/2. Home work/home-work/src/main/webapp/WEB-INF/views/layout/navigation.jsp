<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top shadow">
    <div class="container-fluid justify-content-center">

        <!-- Логотип -->
        <a class="navbar-brand mx-2" href="${pageContext.request.contextPath}/">
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

                <!-- Клиенты -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${clientsActive}' href="${pageContext.request.contextPath}/clients">
                        Клиенты
                    </a>
                </li>

                <!-- Страны -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${countriesActive}' href="${pageContext.request.contextPath}/countries">
                        Страны
                    </a>
                </li>

                <!-- Цели поездок -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${objectivesActive}' href="${pageContext.request.contextPath}/objectives">
                        Цели поездок
                    </a>
                </li>

                <!-- Маршруты -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${routesActive}' href="${pageContext.request.contextPath}/routes">
                        Маршруты
                    </a>
                </li>

                <!-- Поездки -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${visitsActive}' href="${pageContext.request.contextPath}/visits">
                        Поездки
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>