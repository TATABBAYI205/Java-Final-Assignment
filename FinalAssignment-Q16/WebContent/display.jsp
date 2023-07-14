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
	<h1 style="color: red; text-align: center">iNeuron Intelligence
		Private limited</h1>
	<h1 style="color: green; text-align: center">Student Data</h1>
	<table align="center" border="1">
		<tr>
			<th>NAME</th>
			<td>${name}</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${age}</td>
		</tr>
		<tr>
			<th>QUALIFICATION</th>
			<td>${squal}</td>
		</tr>
		<tr>
			<th>DESIGNATION</th>
			<td>${sdesg}</td>
		</tr>
		<tr>
			<th>MOBILE</th>
			<td>${smobile}</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>${semail}</td>
		</tr>
		
	</table>
</body>
</html>