<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Books</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Library management</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<input type="button" value="Add Book"
				   onclick="window.location.href='add'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Title</th>
					<th>author Name</th>
					<th>category</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="temp" items="${books}">
				
					<!-- update link -->
					
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="bookId" value="${temp.id}" />
					</c:url>
					
					<!-- construct an "delete" link with book id -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="bookId" value="${temp.id}" />
					</c:url>
					
					<tr>
						<td> ${temp.title} </td>
						<td> ${temp.author_name} </td>
						<td> ${temp.category} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>








