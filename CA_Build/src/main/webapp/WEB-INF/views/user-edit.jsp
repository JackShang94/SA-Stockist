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
<title>Edit Product page</title>
</head>
<body>
	<div id="cl-wrapper">
		<div class="container-fluid" id="pcont">
			<div class="cl-mcont">
				<div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">
								<h3>Edit User page</h3>
							</div>
							<div class="content">
								<form:form class="form-horizontal group-border-dashed"
									method="POST" modelAttribute="user"
									action="${pageContext.request.contextPath}/staff/edit-${staff.staffId}">
									<div class="form-group">
										<label class="col-sm-3 control-label">Staff ID</label>
										<div class="col-sm-6">
											<form:input class="form-control" path="staffID" value="${PK}"
												readonly="true" />
											<form:errors class="parsley-errors-list" path="staffID"
												cssStyle="color: red;" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Staff Name</label>
										<div class="col-sm-6">
											<form:input class="form-control" path="name" />
											<form:errors class="parsley-errors-list" path="name"
												cssStyle="color: red;" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Password</label>
										<div class="col-sm-6">
											<form:input class="form-control" path="password" />
											<form:errors class="parsley-errors-list" path="password"
												cssStyle="color: red;" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Role</label>
										<div class="col-sm-6">
											<form:select class="form-control" path="role">
												<c:forEach var="droplist" items="${dropList}">
													<option value="${droplist}">${droplist}</option>
												</c:forEach>
											</form:select>
											<form:errors class="parsley-errors-list" path="role"
												cssStyle="color: red;" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Contact Number</label>
										<div class="col-sm-6">
											<form:input class="form-control" path="contactNumber" />
											<form:errors class="parsley-errors-list" path="contactNumber"
												cssStyle="color: red;" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Active</label>
										<div class="col-sm-6">
											<form:input class="form-control" path="active" />
											<form:errors class="parsley-errors-list" path="active"
												cssStyle="color: red;" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button class="btn btn-primary" type="submit">Submit</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>