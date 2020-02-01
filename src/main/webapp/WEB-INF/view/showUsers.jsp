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
    <form action="showUsers" method="post">
        <hr>
        <h3>
            TABLE FOR DATE
            <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Surname</td>
                <%--<td>SubjectId</td>--%>
                <%--<td>SpecializationID</td>--%>
                <td>Specialization</td>
                <td>Mark</td>
                <td>Subject</td>

            </tr>
            <c:forEach items="${userSession}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.surname}"/></td>
                    <%--<td><c:out value="${user.subjectId}"/></td>--%>
                    <%--<td><c:out value="${user.specializationId}"/></td>--%>
                    <td><c:out value="${user.specialization}"/></td>
                    <td><c:out value="${user.subject_col}"/></td>
                    <td><c:out value="${user.mark}"/></td>

                </tr>
            </c:forEach>
        </h3>

         </table>
    </form>
</div>
</body>
</html>