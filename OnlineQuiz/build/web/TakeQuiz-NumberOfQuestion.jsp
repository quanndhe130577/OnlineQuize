<%-- 
    Document   : TakeQuiz-NumberOfQuestion
    Created on : Feb 5, 2020, 9:50:50 PM
    Author     : quanh
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String username = String.valueOf(request.getSession().getAttribute("username"));
        Account a = Account.class.cast(request.getSession().getAttribute("account"));
    %>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <form action="TakeQuiz" method="POST">
            <h3>Welcome <span style="color: blue"><%=a.getUsername()%></span></h3>
            <h4>Enter number of question : </h4>
            <input type="number" name="number_of_question" required="true">
            <br><br>
            <input type="submit" value="Start">
        </form>
    </body>
</html>
