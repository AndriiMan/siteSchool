<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
   <%-- <style>
        form{
            display: inline;
        }
    </style>--%>
</head>
<body>

<%--Go to another page--%>
<jsp:forward page="WEB-INF/view/mainPage.jsp"/>
<%--
<form action="<c:url value="../view/mainPage.jsp"/>">
    <input type="submit" value="submit">
</form>

<form action="<c:url value="../view/mainPage.jsp"/>">
    <input type="submit" value="submit2">
</form>


<h1>Hello!</h1><br/>

<h2>Все пользователи</h2><br/>

<c:forEach var="user" items="${requestScope.users}">
    <ul>

        <li>Имя: <c:out value="${user.name}"/></li>

        <li>Возраст: <c:out value="${user.age}"/></li>
    </ul>
    <hr/>

</c:forEach>

<h2>Создание нового пользователя</h2><br/>

<form method="post" action="">

    <label><input type="text" name="name"></label>Имя<br>

    <label><input type="number" name="age"></label>Возраст<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>--%>

</body>
</html>
