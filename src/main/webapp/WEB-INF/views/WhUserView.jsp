<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>WhUserTypeViewPage</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">WhUserTypeViewPage</div>
			<div class="card-body">
				<table class="table table-bordered table-hover table-primary">
					<tr>
						<th>WhuserType</th>
						<th>Value</th>
					</tr>
					<tr>
						<th>ID</th>
						<td>${ob.id}</td>
					</tr>
					<tr>
						<th>WhUserType</th>
						<td>${ob.userType}</td>
					</tr>
					<tr>
						<th>WhUserCode</th>
						<td>${ob.userCode}</td>
					</tr>
					<tr>
						<th>WhUserFor</th>
						<td>${ob.userFor}</td>
					</tr>
					<tr>
						<th>WhUserEmail</th>
						<td>${ob.userEmail}</td>
					</tr>
					<tr>
						<th>WhUserContact</th>
						<td>${ob.userContact}</td>
					</tr>
					<tr>
						<th>WhUserIdType</th>
						<td>${ob.uidType}</td>
					</tr>
					<tr>
						<th>WhUserIdother</th>
						<td>${ob.other}</td>
					</tr>
					<tr>
						<th>WhUserIdNumber</th>
						<td>${ob.uidNumber}</td>
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