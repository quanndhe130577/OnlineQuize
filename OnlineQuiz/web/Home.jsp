<%-- 
    Document   : Home
    Created on : Feb 5, 2020, 9:30:30 PM
    Author     : quanh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--login-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String username = String.valueOf(request.getSession().getAttribute("username"));
            String error_account = String.valueOf(request.getSession().getAttribute("error_account"));
        %>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <c:if test="${username ne null}}"> <h4>Register success</h4></c:if>
        <c:if test="${error_account ne null}"> <h4>Username has not existed or password is wrong</h4></c:if>
        <h1 style="color: blue">Login</h1>
        <form action="Login" method="POST">
            <div>
                <h4>User Name : </h4> 
                <input type="text" name="username" required="true"
                       <c:if test="${username eq null}">
                           placeholder="Input your username"
                       </c:if>
                       <c:if test="${username ne null}">
                            value="<%=username%>"
                       </c:if>
                       >
            </div>
            <div>
                <h4>Password : </h4> 
                <input type="password" required="true" name="password" placeholder="Input your password">
            </div>
            <br>
            <input type="submit" value="Sign In" >
            <a href="Register.jsp">Register</a>
        </form>
        <%
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("error_account");
        %>
    </body>
</html>
