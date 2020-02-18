<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>GrnEdit Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">GrnEdit Page</div>
			<div class="card-body">
				<form:form action="update" id="myform" method="post" modelAttribute="Grn">
					<div class="row">
						<div class="col-4">
							<label for="id">GrnID</label>
						</div>
						<div class="col-4">
							<form:input path="id" readonly="true" class="form-control" />
						</div>
					</div>
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
							<form:select path="orderCode" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:option value="OCA1">OCA1</form:option>
								<form:option value="OCB2">OCB2</form:option>
								<form:option value="NA">-NA-</form:option>
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
								<input type="submit" value="CreateGrn" class="btn btn-info" />
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer"></div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/Grn.js"></script>
</body>
</html>