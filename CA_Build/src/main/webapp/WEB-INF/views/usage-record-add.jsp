<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3 align="center">
	<b>New Usage Record</b>
</h3>
<body>
	<div class="content">
		<form:form class="form-horizontal group-border-dashed" method="POST"
			modelAttribute="usageRecord"
			action="${pageContext.request.contextPath}/mechanic/usage-record-create">

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
					<form:input class="form-control" type="Date" path="UsageDate" />
					<form:errors class="parsley-errors-list" path="UsageDate"
						cssStyle="color: red;" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Staff ID</label>
				<div class="col-sm-6">

					<form:select path="staffID">
						<c:forEach var="droplist" items="${dropList}">
							<option value="${droplist}">${droplist}</option>
						</c:forEach>
					</form:select>
					<form:errors class="parsley-errors-list" path="staffID"
						cssStyle="color: red;" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Customer Name</label>
				<div class="col-sm-6">
					<form:input class="form-control" path="customerName" />
					<form:errors class="parsley-errors-list" path="customerName"
						cssStyle="color: red;" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Customer Contact
					Details</label>
				<div class="col-sm-6">
					<form:input class="form-control" path="contactNumber" />
					<form:errors class="parsley-errors-list" path="contactNumber"
						cssStyle="color: red;" />
				</div>
			</div>
			<br />

			<table class="table table-bordered" align="center" style="width:70%" >
				<thead>
					<tr>
						<td align="center" ><b>Part Number</b></td>
						<td align="center" ><b>Product Name</b></td>
						<td align="center" ><b>Quantity</b></td>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="plist" items="${pList}">

						<tr>
							<td align="center">${plist.partNumber}</td>
							<td align="center">${plist.productName}</td>

							<td align="center"><input align="middle" class="center-block" type="text" value="0" name="${plist.partNumber}" /></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<br />
			<div align="center">
			<button class="btn btn-primary" type="submit">Create</button>
</div>
		</form:form>
	</div>
</body>
