<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<form:form method="post" modelAttribute="staff" action="${pageContext.request.contextPath}/Authorize/validate">  
<form:errors path="*" cssClass="error" />  
<table>  
  <tr>  
    <td>userName</td>  
    <td><form:input path="name" /></td>  
    <td><form:errors path="name" cssClass="error" /></td>  
  </tr>  
  <tr>  
    <td>pass</td>  
    <td><form:input path="password" /></td>  
    <td><form:errors path="password" cssClass="error" /></td>  
  </tr>  
  <tr>  
    <td colspan="3"><input type="submit" /></td>  
  </tr>  
</table>  
</form:form>  
</body>
</html>