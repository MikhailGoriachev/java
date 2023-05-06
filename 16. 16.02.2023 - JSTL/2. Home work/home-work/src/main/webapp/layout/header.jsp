<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top shadow">
    <div class="container-fluid justify-content-center">

        <!-- Логотип -->
        <a class="navbar-brand mx-2" href="index.jsp">
            <img class="logo" src="resources/images/icon.svg" alt="logo">
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">

                <!-- Главная -->
                <li class="nav-item">
                    <a class='nav-link mx-3 <%= request.getAttribute("indexActive") != null ? "active" : "" %>' href="index.jsp">
                        Главная
                    </a>
                </li>
                
                <!-- Задание 1 -->
                <li class="nav-item">
                    <a class='nav-link mx-3 <%= request.getAttribute("task01Active") != null ? "active" : "" %>' href="task01">
                        Дата и время
                    </a>
                </li>
                
                <!-- Задание 2 -->
                <li class="nav-item">
                    <a class='nav-link mx-3 <%= request.getAttribute("task02Active") != null ? "active" : "" %>' href="task02">
                        Цилиндр
                    </a>
                </li>
                
                <!-- Задание 3 -->
                <li class="nav-item">
                    <a class='nav-link mx-3 <%= request.getAttribute("task03Active") != null ? "active" : "" %>' href="task03">
                        Устройства
                    </a>
                </li>
                
                <!-- Ошибка 404 -->
                <li class="nav-item">
                    <a class='nav-link mx-3' href="error404">
                        Ошибка 404
                    </a>
                </li>
                
                <!-- Ошибка Exception -->
                <li class="nav-item">
                    <a class='nav-link mx-3' href="exception">
                        Ошибка Exception
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>