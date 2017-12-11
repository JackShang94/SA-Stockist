
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>
<a href="${pageContext.request.contextPath}/staff/create.html">Add
	User</a>
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
										<td><a href="${pageContext.request.contextPath}/staff/edit-${staff.staffID}">edit</a></td>
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

</c:if>