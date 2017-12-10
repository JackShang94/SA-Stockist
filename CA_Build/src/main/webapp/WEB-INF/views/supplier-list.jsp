<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/create/">Add new supplier</a>

	<table>
		<tr>
			<th>Supplier ID</th>
			<th>Supplier Name</th>
			<th>Contact Number</th>
			<th>Address</th>
			<th>Contact Person</th>
			<th>edit</th>
			<th>delete</th>
		</tr>

		<c:forEach var="supl" items= "${slist}">

		<tr>
			<td>${supl.supplierID}</td>
			<td>${supl.supplierName}</td>
			<td>${supl.contactNumber}</td>
			<td>${supl.address}</td>
			<td>${supl.contactPerson}</td>
			<!--  need to state .html at the end or not? NO -->
			<td><a href="${pageContext.request.contextPath}/edit/${supl.supplierID}">edit</a></td>
			<td><a href="${pageContext.request.contextPath}/delete/${supl.supplierID}">delete</a></td>
		</tr>
		
		</c:forEach>

	</table>



</body>
</html>