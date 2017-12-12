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
<title>Edit Product page</title>
</head>
<body>
<h3>Edit Product page</h3>
<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/editproduct-${product.partNumber}">
	<table>
		<tbody>
			<tr>
				<td>Part Number</td>
				<td><form:input path="partNumber" readonly="true" /></td>
			</tr>
			
			<tr>
				<td>Product Name</td>
				<td><form:input path="productName" /></td>
				<td><form:errors path="productName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Unit Price</td>
				<td><form:input path="unitPrice" /></td>
				<td><form:errors path="unitPrice" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity" /></td>
				<td><form:errors path="quantity" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td>Color</td>
				<td><form:input path="color" /></td>
				<td><form:errors path="color" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" /></td>
				<td><form:errors path="dimension" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Reorder Point</td>
				<td><form:input path="reorderPoint" /></td>
				<td><form:errors path="reorderPoint" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Min Order</td>
				<td><form:input path="minOrder" /></td>
				<td><form:errors path="minOrder" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>SupplierID</td>
				<td><form:select path="supplierID">
					<c:forEach var="droplist" items="${dropList}" >
					<option value="${droplist}">${droplist}</option>
					</c:forEach>
					</form:select></td>
				<td><form:errors path="supplierID" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Shelf Location</td>
				<td><form:input path="shelfLocation" /></td>
				<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
			</tr>			
				<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
</body>
</html>