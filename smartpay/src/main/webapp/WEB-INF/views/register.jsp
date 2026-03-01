<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>Register</h2>

<form action="register" method="post">
    Name: <input type="text" name="name" /><br><br>
    Email: <input type="text" name="email" /><br><br>
    Password: <input type="password" name="password" /><br><br>
	Role:
	<select name="role">
		<option value="USER">User</option>
		<option value="ADMIN">Admin</option>
		</select><br><br>
    <input type="submit" value="Register" />
</form>

</body>
</html>