<%-- 
    Document   : Header
    Created on : Feb 21, 2020, 11:05:53 AM
    Author     : quanh
--%>
<!--Include main links -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Account a = Account.class.cast(request.getSession().getAttribute("account"));
    %>
    <body>
        <table id="header">
            <tr id="header">
                <%if(a == null){%>
                    <td id="header"><a href="Home.jsp">Home</a></td>
                <%}else{%>
                    <%if (a.getType().equals("0")) {%>
                        <td id="header"><a href="TakeQuiz-NumberOfQuestion.jsp">Take Quiz</a></td>
                    <%} else {%>
                        <td id="header"><a href="MakeQuiz.jsp">Make Quiz</a></td>
                        <td id="header"><a href="ManageQuiz">Manage Quiz</a></td>
                    <%}%>
                    <td id="header"><a href="Logout">Logout</a></td>
                <%}%>
            </tr>
        </table>
    </body>
</html>
