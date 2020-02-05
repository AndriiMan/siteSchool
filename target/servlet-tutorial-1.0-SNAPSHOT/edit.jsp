<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ua.site.BD.dao.CRUD.EditValues" %>
<%@ page import="ua.site.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>
<head>
    <title>Edit values</title>
</head>
<body>
<%
    String id= request.getParameter("userId");
    EditValues editValues=new EditValues();
    User objUser=editValues.getValueOfUser(Integer.parseInt(id));
%>
<div style="text-align: center;">
    <h1>Edit Values</h1>

    <form action="editController" method="post">


        <%--Id is :<input type="text" name="id" value="<%=request.getParameter("userId")%>"><br>--%>
        <%--<p>Id is <%=request.getParameter("userId")%></p>--%>
        <p>Id is <c:out value="${sessionScope.userId}"/></p>
            <input type='hidden' name='userId' value='${sessionScope.userId}' />

        <p>Name is <c:out value="${sessionScope.userName}"/></p>
            <input type='hidden' name='userName' value='${sessionScope.userName}' />

        <p>Surname is <c:out value="${sessionScope.userSurname}"/></p>
            <input type='hidden' name='userSurname' value='${sessionScope.userSurname}' />

        <p>Subject is <c:out value="${sessionScope.userSubject}"/></p>
            <input type='hidden' name='userSubject' value='${sessionScope.userSubject}' />

        <p>Mark is <c:out value="${sessionScope.userMark}"/></p>
            <input type='hidden' name='userMark' value='${sessionScope.userMark}' />

            <input type='hidden' name='userSubId' value='${sessionScope.userSubId}' />
            <input type='hidden' name='userLogin' value='${sessionScope.userLogin}' />
            <input type='hidden' name='userPassword' value='${sessionScope.userPassword}' />
            <%--<input type='hidden' name='userSpecId' value='${sessionScope.userSpecId}' />--%>

            <%--Id is :<input type="text" name="id" value="<%=request.getParameter("userId")%>"><br>--%>

            Mark is :<input type="text" name="mark" value="${sessionScope.userMark}"><br>

        <%--User Name :<input type="text" name="name"&lt;%&ndash; value="<%=objUser.getName()%>&ndash;%&gt;"><br>
        Mobile:<input type="text" name="surname"&lt;%&ndash; value="<%=objUser.getSurname()%>&ndash;%&gt;"><br>
        Email:<input type="text" name="login" &lt;%&ndash;value="<%=objUser.getLogin()%>&ndash;%&gt;><br>
        --%><%--Mark:<input type="text" name="mark" &lt;%&ndash;value="<%=objUser.getMark()%>&ndash;%&gt;><br>--%>
        <input type="submit" value="Edit">
    </form>
</div>
</body>
</html>
