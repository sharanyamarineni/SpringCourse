<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
	<style>
		.error {color:red}
	</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name(*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"></form:errors>
		<br><br>
		Registration ID: <form:input path="registrationId"/>
		<form:errors path="registrationId" cssClass="error"></form:errors>
		
		<br><br>
		Country: <form:select path="country">
		<form:options items="${student.countryOptions}" />
		</form:select>
		<br><br>
		Favorite Language:
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		C <form:radiobutton path="favoriteLanguage" value="C"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		<br><br>
		Operating Systems:
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac <form:checkbox path="operatingSystems" value="MAc"/>
		<br><br>
		<input type="submit" value="Submit"/>
		<br><br>
	</form:form>
</body>
</html>