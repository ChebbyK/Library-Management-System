<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/30/2017
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="get">

    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Update Book</th>
        </tr>
        </thead>
        <tr>
            <td>ENTER INVENTORY ID </td>
            <td><input type="number" name="inventoryId" value="" required/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Search" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>

    </table>

</form>
</body>
</html>
