<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>UserRegister Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info">
				<h2>
					<i>UserRegister Page</i>
				</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="user" id="userForm">
					<div class="row">
						<div class="col-4">
							<label for="userName">UserName</label>
						</div>
						<div class="col-4">
							<form:input path="userName" class="form-control" />
						</div>
						<div class="col-4" id="userNameError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userEmail">UserEmail</label>
						</div>
						<div class="col-4">
							<form:input path="userEmail" class="form-control" />
						</div>
						<div class="col-4" id="userEmailError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userPwd">UserPassword</label>
						</div>
						<div class="col-4">
							<form:password path="userPwd" class="form-control" />
							<!-- <input type="password" name="userPwd" id="userPwd"/> -->
						</div>
						<div class="col-4" id="userPwdError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="roles">Roles</label>
						</div>
						<div class="col-4">
							<form:checkbox path="roles" value="Admin" />
							Admin
							<form:checkbox path="roles" value="Employee" />
							Employee
						</div>
						<div class="col-4" id="rolesError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<input type="submit" value="Create User"
								class="btn btn-success" /> <input type="reset" value="Clear"
								class="btn btn-info" />
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer">${msg}</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/user.js"></script>
</body>
</html>