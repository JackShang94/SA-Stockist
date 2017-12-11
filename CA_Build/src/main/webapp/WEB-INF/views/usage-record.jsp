<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>usage record list</title>
</head>
<body>
<h1>Record</h1>
<div id="cl-wrapper">

		<div class="container-fluid" id="pcont">		
		<div class="cl-mcont">
		
			<div class="row">
						<div class="content">
							<div class="table-responsive">
								<table class="table table-bordered" id="datatable" >
								<thead>
									<tr>
										<th>RecordID</th>
										<th>UsageDate</th>
										<th>StaffID</th>
										<th>CustomerName</th>
										<th>CustomerContact</th>
										<th>ShowDetails</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="recordList" items="${recordList}">

									<tr>
										<td>${recordList.recordID}</td>
										<td>${recordList.usageDate}</td>
										<td>${recordList.staffID}</td>
										<td>${recordList.customerName}</td>
										<td>${recordList.contactNumber}</td>
										<td><a href="${pageContext.request.contextPath}/mechanic/usage-record-display-${recordList.recordID}">details</a></td>
									</tr>

								</c:forEach>
								</tbody>
								</table>			
											
							</div>
						</div>			
				</div>
			</div>		
		  </div>
		</div> 	

</body>
</html>