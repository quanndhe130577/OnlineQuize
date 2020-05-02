<%-- 
    Document   : Register
    Created on : Feb 5, 2020, 9:51:59 PM
    Author     : quanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <h1>Registration Form</h1>
        <form action="Register" method="POST">
            <table>
                <tr>
                    <td>User Name : </td>
                    <td><input type="text" required="true" name="res_username"></td>
                </tr>
                <tr>
                    <td>Password : </td>
                    <td><input type="password" required="true" name="res_password"></td>
                </tr>
                <tr>
                    <td>User Type : </td>
                    <td>
                        <select name="type">
                            <option value="1">Teacher</option>
                            <option value="0">Student</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Email : </td>
                    <td><input type="text"  required="true" name="res_email"></td>
                </tr>
            </table>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
