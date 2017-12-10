<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>usage record list</title>
</head>
<body>

	<p>Search By</p>
<a href="${pageContext.request.contextPath}/mechanic/usage-record/create">Add new usage record</a>

	<table>
		<tr>
			<th>Record ID</th>
			<th>staffID</th>
			<th>usageDate</th>
			<th>customerName</th>
			<th>contact number</th>


		</tr>

		<c:forEach var="recordList" items="${recordList}">

			<tr>
				<td>${recordList.recordID}</td>
				<td>${recordList.staffID}</td>
				<td>${recordList.usageDate}</td>
				<td>${recordList.customerName}</td>
				<td>${recordList.contactNumber}</td>



			</tr>

		</c:forEach>

	</table>

</body>
</html>