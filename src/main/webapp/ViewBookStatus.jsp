<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 11/1/2017
  Time: 12:40 PM
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
        <th width="10%">BOOK ID</th>
        <th width="10%">USER ID</th>
        <th width="10%">STATUS</th>

        <th width="10%">DATE</th>

    </tr>
    <c:forEach var="book" items="${viewBook}">
        <table border="1" width="40%">
            <tr>
                <td width="10%"><c:out value="${book.book.bookId}"></c:out></td>
                <td width="10%"><c:out value="${book.user.userId}"></c:out></td>
                <td width="10%"><c:out value="${book.status}"></c:out></td>
                <td width="10%"><c:out value="${book.issuedate}"></c:out></td>
                <%--<td width="10%"><c:out value="${book.expectedReturndate}"></c:out></td>--%>



            </tr>
        </table>
    </c:forEach>
    <tr>
        <td colspan="2">BACK!! <a href="index.jsp">BACK</a></td>
    </tr>
    <%-- //</form>--%>
</table>
</body>
</html>
