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
<title>Employee Report</title>
</head>
<body>
	<h2>Employees List</h2>
	<table style="width: 50%">
		<thead>
			<tr>
				<th>Name</th>
				<th>Organization Name</th>
				<th>City</th>
				<th>Department</th>
				<th>Email-ID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${details}" var="employee">
				<tr>
					<td>${employee.firstName} ${employee.lastName}</td>
					<td>${employee.orgName}</td>
					<td>${employee.city}</td>
					<td>${employee.department}</td>
					<td>${employee.primaryEmail}</td>
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