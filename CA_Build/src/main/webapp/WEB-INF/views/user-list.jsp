
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>
<a href="${pageContext.request.contextPath}/staff/create.html">Add
	User</a>
<c:if test="${fn:length(userList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.staffID" /></th>
				<th><spring:message code="fieldLabel.name" /></th>
				<th><spring:message code="fieldLabel.password" /></th>
				<th><spring:message code="fieldLabel.role" /></th>
				<th><spring:message code="fieldLabel.contactNumber"/></th>
				<th><spring:message code="fieldLabel.active" /></th>				
				
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="staff" items="${userList}">
				<tr class="listRecord">
					<td>${staff.staffID}</td>
					<td>${staff.name}</td>
					<td>${staff.password}</td>
					<td>${staff.role}</td>
					<td>${staff.contactNumber}</td>
					<td>${staff.active}</td>
					
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/staff/edit/${staff.staffID}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/staff/delete/${staff.staffID}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>