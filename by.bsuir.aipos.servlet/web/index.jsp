<%-- 
    Document   : index
    Created on : 18.10.2013, 21:06:28
    Author     : Александр
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<jsp:useBean id="operation" scope="session" class="model.Operation">
    <jsp:setProperty name="operation" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java manual service</title>
        <style>
            .concepts ul{
                background-color: lightblue;
                color: black;
                margin: 2px;
                padding: 0px;
            
            }
            .concepts ul:hover{
                background-color: lightcyan;
                color: black;
                margin: 2px;
                padding: 0px;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center;"> Java manual service</h1>
        <table border="1" align="center"> 
            <tr>
                <td width="150">
                    Founded concepts:<br>
                    <div class="concepts">
                        <%
                            List<String> list = operation.getAllConcepts();
                            for (int i = 0; i < list.size(); i++) {

                        %>           
                        <ul><%=list.get(i)%></ul>
                        <%}%>
                    </div>
                </td>
                <td>
                    <table border="1" cellpadding="1" cellspacing="1" style="width: 600px;" align ="center">
                        <tr>
                            <td>
                                <form name="searchform" method="GET" action="JServlet">
                                    Name:&nbsp;<input name="searchingName" type="text" />
                                    <input type="submit" value="Search" />
                                </form>
                            </td>
                            <td>
                                <form name="eraseform" method="POST" action="JServlet">
                                    Name:&nbsp;<input name="erasingName" type="text" />
                                    <input type="submit" value="Erase" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form name="addform" method="GET" action="CServlet">
                                    Name: &nbsp; &nbsp;<input name="addingName" type="text" /><br>
                                    Content:&nbsp;<textarea name="addingContent"></textarea><br>
                                    <input type="submit" value="Add concept" />
                                </form>
                            </td>
                            <td>
                                <form name="changeform" method="POST" action="CServlet">
                                    Name: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input name="changingName" type="text" /><br>
                                    New content:&nbsp;<textarea name="changingContent" style="margin: 2px; width: 199px; height: 64px;"></textarea><br>
                                    <input type="submit" value="Change content" />
                                </form>
                            </td>
                        </tr>

                    </table>
                </td>
            </tr>
        </table>

    </body>
</html>

