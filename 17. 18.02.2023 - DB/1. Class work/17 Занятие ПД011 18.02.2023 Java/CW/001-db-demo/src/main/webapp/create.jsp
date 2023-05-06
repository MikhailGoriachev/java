<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create product</title>
  <link rel="stylesheet" href="./resources/style.css">
</head>
<body>
<h3>Новый товар</h3>
<!-- форма передает данные get-запросом на create - этот запрос перехватывает одноименный сервлет
-->
<form method="post" action="create">
  <label>Наименование</label><br>
  <input name="name"/><br><br>
  <label>Цена</label><br>
  <input name="price" type="number" min="1" />
  <br><br>
  <input type="submit" value="Создать" />
  <a href='<c:url value="/index-servlet" />'>На главную</a>
</form>

</body>
</html>