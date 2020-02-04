<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	
<link rel="stylesheet" href="./views/css/bootstrap.min.css">

<link rel="stylesheet" href="./views/css/mdb.min.css">

<link rel="stylesheet" href="./views/css/style.css">

</head>
<body>

	<jsp:include page="Header.jsp" />
		
	<div id="header"></div>
	
	<div class="d-flex justify-content-center ubuntu">
		<h1>This is home page</h1>
	</div>
	
	<div class="footer">
		<jsp:include page="Footer.jsp" />
	</div>

	<!-- jQuery -->
  	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
  
  	<script type="text/javascript" src="./views/js/popper.min.js"></script>
  
  	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
  
  	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	
	<script>
    	$(document).ready(function(){
       		$('#header').load("http://localhost:8080/header");
    	});
    </script> 
</body>
</html>