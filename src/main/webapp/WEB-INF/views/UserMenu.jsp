<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- ****************MENU BAR STARTS HERE********* -->

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
		<!-- Brand -->
		<a class="navbar-brand " href="#"><img
			src="../resources/images/logo.png" width="100" height="60" /></a>

		<!-- Links -->
		<ul class="navbar-nav">




			<!-- **** 1.START: Uom ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> UOM </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/uom/reg">Register</a> <a
						class="dropdown-item" href="${url}/uom/all">View All</a> <a
						class="dropdown-item" href="${url}/uom/charts">Charts</a>
				</div></li>
			<!--** END UOM **-->

			<!-- 2.START: GRN -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> GRN </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/grn/reg">Register </a> <a
						class="dropdown-item" href="${url}/grn/all">View All</a>
				</div></li>
			<!-- END: GRN -->

			<!--3. START: PURCHASE -->

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> PURCHASE </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/purchase/reg">Register </a>
					<a class="dropdown-item" href="${url}/purchase/all">View All</a>
				</div></li>

			<!--END: PURCHASE -->

			<!--4. START: SALE -->

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> SALE </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/sale/reg">Register </a> <a
						class="dropdown-item" href="${url}/sale/all">View All</a>
				</div></li>
			<!-- END: SALE -->

			<!-- 5.START: SHIPMENTTYPE -->

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> SHIPMENTTYPE </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/shipmenttype/reg">Register
					</a> <a class="dropdown-item" href="${url}/shipmenttype/all">View
						All</a>
				</div></li>
			<!-- END: SHIPMENTTYPE -->

			<!-- 6.START: SHIPPING -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> SHIPPING </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/shipping/reg">Register </a>
					<a class="dropdown-item" href="${url}/shipping/all">View All</a>
				</div></li>

			<!-- END: SHIPPING -->


			<!-- 7.**** START: OM ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> ORDER METHOD </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/om/reg">Register </a> <a
						class="dropdown-item" href="${url}/om/all">View All</a>
				</div></li>
			<!--** END OM **-->

			<!--8. Start: WhUSER Type -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> WhUserType </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/whusertype/reg">Register
					</a> <a class="dropdown-item" href="${url}/whusertype/all">View All</a>
				</div></li>
			<!-- End: WhUser Type -->


			<!--9. Start: PART MODULE -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> PART </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/part/reg">Register
					</a> <a class="dropdown-item" href="${url}/part/all">View All</a>
				</div></li>
			<!-- End: END PART MODULE -->
			
			<!--10. Start: PART MODULE -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> USER </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/user/reg">Register
					</a>
				</div></li>
			<!-- End: END USER MODULE -->

			<!-- 10.Documents -->
			<li class="nav-item"><a class="nav-link text-white"
				href="${url}/document/reg"><b>DOCUMENTS</b></a></li>


			<!-- Logout Link -->
			<li class="nav-item"><a class="nav-link text-white"
				href="${url}/logout"><b>LOGOUT</b></a></li>

		</ul>
	</nav>
</body>
</html>