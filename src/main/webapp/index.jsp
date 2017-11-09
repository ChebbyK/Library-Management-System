<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WELCOME TO LMS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <%--<li><a href="RegisterRoom.jsp">Register Room</a></li>--%>
            <li><a href="AddUser.jsp">ADD USER</a></li>
            <li><a href="AddLibrarian.jsp">ADD LIBRARIAN</a></li>
            <li><a href="AddBook.jsp">ADD BOOK</a></li>
            <li><a href="Search.jsp">ISSUE BOOK</a></li>
            <%--<li><a href="IssueBook.jsp">ISSUEBOOK</a></li>--%>
            <li><a href="Update.jsp">UPDATE BOOK </a></li>
            <li><a href="viewLibrarian">VIEW BOOK </a></li>
            <li><a href="BookHistory.jsp">BOOK HISTORY </a></li>
            <li><a href="view">VIEW AUDIT </a></li>
            <li><a href="logout">LOGOUT</a></li>
            <li><a href=""><%="Welcome:" + session.getAttribute("sName")%></a></li>

        </ul>
    </div>
</nav>

</body>
</html>
