<%-- 
    Document   : index
    Created on : 24.10.2013, 10:24:26
    Author     : Александр
--%>

<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="operation" scope="session" class="model.Operation">
    <jsp:setProperty name="operation" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" type="text/css" rel="stylesheet"> 
    </head>
    <body>
        <h1><center>oAuth</center></h1>
        <table width="489" border="0">
            <tr>
                <td width="152">
                    <div class="general_menu">
                        <ul><a href="index.jsp">Главная</a></ul>
                        <ul><a href="search.jsp">Поиск</a></ul>
                        <ul><a href="add.jsp">Добавление</a></ul>
                        <ul><a href="change.jsp">Изменение</a></ul>
                        <ul><a href="erase.jsp">Удаление</a></ul>
                        <ul><a href="http://www.facebook.com/dialog/oauth?client_id=708635192499906&redirect_uri=http://localhost:8084/by.bsuir.aipos.oauth&scope=email">facebook</a></ul>
                    </div>
                </td>
                <td width="327">
                    <b>Список описанных понятий:</b>
                    <br>
                    <div class="concept_list">
                        <%
                            List<String> list = operation.getAllConcepts();
                            for (int i = 0; i < list.size(); i++) {
                        %>           
                        <ul><%=list.get(i)%></ul>
                        <%}%>

                    </div>

                </td>
            </tr>
        </table>
    </body>
</html>
