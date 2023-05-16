
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Patients</title>

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
	<p></p>
	<div class="container">
		<div class="row d-flex justify-content-end">
			<p>
				<a class="btn" href="Logout">Logout</a>
				<a class="btn" href="Profile">Profile</a>
			</p>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<p>
				<a class="btn" href="AddPatient">New Patient</a>
			</p>
		</div>
	</div>

	<div class="container">
		<div class="row">

			<table class="table table-bordered">
				<thead class="bold">
					<tr>
						<c:forEach items="${plist}" var="item">
							<th style="text-align: center;" class="border border-dark">${item}</th>
						</c:forEach>
					</tr>
				</thead>

				<c:forEach items="${pentries}" var="entry">

					<tr class="border border-dark">
						<td style="text-align: center;" class="border border-dark">${entry.patientId}</td>
						<td style="text-align: center;" class="border border-dark">${entry.patientName}</td>
						<td style="text-align: center;" class="border border-dark">${entry.vaccineNameReceived}</td>
						<td style="text-align: center;" class="border border-dark"><fmt:formatDate
								value="${entry.firstDoseDate}" pattern="MM/dd/yyyy" /></td>

						<c:choose>

							<c:when
								test="${entry.vaccineNameReceived == 'Johnson & Johnson'}">
								<td style="text-align: center;" class="border border-dark">-</td>
							</c:when>

							<c:when test="${(empty entry.secondDoseDate)}">
								<td style="text-align: center;" class="border border-dark"><a
									class="btn" href="Received?id=${entry.patientId}">Received</a></td>
							</c:when>

							<c:when test="${entry.vaccineDosesLeft <= 0}">
								<td style="text-align: center;" class="border border-dark">Out
									of Stock</td>
							</c:when>

							<c:when test="${!(empty entry.secondDoseDate)}">
								<td style="text-align: center;" class="border border-dark"><a><fmt:formatDate
											value="${entry.firstDoseDate}" pattern="MM/dd/yyyy" /></a></td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>






	<!-- Linking of bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
	<!-- Linking of bootstrap -->
</body>
</html>