<!-- директива  -->
<%-- Первое приложение на JSP --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>

<%!
    // Декларация/объявление - для использования метода/методов на странице
    int square(int n){
        return n * n;
    }
%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>JSP - Java Server Pages</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

    <!-- Навигация по приложению -->
    <nav>
        <a href="hello-servlet">Сервлет :)</a>|
        <a href="java_classes_in_jsp.jsp">Использование классов Java в JSP</a>|
        <a href="demo_layouts.jsp">Вложение JSP-страниц, шаблоны страниц</a>|
        <a href="get_request_param.jsp?name=Василий Леонов&age=33&salary=35000&city=Амвросиевка">Параметры в строке запроса</a>|
        <a href="simple_form.html">Простая форма</a>|
        <a href="complex_form.html">Сложная форма</a>|
        <a href="send_to_jsp.html">Передача данных из сервлета в JSP-страницу</a>|
        <a href="сomplex-object-servlet">EL: Передача сложных данных в JSP-страницу</a>|
    </nav>

<!-- JSP Expression, примеры использования -->
<h1><%= "Основы синтаксиса JSP" %></h1>
<p>2 + 2 = <%= 2 + 2 %></p>
<p>5 > 2 = <%= 5 > 2 %></p>
<p><%= "Hello".toUpperCase() %></p>
<p>Today <%= new java.util.Date() %></p>
<br/>

<ul>
<!-- JSP скриплет -->
<%
    for(int i = 1; i <= 5; i++){
        out.println(String.format("<li>Hello %d</li>", i));
    }
%>
</ul>

<%-- Еще один пример скриплета, с объявлением переменных --%>
<%
    String header = "Users list";
    String[] people = new String[]{"Tom", "Bob", "Sam"};
    String str;
%>

<h3><%= header %></h3>
<ul>
    <%-- скриплет для вывода массива   --%>
    <%
        for(String person: people){
            out.println(String.format("<li>%s</li>", person));
        }
    %>
</ul>

<!--  применение метода, объявленного в декларации в начале страницы  -->
<p>Шесть в квадрате будет <%= square(6) %></p>
<ul>
    <%
        for(int i = 1; i <= 5; i++){
            str = String.format("<li>%d --> %s</li>", i, square(i));
            out.println(str);
        }
    %>
</ul>

<%-- демо вложенной страницы, в данном случае это футер для страницы --%>
<jsp:include page="layouts/footer.jsp"/>
</body>
</html>