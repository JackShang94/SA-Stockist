<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Supplier List page</h3>
<a href="${pageContext.request.contextPath}/admin/create">Add
	Supplier</a>
<c:if test="${fn:length(supplierList) gt 0}">
<table style="cellspacing: 2; cellpadding: 2; border: 1;">

	<tr class="listHeading">
		<th>Supplier ID</th>
		<th>Supplier Name</th>
		<th>Contact Number</th>
		<th>Address</th>
		<th>Contact Person</th>
		<th>${sessionScope.message }</th>
		<th><spring:message code="caption.edit" /></th>
		<th><spring:message code="caption.delete" /></th>
	</tr>


	<c:forEach var="sup" items="${supplierList}">
		<tr class="listRecord">
			<td align="left">${sup.supplierID}</td>
			<td align="left">${sup.supplierName}</td>
			<td align="left">${sup.contactNumber}</td>
			<td align="left">${sup.address}</td>
			<td align="left">${sup.contactPerson}</td>
			<td align="center"><a
				href="${pageContext.request.contextPath}/admin/${sup.supplierID}.html"><spring:message
						code="caption.edit" /></a></td>
			<td><a
				href="${pageContext.request.contextPath}/admin/delete/${sup.supplierID}"><spring:message
						code="caption.delete" /></a></td>
		</tr>
	</c:forEach>

</table>
</c:if>