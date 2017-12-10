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
<title>Insert title here</title>
</head>
<body>
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

</body>
</html>