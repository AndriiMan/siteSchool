<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Log in</title>
</head>

<body>

<div style="text-align: center;">
    <h3>Login Here</h3>

    <form action="<c:url value="/Controllers/SignInController/sign_in_controller.jsp"/>" , method="post" >
        Enter User Login
        <input type="text" name="login"> <br>
        Enter Password
        <input type="password" name="password"><br>
        <input type="submit" value="Submit">
    </form>
    <%
        String message=(String)session.getAttribute("login_message");
        if(message!=null){
            out.println(message);
            //to delete message
            session.removeAttribute("login_message");
        }
    %>
</div>
</body>
