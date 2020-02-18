<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Part Register Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header "><h1>Welcome to PartRegister Page</h1></div>
			<div class="card-body">
				<form:form action="save" id="myform" method="POST"
					modelAttribute="part">
					<div class="row">
						<div class="col-4">
							<label for="code">PartCode</label>
						</div>
						<div class="col-4">
							<form:input path="code" class="form-control" />
						</div>
						<div class="col-4" id="codeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="width">Dimensions</label>
						</div>
						<div class="col-4">
							W
							<form:input path="width" size="3" />
							L
							<form:input path="length" size="3" />
							H
							<form:input path="height" size="3" />
						</div>
						<div class="col-4" id="dimensionsError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="baseCost">BaseCost</label>
						</div>
						<div class="col-4">
							<form:input path="baseCost" class="form-control" />
						</div>
						<div class="col-4" id="baseCostError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="baseCurr">BaseCurrency</label>
						</div>
						<div class="col-4">
							<form:select path="baseCurr" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>
						<div class="col-4" id="baseCurrError"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="uom">UOM</label>
						</div>
						<div class="col-4">
							<form:select path="uom.id" id="uom" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${uom}" />
							</form:select>
						</div>
						<div class="col-4" id="uomError"></div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="sale">SALE</label>
						</div>
						<div class="col-4">
							<form:select path="sale.id" id="sale" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${saleMap}" />
							</form:select>
						</div>
						<div class="col-4" id="saleError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="purchase">PURCHASE</label>
						</div>
						<div class="col-4">
							<form:select path="purchase.id" id="purchase" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:options items="${purchaseMap}" />
							</form:select>
						</div>
						<div class="col-4" id="purchaseError"></div>
					</div>


					<br>
					<div class="row">
						<div class="col-4">
							<label for="note">NOTE</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4" id="noteError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<input type="submit" value="create" class="btn btn-success" />
						</div>
					</div>

				</form:form>
			</div>
			<div class="card-footer">${msg }</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/Part.js"></script>
</body>
</html>