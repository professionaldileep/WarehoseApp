<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>SaleView Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>SaleView Page</h3>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th class="table table-bordered table-primary">SaleId</th>
						<td>${sale.id}</td>
					</tr>
					<tr>
						<th >OrderCode</th>
						<td>${sale.orderCode}</td>
					</tr>
					<tr>
						<th>ShipmentCode</th>
						<td>${sale.shipmentCode.shipmentCode}</td>
					</tr>
					<tr>
						<th>Customer</th>
						<td>${sale.customer.userCode}</td>
					</tr>
					<tr>
						<th>ReferenceNumber</th>
						<td>${sale.refNumber}</td>
					</tr>
					<tr>
						<th>StockMode</th>
						<td>${sale.stockMode}</td>
					</tr>
					<tr>
						<th>StockSource</th>
						<td>${sale.stockSource}</td>
					</tr>
					<tr>
						<th>DefaultStatus</th>
						<td>${sale.defStatus}</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${sale.description}</td>
					</tr>
				</table>
			</div>
			<div class="card-footer">
			<a href="excel?id=${ob.id}">
				<img src="../resources/images/excel.png" height="35" width="40">
			</a> 
			<a href="pdf?id=${ob.id}">
				<img src="../resources/images/pdf.png" height="35" width="40">
			</a>
			</div>
		</div>
	</div>
</body>
</html>