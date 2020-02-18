<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="card-header">Welcome To Parts in Purchase</div>
			<div class="card-body">
				<table class="table table-bordered">
					<tr>
						<td>OrderCode:</td>
						<td>${parent.orderCode}</td>
					</tr>
					<tr>
						<td>Status:</td>
						<td>${parent.defaultStatus}</td>
					</tr>
				</table>
				<hr color="red">
				<form:form action="add" method="POST" modelAttribute="purchaseDtl">
					<div class="row">
						<div class="col-4">SELECT PARTS:</div>
						<div class="col-4">
							<form:select path="part.id" class="form-control">
								<form:option value="">--select--</form:option>
								<form:options items="${parts}" />
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>
					<form:hidden path="parent.id" />
					<div class="row">
						<div class="col-4">QUANTITY:</div>
						<div class="col-4">
							<form:input path="qnt" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<input type="submit" value="ADD" class="btn btn-success">
						</div>
					</div>
				</form:form>
				<hr color="cyan">
				<table class="table table-bordered table-hover">
					<tr>
						<th>SLNO</th>
						<th>PART</th>
						<th>BASE COST</th>
						<th>QUANTITY</th>
						<th>OPERATIONS</th>
					</tr>
					<d:forEach items="${parent.purchaseDtl}" var="ob">
						<tr>
							<td><d:out value="${ob.slno}" /></td>
							<td><d:out value="${ob.part.code}" /></td>
							<td><d:out value="${ob.part.baseCost}" /></td>
							<td><d:out value="${ob.qnt}" /></td>
							<td><a href="remove?id=${parent.id}&dtlId=${ob.id}"
								class="btn btn-danger"><img
									src="../resources/images/delete2.png" height="25" width="25">
							</a></td>
						</tr>
					</d:forEach>
				</table>
			</div>
			<div class="card-footer"></div>
		</div>
	</div>

</body>
</html>