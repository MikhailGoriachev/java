<%-- директива @page JSP (Java Server Page) для задания кодировки при рендеринге страницы --%>
<%@page contentType='text/html' pageEncoding='UTF-8'%> 

<%-- блок кода Java --%>
<%
String header = "Привет, Apache Tomcat";
%>
<!DOCTYPE html>
<!-- 
    это пример Java Server Page, разместите ее в подпапке ROOT папки, 
	в которую установлен Tomcat 
	(не забудбьте сохранить index.jsp, котьорый входит в комплект поставки Tomcat)
-->
<html>
    <head>
        <meta charset="UTF-8" />
        <title>First JSP App</title>
    </head>
    <body>
		<%-- выражение JSP --%>
        <h2><%= header %></h2>
        <p>Today: <%= new java.util.Date() %></p>
		<hr/>
		<p><a href='index.html'>На главную</a></p>
		<hr/>
		<h4>JSP index.jsp</h4>
    </body>
</html>