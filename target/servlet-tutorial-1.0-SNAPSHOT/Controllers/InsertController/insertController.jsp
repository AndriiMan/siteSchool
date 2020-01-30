<%@ page import="ua.site.BD.dao.CRUD.InsertValues" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>--%>

<html>
<head>
    <title>SaveDataInsertController</title>
</head>
<body>
<%
    String login=request.getParameter("login");
    String password=request.getParameter("password");
    String name=request.getParameter("name");
    String surname=request.getParameter("surname");
    String subject_id=request.getParameter("subject_id");
    InsertValues obj_Insert_Values=new InsertValues();
    obj_Insert_Values.insert_values(login, password,name,surname,subject_id);
%>

<script type="text/javascript">
    window.location.href="../../logIn"
</script>

</body>
</html>
