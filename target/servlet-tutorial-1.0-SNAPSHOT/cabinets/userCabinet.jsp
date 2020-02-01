<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UserCabinet</title>
</head>
<body>

<h3>
    <c:out value="${userNameSession}"/>

   <%-- <c:out value="${userLoginSession}"/>--%>

    <c:out value="${userSubjectSession}"/>

    <c:out value="${userMarkSession}"/>
</h3>

<button onclick="location.href='/Project_war/logOut'">Log out</button>

</body>
</html>
