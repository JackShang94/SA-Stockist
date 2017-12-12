<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>Updating Usage Record</h3>

<form:form method="POST" modelAttribute="recordList"
	action="${pageContext.request.contextPath}/mechanic/usage-record-create">

	<table>
		<tbody>
			<tr>
				<td>Record ID</td>
				<td><form:input path="recordID" /></td>
				<td><form:errors path="recordID" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td>UsageDate</td>
				<td><form:input type="Date" path="usageDate" /></td>
				<td><form:errors path="usageDate" cssStyle="color: red;" /></td>
				
				
			</tr>

			<tr>
				<td>Staff ID</td>
				<td><form:select path="staffID">
					<c:forEach var="droplist" items="${dropList}" >
					<option value="${droplist}">${droplist}</option>
					</c:forEach>
					</form:select></td>
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

		</tbody>
	</table>

	<br />


	<table>
		<thead>
			<tr>
				<th>Part Number</th>
				<th>Product Name</th>
				<th>Quantity</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="usageRecordDetails" items="${usageRecordDetails}">

				<tr>
					<td>${usageRecordDetails.partNumber}</td>
					<td>${usageRecordDetails.partName}</td>

					<td><input type="text" value="${usageRecordDetails.quantity}" /></td>
				</tr>

			</c:forEach>





		</tbody>


	</table>
	<br />
	<input type="submit" value="Update" />

</form:form>