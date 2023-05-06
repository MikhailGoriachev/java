<%@ page import="org.homework.app.utils.Utils" %>
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
    <title>Ввод данных устройства</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<% request.setAttribute("task03Active", true); %>
<jsp:include page="../layout/header.jsp"/>

<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">Ввод данных устройства</h4>

        <form action="task03" method="post">

            <!-- Тип устройства -->
            <div class="form-floating my-3">
                <select class="form-select" name="type" id="type" required>
                    <option>планшет</option>
                    <option>компьютер</option>
                    <option>ноутбук</option>
                    <option>умные часы</option>
                </select>
                <label class="form-label" for="type">Тип устройства</label>
            </div>
            
            <!-- Производитель -->
            <div class="form-floating my-3">
                <input class="form-control" name="manufacture" id="manufacture" type="text"
                       value="<%= Utils.getItem(Utils.manufactureList) %>" required/>
                <label class="form-label" for="manufacture">Производитель:</label>
            </div>

            <!-- Год выпуска -->
            <div class="form-floating my-3">
                <input class="form-control" name="year" id="year" type="number" min="1970"
                       value="<%= Utils.getInt(2015, 2022) %>" required/>
                <label class="form-label" for="year">Год выпуска:</label>
            </div>
            
            <!-- Операционная система -->
            <div class="form-floating my-3">
                <select class="form-select" name="system" id="system" required>
                    <option>Windows 11</option>
                    <option>Windows 10</option>
                    <option>Windows 8.1</option>
                    <option>Windows 8</option>
                    <option>Windows 7</option>
                    <option>Android 13</option>
                    <option>Android 12</option>
                    <option>Android 11</option>
                    <option>Linux</option>
                </select>
                <label class="form-label" for="system">Операционная система</label>
            </div>

            <!-- Цена -->
            <div class="form-floating my-3">
                <input class="form-control" name="price" id="price" type="number" min="1"
                       value="<%= Utils.getInt(20, 30) * 100 %>" required/>
                <label class="form-label" for="year">Цена:</label>
            </div>

            <div class="mt-5 text-center">
                <input class="btn btn-primary w-10rem me-2" type="submit" value="Добавить">
                <a class="btn btn-secondary w-10rem" href="task03">Назад</a> 
            </div>
        </form>
    </section>
</div>

<!-- #endregion Контент -->
<jsp:include page="../layout/footer.jsp"/>

</body>
</html>