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
    <title>Ошибка</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<jsp:include page="layout/header.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <h4 class="text-center">Ошибка времени исполнения. <a class="btn-link" href="index.jsp">На главную страницу</a></h4>
</section>

<!-- #endregion Контент -->
<jsp:include page="layout/footer.jsp"/>

</body>
</html>