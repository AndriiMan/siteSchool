<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h2>New user</h2><br/>

<form method="post" action="registration">

    <label><input type="text" name="login"></label>Login<br>

    <label><input type="text" name="password"></label>Password<br>

    <label><input type="text" name="name"></label>Name<br>

    <label><input type="text" name="surname"></label>Surname<br>

    <%--<label><input type="text" name="subject_col"></label>Subject<br>--%>

    <select name="subject_col">
        <option value="History">History</option>
        <option value="Math">Math</option>
        <option value="Geography">Geography</option>
        <option value="Ukrainian language">Ukrainian language</option>
        <option value="English language">English language</option>
    </select>

    <%--Because in room--%>
   <%-- <label><input type="number" name="specialization"></label>Specialization<br>--%>


    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
