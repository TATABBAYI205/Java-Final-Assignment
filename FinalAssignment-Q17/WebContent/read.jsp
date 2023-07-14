<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Page</title>
</head>
<body bgcolor="lightblue">
	<form method="get" action="./controller/read">
	<h1 style="color:red; text-align:center">READ BLOG</h1>
	<br/>
		<table align="center">
			<tr>
				<th>TITLE OF BLOG</th>
				<td><input type="text" name="title" placeholder="Enter title of blog"/></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="search"/></td>
			</tr>
		</table>
	</form>

</body>
</html>