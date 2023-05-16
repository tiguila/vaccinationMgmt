
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action='ChangePassword' method="post">
		<input type="hidden" name="id" value='${sessionScope.user.id}'>
		New password: <input name="newPassword">
		<button type="submit">Save</button>
	</form>


</body>
</html>