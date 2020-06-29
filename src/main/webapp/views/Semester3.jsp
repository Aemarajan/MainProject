<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Third Semester</title>

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
			
			<div class="mt-2 mb-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb indigo lighten-4">
						<li class="breadcrumb-item">
							<a class="black-text" href="home">Home</a>
							<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
						</li>
						<li class="breadcrumb-item">
							<a class="black-text" href="AddExternal">Add External Marks</a>
							<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
						</li>
						<li class="breadcrumb-item active">Third Semester</li>
					</ol>
				</nav>
			</div>
		
			<h4 class="banner p-2 mt-2 mb-2">Third Semester</h4>
			
<%-- 			<s:form action="SaveSemester3" method="post" modelAttribute="external" class="mt-2"> --%>
			<form action="SaveSemester3" method="post" class="mt-2">
				
<!-- 				<div class="md-form" hidden="true"> -->
<%-- 					<s:input path="user_id" id="user_id" value='<%= request.getParameter("user") %>' class="form-control"/> --%>
<%-- 					<s:errors path="user_id" cssClass="error"></s:errors> --%>
<%-- 					<label for="username">UserId<span class="mandatory pl-1">*</span></label> --%>
<!-- 				</div> -->
				
				<div class="md-form" hidden="true">
					<input name="user" id="user" value='<%= request.getParameter("user") %>' class="form-control"/>
					<label for="username">UserId<span class="mandatory pl-1">*</span></label>
				</div>
				
<!-- 				<div class="md-form" hidden="true"> -->
<%-- 					<s:input path="semester" id="semester" cssClass="form-control" value='<%= request.getParameter("sem") %>' /> --%>
<%-- 					<s:errors path="semester" cssClass="error"></s:errors> --%>
<%-- 					<label class="d-flex justify-content-start"> Semester <span class="mandatory pl-1"> *</span></label> --%>
<!-- 				</div> -->
				
				<div class="md-form" hidden="true">
					<input name="semester" id="semester" class="form-control" value='<%= request.getParameter("sem") %>' />
					<label class="d-flex justify-content-start"> Semester <span class="mandatory pl-1"> *</span></label>
				</div>
			
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Subject Code</th>
							<th>Subject Name</th>
							<th>Credit</th>
							<th>Grade</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${subject }">
							<tr>
								<td class="text-uppercase">${s.subject.subject_code }</td>
								<td class="text-capitalize">${s.subject.subject_name }</td>
								<td class="">${s.subject.credit }</td>
								<td>
<%-- 									<s:select path="${s.subject.subject_code }" id="${s.subject.subject_code }" class="custom-select browser-default grade" style="width:150px" required="true"/> --%>
									<select name="${s.subject.subject_code }" id="${s.subject.subject_code }" class="custom-select browser-default grade" style="width:150px" required></select>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

<!-- 				<div class="form-group"> -->
<%-- 					<s:checkbox path="inn" id="inn" cssClass="drop"/> --%>
<%-- 					<s:errors path="inn" cssClass="error"></s:errors> --%>
<!-- 					<label>In use</label> -->
<!-- 				</div> -->
				
				<div class="form-group">
					<input type="checkbox" name="inn" id="inn" class="drop"/>
					<label>In use</label>
				</div>
				
				
				<div class="text-center">
					<button type="submit" class="btn btn-custom w-25">Add</button>
				</div>
			</form>			
		</div>	
	</div>
	
	<c:if test="${exist != null }">
		<div class="toast" id="LongToast"
			style="position: absolute; overflow: auto; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Error</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Semester Mark Details Already Entered for this Student, Try Another Semester...</div>
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
			var grade = $('.grade');

			var varurl = "http://localhost:8080/api/getAllGrade";
			$.ajax({
				type: 'GET',
				url: varurl,
				async: true,
				success: function(result){
					var output = "<option value=''> -- Select -- </option>";
					for(var i in result){
						output += "<option value='" + result[i].id + "'>" + result[i].acronym + "</option>"; 
					}
					//console.log(output);
					grade.html(output);
				}
			});
		});
	</script>
</body>
</html>