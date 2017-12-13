<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>usage record list</title>
</head>
<body>
<h1 align="center" >Usage Record</h1>
<div align="right">
<a class="btn btn-success " 
href="${pageContext.request.contextPath}/mechanic/usage-record-create">Add new usage record</a>
</div>
<br>
<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">		
		<div class="cl-mcont">
		
			<div class="row">
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
								<thead>
									<tr>
										<th>RecordID</th>
										<th>UsageDate</th>
										<th>StaffID</th>
										<th>CustomerName</th>
										<th>CustomerContact</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="recordList" items="${recordList}">

									<tr>
										<td>${recordList.recordID}</td>
										<td>${recordList.usageDate}</td>
										<td>${recordList.staffID}</td>
										<td>${recordList.customerName}</td>
										<td>${recordList.contactNumber}</td>
										<td><a class="fa fa-book fa-fw" href="${pageContext.request.contextPath}/mechanic/usage-record-display-${recordList.recordID}">details</a></td>
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
	<c:url value="${request.contextPath}/mechanic/usage-record" var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:url value="${request.contextPath}/mechanic/usage-record" var="next">
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
						<c:url value="${request.contextPath}/mechanic/usage-record"
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