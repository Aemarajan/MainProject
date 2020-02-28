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

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

<style>
	table.table tr th:first-child {
		width: 300px;
	}
</style>

</head>
<body>

<!-- Project Start --> 
<div>
	<jsp:include page="Header.jsp" />
	
	<div id="header"></div>
	
	<div class="content">  
		<div class="container-fluid">
			<div class="row">
				<div class="col col-md-1"></div>
					
				<div class="col col-md-10">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								
								<div class="col-sm-6">
									<h2>Manage <b>Community</b></h2>
								</div>
								<div class="col-sm-6">
									<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
								</div>
							</div>
						</div>
						
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Name</th>
									<th>Acronym</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="l" items="${list }">
									<tr>
										<td class="text-capitalize">${l.name }</td>
										<td>${l.acronym }</td>
										<td>
											<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
											<c:if test="${l.inn != 1 }"><span><i class="fa fa-circle text-danger"></i>  Inactive</span></c:if>
										</td>
										<td>
											<a href="#editModal" class="edit" data-toggle="modal" data-id="${l.id }" data-name="${l.name }" data-acronym="${l.acronym }" data-inn="${l.inn }"><i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i></a>
											<a href="#deleteModal" class="delete" data-toggle="modal" data-id="${l.id }" data-name="${l.name }" data-acronym="${l.acronym }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
							
						<!-- Add Modal HTML -->
						<div id="addModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="SaveCommunityMaster" method="post" modelAttribute="community">
										<div class="modal-header">						
											<h4 class="modal-title">Add Community</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">
											
											<c:if test="${addExistAcronym != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Acronym Already Exist, Enter New Acronym...</div>
													</div>
												</div>
											</c:if>
											
											<c:if test="${addExistCommunity != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Community Already Exist, Enter New Community...</div>
													</div>
												</div>
											</c:if>
										
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id"/>
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="name" id="name" autofocus="autofocus" cssClass="form-control"/>
														<label for="name">Name<span class="mandatory"> *</span></label>
														<s:errors path="name" cssClass="error"></s:errors>
													</div>		
												</div>
												<div class="col-sm-1">
													<a href="#" data-toggle="tooltip" data-placement="bottom" title="Example : Backward Class"><i class="fa fa-info mt-4"></i></a>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="acronym" id="acronym" maxlength="3" cssClass="form-control"/>
														<label for="acronym">Acronym<span class="mandatory"> *</span></label>
														<s:errors path="acronym" cssClass="error"></s:errors>
													</div>	
												</div>
												<div class="col-sm-1">
													<a href="#" data-toggle="tooltip" data-placement="bottom" title="Example : BC"><i class="fa fa-info mt-4"></i></a>
												</div>
											</div>
											<div class="form-group">
												<s:checkbox path="inn" cssClass="inn"/>
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
						<div id="editModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="EditCommunity" method="post" modelAttribute="community">
										<div class="modal-header">						
											<h4 class="modal-title">Edit Community</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
															
										<div class="modal-body">
											<c:if test="${editExistAcronym != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Acronym Already Exist, Enter New Acronym...</div>
													</div>
												</div>
											</c:if>
											
											<c:if test="${editExistCommunity != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Community Already Exist, Enter New Community...</div>
													</div>
												</div>
											</c:if>	
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id" id="id"/>					
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="name" id="name" autofocus="autofocus" cssClass="form-control"/>
														<label for="name">Name<span class="mandatory"> *</span></label>
														<s:errors path="name" cssClass="error"></s:errors>
													</div>		
												</div>
												<div class="col-sm-1">
													<a href="#" data-toggle="tooltip" data-placement="bottom" title="Example : Backward Class"><i class="fa fa-info mt-4"></i></a>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="acronym" id="acronym" autofocus="autofocus" maxlength="3" cssClass="form-control"/>
														<label for="acronym">Acronym<span class="mandatory"> *</span></label>
														<s:errors path="acronym" cssClass="error"></s:errors>
													</div>	
												</div>
												<div class="col-sm-1">
													<a href="#" data-toggle="tooltip" data-placement="bottom" title="Example : BC"><i class="fa fa-info mt-4"></i></a>
												</div>
											</div>
											<div class="form-group">
												<s:checkbox path="inn" id="inn"/>
												<label>In use</label>
											</div>					
										</div>
										
										<div class="modal-footer">
											<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
											<input type="submit" class="btn btn-info" value="Update">
										</div>
									</s:form>
								</div>
							</div>
						</div>
						
						<!-- Delete Modal HTML -->
						<div id="deleteModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="DeleteCommunity" method="post">
										<div class="modal-header">						
											<h4 class="modal-title">Delete Community</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">					
											<input id="id" name="id" hidden/>
											<div class="md-form mt-0">
												<input id="name" autofocus="autofocus" class="form-control" readonly/>
												<label for="Name">Name</label>
											</div>
											<p>Are you sure you want to delete these Records?</p>
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
				<div>Community Details are Added Successfully.</div>
			</div>
		</div>
	</c:if>

	<c:if test="${updated != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-warning pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Community Details are Updated Successfully.</div>
			</div>
		</div>
	</c:if>

	<c:if test="${deleted != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Community Deactivated Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>
</div>

<c:if test="${addError != null }"> 
	<script type="text/javascript">
		$('#addModal').modal('show');
	</script>
</c:if>

<c:if test="${editError != null }"> 
	<script type="text/javascript">
		$('#editModal').modal('show');
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
		$('.inn').prop('checked',true);
		$('#editModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var name = button.data('name'); 
			var acronym = button.data('acronym');
			var inn = button.data('inn');
			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#name').val(name);
			modal.find('#acronym').val(acronym);
			modal.find('#inn').val(inn);
			if(inn == 1)
				modal.find('#inn').prop('checked',true);
			else
				modal.find('#inn').prop('checked',false);
		});

		$('#deleteModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var name = button.data('name'); 
			var acronym = button.data('acronym');
			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#name').val(name);
		});

		$('#Toast').toast({
			delay:5000
		});
		$('#Toast').toast('show');
		$('[data-toggle = "tooltip"]').tooltip();
	}); 
</script>
</body>
</html>