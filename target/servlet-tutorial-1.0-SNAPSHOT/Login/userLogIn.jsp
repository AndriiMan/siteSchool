<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Log in</title>
</head>

<body>

<div style="text-align: center;">
    <h3>Login Here</h3>

    <form action="signUserController" method="post">
        Enter User Login
        <input type="text" name="login"> <br>
        Enter Password
        <input type="password" name="password"><br>
        <input type="submit" value="Submit">

        <%--Out message of problem with login--%>
        <h3>
            <c:out value="${loginUserMessage}"/>
        </h3>
    </form>


</div>
</body>
