<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>First Semester</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body id="page-top">

	<jsp:include page="Header.jsp" />
<%-- 	<jsp:include page="Menubar.jsp" /> --%>
	<div id="header" class="mt-2"></div>
	
	<div class="wrapper d-flex align-items-stretch">
		
		<jsp:include page="Sidebar.jsp" />

		<div class="container-fluid pl-6 mt-2">
			<h3>First Semester</h3>
			
			<s:form action="SaveSemester1" method="post" modelAttribute="external" class="mt-2">
				
				<div class="md-form" hidden="true">
					<s:input type="text" path="user_id" id="user_id" value='<%= request.getParameter("user_id") %>' class="form-control"/>
					<s:errors path="user_id" cssClass="error"></s:errors>
					<label for="username">UserId<span class="mandatory pl-1">*</span></label>
				</div>
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Subject Code</th>
							<th>Subject Name</th>
							<th>Grade</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${subject }">
							<tr>
								<td class="text-uppercase">${s.subject_code }</td>
								<td class="text-capitalize">${s.subject_name }</td>
								<td>
									<s:input type="text" path="${s.subject_code }" id="${s.subject_code }" cssClass="form-control" style="width:150px;"/>
									<s:errors path="${s.subject_code }" cssClass="error"></s:errors>	
<%-- 									<select name="${s.subject_code }" id="grade" class="custom-select browser-default" style="width:150px"></select> --%>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="form-group">
					<s:checkbox path="inn" id="inn" cssClass="drop"/>
					<s:errors path="inn" cssClass="error"></s:errors>
					<label>In use</label>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-custom w-25">Add</button>
				</div>
			</s:form>			
		</div>	
	</div>
	
	<c:if test="${added != null }">
		<div class="toast" id="Toast" 
			style="position: absolute; overflow: auto; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-success">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>External Marks Details are Added Successfully.</div>
			</div>
		</div>
	</c:if>

	<jsp:include page="Footer.jsp" />
		
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
		
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
		});
	</script>
</body>
</html>