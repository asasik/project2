<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="styles/style.css" rel="stylesheet">
<title>Registration Page</title>
</head>
<body>
	<div class="head">InfinityLoop Solutions</div>
	<div id="register">
		<div id="login">
			<form action="Registration" method="post">
				<br> <br> <label for="name">Name</label><br> 
				<input type="text" name="name"><br> 
				<label for="email">Email</label><br>
				<input type="email" name="email"><br>
				 <label	for="username">Username</label><br> 
				 <input type="text"	name="username"><br> 
				 <label for="password">Password</label><br>
				<input type="password" name="password"><br> <br> <input
					type="submit" value="Register"><br> <br>
			</form>
		</div>
	</div>
</body>
</html>