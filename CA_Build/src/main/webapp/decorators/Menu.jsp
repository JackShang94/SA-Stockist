<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Stockist System : Team3</title>
<!-- BOOTSTRAP STYLES-->
<link href="../css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="../css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="../css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- LOGINPAGE STYLES-->
<link href="../css/loginpage.css" rel="stylesheet" />

<!--  -->
<link rel="shortcut icon" href="images/favicon.png">
<link href="../js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery.gritter/css/jquery.gritter.css" />

<link rel="stylesheet" type="text/css"
	href="../js/jquery.nanoscroller/nanoscroller.css" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery.easypiechart/jquery.easy-pie-chart.css" />
<link rel="stylesheet" type="text/css"
	href="../js/bootstrap.switch/bootstrap-switch.css" />
<link rel="stylesheet" type="text/css"
	href="../js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery.select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="../js/bootstrap.slider/css/slider.css" />
<link rel="stylesheet" type="text/css" href="../js/intro.js/introjs.css" />

</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.role=='Admin'}">
			<div id="wrapper">
				<div class="navbar navbar-inverse navbar-fixed-top">
					<div class="adjust-nav">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">&nbsp;Stockist System-Team3</a>
						</div>
						<div class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a
									href="${pageContext.request.contextPath}/Authorize/logout">Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
				
			</div>
			
			 <nav class="navbar-default navbar-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="main-menu">
						<li class="text-center user-image-back"><img
							src="../image/find_user.png" class="img-responsive" /></li>
						<li ><a
							href="${pageContext.request.contextPath}/product/product-list"><i
								class="fa fa-desktop "></i>Manage products</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/list"><i
								class="fa fa-edit "></i>Manage suppliers</a></li>

						<li><a href="${pageContext.request.contextPath}/staff/list"><i
								class="fa fa-table "></i>Manage users</a></li>
						<li><a
							href="${pageContext.request.contextPath}/reorder/lists"><i
								class="fa fa-edit "></i>Reorder report</a></li>
						<li><a
							href="${pageContext.request.contextPath}/mechanic/admin-usage-record"><i
								class="fa fa-sitemap "></i>Record usage</a></li>
					</ul>
				</div>
			</nav> 
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<div>
								<decorator:body />
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>

		<c:when test="${sessionScope.role=='Mechanic'}">
			<div id="wrapper">
				<div class="navbar navbar-inverse navbar-fixed-top">
					<div class="adjust-nav">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">&nbsp;Stockist System-Team3</a>
						</div>
						<div class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a
									href="${pageContext.request.contextPath}/Authorize/logout">Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<nav class="navbar-default navbar-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="main-menu">
						<li class="text-center user-image-back"><img
							src="../image/find_user.png" class="img-responsive" /></li>
						<li class="adjust-nav"><a
							href="${pageContext.request.contextPath}/product/product-show-list"><i
								class="fa fa-desktop "></i>view products</a></li>
						<li><a
							href="${pageContext.request.contextPath}/reorder/lists"><i
								class="fa fa-edit "></i>Reorder report</a></li>
						<li><a
							href="${pageContext.request.contextPath}/mechanic/usage-record"><i
								class="fa fa-sitemap "></i>Record usage</a></li>
					</ul>
				</div>
			</nav>
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<div>
								<decorator:body />
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.role== null}">
			<div>
				<decorator:body />
			</div>
		</c:when>
	</c:choose>

	<!-- JQUERY SCRIPTS -->
	<script src="../js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="../js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="../js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="../js/custom.js"></script>
</body>
</html>
