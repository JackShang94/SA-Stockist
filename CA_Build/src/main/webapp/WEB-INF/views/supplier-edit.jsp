<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Supplier page</h3>

<form:form method="POST" modelAttribute="supl"
	action="${pageContext.request.contextPath}/edit/${supl.supplierID}.html">
	<table>
		<tbody>
			<tr>
				<td>Supplier ID</td>
				<td><form:input path="supplierID" readonly="true" /></td>
				<%-- 		<td><form:errors path="userId" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><form:input path="supplierName" /></td>
				<%-- 				<td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>Supplier Contact Number</td>
				<td><form:input path="contactNumber" /></td>
				<%-- 				<td><form:errors path="password" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>Supplier Address</td>
				<td><form:input path="address"  /></td>
				<%-- 				<td><form:errors path="employeeId" cssStyle="color: red;" /></td> --%>
			</tr>

			<tr>
				<td>Contact Person</td>
				<td><form:input path="contactPerson"  /></td>
				<%-- 				<td><form:errors path="employeeId" cssStyle="color: red;" /></td> --%>
			</tr>

			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
</html>