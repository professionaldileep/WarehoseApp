<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>WhUserEditPage</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<form:form action="update" id="myform" method="post" modelAttribute="wh">
		<div class="container">
			<div class="card-header">
				<h3>WhUserEditPage</h3>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-4">
						<label for="id">ID</label>
					</div>
					<div class="col-4">
						<form:input path="id" readonly="true" Class="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="userType">UserType</label>
					</div>
					<div class="col-4">
						<form:radiobutton path="userType" value="VENDOR" />
						vendor
						<form:radiobutton path="userType" value="CUSTOMER" />
						Customer
					</div>
					<div class="col-4" id="userTypeError"></div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="userCode">UserCode</label>
					</div>
					<div class="col-4">
						<form:input path="userCode" Class="form-control"/>
					</div>
					<div class="col-4" id="userCodeError"></div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="userFor">UserFor</label>
					</div>
					<div class="col-4">
						<form:input path="userFor" Class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="userEmail">UserEmail</label>
					</div>
					<div class="col-4">
						<form:input path="userEmail" Class="form-control"/>
					</div>
					<div class="col-4" id="userEmailError"></div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="userContact">UserContact</label>
					</div>
					<div class="col-4">
						<form:input path="userContact" Class="form-control"/>
					</div>
					<div class="col-4" id="userContactError"></div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="uidType">User Id Type</label>
					</div>
					<div class="col-4">
						<form:select path="uidType" Class="form-control">
							<form:option value="">--Select--</form:option>
							<form:option value="PanCard">PanCard</form:option>
							<form:option value="Aadhar">Aadhar</form:option>
							<form:option value="VoterId">VoterId</form:option>
							<form:option value="Other">Other</form:option>
						</form:select>
					</div>
					<div class="col-4" id="uidTypeError"></div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="other">If Other</label>
					</div>
					<div class="col-4">
						<form:input path="other" Class="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
						<label for="uidNumber">Id Number</label>
					</div>
					<div class="col-4">
						<form:input path="uidNumber" Class="form-control"/>
					</div>
					<div class="col-4" id="uidNumberError"></div>
				</div>
				<div class="row">
					<div class="col-4">
						<input type="submit" value="UpdateUser">
					</div>
				</div>
			</div>
			<div class="card-footer"></div>
		</div>
	</form:form>
	<script type="text/javascript" src="../resources/js/WhUser.js"></script>
</body>
</html>