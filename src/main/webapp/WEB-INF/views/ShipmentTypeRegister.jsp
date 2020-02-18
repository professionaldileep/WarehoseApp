<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentType RegisterPage</title>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
.b1 {
	background-color: blue;
}

.b2 {
	background-color: yellow;
}

.b3 {
	background-color: cyan;
}

.b4 {
	background-color: skyblue;
}
</style>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">

			<div class="card-Header bg-secondary text-white">
				<h3>WELCOME TO SHIPMENT TYPE PAGE</h3>
			</div>


			<div class="card-body">
				<form:form action="save" id="shipmentForm" method="post" modelAttribute="shipmentType">

					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">SHIPMENT MODE </label>
						</div>
						<div class="col-4">
							<form:select path="shipmentMode" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="AIR">AIR</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIP">SHIP</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
							</form:select>
						</div>
						<div class="col-4" id="shipmentModeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shipmentCode">SHIPMENT CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shipmentCode" class="form-control" />
						</div>
						<div class="col-4" id="shipmentCodeError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="enable">ENABLESHIPMENT</label>
						</div>
						<div class="col-4">
							<form:select path="enable" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="YES">YES</form:option>
								<form:option value="NO">NO</form:option>
							</form:select>
						</div>
						<div class="col-4" id="enableError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="grade">SHIPMENTGRADE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="grade" value="A" />
							A
							<form:radiobutton path="grade" value="B" />
							B
							<form:radiobutton path="grade" value="C" />
							C
						</div>
						<div class="col-4" id="gradeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="descr">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="descr" class="form-control" />
						</div>
						<div class="col-4" id="descrError"></div>
					</div>


					<div class="row">
						<div class="col-2">
							<input type="submit" value="Create ShipMent"
								class="btn btn-primary">
						</div>
					</div>
				</form:form>
			</div>

			<div class="card-footer b1 ">
				<b>${msg}</b>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/ShipmentType.js"></script>
</body>
</html>