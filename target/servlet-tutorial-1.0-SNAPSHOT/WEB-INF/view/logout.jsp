<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.01.2020
  Time: 20:01
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log out</title>
</head>
<body>
<%
    session.invalidate();
%>

<%out.println("You are successfully log out");%>
<%out.println("Tap to home");%>
<button onclick="location.href='/Project_war/home'">Home</button>
&lt;%&ndash;<jsp:forward page="mainPage.jsp"/>&ndash;%&gt;
</body>
</html>
--%>
