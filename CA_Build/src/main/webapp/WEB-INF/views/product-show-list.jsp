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
<title>ShowProducts</title>
</head>
<body>
	<h1>Product Show List</h1>
	<span>Search By</span>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/product/product-show-list">
		<select name="filter">
			<option value="ID">ID</option>
			<option value="Name">Name</option>
			<option value="Description">Description</option>
			<option value="Color">Color</option>
			<option value="Dimension">Dimension</option>
		</select>
		<input type="text" name="searchVar" />
		<input type="submit" value="Search" />
	</form:form>
	<table>
		<tr>
			<th>Part Number</th>
			<th>Product Name</th>
			<th>Unit Price</th>
			<th>Quantity</th>
			<th>Description</th>
			<th>Color</th>
			<th>Dimension</th>
			<th>Reorder Point</th>
			<th>Minimum Order</th>
			<th>Supplier ID</th>
			<th>Shelf Location</th>
		</tr>
		<c:forEach var="plist" items="${pList}">
			<tr>
				<td>${plist.partNumber}</td>
				<td>${plist.productName}</td>
				<td>${plist.unitPrice}</td>
				<td>${plist.quantity}</td>
				<td>${plist.description}</td>
				<td>${plist.color}</td>
				<td>${plist.dimension}</td>
				<td>${plist.reorderPoint}</td>
				<td>${plist.minOrder}</td>
				<td>${plist.supplierID}</td>
				<td>${plist.partNumber}</td>
			</tr>
		</c:forEach>
	</table>
	<c:url value="${request.contextPath}/product/product-show-list"
		var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:url value="${request.contextPath}/product/product-show-list"
		var="next">
		<c:param name="page" value="${page+1}" />
	</c:url>
	<span> <a href="<c:out value="${prev}" />">Previous</a> <c:forEach
			begin="0" end="${maxPages}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${page == i.index}">
					<span>${i.index}</span>
				</c:when>
				<c:otherwise>
					<c:url value="${request.contextPath}/product/product-show-list"
						var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach> <a href="<c:out value="${next}" />">Next</a>
	</span>
</body>
</html>