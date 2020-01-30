<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h2>New user</h2><br/>

<form method="post" action="/Project_war/Controllers/InsertController/insertController.jsp">

    <label><input type="text" name="login"></label>Login<br>

    <label><input type="text" name="password"></label>Password<br>

    <label><input type="text" name="name"></label>Name<br>

    <label><input type="text" name="surname"></label>Surname<br>

    <label><input type="number" name="subject_id"></label>Subject<br>


    <%--Because in room--%>
   <%-- <label><input type="number" name="specialization"></label>Specialization<br>--%>


    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
