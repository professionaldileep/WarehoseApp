<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>ShippingRegister Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">Shipping Register Page</div>
			<div class="card-body">
				<form:form id="myform" action="save" method="post" modelAttribute="shipping">
					<div class="row">
						<div class="col-4">
							<label for="shippingCode">Shipping Code</label>
						</div>
						<div class="col-4">
							<form:input path="shippingCode" class="form-control" />
						</div>
						<div class="col-4" id="shippingCodeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shippingRefNum">Shipping Reference Number</label>
						</div>
						<div class="col-4">
							<form:input path="shippingRefNum" class="form-control" />
						</div>
						<div class="col-4" id="shippingRefNumError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="courierRefNum">Courier Reference Number</label>
						</div>
						<div class="col-4">
							<form:input path="courierRefNum" class="form-control" />
						</div>
						<div class="col-4" id="courierRefNumError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="contactDetails">Contact Details</label>
						</div>
						<div class="col-4">
							<form:textarea path="contactDetails" class="form-control" />
						</div>
						<div class="col-4" id="contactDetailsError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="saleOrderCode">Sale OrderCode</label>
						</div>
						<div class="col-4">
							<form:input path="saleOrderCode" class=" form-control" />
						</div>
						<div class="col-4" id="saleOrderCodeError"></div>
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
							<label class="billToAddr">BillToAddress</label>
						</div>
						<div class="col-4">
							<form:textarea path="billToAddr" class=" form-control" />
						</div>
						<div class="col-4" id="billToAddrError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipToAddr">Ship To Address</label>
						</div>
						<div class="col-4">
							<form:textarea path="shipToAddr" class="form-control" />
						</div>
						<div class="col-4" id="shipToAddrError"></div>
					</div>
					<input type="submit" value="CreateShipping" />
				</form:form>
			</div>
			<div class="card-footer">${msg}</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/shipping.js"></script>
</body>
</html>