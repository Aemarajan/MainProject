<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Header</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./views/css/bootstrap.min.css">
	<link rel="stylesheet" href="./views/css/bootstrap.css"/>
	<style>
		.footer{
			position:absolute;
			left:0;
			bottom:0;
			width:100%;
		}
	</style>
</head>
<body>
	<div id="header"></div>
	<div class="d-flex justify-content-center">
		<h1>This is home page</h1>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
	<script src="./views/js/jquery..js"></script>
	<script src="./views/js/jquery.min.js"></script>
	<script src="./views/js/popper.min.js"></script>
	<script>
    $(document).ready(function(){
        $('#header').load("http://localhost:8080/header");
    });
    </script>
</body>
</html>