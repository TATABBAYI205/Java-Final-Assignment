<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="lightyellow">
<br /><br />
	<h1 style="color: red; text-align: center;">Student Registration
			Page</h1>
		<form method='GET' action="login">
			<table align="center">
				<tr>
					<th>SID</th>
					<td><input type='text' name='sid'></td>
				</tr>
				<tr>
					<th>SET PASSWORD</th>
					<td><input type="password" name='password'></td>
				</tr>
				<tr>
					<td></td>
					<td><input type='submit' value='login'></td>
				</tr>

			</table>
		</form>

</body>
</html>