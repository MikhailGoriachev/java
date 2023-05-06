<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ввод данных цилиндра</title>
    <meta charset="utf-8">
</head>
<body>
<br>
<h3>Форма ввода параметров цилиндра</h3>
<form action="task02" method="post">
    <label for="height">Высота:</label> <input name="height" id="height" type="number" min="0" step="any"/>
    <br><br>
    <label for="radius">Радиус:</label> <input name="radius" id="radius" type="number" min="0" step="any"/>
    <br><br>
    <br><br>

    <label for="material">Материал</label>
    <select name="material" id="material">
        <option>медь</option>
        <option>сталь</option>
        <option>базальт</option>
        <option>лёд</option>
    </select>
    <br><br>
    
    Вид расчёта:
    <!-- Массив данных -->
    <label>
        <input type="checkbox" name="calculate_params" value="area" checked />
        Площадь
    </label>

    <label>
        <input type="checkbox" name="calculate_params" value="volume" checked />
        Объём
    </label>

    <label>
        <input type="checkbox" name="calculate_params" value="mass" checked />
        Масса
    </label>

    <br><br>
    <input type="submit" value="Вычислить параметры" />

    <p><a href="index.jsp">На главную</a></p>
</form>
</body>
</html>
