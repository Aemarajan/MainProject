<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Batch Master</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./views/css/bootstrap.min.css">

	<link rel="stylesheet" href="./views/css/mdb.min.css">

	<link rel="stylesheet" href="./views/css/style.css">
	<style type="text/css">
		body {
			color: #566787;
			background: #f5f5f5;
			font-family: 'Varela Round', sans-serif;
			font-size: 13px;
		}
		.table-wrapper {
			background: #fff;
			padding: 20px 25px;
			margin: 30px 0;
			border-radius: 3px;
			box-shadow: 0 1px 1px rgba(0,0,0,.05);
		}
		.table-title {        
			padding-bottom: 15px;
			background: #435d7d;
			color: #fff;
			padding: 16px 30px;
			margin: -20px -25px 10px;
			border-radius: 3px 3px 0 0;
		}
		.table-title h2 {
			margin: 5px 0 0;
			font-size: 24px;
		}
		.table-title .btn-group {
			float: right;
		}
		.table-title .btn {
			color: #fff;
			float: right;
			font-size: 13px;
			border: none;
			min-width: 50px;
			border-radius: 2px;
			border: none;
			outline: none !important;
			margin-left: 10px;
		}
		.table-title .btn i {
			float: left;
			font-size: 21px;
			margin-right: 5px;
		}
		.table-title .btn span {
			float: left;
			margin-top: 2px;
		}
		table.table tr th, table.table tr td {
			border-color: #e9e9e9;
			padding: 12px 15px;
			vertical-align: middle;
		}
		table.table tr th:first-child {
			width: 150px;
		}
		table.table tr th:last-child {
			width: 100px;
		}
		table.table-striped tbody tr:nth-of-type(odd) {
			background-color: #fcfcfc;
		}
		table.table-striped.table-hover tbody tr:hover {
			background: #f5f5f5;
		}
		table.table th i {
			font-size: 13px;
			margin: 0 5px;
			cursor: pointer;
		}	
		table.table td:last-child i {
			opacity: 0.9;
			font-size: 22px;
			margin: 0 5px;
		}
		table.table td a {
			font-weight: bold;
			color: #566787;
			display: inline-block;
			text-decoration: none;
			outline: none !important;
		}
		table.table td a:hover {
			color: #2196F3;
		}
		table.table td a.edit {
			color: #FFC107;
		}
		table.table td a.delete {
			color: #F44336;
		}
		table.table td i {
			font-size: 19px;
		}
		table.table .avatar {
			border-radius: 50%;
			vertical-align: middle;
			margin-right: 10px;
		}
		.pagination {
			float: right;
			margin: 0 0 5px;
		}
		.pagination li a {
			border: none;
			font-size: 13px;
			min-width: 30px;
			min-height: 30px;
			color: #999;
			margin: 0 2px;
			line-height: 30px;
			border-radius: 2px !important;
			text-align: center;
			padding: 0 6px;
		}
		.pagination li a:hover {
			color: #666;
		}	
		.pagination li.active a, .pagination li.active a.page-link {
			background: #03A9F4;
		}
		.pagination li.active a:hover {        
			background: #0397d6;
		}
		.pagination li.disabled i {
			color: #ccc;
		}
		.pagination li i {
			font-size: 16px;
			padding-top: 6px
		}
		.hint-text {
			float: left;
			margin-top: 10px;
			font-size: 13px;
		}    
		/* Modal styles */
		.modal .modal-dialog {
			max-width: 400px;
		}
		.modal .modal-header, .modal .modal-body, .modal .modal-footer {
			padding: 20px 30px;
		}
		.modal .modal-content {
			border-radius: 3px;
		}
		.modal .modal-footer {
			background: #ecf0f1;
			border-radius: 0 0 3px 3px;
		}
		.modal .modal-title {
			display: inline-block;
		}
		.modal .form-control {
			border-radius: 2px;
			box-shadow: none;
			border-color: #dddddd;
		}
		.modal textarea.form-control {
			resize: vertical;
		}
		.modal .btn {
			border-radius: 2px;
			min-width: 100px;
		}	
		.modal form label {
			font-weight: normal;
		}	
		.add-new{
			border-radius:50px !important
		}
	</style>
