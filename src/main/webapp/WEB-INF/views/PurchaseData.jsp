<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="D" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Purchase Data Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>Purchase DataViewPage</h3>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th>PurchaseId</th>
						<th>QualityCheck</th>
						<th>Operations</th>
					</tr>
					<D:forEach items="${list}" var="ob">
						<tr>
							<td>${ob[0]}</td>
							<td>${ob[1]}</td>
							<td><a href="delete?id=${ob[0]}"> <img
									src="../resources/images/delete.png" height="20" width="20">
							</a> <a href="edit?id=${ob[0]}"> <img
									src="../resources/images/edit.png" height="20" width="20">
							</a> <a href="view?id=${ob[0]}"> <img
									src="../resources/images/view.png" height="20" width="20">
							</a> <a href="parts?id=${ob[0]}"><img
									src="../resources/images/items2.png" height="30" width="30"></a>
								<a href="vendorinvoice?id=${ob[0]}">VendorInvoice</a>
							</td>
						</tr>
					</D:forEach>
				</table>
			</div>
			<div class="card-footer">
				${msg} <a href="excel"> <img src="../resources/images/excel.png"
					height="30" width="40">
				</a> <a href="pdf"> <img src="../resources/images/pdf.png"
					height="30" width="40">
				</a>
			</div>
		</div>
	</div>
</body>
</html>