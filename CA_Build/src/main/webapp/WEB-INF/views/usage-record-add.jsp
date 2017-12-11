<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>New Usage Record</h3>

<form:form method="POST" modelAttribute="usageRecord"
	action="${pageContext.request.contextPath}/mechanic/usage-record/create">

	<table>
		<tbody>
			<tr>
				<td>Record ID</td>
				<td><form:input path="recordID" /></td>
				<td><form:errors path="recordID" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>UsageDate</td>
				<td><form:input path="UsageDate" /></td>
				<td><form:errors path="UsageDate" cssStyle="color: red;" /></td>
			</tr>
			
				<tr>
				<td>Staff ID</td>
				<td><form:input path="staffID" /></td>
				<td><form:errors path="staffID" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>customer Name</td>
				<td><form:input path="customerName" /></td>
				<td><form:errors path="customerName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>contactNumber</td>
				<td><form:input path="contactNumber" /></td>
				<td><form:errors path="contactNumber" cssStyle="color: red;" /></td>
			</tr>
			
			
			
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>