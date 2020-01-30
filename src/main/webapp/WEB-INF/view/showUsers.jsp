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
        ReadValues obj_Read_Values=new ReadValues();
        List<User> list=obj_Read_Values.get_values();
        Iterator<User> it_list=list.iterator();
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
            while(it_list.hasNext()){
                User obj_User=new User();
                obj_User=it_list.next();
        %>
        <tr>
            <td><%=obj_User.getId() %></td>
            <td><%=obj_User.getName() %></td>
            <td><%=obj_User.getSurname() %></td>
            <td><%=obj_User.getSubjectid() %></td>
            <td><%=obj_User.getSpecialization() %></td>
            <td><%=obj_User.getMark() %></td>

        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>