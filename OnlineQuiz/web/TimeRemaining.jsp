<%-- 
    Document   : TimeRemaining
    Created on : Feb 26, 2020, 10:09:55 PM
    Author     : quanh
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
//        int number_of_question = Integer.parseInt(String.valueOf(request.getSession().getAttribute("number_of_question")));
    %>
    <body>
        <h4>Time remaining :<strong id="count_down" style="padding-left: 10px"></strong></h4>
        <script>
            var time_end = <%=request.getSession().getAttribute("time_end")%>;
            function count_down() { 
                var time_now = new Date().getTime();
                if(time_now > time_end) window.location.href = "Result.jsp";
                var sub = time_end - time_now;
                var sec = parseInt(sub/1000);
                var min = parseInt(sec/60);
                sec = sec - min*60;
                document.getElementById("count_down").innerHTML = min + " : " + sec;
                setTimeout("count_down()", 1000); 
            }
            count_down();
        </script>
    </body>
</html>
