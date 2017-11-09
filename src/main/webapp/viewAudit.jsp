<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/29/2017
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="40%">
    <tr>
        <%--<th width="10%">ID</th>--%>
        <th width="10%">DATE</th>
        <th width="10%">DETAIL</th>
        <th width="10%">NAME</th>

        <th width="10%">TIME</th>

    </tr>
    <c:forEach var="audit" items="${viewAudit}">
        <table border="1" width="40%">
            <tr>
                <td width="10%"><c:out value="${audit.date}"></c:out></td>
                <td width="10%"><c:out value="${audit.detail}"></c:out></td>
                <td width="10%"><c:out value="${audit.name}"></c:out></td>
                <td width="10%"><c:out value="${audit.time}"></c:out></td>



            </tr>
        </table>
    </c:forEach>
    <%-- //</form>--%>
</table>
</body>
</html>
