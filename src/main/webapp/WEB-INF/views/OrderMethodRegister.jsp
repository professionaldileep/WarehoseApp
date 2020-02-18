<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>OrderMethodRegister Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info">
				<h2>
					<i>OrderMethod Register Page</i>
				</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="orderMethod"
					id="myform">
					<div class="row">
						<div class="col-4">
							<label for="orderMode">OrderMode</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="orderMode" value="sale" />
							sale
							<form:radiobutton path="orderMode" value="purchase" />
							purchase
						</div>
						<div class="col-4" id="orderModeError"></div>
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
					<div class="row">
						<div class="col-4">
							<label for="orderType">OrderType</label>
						</div>
						<div class="col-4">
							<form:select path="orderType" class="form-control">
								<form:option value="" class="form-control">--select--</form:option>
								<form:option value="FIFO" class="form-control">FIFO</form:option>
								<form:option value="LIFO" class="form-control">LIFO</form:option>
								<form:option value="FCFO" class="form-control">FCFO</form:option>
								<form:option value="FEFO" class="form-control">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4" id="orderTypeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderAccept">OrderAccept</label>
						</div>
						<div class="col-4">
							<form:checkbox path="orderAccept" value="Multi-model" />
							Multi-model
							<form:checkbox path="orderAccept" value="AcceptReturn" />
							AcceptReturn
						</div>
						<div class="col-4" id="orderAcceptError"></div>
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
							<input type="submit" value="Create OrderMethod"
								class="btn btn-success" /> <input type="reset" value="Clear"
								class="btn btn-info" />
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer">${msg}</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/OrderMethod.js"></script>
</body>
</html>