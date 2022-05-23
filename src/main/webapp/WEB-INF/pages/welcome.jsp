<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="styles/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Welcome <%=request.getSession().getAttribute("name") %></title>
</head>
<body>
<div class="head">InfinityLoop Solutions</div>
<div id="parent">
<h2>Username :</h2><%=request.getSession().getAttribute("username") %><br>
<h2>email :</h2><%=request.getSession().getAttribute("email") %><br>
<h2>emp id :</h2><%=request.getSession().getAttribute("eid") %><br>
<br><br>
<form action="Logout" method="get">
<input type="submit" value="Logout">
</form>
</div>
</body>
</html>