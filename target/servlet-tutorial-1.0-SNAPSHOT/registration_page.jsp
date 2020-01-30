<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 24.01.2020
  Time: 13:57
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h1>SIGN UP</h1>
<form action="<%= request.getContextPath() %>/signUp" method="post">
    <table style="width: 50%">
        <tr>
            <td>login</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/>
</form>

<hr/>

<h1>SIGN IN</h1>
<form action="<%= request.getContextPath() %>/signIn" method="post">
    <table style="width: 50%">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        <tr>
            <td>Confirm password</td>
            <td><input type="password" name="confirmPassword"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/>
</form>
<hr/>
&lt;%&ndash;<p><a href="managerPage">Sign up like Manager</a></p>&ndash;%&gt;
&lt;%&ndash;<p><a href="masterPage">Sign up like Master</a></p>&ndash;%&gt;
</body>
</html>--%>
