<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- #region Стили -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/style.css">
    <!-- #endregion -->

    <!-- #region Скрипты -->
    <script src="resources/js/bootstrap.bundle.min.js"></script>
    <!-- #endregion -->

    <!-- заголовок -->
    <title>Данные цилиндра</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<% request.setAttribute("task02Active", true); %>
<jsp:include page="../layout/header.jsp"/>

<%--<section class="">--%>
<div class="min-vh-100">
    <div class="card w-25 mx-auto my-4 bg-light shadow-sm border rounded-3">
        <div class="card-header"><h4 class="text-center">Данные цилиндра</h4></div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                Высота: <%= String.format("%.4f", (double) request.getAttribute("height")) %>
            </li>
            <li class="list-group-item">
                Радиус: <%= String.format("%.4f", (double) request.getAttribute("radius")) %>
            </li>
            <li class="list-group-item">
                Материал: <%= request.getAttribute("material") %>
            </li>
            <li class="list-group-item">
                Плотность: <%= String.format("%.4f", (double) request.getAttribute("density")) %>
            </li>
            <li class="list-group-item">&nbsp;</li>
            <li class="list-group-item">
                Площадь: <%= request.getAttribute("area") != null
                    ? String.format("%.4f", (double) request.getAttribute("area"))
                    : "———" %>
            </li>
            <li class="list-group-item">
                Объём: <%= request.getAttribute("volume") != null
                    ? String.format("%.4f", (double) request.getAttribute("volume"))
                    : "———" %>
            </li>
            <li class="list-group-item">
                Масса: <%= request.getAttribute("mass") != null
                    ? String.format("%.4f", (double) request.getAttribute("mass"))
                    : "———" %>
            </li>
        </ul>
        <div class="card-footer text-center">
            <a class="btn btn-primary w-10rem me-2" href="task02">Ввод данных</a>
        </div>
    </div>
</div>
<%--</section>--%>

<!-- #endregion Контент -->
<jsp:include page="../layout/footer.jsp"/>

</body>
</html>