</head>
<body>
	<!-- Start your project here--> 
	<div>
		<div class="p-auto">
			<jsp:include page="Header.jsp" />

			<div class="content mt-2">  

				<div id="header"></div>

				<div class="container-fluid mt-2 mb-2">
					<div class="row">
						<div class="col col-md-1"></div>
						<div class="col col-md-10 mt-2 mb-2">
							<div class="container">

								<div class="table-wrapper">
									<div class="table-title">
										<div class="row">
											<div class="col-sm-6">
												<h2>Manage <b>Batch</b></h2>
											</div>
											<div class="col-sm-6">
												<a href="#addEmployeeModal" class="btn btn-info add-new" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
											</div>
										</div>
									</div>
									<table class="table table-striped table-hover">
										<thead>
											<tr>
												<th>Name</th>
												<th>From Year</th>
												<th>To Year</th>
												<th>Duration</th>
												<th>In Use</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="l" items="${list }">
											<tr>
												<td>${l.from_year } - ${l.to_year }</td>
												<td>${l.from_year }</td>
												<td>${l.to_year }</td>
												<td>${l.no_of_years }</td>
												<td>
													<c:if test="${l.inn == 1 }">Active</c:if>
													<c:if test="${l.inn != 1 }">In Active</c:if>
												</td>
												<td>
													<a href="#editEmployeeModal" class="edit" data-toggle="modal" data-id="${l.id }" data-from="${l.from_year }" data-to="${l.to_year }" data-inn="${l.inn }"><i class="fa fa-pencil" data-toggle="tooltip" title="Edit"></i></a>
													<a href="#deleteEmployeeModal" class="delete" data-toggle="modal" data-id="${l.id }" data-from="${l.from_year }" data-to="${l.to_year }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="clearfix">
									<div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
									<ul class="pagination">
										<li class="page-item disabled"><a href="#">Previous</a></li>
										<li class="page-item"><a href="#" class="page-link">1</a></li>
										<li class="page-item"><a href="#" class="page-link">2</a></li>
										<li class="page-item active"><a href="#" class="page-link">3</a></li>
										<li class="page-item"><a href="#" class="page-link">4</a></li>
										<li class="page-item"><a href="#" class="page-link">5</a></li>
										<li class="page-item"><a href="#" class="page-link">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
						<!-- Add Modal HTML -->
						<div id="addEmployeeModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="SaveBatchMaster" method="post" modelAttribute="addBatch">
									<div class="modal-header">						
										<h4 class="modal-title">Add Batch</h4>
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									</div>
									<c:if test="${exist != null }">
									<div class="mt-1 alert alert-danger alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Batch Already exist.
									</div>
								</c:if>
								<div class="modal-body">
									<s:hidden path="id"/>					
									<div class="form-group">
										<label>From Year</label>
										<s:input path="from_year" class="form-control"/>
										<s:errors path="from_year" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<label>To Year</label>
										<s:input path="to_year" class="form-control"/>
										<s:errors path="to_year" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<s:checkbox path="inn"/>
										<label>In use</label>
									</div>					
								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
									<input type="submit" class="btn btn-success" value="Add">
								</div>
							</s:form>
						</div>
					</div>
				</div>
				<!-- Edit Modal HTML -->
				<div id="editEmployeeModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<s:form action="EditBatch" method="post" modelAttribute="addBatch">
								<div class="modal-header">						
									<h4 class="modal-title">Edit Batch</h4>
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								</div>
								<div class="modal-body">					
									<div class="modal-body">
										<c:if test="${exist != null }">
											<div class="mt-1 alert alert-danger alert-dismissible">
												<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
												Batch Already exist.
											</div>
										</c:if>
										<c:if test="${invalidYear != null }">
											<div class="mt-1 alert alert-danger alert-dismissible">
												<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
												Batch duration between 2 and 4.
											</div>
										</c:if>		
										<s:hidden path="id" id="id"/>		
										<div class="form-group">
											<label>From Year</label>
											<s:input path="from_year" id="from_year" class="form-control"></s:input>
											<s:errors path="from_year"></s:errors>
										</div>
										<div class="form-group">
											<label>To Year</label>
											<s:input path="to_year" id="to_year" class="form-control"></s:input>
											<s:errors path="to_year"></s:errors>
										</div>
										<div class="form-group">
											<s:checkbox path="inn" id="inn"/>
											<label>In use</label>
										</div>					
									</div>			
								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
									<input type="submit" class="btn btn-info" value="Save">
								</div>
							</s:form>
						</div>
					</div>
				</div>
				<!-- Delete Modal HTML -->
				<div id="deleteEmployeeModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<form action="DeleteBatch" method="post">
								<div class="modal-header">						
									<h4 class="modal-title">Delete Employee</h4>
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								</div>
								<div class="modal-body">					
									<input id="id" name="id" hidden/>
									<input id="name" class="form-control" readonly/>
									<p>Are you sure you want to delete these Records?</p>
									<p class="text-warning"><small>This action cannot be undone.</small></p>
								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
									<input type="submit" class="btn btn-danger" value="Delete">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col col-md-3.5"></div>
		</div>
	</div>
</div>

<jsp:include page="Footer.jsp" />
</div>
</div>
<c:if test="${addError != null }"> 
<script type="text/javascript">
	$('#addEmployeeModal').modal('show');
</script>
</c:if>
<c:if test="${editError != null }"> 
<script type="text/javascript">
	$('#editEmployeeModal').modal('show');
</script>
</c:if>

<!-- End your project here-->

<!-- jQuery -->
<script type="text/javascript" src="./views/js/jquery.min.js"></script>

<script type="text/javascript" src="./views/js/popper.min.js"></script>

<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>

<script type="text/javascript" src="./views/js/mdb.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#header').load("http://localhost:8080/header");
		$('#editEmployeeModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var from = button.data('from'); 
			var to = button.data('to');
			var inn = button.data('inn');
			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#from_year').val(from);
			modal.find('#to_year').val(to);
			if(inn == 1)
				modal.find('#inn').prop('checked',true);
			else
				modal.find('#inn').prop('checked',false);
		});
		$('#deleteEmployeeModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var from = button.data('from'); 
			var to = button.data('to');
			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#name').val(from+' - '+to);
		});
	}); 
</script>
</body>
</html>