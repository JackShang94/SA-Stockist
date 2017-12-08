<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<form:form method="POST" modelAttribute="supl"
	action="${pageContext.request.contextPath}/create/">



<table>


	<tr>
		<td>Supplier ID</td>
		<td><form:input path="supplierID" /></td>

	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><form:input path="supplierName" /></td>

	</tr>
	<tr>
		<td>Contact Number</td>
		<td><form:input path="contactNumber" /></td>

	</tr>
	<tr>
		<td>Address</td>
		<td><form:input path="address" /></td>

	</tr>

	<tr>
		<td>Contact Person</td>
		<td><form:input path="contactPerson" /></td>

	</tr>

	<tr>
		<td><input type="submit" value="Create" /></td>


	</tr>
</table>
</form:form>