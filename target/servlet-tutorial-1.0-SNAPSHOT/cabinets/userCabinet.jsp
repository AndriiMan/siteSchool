<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UserCabinet</title>
</head>
<body>

<h3>
    <form method="post" action="userSpecControl">

        <c:out value="Name is ${userNameSession}"/>

        <c:out value="Surname is ${userSurnameSession}"/>

        <c:out value="Subject is ${userSubjectSession}"/>

        <c:out value="Mark is ${userMarkSession}"/>

        <input type='hidden' name='userName' value='${userNameSession}'/>
        <input type='hidden' name='userSurname' value='${userSurnameSession}'/>
        <input type='hidden' name='userId' value='${userIdSession}'/>
        <input type='hidden' name='userLogin' value='${userLoginSession}'/>
        <input type='hidden' name='userPassword' value='${userPasswordSession}'/>
        <input type='hidden' name='userSubId' value='${userSubIdSession}'/>
        <input type='hidden' name='userSpecId' value='${userSpecIdSession}'/>
        <input type='hidden' name='mark' value='${userMarkSession}'/>

        <%--<form&lt;%&ndash; action="edit"  method="post"&ndash;%&gt;>
                Mark is :<input type="text" name="mark" &lt;%&ndash;value="${sessionScope.userMark}"&ndash;%&gt;><br>
            </form>--%>

        <c:if test="${userMarkSession != 0}">

            <select name="specialization">
                <option value="Computer and Network Security">Computer and Network Security</option>
                <option value="Software Engineering">Software Engineering</option>
                <option value="Bioinformatics">Bioinformatics</option>
                <option value="Rankings">Rankings</option>
                <option value="Data Analytics">Data Analytics</option>
            </select>
            <input type="submit" value="Ok" name="Ok"><br>

        </c:if>
        <%--Because in room--%>
        <%-- <label><input type="number" name="specialization"></label>Specialization<br>--%>
    </form>
</h3>

<button onclick="location.href='/Project_war/home'">Home</button>
<button onclick="location.href='/Project_war/logOut'">Log out</button>

</body>
</html>
