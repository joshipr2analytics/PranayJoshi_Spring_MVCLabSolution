<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<Style>
#formUpdate {
	margin-top: 20px;
}
</Style>
<title>Registration Form</title>
</head>
<body>
	<div class="w3-container" id="formUpdate">
		<div class="w3-card-4">
			<div class="w3-container w3-green">
				<h2>Add/Update Registration</h2>
			</div>
			<form action="saveDetails" method="post" class="w3-container">
				<!-- Add hidden form field to handle update -->
				<input type="hidden" name="id" value="${Student.id}" /> <br /> 
				<input type="text" name="name" value="${Student.name}" class="w3-input"
					placeholder="Name"> <br /> 
				<input type="text" name="department" value="${Student.department}" class="w3-input"
					placeholder="Department"> <br /> 
				<input type="text" name="country" value="${Student.country}" class="w3-input"
					placeholder="Country"> <br />
				<input type="submit" value="SAVE" class="btn btn-info col-2" /> <br /> <br />
				<a href="/EventManagement/" class="btn btn-success col-4">BACK TO REGISTERED STUDENTS</a>
				<br /> <br />
			</form>
			
		</div>
	</div>
</body>
</html>