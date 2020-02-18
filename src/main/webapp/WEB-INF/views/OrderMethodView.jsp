<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>OrderMethod View Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">OrderMethod View Page</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
					<th>ID</th>
					<td>${orderMethod.id}</td>
					</tr>
					<tr>
					<th>OrderMethod Mode</th>
					<td>${orderMethod.orderMode}</td>
					</tr>
					<tr>
					<th>OrderMethod Code</th>
					<td>${orderMethod.orderCode}</td>
					</tr>
					<tr>
					<th>OrderMethod Type</th>
					<td>${orderMethod.orderType}</td>
					</tr>
					<tr>
					<th>OrderMethod Accept</th>
					<td>${orderMethod.orderAccept}</td>
					</tr>
					<tr>
					<th>Description</th>
					<td>${orderMethod.description}</td>
					</tr>
				</table>
			</div>
			<div class="card-footer">
			<a href="excel?id=${orderMethod.id}"><img src="../resources/images/excel.png" height="35" width="40"></a> 
		<a href="pdf?id=${orderMethod.id}"><img src="../resources/images/pdf.png" height="35" width="40"></a>
			</div>
		</div>
	</div>
</body>
</html>