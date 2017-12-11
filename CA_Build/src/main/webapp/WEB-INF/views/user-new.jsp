<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New User page</h3>
<form:form method="POST" commandName="staff"
	action="${pageContext.request.contextPath}/staff/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.staffID" /></td>
				<td><form:input path="staffID" /></td>
				<td><form:errors path="staffID" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.password" /></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.role" /></td>
				<td><form:select path="role" /></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.contactNumber" /></td>
				<td><form:select path="contactNumber" /></td>
				<td><form:errors path="contactNumber" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.active" /></td>
				<td><form:select path="active" /></td>
				<td><form:errors path="active" cssStyle="color: red;" /></td>
			</tr>
			
			

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

