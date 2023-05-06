<%--
  Вывод данных студента
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<h1>Детальная информация о студенте</h1>
<ul>
  <li>Фамилия: <b>${student.surname}</b></li>
  <li>Имя: <b>${student.name}</b></li>
  <li>Возраст (полных лет): <b>${student.age}</b></li>
  <li>Группа: <b>${student.group}</b></li>
  <li>Основное увлечение: <b>${student.hobby}</b></li>
  <li>Владение иностранным языком: <b>${student.foreignLanguage?"Да":"Нет"}</b></li>
  <li>Фитнес: <b>${student.workout?"Да":"Нет"}</b></li>
  <li>Нуждается в паркинге: <b>${student.hasCar?"Да":"Нет"}</b></li>
</ul>

<%-- подключение шаблона нижней части страницы --%>
<c:import url="layout/footer.jsp"/>