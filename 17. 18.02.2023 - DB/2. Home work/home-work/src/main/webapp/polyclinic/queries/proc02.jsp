<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<% request.setAttribute("title", "Запрос 2"); %>
<jsp:include page="../../layout/head.jsp"/>
<body>

<% request.setAttribute("queriesActive", true); %>
<jsp:include page="../../layout/navigation.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

    <form method="post">
        <div class="row">
            <div class="col-5">
                <div class="row">
                    <div class="col">
                        <div class="form-floating">
                            <input type="date" name="fromDate" class="form-control" placeholder=" "
                                   value="<?= $from ?>"
                                   required>
                            <label class="form-label">Мин. дата</label>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-floating">
                            <input type="date" name="toDate" class="form-control" placeholder=" " value="<?= $to ?>"
                                   required>
                            <label class="form-label">Макс. дата</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col my-auto">
                <button class="btn btn-success my-auto" type="submit">Выбрать</button>
                <a class="btn btn-warning my-auto <?= is_null($from) && is_null($to) ? 'disabled' : '' ?>"
                   href="/pages/task02/queries/proc03.php">Сброс</a>
            </div>
        </div>
    </form>

    <h4 class="text-center">Запрос 02</h4>

    <%= request.getAttribute("data") %>

</section>

<jsp:include page="../../layout/footer.jsp"/>

</body>
</html>