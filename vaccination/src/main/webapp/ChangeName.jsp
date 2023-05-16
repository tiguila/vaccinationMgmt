<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='ChangeName' method="post">
		<input type="hidden" name="id" value='${sessionScope.user.id}'>
		New name: <input name="newName">
		<button type="submit">Save</button>
	</form>


</body>
</html>