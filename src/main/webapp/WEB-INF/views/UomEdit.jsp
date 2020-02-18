<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>UomEditPage</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h3>Welcome to Uom Edit Page</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="uom">
					<div class="row">
						<div class="col-4">
							<label for="id">UOM ID</label>
						</div>
						<div class="col-4">
							<form:input path="id" readonly="true" class="form-control" />
						</div>
					</div>
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
							<form:input path="uomModel" class="form-control" />
						</div>
						<div class="col-4" id="uomModelError"></div>
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
							<input type="submit" value="Update UOM" class="btn btn-primary">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="../resources/js/Uom.js"></script> 
</body>
</html>