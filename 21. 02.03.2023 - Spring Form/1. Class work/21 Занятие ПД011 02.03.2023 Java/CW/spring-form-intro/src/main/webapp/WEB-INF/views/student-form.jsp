<%--
  Форма ввода данных студента
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- подключение шаблона верхней части страницы --%>
<c:import url="layout/header.jsp"/>

<h1>Ввод данных студента</h1>
<%-- srtudent/addStudent --%>
<form:form action="addStudent" mode="post" modelAttribute="student">
    <label>Фамилия:</label> <form:input path="surname"/> <br> <br>
    <label>Имя:</label> <form:input path="name"/> <br> <br>
    <label>Возраст:</label>  <form:input path="age"/> <br> <br> <br>

    <label>Группа:</label> <form:select path="group">
        <form:option value="ПД011" label="ПД011"/>
        <form:option value="CПД021" label="CПД021"/>
        <form:option value="ПУ021" label="ПУ021"/>
        <form:option value="ВПД011" label="ВПД011"/>

        <%-- полукение списка знаений из поля groups - такое поле можно создать во ViewModel для Student --%>
        <%-- <form:options items="${student.groups}"/> --%>
     </form:select>
    <br> <br> <br>

    <label>Основное увлечение: <br>
        <form:radiobutton path="hobby" value="чтение"/> чтение<br>
        <form:radiobutton path="hobby" value="туризм"/> туризм <br>
        <form:radiobutton path="hobby" value="театр"/> театр <br>
        <form:radiobutton path="hobby" value="кино"/> кино <br>
    </label>
    <br> <br>

    <label><form:checkbox path="foreignLanguage"/>Владение иностранным языком</label> <br> <br>
    <label><form:checkbox path="workout" />Фитнес</label><br> <br>
    <label><form:checkbox path="hasCar" /> Нуждается в паркинге</label><br> <br>
    <br> <br>

    <input type="submit" value="Добавить"/>
</form:form>

<%-- подключение шаблона нижней части страницы --%>
<c:import url="layout/footer.jsp"/>
