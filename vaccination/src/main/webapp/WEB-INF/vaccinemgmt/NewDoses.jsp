<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Doses</title>
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
				<a class="btn" href="Logout">Logout</a> <a class="btn"
					href="Profile">Profile</a>
			</p>
		</div>
	</div>



	<div class="container">
		<div class="row">

			<form action='NewDoses' method='post'>
				<table class="table table-bordered">

					<tbody>
						<tr class="border border-dark">
							<td class="border border-dark">Name</td>
							<td class="border border-dark"><select name='vaccinename'
								class="form-control">

									<c:forEach items="${entries}" var="entry">
										<option value="${entry.vaccineId}">${entry.vaccineName}</option>
									</c:forEach>


							</select></td>
						<tr class="border border-dark">
							<td class="border border-dark">New Doses Required</td>
							<td class="border border-dark"><input type='text'
								name='doses'></td>
						</tr>

						<tr class="border border-dark">
							<td class="border border-dark" colspan=2 scope='row'><button
									type='submit'>Add</button></td>
						</tr>
					</tbody>
				</table>

			</form>


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