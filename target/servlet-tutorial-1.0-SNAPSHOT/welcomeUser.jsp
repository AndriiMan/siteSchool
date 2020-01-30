<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>WelcomeUser</title>
</head>
<body>
<%
    request.getSession(false);
    if (session == null) { %>
<a href="http://localhost:8080/loginDemo/home.jsp"> Home</a>
<a href="http://localhost:8080/loginDemo/login.jsp"> Login</a>
<%
} else {
    // Already created.
%>
&lt;%&ndash;<a href="http://localhost:8080/loginDemo/logout.jsp"> Logout</a>&ndash;%&gt;
<button onclick="location.href='/Project_war/LogOut'">Log out</button>
<%
    }
    String login = request.getParameter("login");
%>
<br><br>
<%
    out.println("Welcome: "+login);
%>
</body>
</html>
--%>
