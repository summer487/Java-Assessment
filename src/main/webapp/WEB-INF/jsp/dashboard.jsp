<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>${userName}'sDashboard</title>
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
	<h2>Welcome to your Dashboard, ${userName}!</h2>
	<p>
		Pending Tasks: <a href="/task-information" style="color: red;">${pendingCount}</a>
	</p>
	<p>
		Ongoing Tasks: <a href="/task-information" style="color: orange;">${ongoingCount}</a>
	</p>
	<p>
		Completed Tasks: <a href="/task-information" style="color: green;">${completedCount}</a>
	</p>
	<b>To go back to home page, please click below link</b>
	<br />
	<a href="/">Return back to Home page</a>
</body>
</html>