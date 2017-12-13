<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<form:form method="POST"
		action="${pageContext.request.contextPath}/reorder/lists">
		<label>Supplier</label>
		<select name="select_supplier">
			<option value="ALL">ALL</option>
			<c:forEach var="slist" items="${sList}">
				<option value="${slist}">${slist}</option>
			</c:forEach>
		</select>
		<td><input type="submit" value="search" /></td>
	</form:form>
	<br />
	<tr>
		<c:forEach var="plist" items="${xlist}">
			<h2 align="center">Inventory Reorder Report For Suppler ${plist}</h2>
		</c:forEach>
	</tr>
	<table class="table table-bordered" id="datatable">
		<thead>
			<tr>
				<th>partNumber</th>
				<th>unitPrice</th>
				<th>quantity</th>
				<th>reorderQty</th>
				<th>minOrderQty</th>
				<th>orderQty</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="plist" items="${reorderReport}">
				<tr>
					<td>${plist.partNumber}</td>
					<td>${plist.unitPrice}</td>
					<td>${plist.quantity}</td>
					<td>${plist.reorderquantity}</td>
					<td>${plist.minorderQty}</td>
					<td>${plist.orderQty}</td>
					<td>${plist.price}</td>
				</tr>
			</c:forEach>
			
			<tr  style="text-align:left">
			<td colspan="6"></td>
			
			<td ><b>Total Price: </b><fmt:formatNumber type = "number" 
         pattern = "###.00" value = "${sum}" /></td>
			</tr>
		</tbody>
		
	</table>

</body>
</html>