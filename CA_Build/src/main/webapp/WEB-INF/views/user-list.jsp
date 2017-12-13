
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>
<div align="right">
				<a class="btn btn-success "
					href="${pageContext.request.contextPath}/staff/create.html">Add User</a>
			</div>
<c:if test="${fn:length(userList) gt 0}">

<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">		
		<div class="cl-mcont">
		
			<div class="row">
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
								<thead>
									<tr>
										<th>StaffID</th>
										<th>Name</th>
										<th>Password</th>
										<th>role</th>
										<th>ContactNumber</th>
										<th>Active</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="staff" items="${userList}">

									<tr>
										<td>${staff.staffID}</td>
										<td>${staff.name}</td>
										<td>${staff.password}</td>
										<td>${staff.role}</td>
										<td>${staff.contactNumber}</td>
										<td>${staff.active}</td>
										<td><a class="fa fa-pencil fa-fw" href="${pageContext.request.contextPath}/staff/edit-${staff.staffID}">edit</a><br/>
										<a class="fa fa-book fa-fw" href="${pageContext.request.contextPath}/staff/delete-${staff.staffID}">delete</a></td>
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
	<c:url value="${request.contextPath}/staff/list" var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:url value="${request.contextPath}/staff/list" var="next">
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
						<c:url value="${request.contextPath}/staff/list"
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
</c:if>
<c:if test="${not empty message}">
   <c:out value="${message}"/>
</c:if>

