<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">Welcome To Parts in Sale</div>
			<div class="card-body">
				<form:form action="#" method="POST" modelAttribute="saleDtl">
					<div class="row">
						<div class="col-4">SELECT PARTS:</div>
						<div class="col-4">
							<form:select path="part.id">
								<form:option value="">--select--</form:option>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">QUANTITY:</div>
						<div class="col-4">
							<form:input path="qty" />
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<input type="submit" value="ADD" class="btn btn-info">
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer"></div>
		</div>
	</div>

</body>
</html>