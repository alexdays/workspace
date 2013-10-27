<%-- 
    Document   : content
    Created on : 21.10.2013, 12:01:42
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="jservlet" scope="session" class="servlets.JServlet">
    <jsp:setProperty name="jservlet" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concept content page</title>
    </head>
    <body>
        <div>
            <ul><h1>${name}</h1></ul>
            <ul>${content}</ul>
        </div>
        <br>
        <a href="index.jsp">На главную</a>
    </body>
</html>
