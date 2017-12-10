<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/css/simple.css" />" rel="stylesheet"
	type="text/css">

<title>Reorder Form</title>
</head>
<body>
	<h1>Print Reorder Form</h1>
	<br />
	<span>Search by:</span>
	<br />
	<form>
		<label>Week ending on: </label> <input type="date"><br> <input
			type="submit" value="Start Search">
	</form>
	<br />
	<form:form method="POST"
		action="${pageContext.request.contextPath}/admin/reorderdetails">
		<h3>Search Results</h3>
		<table>
			<tr>
				<th>Item Number</th>
				<th>Order ID</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Order Date</th>
			</tr>

			<c:forEach var="rlist" items="${rList}">
				<tr>
					<td>${rlist.partNumber}</td>
					<td>${rlist.reorderID}</td>
					<td>${rlist.orderQuantity}</td>
					<td>${rlist.unitPrice}</td>
					<td>${rlist.dateOrdered}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="1"></td>
				<td colspan="2" align="right"><input type="submit"
					value="Print Form"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>