<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>New Supplier page</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/create.html">
	<table>
		<tbody>
			<tr>
				<td>Supplier ID</td>
				<td><form:input path="supplierID" value="${PK}" readonly="true"/></td>
				<td><form:errors path="supplierID" cssStyle="color: red;" /></td>
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
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	<p>Message:</p>
	<c:if test="${not empty message}">
		<font color="blue"> <c:out value="${message}" /></font>
		<c:if test="${not empty error}">
			<font color="red"> <c:out value="${error}" /></font>
		</c:if>
	</c:if>
</form:form>