<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top shadow">
    <div class="container-fluid justify-content-center">

        <!-- Логотип -->
        <a class="navbar-brand mx-2" href=${path}"index.jsp">
            <img class="logo" src="${path}resources/images/icon.svg" alt="logo">
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">

                <!-- Главная -->
                <li class="nav-item">
                    <a class='nav-link mx-3 ${indexActive != null ? "active" : "" }' href="${path}index.jsp">
                        Главная
                    </a>
                </li>

                <!-- Таблицы -->
                <li class="nav-item dropdown">
                    <a class="nav-link mx-3 dropdown-toggle ${tablesActive != null ? "active" : ""}"
                       role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">
                        Таблицы
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark">
                        <li><a class="dropdown-item" href="${path}tables/appointments">Приёмы</a></li>
                        <li><a class="dropdown-item" href="${path}tables/doctors">Доктора</a></li>
                        <li><a class="dropdown-item" href="${path}tables/patients">Пациенты</a></li>
                        <li><a class="dropdown-item" href="${path}tables/people">Персоны</a></li>
                        <li><a class="dropdown-item" href="${path}tables/specialities">Специальности</a></li>
                    </ul>
                </li>

                <!-- Запросы -->
                <li class="nav-item dropdown">
                    <a class="nav-link mx-3 dropdown-toggle ${queriesActive != null ? "active" : ""}"
                       role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">
                        Запросы
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark">
                        <li><a class="dropdown-item" href="${path}queries/query01">Запрос 01</a></li>
                        <li><a class="dropdown-item" href="${path}queries/query02">Запрос 02</a></li>
                        <li><a class="dropdown-item" href="${path}queries/query03">Запрос 03</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="${path}queries/query04">Запрос 04</a></li>
                        <li><a class="dropdown-item" href="${path}queries/query05">Запрос 05</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>