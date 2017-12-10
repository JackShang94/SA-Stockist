<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>New Usage Record page</h3>

<form:form method="POST" modelAttribute="recordList"
	action="${pageContext.request.contextPath}/mechanic/usage-record/create">



	<table>


		<tr>
			<td>Record ID</td>
			<td><form:input path="recordID" /></td>

		</tr>

		<tr>
			<td>Record Date</td>
			<td><form:input path="recordDate" /></td>

		</tr>

		<tr>
			<td>staffID</td>
			<td><form:input path="staffID" /></td>

		</tr>

		<tr>
			<td>Customer Name</td>
			<td><form:input path="customerName" /></td>

		</tr>
		<tr>
			<td>Contact Number</td>
			<td><form:input path="contactNumber" /></td>

		</tr>

		<tr>
			<td><input type="submit" value="Create" /></td>


		</tr>
	</table>
</form:form>