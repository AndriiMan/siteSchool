<%@ page import="ua.site.BD.dao.CRUD.ReadValues" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.site.model.User" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ShowUsers</title>
</head>
<body>
<div style="text-align: center;">

    <hr>
    <%
        ReadValues objReadValues=new ReadValues();
        List<User> list=objReadValues.getValues();
        Iterator<User> itList=list.iterator();
    %>
    <%--tABLE FOR DATE--%>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Subject</td>
            <td>Specialization</td>
            <td>Mark</td>

        </tr>

        <%
            while(itList.hasNext()){
                User objUser=new User();
                objUser=itList.next();
        %>
        <tr>
            <td><%=objUser.getId() %></td>
            <td><%=objUser.getName() %></td>
            <td><%=objUser.getSurname() %></td>
            <td><%=objUser.getSubjectId() %></td>
            <td><%=objUser.getSpecialization() %></td>
            <td><%=objUser.getMark() %></td>

        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>