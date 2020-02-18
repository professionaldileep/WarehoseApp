<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>SaleRegister Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>Sale Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="save" id="saleform" method="post" modelAttribute="sale">
					<div class="row">
						<div class="col-4">
							<label for="orderCode">OrderCode</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control"/>
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="shipmentCode">ShipmentCode</label>
						</div>
						<div class="col-4">
							<form:select path="shipmentCode.id" id="shipmentCode" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${shipmentTypeCode}" />
							</form:select>
						</div>
						<div class="col-4" id="shipmentCodeError"></div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="customer">Customer</label>
						</div>
						<div class="col-4">
							<form:select path="customer.id" id="customer" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${customer}" />
							</form:select>
						</div>
						<div class="col-4" id="customerError"></div>
					</div>
				<br>
					<div class="row">
						<div class="col-4">
							<label for="refNumber">ReferenceNumber</label>
						</div>
						<div class="col-4">
							<form:input path="refNumber" class="form-control"/>
						</div>
						<div class="col-4" id="refNumberError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="stockMode">StockMode</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" value="Grade" />
							Grade
							<form:radiobutton path="stockMode" value="Margin" />
							Margin
						</div>
						<div class="col-4" id="stockModeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="stockSource">StockSource</label>
						</div>
						<div class="col-4">
							<form:select path="stockSource" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:option value="Open">OPEN</form:option>
								<form:option value="Avail">AVAIL</form:option>
								<form:option value="Refund">REFUND</form:option>
							</form:select>
						</div>
						<div class="col-4" id="stockSourceError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="defStatus">DefaultStatus</label>
						</div>
						<div class="col-4">
							<form:input path="defStatus" readonly="true" class="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="description">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control"/>
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<div class="row">
						<input type="submit" value="SaleRegister" class="btn btn-success" />
						<input type="reset" value="clear" class="btn btn-info" />
					</div>
				</form:form>
			</div>
			<div class="card-footer">${msg}</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/sale.js"></script>
</body>
</html>