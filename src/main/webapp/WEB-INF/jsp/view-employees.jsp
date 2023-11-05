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
<title>View Employees</title>
</head>
<body>
	<h2>Employees List</h2>
	<table style="width: 50%">
		<thead>
			<tr>
				<th>Department</th>
				<th>Name</th>
				<th>Delete User</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${form}" var="employee">
				<tr>
					<td>${employee.department}</td>
					<td>${employee.firstName} ${employee.lastName}</td>
					<td>
					<div class="container">
					<a href="/delete-employee?id=${employee.userId}">Delete</a>
					</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/><br/>
	<b>To go back to home page, please click below link</b>
	<br/>
	<a href="/">Return back to home page</a>
</body>
</html>