<%-- 
    Document   : Result
    Created on : Feb 18, 2020, 11:04:05 PM
    Author     : quanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        int number_of_question = Integer.parseInt(String.valueOf(request.getSession().getAttribute("number_of_question")));
        double rs = Double.parseDouble(String.valueOf(request.getSession().getAttribute("rs")));
    %>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <h1>Your score : <%=rs*10%> (<%=rs*100%>%)</h1>
        <c:if test="${rs*10 ge 5}"><h1 style="color: green"> - PASS</h1></c:if>
        <c:if test="${rs*10 lt 5}"><h1 style="color: red"> - FAILED</h1></c:if>
        <%
            request.getSession().removeAttribute("rs");
            request.getSession().removeAttribute("number_of_question");
        %>
        
        <h4>Take another test</h4>
        <form action="TakeQuiz-NumberOfQuestion.jsp">
            <input type="submit" value="Start">
        </form>
    </body>
</html>
