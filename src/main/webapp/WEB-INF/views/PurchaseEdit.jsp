<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Purchase Edit Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>Welcome To Purchase Edit Page</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="purchase">
					<div class="row">
						<div class="col-4">
							<label for="id">ID</label>
						</div>
						<div class="col-4">
							<form:input path="id" readonly="true" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderCode">OrderCode</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>

					<br>
					<div class="row">
						<div class="col-4">
							<label for="shipmentCode">ShipmentCode</label>
						</div>
						<div class="col-4">
							<form:select path="shipmentCode.id" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${shipmentCode}" />
							</form:select>
						</div>
						<div class="col-4" id="shipmentCodeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="vendor">Vendor</label>
						</div>
						<div class="col-4">
							<form:select path="vendor.id" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${whuserCode }" />
							</form:select>
						</div>
						<div class="col-4" id="vendorError"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="referenceNum">ReferenceNumber</label>
						</div>
						<div class="col-4">
							<form:input path="referenceNum" class="form-control" />
						</div>
						<div class="col-4" id="referenceNumError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="qualityCheck">QualityCheck</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qualityCheck" value="Required" />
							Required
							<form:radiobutton path="qualityCheck" value="NotRequired" />
							NotRequired
						</div>
						<div class="col-4" id="qualityCheckError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="defaultStatus">DefaultStatus</label>
						</div>
						<div class="col-4">
							<form:input path="defaultStatus" readonly="true"
								class="form-control" />
						</div>
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
					<div class="row">
						<div class="col-4">
							<input type="submit" value="UpdateOrder" class="btn btn-success">
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer"></div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/Purchase.js"></script>
</body>
</html>