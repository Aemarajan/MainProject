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

<link rel="stylesheet" href="./views/css/all.min.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

<style type="text/css">
	.table-wrapper {
		background: #fff;
		padding: 20px 25px;
		margin: 30px 0;
		border-radius: 3px;
		box-shadow: 0 1px 1px rgba(0,0,0,.05);
	}
	.table-title {        
		background: #435d7d;
		color: #fff;
		padding: 5px 30px;
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
		font-size: 15px;
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
		margin-top: 0px;
	}
	.table{
		padding: 0px 0px ;
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
	.add-new{
		border-radius:50px !important
	}
</style>
</head>
<body>

<!-- Project Start --> 
<div>
	<jsp:include page="Header.jsp" />

	<div class="content">  
		<div id="header"></div>
		
		<div class="container-fluid">
			<div class="row">
				
				<div class="col col-md-1"></div>
					
				<div class="col col-md-10">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6">
									<h2>Manage <b>Batch</b></h2>
								</div>
								<div class="col-sm-6">
									<a href="#addBatchModal" class="btn btn-info add-new" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
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
											<a href="#editBatchModal" class="edit" data-toggle="modal" data-id="${l.id }" data-from="${l.from_year }" data-to="${l.to_year }" data-inn="${l.inn }"><i class="fa fa-pencil" data-toggle="tooltip" title="Edit"></i></a>
											<a href="#deleteBatchModal" class="delete" data-toggle="modal" data-id="${l.id }" data-from="${l.from_year }" data-to="${l.to_year }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
							
						<!-- Add Modal HTML -->
						<div id="addBatchModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="SaveBatchMaster" method="post" modelAttribute="addBatch">
										<div class="modal-header">						
											<h4 class="modal-title">Add Batch</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											
											<c:if test="${exist != null }">
												<div class="mt-1 alert alert-danger alert-dismissible">
												<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
													Batch Already exist.
												</div>
											</c:if>
										
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id"/>					
											<div class="md-form mt-0">
												<s:input path="from_year" maxlength="4" autofocus="autofocus" cssClass="form-control"/>
												<label for="From Year">From Year<span class="mandatory"> *</span></label>
												<s:errors path="from_year" cssClass="error"></s:errors>
											</div>											
											<div class="md-form">
												<s:input path="to_year" maxlength="4" cssClass="form-control"/>
												<label for="To Year">To Year<span class="mandatory"> *</span></label>
												<s:errors path="to_year" cssClass="error"></s:errors>
											</div>
											<div class="form-group">
												<s:checkbox path="inn"/>
												<label>In use</label>
											</div>					
										</div>
										<div class="modal-footer">
											<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
											<input type="submit" class="btn btn-info" value="Add">
										</div>
									</s:form>
								</div>
							</div>
						</div>
						
					
						<!-- Edit Modal HTML -->
						<div id="editBatchModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="EditBatch" method="post" modelAttribute="addBatch">
										<div class="modal-header">						
											<h4 class="modal-title">Edit Batch</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
															
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
												
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id"/>					
											<div class="md-form mt-0">
												<s:input path="from_year" maxlength="4" autofocus="autofocus" cssClass="form-control"/>
												<label for="From Year">From Year<span class="mandatory"> *</span></label>
												<s:errors path="from_year" cssClass="error"></s:errors>
											</div>
											<div class="md-form">
												<s:input path="to_year" maxlength="4" autofocus="autofocus" cssClass="form-control"/>
												<label for="To Year">To Year<span class="mandatory"> *</span></label>
												<s:errors path="to_year" cssClass="error"></s:errors>
											</div>
											<div class="form-group">
												<s:checkbox path="inn"/>
												<label>In use</label>
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
						<div id="deleteBatchModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="DeleteBatch" method="post">
										<div class="modal-header">						
											<h4 class="modal-title">Delete Employee</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">					
											<input id="id" name="id" hidden/>
											<div class="md-form mt-0">
												<input id="name" class="form-control" readonly/>
											</div>
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
					<!-- Table wrapper -->
				</div>
				<!-- col-md-10 -->
				
				<div class="col col-md-1"></div>
			
			</div>
			<!-- Row -->
		</div>
		<!-- Container Fluid -->
	</div>
	<!-- Content -->
	
	<jsp:include page="Footer.jsp" />
</div>

<c:if test="${addError != null }"> 
	<script type="text/javascript">
		$('#addBatchModal').modal('show');
	</script>
</c:if>

<c:if test="${editError != null }"> 
	<script type="text/javascript">
		$('#editBatchModal').modal('show');
	</script>
</c:if>

<!-- Project End -->

<!-- jQuery -->
<script type="text/javascript" src="./views/js/jquery.min.js"></script>

<script type="text/javascript" src="./views/js/popper.min.js"></script>

<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>

<script type="text/javascript" src="./views/js/mdb.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#header').load("http://localhost:8080/header");

		$('#editBatchModal').on('show.bs.modal', function (event) {
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

		$('#deleteBatchModal').on('show.bs.modal', function (event) {
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