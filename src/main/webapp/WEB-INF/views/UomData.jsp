<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UomDataPage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
.b1 {
	background-color: blue;
}

.b2 {
	background-color: yellow;
}

.b3 {
	background-color: cyan;
}

.b4 {
	background-color: skyblue;
}
</style>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card-header">
			<h2>Welcome to Uom Data Page</h2>
		</div>
		<div class="card">
			<table class="table table-bordered table-hover">
				<tr class="table-success">
					<th>PrimaryKey</th>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>DESCRIPTION</th>
					<th>OPERATION</th>
				</tr>
				<d:forEach items="${list}" var="ob">
					<tr>
						<td><d:out value="${ob.id}" /></td>
						<td><d:out value="${ob.uomType}" /></td>
						<td><d:out value="${ob.uomModel}" /></td>
						<td><d:out value="${ob.descr}" /></td>
						<td><a href="delete?id=${ob.id}"> <img
								src="../resources/images/delete.png" height=30 width="30">
						</a> <a href="edit?id=${ob.id}"> <img
								src="../resources/images/edit.png" height=30 width="30">
						</a> <a href="view?id=${ob.id}"> <img
								src="../resources/images/view.png" height=30 width="30">
						</a></td>
					</tr>
				</d:forEach>
			</table>
			${msg}
		</div>
		<a href="excel?id=${ob.id}"><img
			src="../resources/images/excel.png" height="35" width="40"></a> <a
			href="pdf?id=${ob.id}"><img src="../resources/images/pdf.png"
			height="35" width="40"></a>
	</div>
</body>
</html>