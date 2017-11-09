<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/23/2017
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="addBook">
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
                <td>INVENTORY ID</td>
                <td><input type="text" name="bookid" required value="" /></td>
            </tr>
            <tr>
                <td>AUTHOR</td>
                <td><input type="text" name="author" required value="" /></td>
            </tr>
            <tr>
                <td>BOOK CATEGORY</td>
                <td>
                    <%--<input type="text" name="Type" value="" />--%>
                    <SELECT name="bookcat">
                        <OPTION name="science" VALUE="science" SELECTED>SCIENCE
                        <OPTION name="law" VALUE="law">LAW
                        <OPTION name="maths" VALUE="maths">MATHEMATICS
                        <OPTION name="history" VALUE="history">HISTORY
                        <OPTION name="art" VALUE="art">ART
                        <OPTION name="language" VALUE="language">LANGUAGE

                    </SELECT>
                </td>
            </tr>

            <tr>
                <td>YEAR PUBLISHED</td>
                <td><input type="text" name="year" required value="" /></td>
            </tr>
                <td><input type="submit" value="Submit" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <%--<tr>--%>
            <%--<td colspan="2">Already registered!! <a href="">Login Here</a></td>--%>
            <%--</tr>--%>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
