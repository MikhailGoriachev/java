<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<% request.setAttribute("title", "Пациенты"); %>
<jsp:include page="../../layout/head.jsp"/>
<body>

<% request.setAttribute("tablesActive", true); %>
<jsp:include page="../../layout/navigation.jsp"/>

<section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

    <h4 class="text-center">Пациенты</h4>

    <%= request.getAttribute("data") %>

</section>

<jsp:include page="../../layout/footer.jsp"/>

</body>
</html>