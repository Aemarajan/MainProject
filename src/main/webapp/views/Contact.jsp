<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Contact Us</title>

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
		
		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 p-sm-5 p-lg-5 pt-5">
			<h4 class="mb-3">Contact Details</h4>
			
			<div class="d-flex justify-content-between">
				<div class="">
					Dr.P.Jaganathan, MCA.,Ph.D,<br>
					Director,<br>
					Department of MCA,<br>
					PSNA College of Engineering and Technology,<br>
					Kothandaraman nagar,<br>
					Dindigul-624622,<br>
					Tamilnadu,India.<br>
				</div>
				<div class="">
					Direct No : 0451- 2554418<br>
					Board No : 0451-2554032,2554033.<br>
					Extn : 820<br>
					Fax No : 0451- 2554249<br> 
					Email id : hodmca@psnacet.edu.in
				</div>
			</div>
			<!-- row -->
		</div>
	</div>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>

	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>
</body>
</html>