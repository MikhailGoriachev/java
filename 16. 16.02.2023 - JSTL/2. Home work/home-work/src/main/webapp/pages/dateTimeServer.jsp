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
    <title>Дата и время</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<% request.setAttribute("task01Active", true); %>
<jsp:include page="../layout/header.jsp"/>

<section class="w-75 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3 min-vh-100">
    <h4 class="text-center">Дата и время</h4>

    <h5>
        <%= (boolean) request.getAttribute("isCookie")
                ? "Еще рано, подождите, ничего не изменилось<br>Дата и время на сервере в cookie: " +
                  request.getAttribute("cookieDateTime")
                : "Время и дата на сервере: " + request.getAttribute("cookieDateTime") %>
<%--        ${isCookie--%>
<%--                ? "Еще рано, подождите, ничего не изменилось<br>Дата и время на сервере в cookie: " + cookie.dateTime--%>
<%--                : "Время и дата на сервере: " + cookie.dateTime}--%>
    </h5>
</section>

<!-- #endregion Контент -->
<jsp:include page="../layout/footer.jsp"/>

</body>
</html>