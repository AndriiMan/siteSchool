<%@ page import="ua.site.BD.dao.CRUD.EditValues" %>
<%@ page import="ua.site.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    String id= request.getParameter("id");
    EditValues obj_EditValues=new EditValues();
    User obj_User=obj_EditValues.get_value_of_user(Integer.parseInt(id));
%>
<div style="text-align: center;">
    <h1>Edit Values</h1>
    <form action="controller/edit_controller.jsp">
        Sl No :<input type="text" name="id" value="<%=id%>"><br>
        User Name :<input type="text" name="name" value="<%=obj_User.getName()%>"><br>
        Mobile:<input type="text" name="surname" value="<%=obj_User.getSurname()%>"><br>
        Email:<input type="text" name="login" value="<%=obj_User.getLogin()%>"><br>
        <input type="submit" value="Edit">
    </form>
</div>
</body>
</html>
