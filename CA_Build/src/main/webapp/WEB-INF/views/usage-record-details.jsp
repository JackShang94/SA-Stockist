<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>usage record details</title>
</head>
<body>

	<h1 align="center">Usage Record Details</h1>

	<div class="content">
		<form:form class="form-horizontal group-border-dashed" method="POST"
			modelAttribute="recordList"
			action="${pageContext.request.contextPath}/mechanic/usage-record-display-{recordList.recordID}">
			<div class="form-group">
				<label class="col-sm-3 control-label">Record ID</label>
				<div class="col-sm-6">
					<form:input class="form-control" path="recordID" value="${PK}"
						readonly="true" />
					<form:errors class="parsley-errors-list" path="recordID"
						cssStyle="color: red;" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Record Date</label>
				<div class="col-sm-6">
					<form:input class="form-control" path="usageDate" readonly="true" />
					<form:errors class="parsley-errors-list" path="usageDate"
						cssStyle="color: red;" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Staff ID</label>
				<div class="col-sm-6">
					<form:input class="form-control" path="staffID" readonly="true" />
					<form:errors class="parsley-errors-list" path="staffID"
						cssStyle="color: red;" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Customer Name</label>
				<div class="col-sm-6">
					<form:input class="form-control" path="customerName"
						readonly="true" />
					<form:errors class="parsley-errors-list" path="customerName"
						cssStyle="color: red;" />
				</div>
			</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Customer Contact
						Details</label>
					<div class="col-sm-6">
						<form:input class="form-control" path="contactNumber"
							readonly="true" />
						<form:errors class="parsley-errors-list" path="contactNumber"
							cssStyle="color: red;" />
					</div>
				</div>

		</form:form>
	</div>

	<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">
			<div class="cl-mcont">

				<div class="row">
					<div class="content">
						<div class="table-responsive">
							<table  class="table table-bordered" align="center" style="width:50%" id="datatable">
								<thead align="center">
									<tr>
										<td align="center" ><b>Part Number</b></td>
										<td align="center"><b>Quantity</b></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="usageRecordDetails"
										items="${usageRecordDetails}">
										<tr>
											<td align="center">${usageRecordDetails.primarykey.partNumber}</td>
											<td align="center">${usageRecordDetails.usedQuantity}</td>


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
</body>
</html>