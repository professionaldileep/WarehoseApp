<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="D" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>WhUserType Data Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>WhUserType Data Page</h2>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class="table-info">
						<th>WhUserId</th>
						<th>WhUserType</th>
						<th>WhUserEmail</th>
						<th>Operation</th>
					</tr>
					<D:forEach items="${list}" var="ob">
						<tr>
							<td>${ob[0]}</td>
							<td>${ob[1]}</td>
							<td>${ob[2]}</td>
							<td><a href="delete?id=${ob[0]}" class="btn btn-danger">
							<img src="../resources/images/delete.png" height="20" width="20">
							</a>
							<a href="edit?id=${ob[0]}" class="btn btn-info">
							<img src="../resources/images/edit.png" height="20" width="20">
							</a>
							<a href="view?id=${ob[0]}" class="btn btn-secondary">
							<img src="../resources/images/view.png" height="20" width="20">
							</a>
							</td>
						</tr>
					</D:forEach>
				</table>
			</div>
			<div class="card-footer">
				${msg} 
				<a href="excel">
				<img src="../resources/images/excel.png" height="30" width="40">
				</a> 
				<a href="pdf">
				<img src="../resources/images/pdf.png" height="30" width="40">
				</a>
			</div>
		</div>
	</div>
</body>
</html>