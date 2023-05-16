<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Front Page</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>

	<c:choose>
		<c:when test="${user.role == 'administrator'}">
			<div class="container">
				<div class="row">
					<p>
						<a class="btn" href='ListVaccines'>Vaccine Management</a>
						<a class="btn" href='ListPatients'>Patient Management</a>
					</p>
				</div>
			</div>
		</c:when>

		<c:when test="${user.role == 'nurse'}">
		
			<div class="container">
				<div class="row">
					<p>
						<a class="btn" href='ListPatients'>Patient Management</a>
					</p>
				</div>
			</div>
		</c:when>
	</c:choose>


</body>
</html>