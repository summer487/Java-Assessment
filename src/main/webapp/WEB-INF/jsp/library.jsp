<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Library</title>
</head>
<style>
h2 {
	font-size: 25px;
}

p {
	font-size: 18px;
}
</style>
<body>
	<h2>Library</h2>
	<div>
	<p>
		Leave Policy: <a href="/downloads/Leave Policy.docx">View</a>
	</p>
	<p>
		Company Manual: <a href="/downloads/Company Manual.docx">View</a>
	</p>
	</div>
	<div id="myDiv">
	<p>
		Java 8 Documentation: <a href="/downloads/Java 8 Documentation.pdf">View</a>
	</p>
	<p>
		Spring Boot Reference Manual: <a href="/downloads/Spring Boot Reference Documentation.pdf">View</a>
	</p>
	</div>
	<b>To go back to home page, please click below link</b>
	<br />
	<a href="/">Return back to Home page</a>
<script>
var condition =  ${condition}; // Set the condition here 
if (condition) { 
	  document.getElementById('myDiv').style.display = 'none'; 
	} 
</script>
</body>
</html>