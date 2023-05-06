<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<!-- Заголовки -->
<c:set var="title" value="Главная" scope="request"/>
<c:import url="layout/head.jsp"/>

<body>

<!-- Навигация -->
<c:set var="indexActive" value="active" scope="request"/>
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
                <li>Еще раз о <b>REST</b>, <b>RESTful</b></li>
                <li>
                    Зависимости для формирования XML и JSON выходных данных методов действия <b>REST</b>-контроллера
                </li>
                <li>Построение <b>REST</b>-контроллера в Spring MVC</li>
                <li>Аннотации для <b>REST</b>-контроллера, методов действия</li>
                <li>Получение параметров в методы действия <b>REST</b>-контроллера</li>
                <li>
                    Настройка методов действия на <b>REST</b>-запросы <b>GET</b>, <b>PUT</b>, <b>POST</b>, <b>DELETE</b>
                </li>
                <li>Задание формата выходных данных в аннотации метода действия</li>
                <li>
                    Использование <a href="https://www.postman.com/downloads/">Postman</a> для формирования
                    <b>REST</b>-запросов
                </li>

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

            <p>
                Это итоговое задание по курсу Java, в нем <b><i>не требуется реализовывать REST-контроллер</i></b>.
                Задание с использованием <b>REST</b> (мини-курсовая работа) будет выдано позже.
            </p>

            <p>
                Разработайте базу данных <b>MySQL</b> и <b>Spring MVC</b> приложение, работающее с базой данных с
                использованием <b>Spring Data</b>. Приложение должно выполнять запросы по заданию. Все таблицы должны
                быть инициированы не менее чем 10 записями.
            </p>

            <p>
                По навигационным ссылкам выводите все таблицы базы данных с расшифровкой. Не используйте представления,
                используйте связанные свойства сущностей <b>Spring Data</b>.
            </p>

            <table class="table table-bordered table-striped w-75 mx-auto">
                <tbody>
                <tr>
                    <td>
                        <p>База данных <b>«Туристическое агентство»</b></p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>
                            <b>Описание предметной области</b>
                        </p>
                        <p>
                            Фирма предоставляет клиентам услуги по организации зарубежных поездок. При этом цели поездок
                            могут быть различными (отдых, туризм, лечение и т.д.). При оформлении услуги устанавливается
                            фиксированная стоимость 1 дня пребывания в той или иной стране.
                        </p>
                        <p>
                            Стоимость поездки может быть вычислена как <b>Стоимость 1 дня пребывания * Количество дней
                            пребывания + Стоимость транспортных услуг + Стоимость оформления визы</b>. Кроме того,
                            клиент платит налог на добавленную стоимость (НДС) в размере 3% от стоимости поездки.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>
                            <b>
                                База данных должна включать как минимум таблицы КЛИЕНТЫ, МАРШРУТЫ, ПОЕЗДКИ, содержащие
                                следующую информацию:
                            </b>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Фамилия клиента</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Имя клиента</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Отчество клиента</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Серия – номер паспорта клиента</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Страна назначения</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Цель поездки</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Стоимость 1 дня пребывания в стране назначения</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Стоимость транспортных услуг (определяется выбором страны)</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Стоимость оформления визы (определяется выбором страны)</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Дата начала пребывания в стране назначения</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Количество дней пребывания в стране назначения</p>
                    </td>
                </tr>
                </tbody>
            </table>

            <table class="table table-striped table-bordered align-middle w-75 mx-auto">
                <thead>
                <tr>
                    <th>Номер запроса</th>
                    <th>Тип запроса</th>
                    <th>Какую задачу решает запрос</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>1</td>
                    <td>Запрос на выборку</td>
                    <td>Выбирает информацию о маршрутах с заданной целью поездки</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Запрос на выборку</td>
                    <td>
                        Выбирает информацию о маршрутах с заданной целью поездки и стоимостью транспортных услуг менее
                        заданного значения
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Запрос на выборку</td>
                    <td>
                        Выбирает информацию о клиентах, совершивших поездки с заданным количеством дней пребывания в
                        стране
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Запрос на выборку</td>
                    <td>
                        Выбирает информацию о маршрутах в заданную страну
                    </td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>Запрос на выборку</td>
                    <td>
                        Выбирает информацию о странах, для которых стоимость оформления визы есть значение из некоторого
                        диапазона
                    </td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>Запрос на выборку</td>
                    <td>
                        Вычисляет для каждой поездки ее полную стоимость с НДС. Включает поля <b>Страна назначения, Цель
                        поездки, Дата начала поездки, Количество дней пребывания, Полная стоимость поездки</b>.
                        Сортировка по полю <b>Страна назначения</b>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>Итоговый запрос – агрегатные функции</td>
                    <td>
                        Выполняет группировку по полю <b>Цель поездки</b>. Определяет минимальную, среднюю и
                        максимальную стоимость 1 дня пребывания
                    </td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>Итоговый запрос – агрегатные функции</td>
                    <td>
                        Выполняет группировку по полю <b>Страна назначения</b>. Для каждой страны вычисляет среднее
                        значение по полю <b>Стоимость транспортных услуг</b>
                    </td>
                </tr>
                </tbody>
            </table>

            <p>
                Для всех таблиц требуется реализовать операции добавления и изменения, для таблицы <b>ПОЕЗДКИ</b>
                требуется также реализовать операцию удаления записей.
            </p>
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
                    <a href="https://cloud.mail.ru/public/fPRP/nz1eH8Yvj" target="_blank">по этой ссылке</a>,
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