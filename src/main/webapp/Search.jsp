<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/29/2017
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form action="searchbook" method="post">

    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Search Book</th>
        </tr>
        </thead>
        <tr>
            <td>INVENTORY ID </td>
            <td><input type="number" name="inventoryId" value="" required/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Search" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>

    </table>

</form>
    </center>
</body>
</html>
