<%-- 
    Document   : SupDoQues
    Created on : Feb 26, 2020, 7:03:06 PM
    Author     : quanh
--%>

<%@page import="model.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Question> list_question = ArrayList.class.cast(request.getSession().getAttribute("list_question"));
        %>
    </head>
    <body>
        <form action="CheckQuestion" method="POST">
            <h3><%=list_question.get(0).getQuestion()%></h3>
            <input type="checkbox" name="option1" value="1" ><%=list_question.get(0).getOption_1()%><br>
            <input type="checkbox" name="option2" value="2"  ><%=list_question.get(0).getOption_2()%><br>
            <input type="checkbox" name="option3" value="3"  ><%=list_question.get(0).getOption_3()%><br>
            <input type="checkbox" name="option4" value="4"  ><%=list_question.get(0).getOption_4()%><br>
            <br><input type="submit" value="Next">
        </form>
    </body>
</html>
