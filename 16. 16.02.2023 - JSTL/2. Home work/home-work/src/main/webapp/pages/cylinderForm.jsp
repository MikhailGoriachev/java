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
    <title>Ввод данных цилиндра</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<% request.setAttribute("task02Active", true); %>
<jsp:include page="../layout/header.jsp"/>

<div class="min-vh-100">
    <section class="w-25 mx-auto my-4 bg-light shadow-sm border rounded-3 p-3">
        <h4 class="text-center mb-4">Ввод данных цилиндра</h4>

        <form action="task02" method="post">

            <!-- Высота -->
            <div class="form-floating my-3">
                <input class="form-control" name="height" id="height" type="number" min="0" step="any"
                       value="<%= String.format("%.4f", Utils.getDouble(5d, 10d)) %>"/>
                <label class="form-label" for="height">Высота:</label>
            </div>

            <!-- Радиус -->
            <div class="form-floating my-3">
                <input class="form-control" name="radius" id="radius" type="number" min="0" step="any"
                       value="<%= String.format("%.4f", Utils.getDouble(5d, 10d)) %>"/>
                <label class="form-label" for="radius">Радиус:</label>
            </div>

            <!-- Материал -->
            <div class="form-floating my-3">
                <select class="form-select" name="material" id="material">
                    <option>медь</option>
                    <option>сталь</option>
                    <option>базальт</option>
                    <option>лёд</option>
                </select>
                <label class="form-label" for="material">Материал</label>
            </div>

            <!-- Вид расчёта -->
            <div class="mt-3">
                <p>Вид расчёта:</p>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="area" name="calculate_params" value="area"
                           checked/>
                    <label class="form-check-label" for="area">Площадь</label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="calculate_params" id="volume" value="volume"
                           checked/>
                    <label class="form-check-label" for="volume">Объём</label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="calculate_params" id="mass" value="mass"
                           checked/>
                    <label class="form-check-label" for="mass">Масса</label>
                </div>
            </div>

            <div class="mt-5 text-center">
                <input class="btn btn-primary w-10rem me-2" type="submit" value="Вычислить">
                <input class="btn btn-secondary w-10rem" type="reset" value="Сброс">
            </div>
        </form>
    </section>
</div>

<!-- #endregion Контент -->
<jsp:include page="../layout/footer.jsp"/>

</body>
</html>