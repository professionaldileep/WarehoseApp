<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentTypeView</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary">
				<h3>Welcome TO ShipmentType Viewpage</h3>
			</div>
			<div class="card-body">
				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<td>${ob.id}</td>
					</tr>
					<tr>
						<th>ShipmentMode</th>
						<td>${ob.shipmentMode}</td>
					</tr>
					<tr>
						<th>ShipmentCode</th>
						<td>${ob.shipmentCode}</td>
					</tr>
					<tr>
						<th>ShipmentMode</th>
						<td>${ob.shipmentMode}</td>
					</tr>
					<tr>
						<th>EnableShipment</th>
						<td>${ob.enable}</td>
					</tr>
					<tr>
						<th>ShipmentTypeGrade</th>
						<td>${ob.grade}</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${ob.descr}</td>
					</tr>
				</table>
			</div>
			<div class="card-footer">
				<a href="excel"> <img src="../resources/images/excel.png"
					height="30" width="40">
				</a> <a href="pdf"> <img src="../resources/images/pdf.png"
					height="30" width="40">
				</a>
			</div>
		</div>
	</div>
</body>
</html>