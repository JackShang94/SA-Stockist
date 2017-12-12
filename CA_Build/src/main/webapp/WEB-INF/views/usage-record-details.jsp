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

	<h1>Details</h1>"src/main/webapp/WEB-INF/views/admin-usage-record-edit.jsp"

	<table class="table table-bordered">
		<tr>
			<th align="right">Record ID</th>
			<td colspan="3"><c:out value="${recordList.recordID}" /></td>
		</tr>
		<tr>
			<th align="right">Record Date</th>
			<td colspan="3"><c:out value="${recordList.usageDate}" /></td>

		</tr>
		<tr>
			<th align="right">Staff ID</th>
			<td colspan="3"><c:out value="${recordList.staffID}" /></td>
		</tr>
		<tr>
			<th align="right">Customer Name</th>
			<td colspan="3"><c:out value="${recordList.customerName}" /></td>

		</tr>

		<tr>
			<th align="right">Customer Contact Details</th>
			<td colspan="3"><c:out value="${recordList.contactNumber}" /></td>

		</tr>
	</table>



<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">		
		<div class="cl-mcont">
		
			<div class="row">
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
								<thead>
									<tr>
										<th>parNumber</th>
										<th>quantity</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="usageRecordDetails" items="${usageRecordDetails}">
									<tr>
										<td>${usageRecordDetails.primarykey.partNumber}</td>
										<td>${usageRecordDetails.usedQuantity}</td>
						
						
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

	<%-- <form:form method="POST" modelAttribute="usageRecord"
		action="${pageContext.request.contextPath}/mechanic/usage-record.html">
		
		<form:button name="back" type="submit" value="s">
			<img src="${pageContext.request.contextPath}/image/button_submit.gif"
				width="59" height="22" alt="" border="0">
		</form:button>
	</form:form> --%>

</body>
</html>