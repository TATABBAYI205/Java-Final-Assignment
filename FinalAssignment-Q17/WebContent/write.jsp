<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BLOG WRITING PAGE</title>
</head>
<body bgcolor="lightgreen">
<br/><br/><br/>
	<form method="post" action="./controller/write">
	<h1 style="color:red; text-align:center">WRITE BLOG</h1>
		<table align="center">
			<tr>
				<th>BLOG TITLE</th>
				<td>
					<input type="text" name="title" placeholder="Write your blog title here"/>
				</td>
			</tr>
			<tr>
				<th>BLOG DESCRIPTION</th>
				<td>
					<textarea name="blogDesc" rows="2" cols="50" placeholder="Write your blog description here"></textarea>
				</td>
			</tr>
			<tr>
				<th>BLOG BODY</th>
				<td>
					<textarea name="blogContent" rows="5" cols="50" placeholder="Write your blog here"></textarea>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<input type="submit" value="post"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>