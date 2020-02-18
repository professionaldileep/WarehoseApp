<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">GrnViewPage</div>
			<div class="card-body">
				<table class="table-bordered table-hover">
					<tr>
						<th>GrnID</th>
						<td>${grn.id}</td>
					</tr>
					<tr>
						<th>GrnCode</th>
						<td>${grn.grnCode}</td>
					</tr>
					<tr>
						<th>GrnType</th>
						<td>${grn.grnType}</td>
					</tr>
					<tr>
						<th>OrderCode</th>
						<td>${grn.orderCode}</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${grn.description}</td>
					</tr>
				</table>
			</div>
			<div class="card-footer">
				<a href="excel?id=${ob.id}"><img
					src="../resources/images/excel.png" height="35" width="40"></a> <a
					href="pdf?id=${ob.id}"><img src="../resources/images/pdf.png"
					height="35" width="40"></a>
			</div>
		</div>
	</div>
</body>
</html>