<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShippingViewPage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">Shipping View Page</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th>Shipping ID</th>
						<td>${shipping.id}</td>
					</tr>
					<tr>
						<th>Shipping Code</th>
						<td>${shipping.shippingCode}</td>
					</tr>
					<tr>
						<th>Shipping Reference Number</th>
						<td>${shipping.shippingRefNum}</td>
					</tr>
					<tr>
						<th>CourierReference Number</th>
						<td>${shipping.courierRefNum}</td>
					</tr>
					<tr>
						<th>Contact Details</th>
						<td>shipping.contactDetails</td>
					</tr>
					<tr>
						<th>Sale OrderCode</th>
						<td>${shipping.saleOrderCode }</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${shipping.description }</td>
					</tr>
					<tr>
						<th>Bill To Address</th>
						<td>${shipping.billToAddr }</td>
					</tr>
					<tr>
						<th>Ship To Address</th>
						<td>${shipping.shipToAddr}</td>
					</tr>
				</table>
			</div>
			<div class="card-footer">
				<a href="excel?id=${shipping.id}"><img
					src="../resources/images/excel.png" height="35" width="40"></a> <a
					href="pdf?id=${shipping.id}"><img src="../resources/images/pdf.png"
					height="35" width="40"></a>
			</div>
		</div>
	</div>
</body>
</html>