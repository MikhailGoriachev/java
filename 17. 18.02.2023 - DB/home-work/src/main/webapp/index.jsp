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
<jsp:include page="layout/navigation.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">
    <div>
        <button class="btn btn-outline-primary my-2" data-bs-toggle="collapse" href="#collapseTheory" role="button"
                aria-expanded="false"
                aria-controls="collapseTheory">
            <span class="h5">Теоретическая часть</span>
        </button>
        <div class="collapse show" id="collapseTheory">
            <ul>
                <li>Зависимость для подключения к базе данных</li>
                <li>Вспомогательные классы для подключения к базе данных</li>
                <li>Выполнение CRUD-операций с таблицами базы данных</li>
                <li>Обзор возможностей Spring</li>
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
                Разработайте веб-приложение Java для закрепления навыков программирования работы с базами данных в
                Jakarta. Параметры запросов вводите в формах.
            </p>

            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>База данных «Платный прием в поликлинике»</td>
                </tr>
                <tr>
                    <td>Описание предметной области</td>
                </tr>
                <tr>
                    <td>Платный прием пациентов (консультации специалистов) проводится врачами разных специальностей
                        (хирург, терапевт, кардиолог, офтальмолог и т.д.). Несколько врачей могут иметь одну и ту же
                        специальность. При оформлении приема должна быть сформирована квитанция об оплате приема, в
                        которой указывается информация о пациенте, о враче, который консультирует пациента, о
                        стоимости приема, о дате приема.
                    </td>
                </tr>
                <tr>
                    <td>Пациент оплачивает за прием некоторую сумму, которая устанавливается персонально для каждого
                        врача. За каждый прием врачу отчисляется фиксированный процент от стоимости приема. Процент
                        отчисления от стоимости приема на зарплату врача также устанавливается персонально для
                        каждого врача.
                    </td>
                </tr>
                <tr>
                    <td>Размер начисляемой врачу заработной платы за каждый прием вычисляется по формуле: Стоимость
                        приема * Процент отчисления от стоимости приема на зарплату врача. Из этой суммы вычитается
                        подоходный налог, составляющий 13% от суммы.
                    </td>
                </tr>
                <tr>
                    <td>База данных должна включать как минимум таблицы ВРАЧИ, ПАЦИЕНТЫ, ПРИЕМ, содержащие следующую
                        информацию:
                    </td>
                </tr>
                <tr>
                    <td>Фамилия врача</td>
                </tr>
                <tr>
                    <td>Имя врача</td>
                </tr>
                <tr>
                    <td>Отчество врача</td>
                </tr>
                <tr>
                    <td>Специальность врача</td>
                </tr>
                <tr>
                    <td>Стоимость приема</td>
                </tr>
                <tr>
                    <td>Процент отчисления от стоимости приема на зарплату врача</td>
                </tr>
                <tr>
                    <td>Фамилия пациента</td>
                </tr>
                <tr>
                    <td>Имя пациента</td>
                </tr>
                <tr>
                    <td>Отчество пациента</td>
                </tr>
                <tr>
                    <td>Дата рождения пациента</td>
                </tr>
                <tr>
                    <td>Адрес пациента</td>
                </tr>
                <tr>
                    <td>Дата приема</td>
                </tr>
                </tbody>
            </table>

            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th colspan="3">ЗАПРОСЫ</th>
                </tr>
                <tr>
                    <th>Номер запроса</th>
                    <th>Тип запроса</th>
                    <th>Какую задачу решает запрос</th>
                </tr>

                <tr>
                    <td>1</td>
                    <td>Запрос с параметрами</td>
                    <td>
                        Выбирает информацию о пациентах с фамилиями, начинающимися на заданную последовательность
                        символов
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Запрос с параметрами</td>
                    <td>Выбирает информацию о приемах за некоторый период</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Запрос с параметрами</td>
                    <td>Выбирает из таблицы информацию о врачах с заданной <b>специальностью</b></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Запрос с вычисляемыми полями</td>
                    <td>
                        Вычисляет размер заработной платы врача за каждый прием. Включает поля <b>Фамилия врача, Имя
                        врача, Отчество врача, Специальность врача, Стоимость приема, Зарплата</b>. Сортировка
                        по полю <b>Специальность врача</b>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Итоговый запрос</td>
                    <td>
                        Выполняет группировку по полю <b>Дата приема</b>. Для каждой даты вычисляет максимальную
                        стоимость приема
                    </td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>Итоговый запрос</td>
                    <td>
                        Выполняет группировку по полю <b>Специальность</b>. Для каждой специальности вычисляет
                        средний Процент отчисления на зарплату от стоимости приема
                    </td>
                </tr>
                </tbody>
            </table>
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
                    <a href="https://cloud.mail.ru/public/nBgk/Hrk9g8rNe" target="_blank">по этой ссылке</a>,
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