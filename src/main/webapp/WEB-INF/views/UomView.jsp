<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Uom View Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>Welcome to Uom View Page</h3>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th>ID</th>
						<td>${ob.id}</td>
					</tr>
					<tr>
						<th>Type</th>
						<td>${ob.uomType}</td>
					</tr>
					<tr>
						<th>Model</th>
						<td>${ob.uomModel}</td>
					</tr>
					<tr>
						<th>Note</th>
						<td>${ob.descr}</td>
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