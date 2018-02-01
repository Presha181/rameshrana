<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Staff Welfare Joint Team</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- add out html table here -->

			<!-- put new button:ADD Customer -->

			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
				<input type="button" value="Add Staff"
					onclick="window.location.href='showFormForAdd';return false;"
					class="add-buton" />
			</security:authorize>

			<!--  add a search box -->
			<form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<table>
				<!-- input type for add button -->

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Home Phone</th>
					<th>Cell Phone</th>
				</tr>
				<c:forEach var="tempCustomer" items="${staffs}">

					<!-- construct an "update" link with customer id -->
					<!-- SECURITY AUTHORIZATION FOR manager and admin only -->

					<c:url var="updateLink" value="/staff/showFormForUpdate">
						<c:param name="staffId" value="${tempCustomer.id}" />
					</c:url>




					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/staff/delete">
						<c:param name="staffId" value="${tempCustomer.id}" />

					</c:url>


					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.homePhone}</td>
						<td>${tempCustomer.cellPhone}</td>

						<td><security:authorize
								access="hasAnyRole('MANAGER', 'ADMIN')">
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
							</security:authorize> <security:authorize access="hasAnyRole('ADMIN')">
								<!-- display the delete link -->
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>
								<!-- return false says that if user cancel it then nothing is done.. -->
							</security:authorize></td>

					</tr>

				</c:forEach>

			</table>

		</div>
	</div>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" class="add-button" />

	</form:form>

</body>


</html>