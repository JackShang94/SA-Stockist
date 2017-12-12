<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" >View Product list</h1>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/product/product-list">
		<div class="form-group">
			<div class="col-sm-3">
				<select name="filter" class="form-control">
					<option value="ID">ID</option>
					<option value="Name">Name</option>
					<option value="Description">Description</option>
					<option value="Color">Color</option>
					<option value="Dimension">Dimension</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="text" name="searchVar" class="form-control" />
			</div>
			<div class="col-sm-3">
				<input type="submit" value="Search" class="btn btn-primary " />
			</div>
			<div align="right">
				<a class="btn btn-success "
					href="${pageContext.request.contextPath}/product/productcreate">Add
					Product</a>
			</div>
			</div>
			</form:form>
		
		<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">		
		<div class="cl-mcont">
		
			<div class="row">
						
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
								<thead>
									<tr>
										<th>image</th>
										<th>Part Number</th>
										<th>Product Name</th>
										<th>Unit Price</th>
										<th>Quantity</th>
										<th>Description</th>
										<th>Color</th>
										<th>Dimension</th>
										<th>Reorder Point</th>
										<th>Minimum Order</th>
										<th>Supplier ID</th>
										<th>Shelf Location</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="plist" items="${pList}">

									<tr>
									   	<td><img
											src="<c:url value="/image/product_images/${plist.partNumber}.jpg" />"
											alt="Testing image" width="90" height="120" /></td>
										<td>${plist.partNumber}</td>
										<td>${plist.productName}</td>
										<td>${plist.unitPrice}</td>
										<td>${plist.quantity}</td>
										<td>${plist.description}</td>
										<td>${plist.color}</td>
										<td>${plist.dimension}</td>
										<td>${plist.reorderPoint}</td>
										<td>${plist.minOrder}</td>
										<td>${plist.supplierID}</td>
										<td>${plist.shelfLocation}</td>
										<td><a class="fa fa-pencil fa-fw" href="${pageContext.request.contextPath}/product/editproduct-${plist.partNumber}">edit</a><br/>
										<a class="fa fa-book fa-fw" href="${pageContext.request.contextPath}/product/deleteproduct/${plist.partNumber}">delete</a></td>
									</tr>
								</c:forEach>
								</tbody>
								</table>														
							</div>
						</div>			
				</div>
			</div>		
		  </div>
		</div>
	<!-- Paging -->
	<c:url value="${request.contextPath}/product/product-list" var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:url value="${request.contextPath}/product/product-list" var="next">
		<c:param name="page" value="${page+1}" />
	</c:url>
	<div class="dataTables_paginate paging_bs_normal">
		<ul class="pagination">
			<li class="prev disabled"><span class="fa fa-angle-left"><a
					href="<c:out value="${prev}" />">Previous</a></span></li>
			<c:forEach begin="0" end="${maxPages}" step="1" varStatus="i">
				<c:choose>
					<c:when test="${page == i.index}">
						<li><span>${i.index}</span></li>
					</c:when>
					<c:otherwise>
						<c:url value="${request.contextPath}/product/product-list"
							var="url">
							<c:param name="page" value="${i.index}" />
						</c:url>
						<li><a href='<c:out value="${url}" />'>${i.index}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<li class="next"><a href="<c:out value="${next}" />">Next<span
					class="fa fa-angle-right"></span></a></li>
		</ul>
	</div>
</body>
</html>