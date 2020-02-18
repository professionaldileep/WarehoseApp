<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="D" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h3>Welcome to Documents Page</h3>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
ID:			<input type="text" name="fid" />
Doc:		<input type="file" name="fdoc" />
<input type="submit" value="upload" />
</pre>
	</form>

	<table border="1">
		<tr>
			<th>FileName</th>
			<th>Link</th>
		</tr>
		<D:forEach items="${list}" var="ob">
			<tr>
				<td>${ob[1]}</td>
				<td><a href="download?fid=${ob[0]}">DOWNLOAD</a></td>
			</tr>
		</D:forEach>
	</table>
</body>
</html>