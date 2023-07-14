<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Status</title>
</head>
<body bgcolor="lightblue">
	<br /><br />
	<c:choose>
		<c:when test="${loginStatus eq 'success'}">
			<h1 style="text-align: center; color: green;">STUDENT LOGIN
				SUCCESSFUL</h1>
		</c:when>
		<c:otherwise>
			<h1 style="text-align: center; color: red;">STUDENT LOGIN FAILED</h1>
		</c:otherwise>
	</c:choose>
	<br />
	<div style="text-align: center;">
		<a href="http://localhost:9999/StudentApp/student">|Home Page|</a>
	</div>

</body>
</html>