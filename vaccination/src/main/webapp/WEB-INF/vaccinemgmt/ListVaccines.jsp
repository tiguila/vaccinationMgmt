<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vaccines</title>

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
				<a class="btn" href='NewVaccine'>New Vaccine</a> | <a class="btn"
					href='NewDoses'>New Doses</a>
			</p>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<table class="table table-bordered">
				<thead class="bold">
					<tr>
						<c:forEach items="${list}" var="item">
							<th class="border border-dark">${item}</th>
						</c:forEach>
					</tr>
				</thead>

				<c:forEach items="${entries}" var="entry">
					<c:choose>
						<c:when test="${entry.vaccineName == 'Johnson & Johnson'}">
							<tr class="border border-dark">
								<td class="border border-dark">${ entry.vaccineName}</td>
								<td class="border border-dark">${ entry.dosesRequired}</td>
								<td class="border border-dark">${ entry.daysBetweenDoses}</td>

								<td class="border border-dark">${ entry.totalDosesReceived}</td>
								<td class="border border-dark">${ entry.totalDosesLeft}</td>
								<td class="border border-dark"><a class="btn"
									href="EditVaccine?id=${entry.vaccineId}">Edit</a></td>
							</tr>
						</c:when>

						<c:otherwise>
							<tr class="border border-dark">
								<td class="border border-dark">${ entry.vaccineName}</td>
								<td class="border border-dark">${ entry.dosesRequired}</td>
								<td class="border border-dark">${ entry.daysBetweenDoses}</td>
								<td class="border border-dark">${ entry.totalDosesReceived}</td>
								<c:choose>
									<c:when test="${entry.totalDosesLeft <=0}">
										<td class="border border-dark">0</td>
									</c:when>
									<c:otherwise>
										<td class="border border-dark">${ entry.totalDosesLeft}</td>
									</c:otherwise>
								</c:choose>
								<td class="border border-dark"><a class="btn"
									href="EditVaccine?id=${entry.vaccineId}">Edit</a></td>
							</tr>
						</c:otherwise>

					</c:choose>

				</c:forEach>
			</table>
		</div>
	</div>


	<!-- Linking of bootstrap -->
	<!-- Optional JavaScript; choose one of the two! -->
	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
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