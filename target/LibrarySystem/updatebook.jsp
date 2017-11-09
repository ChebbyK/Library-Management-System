<%--
  Created by IntelliJ IDEA.
  User: Kandie
  Date: 10/31/2017
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="updatingg">
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
                <td><input type="text" name="name" required value="<%= session.getAttribute("bookname")%>" /></td>
            </tr>
            <tr>
                <td>INVENTORY ID</td>
                <td><input type="text" name="bookid" required value="<%=session.getAttribute("inventoryId")%>" /></td>
            </tr>
            <tr>
                <td>AUTHOR</td>
                <td><input type="text" name="author" required value="<%=session.getAttribute("author")%>" /></td>
            </tr>
            <tr>
                <td>BOOK CATEGORY</td>
                <td>


                   <select name="bookcat">

                        <option><%=session.getAttribute("bookcategory")%></option>
                        <option>science</option>
                        <option>law</option>
                        <option>maths</option>
                        <option>history</option>
                        <option>art</option>
                        <option>language</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>YEAR PUBLISHED</td>
                <td><input type="text" name="year" required value="<%=session.getAttribute("yearPublished")%>" /></td>
            </tr>
            <td><input type="submit" value="UPDATE" /></td>
            <td><input type="reset" value="Reset" /></td>
            </tr>

            </tbody>
      </table>
    </center>
    </form>
</body>
</html>
