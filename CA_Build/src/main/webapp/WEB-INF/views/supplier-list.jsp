

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
	<h1 align="center">View Supplier list</h1>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/admin/list">
		<div class="form-group">
			<div class="col-sm-3">
				<select name="filter" class="form-control">
					<option value="supplierName">Supplier Name</option>
					<option value="contactNumber">Contact Number</option>
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
					href="${pageContext.request.contextPath}/admin/create">Add
					Supplier</a>
			</div>
		</div>
	</form:form>

	<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">
			<div class="cl-mcont">

				<div class="row">

					<div class="content">
						<div class="table-responsive">
							<table class="table table-bordered" id="datatable">
								<thead>
									<tr>
										<th>Supplier ID</th>
										<th>Supplier Name</th>
										<th>Contact Number</th>
										<th>Address</th>
										<th>Contact Person</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="sup" items="${supplierList}">

										<tr>

											<td>${sup.supplierID}</td>
											<td>${sup.supplierName}</td>
											<td>${sup.contactNumber}</td>
											<td>${sup.address}</td>
											<td>${sup.contactPerson}</td>
											<td><a class="fa fa-pencil fa-fw"
												href="${pageContext.request.contextPath}/admin/${sup.supplierID}">edit</a><br />
												<a class="fa fa-book fa-fw"
												href="${pageContext.request.contextPath}/admin/delete/${sup.supplierID}">delete</a></td>
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
	<c:url value="${request.contextPath}/admin/list" var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:url value="${request.contextPath}/admin/list" var="next">
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
						<c:url value="${request.contextPath}/admin/list" var="url">
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

	<p>Message:</p>
	<c:if test="${not empty message}">
		<font color="blue"> <c:out value="${message}" /></font>
	</c:if>
	<c:if test="${not empty error}">
		<font color="red"> <c:out value="${error}" /></font>
	</c:if>
</body>
</html>