<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>
	<p>
	Welcome to home page!
	</p>
	<hr>
	<!-- display user name and role -->
	<p>
		User:<security:authentication property="principal.username"/>
		<br><br>
		Roles:<security:authentication property="principal.authorities"/>
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- add link to /leaders -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
		(Only for managers)
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">System meeting</a>
		(Only for Admin)
	</p>
	</security:authorize>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>

</body>

</html>