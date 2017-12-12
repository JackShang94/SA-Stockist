<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New User page</h3>
<form:form method="POST" commandName="staff"
	action="${pageContext.request.contextPath}/staff/create">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="staffID" /></td>
				<td><form:input path="staffID" value="${PK}" readonly="true" /></td>
				<td><form:errors path="staffID" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="password" /></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="role" /></td>
				<td><form:select path="role">
					<c:forEach var="droplist" items="${dropList}" >
					<option value="${droplist}">${droplist}</option>
					</c:forEach>
					</form:select></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="contactNumber" /></td>
				<td><form:input path="contactNumber" /></td>
				<td><form:errors path="contactNumber" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="active" /></td>
				<td><form:input path="active" value="1" readonly="true"/></td>
				<td><form:errors path="active" cssStyle="color: red;" /></td>
			</tr>
			
			

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<c:if test="${not empty message}">
   <c:out value="${message}"/>
</c:if>
</form:form>

