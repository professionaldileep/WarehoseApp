<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentType Data Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome to ShipmentType Data Page</h2>
			</div>
			<div class="card-body">
				<div class="row">
					<table class="table table-bordered table-hover">
						<tr class="table-success">
							<th>ID</th>

							<th>SHIPMENT MODE</th>

							<th>SHIPMENT CODE</th>

							<th>ENABLE SHIPMENT</th>

							<th>GRADE</th>

							<th>DESCRIPTION</th>

							<th>OPERATION</th>
						</tr>
						<d:forEach items="${list}" var="ob">
							<tr>
								<td><d:out value="${ob.id}" /></td>
								<td><d:out value="${ob.shipmentMode}" /></td>
								<td><d:out value="${ob.shipmentCode}" /></td>
								<td><d:out value="${ob.enable}" /></td>
								<td><d:out value="${ob.grade}" /></td>
								<td><d:out value="${ob.descr}" /></td>
								<td><a href="delete?id=${ob.id}" class="btn btn-danger">
										<img src="../resources/images/delete.png" height="20"
										width="20">
								</a> <a href="edit?id=${ob.id}" class="btn btn-info"> <img
										src="../resources/images/edit.png" height="20" width="20">
								</a> <a href="view?id=${ob.id}" class="btn btn-secondary"> <img
										src="../resources/images/view.png" height="20" width="20">
								</a></td>
							</tr>
						</d:forEach>
					</table>


				</div>
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