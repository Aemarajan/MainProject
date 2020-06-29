<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>External Marks</title>

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

		<div class="container-fluid pl-6">
			
			<c:set var="user_id" value='<%= session.getAttribute("id")%>'/>
			<c:set var="role" value='<%= session.getAttribute("role")%>'/>
			
			<div class="mt-3 mb-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb indigo lighten-4">
						<li class="breadcrumb-item">
							<a class="black-text" href="home">Home</a>
							<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
						</li>
						<li class="breadcrumb-item">
							<a class="black-text" href="ViewExternal">Get Students</a>
							<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
						</li>
						<li class="breadcrumb-item active">Students List</li>
					</ol>
				</nav>
			</div>
			
			<h4 class="text-center mt-2 mb-2 p-2 banner">External Marks</h4>
			
			<div hidden="true">
				<input type="text" name="id" id="id" value='<%= session.getAttribute("id") %>'/>
			</div>
			
			<div class="container-fluid mt-4 mb-4">
				<table class="table table-striped">
       				<thead>
       					<tr>
       						<th>Student List</th>
       						<th></th>
       						<th></th>
       						<th>Actions</th>
       					<tr>
       				</thead>
       				<tbody id="student">
       					<c:forEach var="l" items="${ AdminViewStudents }">
       						<tr>
       							<td class="text-capitalize">${ l.user.name }</td>
       							<td></td>
       							<td></td>
       							<td><a href="AdminViewSemMarks?user=${l.user.user_id }&name=${l.user.name}" class='view' ><i class='fa fa-eye' aria-hidden='true' data-toggle='tooltip' title='view'></i></a></td>
       						</tr>
       					</c:forEach>
       				</tbody>
       			</table>
			</div>
		</div>
		<!-- Container Fluid -->
	</div>
	
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