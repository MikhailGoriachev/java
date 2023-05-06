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

                <!-- Данные -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle ${tablesActive}" href="#"
                    id="navbarDataId" role="button" data-bs-toggle="dropdown" aria-expanded="False">
                    Данные
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDataId">

                        <!-- Товары -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/tables/goods">Товары</a>
                        </li>
                        
                        <!-- Персоны -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/tables/people">Персоны</a>
                        </li>

                        <!-- Закупки -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/tables/purchases">Закупки</a>
                        </li>

                        <!-- Продажи -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/tables/sales">Продажи</a>
                        </li>

                        <!-- Продавцы -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/tables/sellers">Продавцы</a>
                        </li>

                        <!-- Единицы измерения -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/tables/units">Единицы измерения</a>
                        </li>
                    </ul>
                </li>
                
                <!-- Запросы -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle ${queriesActive}" href="#"
                    id="navbarQueriesId" role="button" data-bs-toggle="dropdown" aria-expanded="False">
                    Запросы
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarQueriesId">

                        <!-- Запрос 1 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query01">Запрос 1</a>
                        </li>
                        
                        <!-- Запрос 2 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query02">Запрос 2</a>
                        </li>
                        
                        <!-- Запрос 3 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query03">Запрос 3</a>
                        </li>
                        
                        <!-- Запрос 4 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query04">Запрос 4</a>
                        </li>
                        
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        
                        <!-- Запрос 5 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query05">Запрос 5</a>
                        </li>
                        
                        <!-- Запрос 6 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query06">Запрос 6</a>
                        </li>
                        
                        <!-- Запрос 7 -->
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/queries/query07">Запрос 7</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>