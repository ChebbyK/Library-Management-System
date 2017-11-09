<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/23/2017
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="adduser">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>NAME</td>
                <td><input type="text" name="name" required value="" /></td>
            </tr>
            <tr>
                <td>NATIONAL ID</td>
                <td><input type="text" name="natid" required value="" /></td>
            </tr>
            <tr>
                <td>CONTACT</td>
                <td><input type="text" name="contact" required value="" /></td>
            </tr>

            <tr>
                <td>EMAIL</td>
                <td><input type="text" name="email" required value="" /></td>

            </tr>
            <tr>
                <td>USERNAME</td>
                <td><input type="text" name="username" required value="" /></td>
            </tr>
            <tr>
                <td>PASSWORD</td>
                <td><input type="text" name="password" required value="" /></td>
            </tr>
            <tr>
                <td>GENDER</td>
                <td>
                    <SELECT name="gender">
                        <OPTION name="female" VALUE="female" SELECTED>FEMALE
                        <OPTION name="male" VALUE="male">MALE

                    </SELECT>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
