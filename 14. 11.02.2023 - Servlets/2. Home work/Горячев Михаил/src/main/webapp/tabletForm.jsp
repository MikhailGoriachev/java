<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Добавление устройства</title>
    <meta charset="utf-8">
</head>
<body>
<br>
<h3>Форма ввода устройства</h3>
<form action="task03-form" method="post">
    <label for="type">Тип</label>
    <select name="type" id="type">
        <option>планшет</option>
        <option>компьютер</option>
        <option>ноутбук</option>
        <option>умные часы</option>
    </select>
    <br><br>

    <label for="manufacture">Производитель</label>
    <select name="manufacture" id="manufacture">
        <option>LG</option>
        <option>Sony</option>
        <option>Lenovo</option>
        <option>Samsung</option>
    </select>
    <br><br>

    <label for="year">Год выпуска:</label>
    <input name="year" id="year" type="number" min="2000"/>
    <br><br>

    <label for="system">Операционная система</label>
    <select name="system" id="system">
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
    <br><br>

    <label for="price">Цена:</label>
    <input name="price" id="price" type="number" min="2000"/>

    <br><br>
    <input type="submit" value="Добавить"/>

    <p><a href="index.jsp">На главную</a></p>
</form>
</body>
</html>
