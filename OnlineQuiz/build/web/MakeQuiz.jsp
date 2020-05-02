<%-- 
    Document   : MakeQuiz
    Created on : Feb 5, 2020, 10:05:03 PM
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
        <br>
        <form action="MakeQuiz" method="POST">
            <table>
                <tr>
                    <td>Question : </td>
                    <!--<td><input type="text" name="question"></td>-->
                    <td><textarea cols="50" rows="8" name="question" placeholder="Input your quesiotn here"></textarea></td>
                </tr>
                <tr>
                    <td>Option 1 : </td>
                    <td><textarea cols="50" rows="3" name="option1"></textarea></td>
                </tr>
                <tr>
                    <td>Option 2 : </td>
                    <td><textarea cols="50" rows="3" name="option2"></textarea></td>
                </tr>
                <tr>
                    <td>Option 3 : </td>
                    <td><textarea cols="50" rows="3" name="option3"></textarea></td>
                </tr>
                <tr>
                    <td>Option 4 : </td>
                    <td><textarea cols="50" rows="3" name="option4"></textarea></td>
                </tr>
            </table>
            <div>
                <h4 style="float: left">Answer(s) : </h4><br>
                <table style="float: left">
                    <tr>
                        <td><input type="checkbox" name="ans_option_1" value="1" > Option 1</td>
                        <td><input type="checkbox" name="ans_option_2" value="2"> Option 2</td>
                        <td><input type="checkbox" name="ans_option_3" value="3" > Option 3</td>
                        <td><input type="checkbox" name="ans_option_4" value="4"> Option 4</td>
                    </tr>
                </table>
            </div>
            <br><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
