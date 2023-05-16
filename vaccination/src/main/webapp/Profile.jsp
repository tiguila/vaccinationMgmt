<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>








	<p>
		<a>${sessionScope.user.name}</a>
	</p>
	<p>
		<a href='ChangeName?id=${sessionScope.user.id}'>Change Name</a>
	</p>
	<p>
		<a href='ChangePassword?id=${sessionScope.user.id}'>Password</a>
	</p>


</body>
</html>