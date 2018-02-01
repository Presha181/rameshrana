<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Staff</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		
</head>

<body>
<div id="wrapper">
	<div id="header">
	<h2>Staff Management</h2>
	</div>
</div>

<div id="container">
		<h3>Save Staff</h3>
		<form:form action="saveStaff" modelAttribute="staff" method="POST">
			<form:hidden path="id"/>
			
			<table>
			<tr>
			<td><label>First name:</label></td>
			<td><form:input path="firstName"/></td>
			</tr>
			
			<tr>
			<td><label>Last name:</label></td>
			<td><form:input path="lastName"/></td>
			</tr>
			
			<tr>
			<td><label>Email:</label></td>
			<td><form:input path="email"/></td>
			</tr>
			
			<tr>
			<td><label>Home Phone:</label></td>
			<td><form:input path="homePhone"/></td>
			</tr>
			
			<tr>
			<td><label>Cell Phone:</label></td>
			<td><form:input path="cellPhone"/></td>
			</tr>
			
			<tr>
			<td><label></label></td>
			<td><input type="submit" value="Save" class="save"/></td>
			</tr>
			
			</table>
			
		</form:form>
		<div style="clear; both;">
		<p><a href="${pageContext.request.contextPath}/staff/allList" >Back to List</a></p>
		</div>
	
</div>
</body>
</html>