<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Output Page</title>
</head>
<body bgcolor="lightblue">
<br/><br/><br/>
	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style="color: green; text-align: center;">BLOG POSTED SUCCESSFULLY</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center;">BLOG POSTING FAILED</h1>
		</c:otherwise>
	</c:choose><br/>
	<div style="text-align: center;"><a href="http://localhost:9999/Question17/index.jsp">|Back|</a></div>
</body>
</html>