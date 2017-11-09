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

            <li><a href="ReturnBook.jsp">RETURN BOOK</a></li>
            <li><a href="viewbook">VIEW BOOK </a></li>
            <li><a href="logoutuser">LOGOUT</a></li>
            <li><a href=""><%="Welcome:" + session.getAttribute("sesname")%></a></li>

        </ul>
    </div>
</nav>
