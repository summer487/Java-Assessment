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
<h2>Welcome to your Home Page, ${userName}! </h2>
<a href="/dashboard">To access your dashboard, please click on this link</a>
<br/><br/>
<a href="/reports">To view reports, please click on this link</a>
<br/><br/>
<a href="/library">To access library, please click on this link</a>
<br/><br/>
<a href="/add-employee">To register a new employee, click on this link</a>
<br/><br/>
<a href="/view-employees">To delete any existing employee from database, click on this link</a>
<br/><br/>
To Logout, please click below button
<br>
<button id="logout" onclick="myFunction();">Log Out</button>
</body>
</html>