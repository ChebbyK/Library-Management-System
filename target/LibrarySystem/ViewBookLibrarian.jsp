<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 11/1/2017
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="50%">
    <tr>
        <%--<th width="10%">ID</th>--%>
        <th width="10%">AUTHOR</th>
        <th width="10%">BOOK CATEGORY</th>
        <th width="10%">NAME</th>

        <th width="10%">INVENTORY ID</th>
        <th width="10%">YEAR PUBLISHED</th>
    </tr>
    <c:forEach var="book" items="${viewBook}">
        <table border="1" width="50%">
            <tr>
                <td width="10%"><c:out value="${book.author}"></c:out></td>
                <td width="10%"><c:out value="${book.bookcategory}"></c:out></td>
                <td width="10%"><c:out value="${book.bookname}"></c:out></td>
                <td width="10%"><c:out value="${book.inventoryId}"></c:out></td>
                <td width="10%"><c:out value="${book.yearPublished}"></c:out></td>


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
