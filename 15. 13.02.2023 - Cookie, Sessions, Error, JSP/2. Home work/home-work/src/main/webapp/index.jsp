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
    <title>Домашнее задание</title>

    <!-- логотип -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/icon.svg">

</head>
<body>

<% request.setAttribute("indexActive", true); %>
<jsp:include page="layout/header.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <div>
        <button class="btn btn-outline-primary my-2" data-bs-toggle="collapse" href="#collapseTheory" role="button"
                aria-expanded="false"
                aria-controls="collapseTheory">
            <span class="h5">Теоретическая часть</span>
        </button>
        <div class="collapse show" id="collapseTheory">
            <ul>
                <li>Обработка ошибок сервлетов, роль файла web.xml в назначении обработчика ошибок</li>
                <li>Куки и сессии</li>
                <li>Вызов JSP-страницы из сервлета</li>
                <li>Основы Expression Language для JSP-страниц</li>
                <li>Понятие о скриплетах в JSP-страницах</li>
                <li>Вложенные JSP-страницы (шаблоны кода)</li>
                <li>Обработка форм в JSP-страницах</li>
                <li>Передача параметров из сервлета в JSP-страницу – через контекст запроса</li>
            </ul>
        </div>
    </div>
    <!-- #endregion -->

    <!-- #region Практическая часть -->
    <div>
        <button class="btn btn-outline-primary my-2" data-bs-toggle="collapse" href="#collapsePractice"
                role="button" aria-expanded="false"
                aria-controls="collapsePractice">
            <span class="h5">Практическая часть</span>
        </button>

        <div class="collapse show" id="collapsePractice">

            <!-- #region Задание 1 -->
            <p>
                Разработайте веб-приложение из нескольких сервлетов, вызов сервлетов из JSP-файла, по ссылкам. Требуется
                назначить страницу обработки исключений, страницу обработки HTTP-ошибки с кодом 404.
            </p>

            <p>Сервлеты должны выполнять следующие действия (один сервлет – одно действие):</p>

            <ul>
                <li>
                    По <b>get</b>-запросу в странице HTML сервлет передает дату и время на сервере в JSP-страницу.
                    Записывать дату и время в куки с временем жизни 20 с. При наличии куки на клиенте выводить сообщение
                    с текстом «Еще рано, подождите, ничего не изменилось»
                </li>
                <li>
                    На странице JSP в форме вводить размеры цилиндра, его материал (медь, сталь, базальт, лед). Учтите,
                    что расширения номенклатуры материалов не будет. Выбирать чек-боксами вид расчета: площадь
                    поверхности, объем, масса. В сервлете обрабатывающем форму, вычислять запрошенные параметры,
                    передавать исходные данные и результаты расчета в JSP-страницу
                </li>
                <li>
                    По <b>get</b>-запросу к сервлету выводить в JSP-страницу коллекцию сведений о гаджетах (тип,
                    производитель, год выпуска, операционная система, цена). По клику на ссылку переходить на страницу
                    JSP с формой ввода данные о гаджете. В сервлете по post-запросу от формы добавить данные о гаджете в
                    коллекцию, отправлять клиенту JSP-страницу, передав в нее коллекцию для вывода.
                </li>
            </ul>
            <!-- #endregion -->
        </div>
    </div>
    <!-- #endregion -->

    <!-- #region Дополнительно -->
    <div>
        <div>
            <button class="btn btn-outline-primary my-2" data-bs-toggle="collapse" href="#collapseAdditionally"
                    role="button" aria-expanded="false"
                    aria-controls="collapseAdditionally">
                <span class="h5">Дополнительно</span>
            </button>

            <div class="collapse show" id="collapseAdditionally">
                <p>
                    Запись занятия можно скачать
                    <a href="https://cloud.mail.ru/public/JZry/tE2J2okUS" target="_blank">по этой ссылке</a>,
                    материалы занятия – в этом же архиве.
                </p>
            </div>
        </div>
    </div>
    <!-- #endregion -->
</section>

<!-- #endregion Контент -->
<jsp:include page="layout/footer.jsp"/>

</body>
</html>