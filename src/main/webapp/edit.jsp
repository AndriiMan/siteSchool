<%@ page import="ua.site.BD.dao.CRUD.EditValues" %>
<%@ page import="ua.site.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit values</title>
</head>
<body>
<%
    String id= request.getParameter("id");
    EditValues editValues=new EditValues();
    User objUser=editValues.getValueOfUser(Integer.parseInt(id));
%>
<div style="text-align: center;">
    <h1>Edit Values</h1>
    <%--Method dopost--%>
    <form action="controller/edit_controller.jsp">
        Sl No :<input type="text" name="id" value="<%=id%>"><br>
        User Name :<input type="text" name="name" value="<%=objUser.getName()%>"><br>
        Mobile:<input type="text" name="surname" value="<%=objUser.getSurname()%>"><br>
        Email:<input type="text" name="login" value="<%=objUser.getLogin()%>"><br>
        <input type="submit" value="Edit">
    </form>
</div>
</body>
</html>
