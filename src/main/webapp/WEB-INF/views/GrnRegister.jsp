<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>GRN Register</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>GRN Register Page</h2>
			</div>
			<div class="card-body">
				<form:form action="save" id="myform" method="post" modelAttribute="grn">
					<div class="row">
						<div class="col-4">
							<label for="grnCode">GrnCode</label>
						</div>
						<div class="col-4">
							<form:input path="grnCode" class="form-control" />
						</div>
						<div class="col-4" id="grnCodeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="grnType">GrnType</label>
						</div>
						<div class="col-4">
							<form:input path="grnType" class="form-control" />
						</div>
						<div class="col-4" id="grnTypeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderCode">OrderCode</label>
						</div>
						<div class="col-4">
							<form:select path="${purchase.id}" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${purchase}"/>
							</form:select>
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="description">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control" />
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<div>
						<div class="row">
							<div class="col-4">
								<input type="submit" value="CreateGrn" class="btn btn-success">
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer">${msg}</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/Grn.js"></script>
</body>
</html>