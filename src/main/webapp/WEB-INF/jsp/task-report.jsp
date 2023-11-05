<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
.container{
	text-align: center;
}
</style>
<title>Task Report</title>
</head>
<body>
	<h2>Task Details : Department Wise</h2>
	<table style="width: 50%">
		<thead>
			<tr>
				<th>Department Name</th>
				<th>Pending Tasks</th>
				<th>Completed Tasks</th>
				<th>Ongoing Tasks</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${details}" var="task">
				<tr>
					<td>${task.department}</td>
					<td>${task.pendingTasks}</td>
					<td>${task.completedTasks}</td>
					<td>${task.ongoingTasks}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/><br/>
	<b>To go back to reports page, please click below link</b>
	<br/>
	<a href="/reports">Return back to Reports page</a>
</body>
</html>