<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Supplier page</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/${supplier.supplierID}">
	<table>
		<tbody>

			<tr>
				<td>Supplier ID</td>
				<td><form:input path="supplierID" readonly="true" /></td>
				
			</tr>

			<tr>
				<td>Supplier Name</td>
				<td><form:input path="supplierName" /></td>
				<td><form:errors path="supplierName" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td>Contact Number</td>
				<td><form:input path="contactNumber" /></td>
				<td><form:errors path="contactNumber" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td>Contact Person</td>
				<td><form:input path="contactPerson" /></td>
				<td><form:errors path="contactPerson" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>