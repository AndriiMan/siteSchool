<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ua.site.modal.Login_Modal" %>
<html>
<head>
    <title>SignInController</title>
</head>
<body>
<jsp:useBean id="obj_User" class="ua.site.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj_User"/>

<%
    System.out.println(obj_User.getLogin());
    System.out.println(obj_User.getPassword());


    Login_Modal obj_Login_Modal = new Login_Modal();
    boolean flag = obj_Login_Modal.check_user_name(obj_User);
    if (flag) {
%>

<script type="text/javascript">
    window.location.href="/Project_war/home";
</script>

<%
        System.out.println("Good acceess useer");
        session.setAttribute("user_session", obj_User);
    }
    else{
        System.out.println("Login Failed");
    }

    session.setAttribute("login_message", "Login Failed, User name and Password is Wrong");

%>

<%--//get back to the login screen--%>
<script type="text/javascript">
    window.location.href="/Project_war/logIn";
</script>

<%--<script type="text/javascript">
    window.location.href="http://localhost:8080/Login_Project/user-home-page/<%=obj_Login_User.getLogin()%>";
</script>--%>

</body
</html>