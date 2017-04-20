<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <% String message = (String) request.getAttribute("name"); %>
   <%= message %>

    <table>
    <c:forEach items="${requestScope.list}" var="student">
        <tr>
            <td><c:out value="${student.id}"></c:out></td>
            <td><c:out value="${student.name}"></c:out></td>
            <td><c:out value="${student.age}"></c:out></td>
            <td><c:out value="${student.groupId}"></c:out></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
