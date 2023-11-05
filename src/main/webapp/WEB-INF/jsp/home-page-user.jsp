<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function myFunction(){
	location.href='/logout';
}
</script>
<title>Home Page</title>
</head>
<body>
<h3>Welcome to your Home Page, ${userName}!</h3>
<a href="/dashboard">To access your dashboard, please click on this link</a>
<br/><br/>
<a href="/library">To access library, please click on this link</a>
<br/><br/>
To Logout, please click below button
<br>
<button id="logout" onclick="myFunction();">Log Out</button>
</body>
</html>