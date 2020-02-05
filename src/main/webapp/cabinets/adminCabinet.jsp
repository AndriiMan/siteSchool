<%@ page import="ua.site.BD.dao.CRUD.ReadValues" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.site.model.User" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AdminCab</title>
</head>
<body>
<button onclick="location.href='/Project_war/home'">Home</button>
<button onclick="location.href='/Project_war/logOut'">Log out</button>
<div style="text-align: center;">

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
                    <%--<td>Specialization</td>--%>
                    <td>Subject</td>
                    <td>Mark</td>

                </tr>
                <c:forEach items="${userSession}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.surname}"/></td>
                        <%--<td><c:out value="${user.subjectId}"/></td>--%>
                        <%--<td><c:out value="${user.specializationId}"/></td>--%>
                    <%--<td><c:out value="${user.specialization}"/></td>--%>
                    <td><c:out value="${user.subject_col}"/></td>
                    <td><c:out value="${user.mark}"/></td>

                    <td>
                            <%--<a href="edit.jsp">Edit</a>--%>
                        <%--//work becouse of this url not form--%>
                        <%--<a href="<c:url value="edit">
                        <c:param name="userId" value="${user.id}"/>
                        </c:url>
                        ">Edit</a>--%>
                                <%--<input type="hidden" name="userID" value="1">--%>
                                <form action="edit"  method="post">
                                <input type='hidden' name='userId' value='${user.id}' />
                                <input type='submit' value='Edit' />
                                </form>
                                    <%--<input type="submit" value="Edit">--%>
                            <%-- <button onclick="location.href='/Project_war/editServlet'">Log out</button>--%>
                    </td>
                </tr>
                </c:forEach>
        </h3>

        </table>

</div>
</body>
</html>