<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SiteSchool</title>
    <style>
        form{
            display: inline;
        }
    </style>

    <button onclick="location.href='/Project_war/registration'">Registration</button>

    <button onclick="location.href='/Project_war/logIn'">Log in</button>

    <button onclick="location.href='/Project_war/showUsers'">UsersAll</button>


    <button onclick="location.href='/Project_war/edit'">Edit</button>

    <button onclick="location.href='/Project_war/LogOut'">Log out</button>

</head>
<body>



<%--Go to another page only without servlet--%>
<%--<jsp:forward page="../view/mainPage.jsp"/>--%>

<%--<form action="<c:url value="../view/mainPage.jsp"/>">
    <input type="submit" value="submit">
</form>--%>
<%--
<form action="<c:url value="../view/mainPage.jsp"/>">
    <input type="submit" value="submit2">
</form>--%>

<%--

<h1>Hello!</h1><br/>

<h2>Все пользователи</h2><br/>

<c:forEach var="user" items="${requestScope.users}">
    <ul>

        <li>Имя: <c:out value="${user.name}"/></li>

        <li>Id: <c:out value="${user.id}"/></li>

        <li>Id: <c:out value="${user.login}"/></li>
    </ul>
    <hr/>

</c:forEach>

<h2>Создание нового пользователя</h2><br/>

<form method="post" action="">

    <label><input type="number" name="id"></label>Id<br>

    <label><input type="text" name="name"></label>Name<br>

    <label><input type="text" name="login"></label>Login<br>

    <label><input type="text" name="password"></label>Password<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
--%>

</body>
</html>
