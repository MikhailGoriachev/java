<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:import url="layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="indexActive" value="active" scope="request"/>
<c:set var="title" value="Главная" scope="request"/>
<c:import url="layout/navigation.jsp"/>

<!-- Контент -->
<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <div>
        <button class="btn btn-outline-primary my-2" data-bs-toggle="collapse" href="#collapseTheory" role="button"
                aria-expanded="false"
                aria-controls="collapseTheory">
            <span class="h5">Теоретическая часть</span>
        </button>
        <div class="collapse show" id="collapseTheory">
            <ul>
                <li>Подключение статических ресурсов на JSP-страницу при помощи JSTL-тегов Spring</li>
                <li>Передача данных в представление</li>
                <li>Вывод переданных данных средствами выражений JSP, скриплетов JSP</li>
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
                Разработайте <b>Spring MVC</b> приложение с единственным контроллером и набором методов действий.
                Выполните стилизацию страниц. Обработанные данные передавайте в представления для отображения Методы
                должны вызывать следующие представления:
            </p>

            <ul>
                <li>
                    <b>Главная страница</b> – запросы методов действия для переходов на остальные страницы, вывод этого
                    задания
                </li>
                <li>
                    <b>Дата и время</b> – текущие дата и время на сервере передаются в JSP-страницу, а количество полных
                    дней, прошедших с начала года (используйте класс <b>Duration</b>)
                </li>
                <li>
                    <b>Цилиндры</b> – по запросу формировать коллекцию цилиндров равного размера, но из разных
                    материалов (медь, сталь, базальт, водяной лед) вычислить площадь поверхности, объем, массу. Вывести
                    исходные данные, изображение материала (или самого цилиндра) и результаты расчета в JSP-страницу.
                </li>
                <li>
                    <b>Гаджеты</b> – выводить в JSP-страницу с коллекцией сведений о гаджетах (тип, производитель, год
                    выпуска, операционная система, цена). Можно использовать не использовать бин для коллекции, просто
                    статическое поле в классе контроллера. Иниицилизация коллекции – также в классе контроллера. По
                    ссылкам на JSP-странице требуется упорядочивать коллекцию гаджетов:
                    <ul>
                        <li>По убыванию цены</li>
                        <li>По типу</li>
                        <li>По производителю</li>
                    </ul>
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
                    <a href="https://cloud.mail.ru/public/XpLV/uEH4HVyKE" target="_blank">по этой ссылке</a>,
                    материалы занятия – в этом же архиве.
                </p>
            </div>
        </div>
    </div>
    <!-- #endregion -->
</section>

<!-- Подвал -->
<c:import url="layout/footer.jsp"/>

</body>
</html>