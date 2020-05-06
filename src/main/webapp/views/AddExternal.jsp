<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h3 class="text-center mt-2 mb-2">External Marks Entry</h3>
			<div hidden="true">
				<input type="text" name="id" id="id" value='<%= session.getAttribute("id") %>'/>
				<input type="text" name="sem" id="sem" value="Semester1" />
			</div>
			
        	<table class="table table-striped">
        		<thead><tr><th>Student List</th><tr></thead>
        		<tbody id="student"></tbody>
        	</table>
        </div>
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
			var student = $('#student');
            var id = $('#id').val();
            var sem = $('#sem').val();

            var pre = "http://localhost:8080/api/getAllStudentByStaffId/";
            var varurl = pre+id;
            $.ajax({
            	type: 'GET',
                url: varurl,
                async: true,
                success:function(result){
                	var output = "<tr></tr>";
                    for(var i in result){
                    	output+="<tr><td class='text-capitalize'><a href=" + sem + "?user_id=" + result[i].student.user_id + " class='' style='cursor:pointer; color:none; text-decoration:none;'>" + result[i].student.name + "</a></td></tr>";
                    }
                    console.log(output);
                student.html(output);
                }
           	});
		});
	</script>
</body>
</html>