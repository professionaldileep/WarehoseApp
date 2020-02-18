<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UomRegister Page</title>
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
	<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">

			<div class="card-Header b3">
				<h3>WELCOME TO UOM REGISTER PAGE</h3>
			</div>


			<div class="card-body">
				<form:form modelAttribute="uom" action="save" method="post" id="myform">

					<div class="row">
						<div class="col-4">
							<label for="uomType">UOM TYPE</label>
						</div>
						<div class="col-4">
							<form:select path="uomType" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NOPACKING">NO PACKING</form:option>
								<form:option value="NA">--NA--</form:option>
							</form:select>
						</div>
						<div class="col-4" id="uomTypeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="uomModel">UOM MODEL</label>
						</div>
						<div class="col-4">
							<form:input path="uomModel"	class="form-control" />
						</div>
						<div class="col-4" id="uomModelError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="descr">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="descr" class="form-control"/>
						</div>
						<div class="col-4" id="descrError"></div>
					</div>


					<div class="row">
						<div class="col-2">
							<input type="submit" value="Create UOM" class="btn btn-primary">
						</div>
						<div class="col-2">
							<input type="reset" value="clear" class="btn btn-warning">
						</div>
					</div>
				</form:form>
			</div>

			<div class="card-footer b1 text-skyblue">
				<b>${msg}</b>
			</div>

		</div>
	</div>
	<script type="text/javascript" src="../resources/js/Uom.js"></script>
</body>
</html>