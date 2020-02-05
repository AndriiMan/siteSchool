<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 01.02.2020
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminLogin</title>
</head>
<body>

<div style="text-align: center;">
    <h3>Login Here</h3>
    <form action="signAdminController" method="post">
        Enter Admin Login
        <input type="text" name="login"> <br>
        Enter Password
        <input type="password" name="password"><br>
        <input type="submit" value="Submit">

        <%--Out message of problem with login--%>
         <h3>
             <c:out value="${loginAdminMessage}"/>
         </h3>
    </form>
</div>
</body>
</html>
