<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error {
	color: red;
	font-style: italic;
}

.mandatory {
	color: red;
}
</style>
<title>${pageTitle}</title>
</head>
<body>
	<h2>${pageHeading}</h2>
	<form:form method="post" modelAttribute="form">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:label path="orgName">Organization Name</form:label> <form:label
						path="orgName" cssClass="mandatory">*</form:label></td>
				<td><form:input path="orgName" type="text" class="form-control" /></td>
				<td><form:errors path="orgName" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="firstName">First Name</form:label> <form:label
						path="firstName" cssClass="mandatory">*</form:label></td>
				<td><form:input path="firstName" type="text"
						class="form-control" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName">Last Name</form:label> <form:label
						path="lastName" cssClass="mandatory">*</form:label></td>
				<td><form:input path="lastName" type="text"
						class="form-control" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><form:label path="primaryEmail">Primary E-mail Address</form:label>
					<form:label path="primaryEmail" cssClass="mandatory">*</form:label></td>
				<td><form:input path="primaryEmail" type="text"
						class="form-control" /></td>
				<td><form:errors path="primaryEmail" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="secondaryEmail">Secondary E-mail Address</form:label></td>
				<td><form:input path="secondaryEmail" type="text"
						class="form-control" /></td>
				<td><form:errors path="secondaryEmail" cssClass="error" /></td>

			</tr>
			
			<tr>
				<td><form:label path="city">City</form:label> <form:label
						path="city" cssClass="mandatory">*</form:label></td>
				<td><form:input path="city" type="text"
						class="form-control" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><form:label path="department">Department</form:label> <form:label
						path="department" cssClass="mandatory">*</form:label></td>
				<td><form:input path="department" type="text"
						class="form-control" /></td>
				<td><form:errors path="department" cssClass="error" /></td>
			</tr>
			
			<tr />
			<tr />
			<tr>
				<td><form:button> ${buttonName} </form:button></td>
			</tr>
		</table>

	</form:form>
	<br />
	<br />
	<b>To go back to home page, please click below link</b>
	<br />
	<a href="/">Return back to home page</a>
</body>
</html>