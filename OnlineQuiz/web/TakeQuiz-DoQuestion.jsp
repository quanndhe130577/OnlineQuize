<%-- 
    Document   : TakeQuiz-DoQuestion
    Created on : Feb 7, 2020, 10:55:13 PM
    Author     : quanh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Account acc = Account.class.cast(request.getSession().getAttribute("account"));  
    %>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <h3>Welcome <span style="color: blue"><%=acc.getUsername()%></span></h3>
        <jsp:include page="TimeRemaining.jsp"></jsp:include> 
        <jsp:include page="SupDoQues.jsp"></jsp:include>       
    </body>
</html>
