<%@ page import="org.itstep.pd011.models.Student" %><%--
  Прием сложных данных - массива объектов из сервлета ComplexObjectServlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
    <%-- Использование шаблонного файла --%>
    <jsp:include page="layouts/header.jsp" />

    <h3>Прием сложных данных из сервлета</h3>

    <%-- скриплет для вывода массива   --%>
    <h4>Выводим массив <u>в скриплете</u></h4>
    <%
        Student[] students = (Student[]) request.getAttribute("students");
        for(Student student: students){
            out.println(student.toHtmlList());
        }
    %>

    <%-- совсем уже лобовое решение, только для очень частных случаев :) --%>
    <h4>Выводим массив <u>жутким хардкодом</u></h4>
    <%= students[0].toHtmlList() %>
    <%= students[1].toHtmlList() %>
    <%= students[2].toHtmlList() %>

    <%-- Использование шаблонного файла --%>
    <jsp:include page="layouts/footer.jsp" />
</body>
</html>
