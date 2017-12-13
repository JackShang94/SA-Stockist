<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product page</title>
</head>
<body>
    <div id="cl-wrapper">
        <div class="container-fluid" id="pcont">
            <div class="cl-mcont">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block-flat">
                            <div class="header">
                                <h3>Edit Product page</h3>
                            </div>
                            <div class="content">
                                <form:form class="form-horizontal group-border-dashed" method="POST" modelAttribute="product"
									action="${pageContext.request.contextPath}/product/editproduct-${product.partNumber}">
											<div class="form-group">
												<label class="col-sm-3 control-label">Part Number</label>
												<div class="col-sm-6">
												<form:input class="form-control" path="partNumber" value="${PK}" readonly="true" />
												<form:errors class="parsley-errors-list" path="partNumber" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Product Name</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="productName" />
												<form:errors class="parsley-errors-list" path="productName" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Unit Price</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="unitPrice"/>
												<form:errors class="parsley-errors-list" path="unitPrice" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Quantity</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="quantity"/>
												<form:errors class="parsley-errors-list" path="quantity" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Description</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="description"/>
												<form:errors class="parsley-errors-list" path="description" cssStyle="color: red;" />
												</div>
											</div>									
											<div class="form-group">
												<label class="col-sm-3 control-label">Color</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="color"/>
												<form:errors class="parsley-errors-list" path="color" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Dimension</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="dimension"/>
												<form:errors class="parsley-errors-list" path="dimension" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Reorder Point</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="reorderPoint"/>
												<form:errors class="parsley-errors-list" path="reorderPoint" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Min Order</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="minOrder"/>
												<form:errors class="parsley-errors-list" path="minOrder" cssStyle="color: red;" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">SupplierID</label>
												<div class="col-sm-6">
													<form:select class="form-control" path="supplierID">
													<c:forEach var="droplist" items="${dropList}" >
													<option value="${droplist}">${droplist}</option>
													</c:forEach>
													</form:select>
												<form:errors class="parsley-errors-list" path="supplierID" cssStyle="color: red;" />
												</div>
											</div>																																																							
											<div class="form-group">
												<label class="col-sm-3 control-label">Shelf Location</label>
												<div class="col-sm-6">
												<form:input class="form-control"  path="shelfLocation"/>
												<form:errors class="parsley-errors-list" path="shelfLocation" cssStyle="color: red;" />
												</div>
											</div>	
		                                    <div class="form-group">
		                                        <div class="col-sm-offset-2 col-sm-10">
		                                            <button class="btn btn-primary" type="submit">Submit</button>
		                                        </div>
		                                    </div>			
								</form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>