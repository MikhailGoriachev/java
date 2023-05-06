<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<% request.setAttribute("title", "Запрос 1"); %>
<jsp:include page="../../layout/head.jsp"/>
<body>

<% request.setAttribute("queriesActive", true); %>
<jsp:include page="../../layout/navigation.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

    <form method="post">
        <div class="row">
            <div class="col-2">
                <div class="form-floating">
                    <input type="text" name="startSurname" class="form-control" placeholder=" " value="<?= $value ?>"
                           required>
                    <label class="form-label">Фамилия</label>
                </div>
            </div>
            <div class="col my-auto">
                <button class="btn btn-success my-auto" type="submit">Выбрать</button>
                <a class="btn btn-warning my-auto <?= empty($value) ? 'disabled' : '' ?>"
                   href="/pages/task02/queries/proc01.php">Сброс</a>
            </div>
        </div>
    </form>

    <h4 class="text-center">Запрос 01</h4>

    <%= request.getAttribute("data") %>

</section>

<jsp:include page="../../layout/footer.jsp"/>

</body>
</html>