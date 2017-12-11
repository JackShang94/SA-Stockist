
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h1>Supplier List page</h1>
<a href="${pageContext.request.contextPath}/admin/create">Add Supplier</a>
<c:if test="${fn:length(supplierList) gt 0}">
<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">		
		<div class="cl-mcont">
		
			<div class="row">
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
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
										<td> ${sup.supplierID}</td>
										<td> ${sup.supplierName}</td>
										<td> ${sup.contactNumber}</td>
										<td> ${sup.address}</td>
										<td> ${sup.contactPerson}</td>
										<td><a href="${pageContext.request.contextPath}/admin/${sup.supplierID}">edit</a></td>
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

<c:url value="${request.contextPath}/admin/list"
		var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:url value="${request.contextPath}/admin/list"
		var="next">
		<c:param name="page" value="${page+1}" />
	</c:url>
	<span> <a href="<c:out value="${prev}" />">Previous</a> <c:forEach
			begin="0" end="${maxPages}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${page == i.index}">
					<span>${i.index}</span>
				</c:when>
				<c:otherwise>
					<c:url value="${request.contextPath}/admin/list"
						var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach> <a href="<c:out value="${next}" />">Next</a>
	</span>

</c:if>

  
  
  
