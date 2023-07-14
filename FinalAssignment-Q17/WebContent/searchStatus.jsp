<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog Page</title>
</head>
<body bgcolor="lightblue">
<br/><br/><br/>
	<c:choose>
		<c:when test="${blog ne null}">
		<h1 style="color: green; text-align: center">BLOG DATA</h1>
			<table align="center" border="1">
				<tr>
					<th>TITLE</th>
					<td>${blog.blogTitle}</td>
				</tr>
				<tr>
					<th>DESCRIPTION</th>
					<td>${blog.blogDesc}</td>
				</tr>
				<tr>
					<th>CONTENT</th>
					<td>${blog.blogContentForRetrival}</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">BLOG NOT FOUND</h1>
		</c:otherwise>
	</c:choose>
	<div style="text-align: center;"><a href="http://localhost:9999/Question17/index.jsp">|Back|</a></div>
</body>
</html>