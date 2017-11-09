<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/28/2017
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="loginuser">
    <center>
        <table border="0" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login page</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Username</td>
                <td><input type="text" name="Username" required value="" /></td>
            </tr>
            <tr>
                <td>Password</td>`
                <td><input type="password" name="Password" required value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <%--<tr>--%>
            <%--<td colspan="2">New User <a href="RegisterUser.jsp">Register Here</a></td>--%>
            <%--</tr>--%>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
