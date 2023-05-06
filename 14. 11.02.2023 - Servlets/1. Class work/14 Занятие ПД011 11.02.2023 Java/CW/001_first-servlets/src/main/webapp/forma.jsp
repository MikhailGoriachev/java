<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<h3>Форма ввода, редирект/форвардинг</h3>
<!-- get_form сервлет для ввода данных из формы -->
<form action="get-form" method="POST">
    Name: <input name="username" />
    <br><br>
    Age: <input name="userage" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Country:
    <select name="country">
    <option>Canada</option>
    <option>Spain</option>
    <option>France</option>
    <option>Germany</option>
    </select>
    <br><br>
    Courses:
    <!-- Массив данных -->
    <label>
        <input type="checkbox" name="courses" value="JavaSE" checked />
        Java SE
    </label>

    <label>
        <input type="checkbox" name="courses" value="JavaFX" checked />
        Java FX
    </label>

    <label>
        <input type="checkbox" name="courses" value="JavaEE" checked />
        Java EE
    </label>

    <br><br>
    <input type="submit" value="Отправить данные" />

    <!-- переход на главную страницу при помощи сервлета с редиректом -->
    <p><a href="forward-index">На главную - редирект</a></p>
</form>
</body>
</html>