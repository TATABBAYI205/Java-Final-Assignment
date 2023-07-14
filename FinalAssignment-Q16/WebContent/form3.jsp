<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<h1 style="color:red; text-align:center">iNeuron Intelligence Private limited</h1>
	<form method="post" action="./disp">
		<c:choose>
			<c:when test="${!empty name }">
				<h1 style="color: blue; text-align: center">Student name :: ${name}</h1>
			</c:when>
		</c:choose>
		<table align="center">
			<tr>
				<th>MOBILE</th>
				<td><input type='text' name='smobile' /></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type='text' name='semail' /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type='submit' value='reg' /></td>
			</tr>
		</table>
	</form>


</body>
</html>