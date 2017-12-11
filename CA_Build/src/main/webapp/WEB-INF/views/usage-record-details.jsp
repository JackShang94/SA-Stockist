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

	<p>Details</p>


	<table>
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

	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr>
			<th><spring:message code="Part Number" /></th>
			<th><spring:message code="Quantity" /></th>

		</tr>

		<c:forEach var="usageRecordDetails" items="${usageRecordDetails}">
			<tr>
				<td>${usageRecordDetails.primarykey.partNumber}</td>
				<td>${usageRecordDetails.usedQuantity}</td>


			</tr>
		</c:forEach>




	</table>
	<%-- <form:form method="POST" modelAttribute="usageRecord"
		action="${pageContext.request.contextPath}/mechanic/usage-record.html">
		
		<form:button name="back" type="submit" value="s">
			<img src="${pageContext.request.contextPath}/image/button_submit.gif"
				width="59" height="22" alt="" border="0">
		</form:button>
	</form:form> --%>

</body>
</html>