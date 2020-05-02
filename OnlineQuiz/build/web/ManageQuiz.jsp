<%-- 
    Document   : ManageQuiz
    Created on : Feb 5, 2020, 10:16:30 PM
    Author     : quanh
--%>

<%@page import="model.Question_Time"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        ArrayList<Question_Time> list = ArrayList.class.cast(request.getSession().getAttribute("question_time"));
    %>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <h3>Number of question : <%=list.size()%> </h3>
        <table>
            <tr>
                <td style="width: 80%"><strong>Question</strong></td>
                <td><strong>DateCreated</strong></td>
            </tr>
            <%for(Question_Time q : list){%>
                <tr>
                    <td><%=q.getQuestion()%></td>
                    <td><%=q.toString()%></td>
                </tr>
            <%}%>
        </table>
</body>
</html>
