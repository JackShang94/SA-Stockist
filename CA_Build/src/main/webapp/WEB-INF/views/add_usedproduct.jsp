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
	<form:form method="POST" modelAttribute="user"
	action="${pageContext.request.contextPath}/mechanic/add-items">

		<table>
			<thead>
				<tr>
					<th>Part Number</th>
					<th>Product Name</th>
					<th>Quantity</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="plist" items="${pList}">

					<tr>
						<td>${plist.partNumber}</td>
						<td>${plist.productName}</td>
						
						<%-- <td>${plist.unitPrice}</td>
					<td>${plist.quantity}</td>
					<td>${plist.description}</td>
					<td>${plist.color}</td>
					<td>${plist.dimension}</td>
					<td>${plist.reorderPoint}</td>
					<td>${plist.minOrder}</td>
					<td>${plist.supplierID}</td>
					<td>${plist.shelfLocation}</td> --%>

						<td><form:input value="0" name="${plist.partNumber}" /></td>
					</tr>

				</c:forEach>
				<tr>
					<td><input type="submit" value="Add Items" /></td>
					<td></td>
					<td></td>
				</tr>

			</tbody>


		</table>

	</form:form>
</body>
</html>