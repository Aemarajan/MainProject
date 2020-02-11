<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Blood Group Master</title>

<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="./views/css/mdb.min.css">

<link rel="stylesheet" href="./views/css/style.css">
<style type="text/css">
body {
	color: #404E67;
	background: #F5F7FA;
	font-family: 'Open Sans', sans-serif;
}

.table-wrapper {
	width: 700px;
	margin: 30px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 10px;
	margin: 0 0 10px;
}

.table-title h2 {
	margin: 6px 0 0;
	font-size: 22px;
}

.table-title .add-new {
	float: right;
	height: 60px;
	font-weight: bold;
	font-size: 12px;
	text-shadow: none;
	min-width: 100px;
	border-radius: 50px;
	line-height: 13px;
}

.table-title .add-new i {
	margin-right: 4px;
}

table.table {
	table-layout: fixed;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table th:last-child {
	width: 100px;
}

table.table td a {
	cursor: pointer;
	display: inline-block;
	margin: 0 5px;
	min-width: 24px;
}

table.table td a.add {
	color: #27C46B;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

table.table td a.add i {
	font-size: 24px;
	margin-right: -1px;
	position: relative;
	top: 3px;
}

table.table .form-control {
	height: 32px;
	line-height: 32px;
	box-shadow: none;
	border-radius: 2px;
}

table.table .form-control.error {
	border-color: #f50000;
}

table.table td .add {
	display: none;
}
</style>
</head>
<body>
	<!-- Start your project here-->
	<div>
		<jsp:include page="Header.jsp" />

		<div id="header"></div>

		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col col-md-1"></div>
					<div class="col col-md-10">
						<div class="container">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-8">
											<h2>
												Employee <b>Details</b>
											</h2>
										</div>
										<div class="col-sm-4">
											<button type="button" class="btn btn-info add-new">
												<i class="material-icons">add_circle</i> Add New
											</button>
										</div>
									</div>
								</div>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Name</th>
											<th>In Use</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>B+</td>
											<td>Active</td>
											<td><a class="add"><i class="material-icons">&#xE03B;</i></a>
												<a class="edit"><i class="material-icons">&#xE254;</i></a> <a
												class="delete"><i class="material-icons">&#xE872;</i></a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div class="col col-md-1"></div>

				</div>
			</div>
		</div>
		<jsp:include page="Footer.jsp" />
	</div>
	<!-- End your project here-->

	<script type="text/javascript" src="./views/js/jquery.min.js"></script>

	<script type="text/javascript" src="./views/js/popper.min.js"></script>

	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="./views/js/mdb.min.js"></script>

	<script type="text/javascript">
    $(document).ready(function() {
      	$('#header').load("http://localhost:8080/header");
		var actions = $("table td:last-child").html();
		// Append table with add row form on add new button click
    	$(".add-new").click(function(){
			$(this).attr("disabled", "disabled");
			var index = $("table tbody tr:last-child").index();
        	var row = '<tr><s:form action="SaveBloodGroupMaster" method="post" modelAttribute="bloodgroup">' +
            	'<td><s:input path="name" class="form-control"/></td>' +
            	'<td><s:checkbox path="inn"/></td>' +
				'<td>' + actions + '</td>' +
        	'</s:form></tr>';
    		$("table").append(row);		
			$("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
    	});
		// Add row on add button click
		$(document).on("click", ".add", function(){
			var empty = false;
			var input = $(this).parents("tr").find('input[type="text"]');
        	input.each(function(){
				if(!$(this).val()){
					$(this).addClass("error");
					empty = true;
				} else{
                	$(this).removeClass("error");
            	}
			});
			$(this).parents("tr").find(".error").first().focus();
			if(!empty){
				input.each(function(){
					$(this).parent("td").html($(this).val());
				});			
				$(this).parents("tr").find(".add, .edit").toggle();
				$(".add-new").removeAttr("disabled");
			}		
    	});
		// Edit row on edit button click
		$(document).on("click", ".edit", function(){		
        	$(this).parents("tr").find("td:not(:last-child)").each(function(){
				$(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
			});		
			$(this).parents("tr").find(".add, .edit").toggle();
			$(".add-new").attr("disabled", "disabled");
    	});
		// Delete row on delete button click
		$(document).on("click", ".delete", function(){
        	$(this).parents("tr").remove();
			$(".add-new").removeAttr("disabled");
    	});
    });
  </script>

</body>
</html>