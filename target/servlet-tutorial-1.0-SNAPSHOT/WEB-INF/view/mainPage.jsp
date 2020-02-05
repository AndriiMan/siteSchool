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

    <button onclick="location.href='/Project_war/registration'">Registration for student</button>

    <button onclick="location.href='/Project_war/logIn'">Log in student</button>

    <button onclick="location.href='/Project_war/logInAdmin'">Log in Admin</button>

    <form action="showUsers" method="post" >
        <input type="submit" value="Students list"/>
    </form>

    <%--Delete this to not paste in url--%>
    <button onclick="location.href='/Project_war/userCab'">Student cabinet</button>
    <button onclick="location.href='/Project_war/adminCab'">Admin cabinet</button>
   <%-- <button onclick="location.href='/Project_war/showUsers'">UsersAll</button>--%>

   <%-- <button onclick="location.href='/Project_war/edit'">Edit</button>--%>

    <button onclick="location.href='/Project_war/logOut'">Log out</button>



</head>
<body>

</body>
</html>
