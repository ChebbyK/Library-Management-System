<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/23/2017
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form action="issuebook" method="post">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">ISSUE BOOK</th>
        </tr>
        </thead>
        <tr >
            <td>INVENTORY ID</td>
            <td><input type="text" name="inventoryId" value="" required> </td>
        </tr>
        <tr >
            <td>NATIONAL ID</td>
            <td><input type="text" name="natid" value="" required></td>
        </tr>
        <%--<tr>--%>
            <%--<td>ISSUED DATE</td>--%>
            <%--<td><input type="date" name="idate" value="" required/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>RETURNED DATE</td>--%>
            <%--<td><input type="date" name="rdate" value="" required/></td>--%>
        <%--</tr>--%>
        <tr>
            <td><input type="submit" value="ISSUE" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>

    </table>
</form>
    </center>
</body>
</html>
