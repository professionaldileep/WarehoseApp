<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Part View Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>Part View Page</h3>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th >PartID</th>
						<td>${part.id}</td>
					</tr>
					<tr>
						<th >PartCode</th>
						<td>${part.code}</td>
					</tr>
					<tr>
						<th >Dimensions</th>
						<td>W: ${part.width} L: ${part.length} H: ${part.height}</td>
					</tr>
					<tr>
						<th >BaseCost</th>
						<td>${part.baseCost}</td>
					</tr>
					<tr>
						<th >BaseCurrency</th>
						<td>${part.baseCurr}</td>
					</tr>
					<tr>
						<th >PartUom</th>
						<td>${part.uom.uomModel}</td>
					</tr>

					<tr>
						<th >Part Sale</th>
						<td>${part.sale.orderCode}</td>
					</tr>

					<tr>
						<th >Part Purchase</th>
						<td>${part.purchase.orderCode}</td>
					</tr>
					<tr>
						<th >NOTE</th>
						<td>${part.note}</td>
					</tr>
				</table>
			</div>
			<div class="card-footer">
				<a href="excel?id=${part.id}"> <img
					src="../resources/images/excel.png" height="35" width="40">
				</a> <a href="pdf?id=${part.id}"> <img
					src="../resources/images/pdf.png" height="35" width="40">
				</a>
			</div>
		</div>
	</div>
</body>
</html>