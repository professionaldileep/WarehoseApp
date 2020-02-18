<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>PurchaseViewPage</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
		<div class="card-header"><h3>Purchase View Page</h3></div>
		<div class="card-body">
		<table class="table table-bordered table-hover">
			<tr>
				<th>ID</th>
				<td>${purchase.id}</td>
			</tr>
			<tr>
				<th>PurchaseOrderCode</th>
				<td>${purchase.orderCode}</td>
			</tr>
			<tr>
				<th>PurchaseShipmentCode</th>
				<td>${purchase.shipmentCode.shipmentCode}</td>
			</tr>
			<tr>
				<th>PurchaseVendor</th>
				<td>${purchase.vendor.userCode}</td>
			</tr>
			<tr>
				<th>ReferenceNumber</th>
				<td>${purchase.referenceNum}</td>
			</tr>
			<tr>
				<th>QualityCheck</th>
				<td>${purchase.qualityCheck}</td>
			</tr>
			<tr>
				<th>DefaultStatus</th>
				<td>${purchase.defaultStatus}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td>${purchase.description}</td>
			</tr>
		</table>
		</div>
		<div class="card-footer">
		<a href="excel?id=${purchase.id}">
		<img src="../resources/images/excel.png" height="35" width="45">
		</a>
		<a href="pdf?id=${purchase.id}">
		<img src="../resources/images/pdf.png" height="35" width="45">
		</a>
		</div>
		</div>
	</div>
</body>
</html>