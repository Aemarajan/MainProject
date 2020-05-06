<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Users</title>

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
			<div class="row mt-2 mb-2">
				<div class="col col-sm-12 col-md-12 col-lg-12">

					<ul class="nav nav-tabs mt-2">
						<li class="nav-item"><a class="nav-link active" href="#Admin">Administrator</a></li>
						<li class="nav-item"><a class="nav-link " href="#Staff">Staff</a></li>
						<li class="nav-item"><a class="nav-link " href="#Student">Student</a></li>
					</ul>

					<c:url value="/SignUp" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
					
					<jsp:useBean id="pagedListHolder1" scope="request" type="org.springframework.beans.support.PagedListHolder" />
					<jsp:useBean id="pagedListHolder2" scope="request" type="org.springframework.beans.support.PagedListHolder" />
					<jsp:useBean id="pagedListHolder3" scope="request" type="org.springframework.beans.support.PagedListHolder" />
					
					<!-- Tab panes -->
					<div class="tab-content">
						<div id="Admin" class="tab-pane active">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-6">
											<h2>Manage <b>Administrators</b></h2>
										</div>
										<div class="col-sm-6">
											<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">New</span></a>						
										</div>
									</div>
								</div>
		
								<div class="row">
									<div class="col col-sm-12 col-md-12 col-lg-12">
										<table class="table table-striped table-hover">
											<thead>
												<tr>
													<th>Role</th>
													<th>Name</th>
													<th>Email</th>
													<th>Username</th>
													<th>Password</th>
													<th>Privilege Status</th>
													<th>Inn</th>
													<th>Actions</th>
												</tr>
											</thead>
											
											<tbody>
												<c:forEach var="l" items="${pagedListHolder1.pageList }">
													<tr>
														<td class="text-capitalize">${l.role }</td>
														<td class="text-capitalize">${l.name }</td>
														<td>${l.email }</td>
														<td>${l.username }</td>
														<td>${l.password }</td>
														<td>${l.privilege_provide}
														<td>
															<c:if test="${l.inn == 1 }">
																<span><i class="fa fa-circle text-success"></i> Active</span>
															</c:if> 
															<c:if test="${l.inn != 1 }">
																<span><i class="fa fa-circle text-danger"></i> Inactive</span>
															</c:if>
														</td>
														<td>
															<a href="#editModal" class="edit" data-toggle="modal" data-user_id="${l.user_id }" data-role="${l.role }" data-name="${l.name }" data-email="${l.email }" data-username="${l.username }" data-password="${l.password }" data-privilege_provide="${l.privilege_provide }" data-inn="${l.inn }"><i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i></a> 
															<a href="#deleteModal" class="delete" data-toggle="modal" data-user_id="${l.user_id }" data-name="${l.name }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- col -->
								</div>
								<!-- row -->
								<tg:paging pagedListHolder="${pagedListHolder1}" pagedLink="${pagedLink}" />
							</div>									
						</div>
						
						<div id="Staff" class="tab-pane fade">	
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-6">
											<h2>Manage <b>Staffs</b></h2>
										</div>
										<div class="col-sm-6">
											<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">New</span></a>						
										</div>
									</div>
								</div>
		
								<div class="row">
									<div class="col col-sm-12 col-md-12 col-lg-12">
										<table class="table table-striped table-hover">
											<thead>
												<tr>
													<th>Role</th>
													<th>Name</th>
													<th>Email</th>
													<th>Username</th>
													<th>Password</th>
													<th>Privilege Status</th>
													<th>Inn</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="l" items="${pagedListHolder2.pageList }">
													<tr>
														<td class="text-capitalize">${l.role }</td>
														<td class="text-capitalize">${l.name }</td>
														<td>${l.email }</td>
														<td>${l.username }</td>
														<td>${l.password }</td>
														<td>${l.privilege_provide}
														<td>
															<c:if test="${l.inn == 1 }">
																<span><i class="fa fa-circle text-success"></i> Active</span>
															</c:if> 
															<c:if test="${l.inn != 1 }">
																<span><i class="fa fa-circle text-danger"></i> Inactive</span>
															</c:if>
														</td>
														<td>
															<a href="#editModal" class="edit" data-toggle="modal" data-user_id="${l.user_id }" data-role="${l.role }" data-name="${l.name }" data-email="${l.email }" data-username="${l.username }" data-password="${l.password }" data-privilege_provide="${l.privilege_provide }" data-inn="${l.inn }"><i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i></a> 
															<a href="#deleteModal" class="delete" data-toggle="modal" data-user_id="${l.user_id }" data-name="${l.name }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- col -->
								</div>
								<!-- row -->
								<tg:paging pagedListHolder="${pagedListHolder2}" pagedLink="${pagedLink}" />
							</div>
							<!-- Table wrapper -->	
						</div>
						
						<div id="Student" class="tab-pane fade">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-6">
											<h2>Manage <b>Students</b></h2>
										</div>
										<div class="col-sm-6">
											<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">New</span></a>						
										</div>
									</div>
								</div>
		
								<div class="row">
									<div class="col col-sm-12 col-md-12 col-lg-12">
										<table class="table table-striped table-hover">
											<thead>
												<tr>
													<th>Role</th>
													<th>Name</th>
													<th>Email</th>
													<th>Username</th>
													<th>Password</th>
													<th>Privilege Status</th>
													<th>Inn</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="l" items="${pagedListHolder3.pageList }">
													<tr>
														<td class="text-capitalize">${l.role }</td>
														<td class="text-capitalize">${l.name }</td>
														<td>${l.email }</td>
														<td>${l.username }</td>
														<td>${l.password }</td>
														<td>${l.privilege_provide}
														<td>
															<c:if test="${l.inn == 1 }">
																<span><i class="fa fa-circle text-success"></i> Active</span>
															</c:if> 
															<c:if test="${l.inn != 1 }">
																<span><i class="fa fa-circle text-danger"></i> Inactive</span>
															</c:if>
														</td>
														<td>
															<a href="#editModal" class="edit" data-toggle="modal" data-user_id="${l.user_id }" data-role="${l.role }" data-name="${l.name }" data-email="${l.email }" data-username="${l.username }" data-password="${l.password }" data-privilege_provide="${l.privilege_provide }" data-inn="${l.inn }"><i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i></a> 
															<a href="#deleteModal" class="delete" data-toggle="modal" data-user_id="${l.user_id }" data-name="${l.name }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- col -->
								</div>
								<!-- row -->
								<tg:paging pagedListHolder="${pagedListHolder3}" pagedLink="${pagedLink}" />
							</div>
							<!-- Table wrapper -->
						</div>
					
					</div>

					<!-- Add Modal HTML -->
					<div id="addModal" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<s:form action="CreateUser" method="post" modelAttribute="signup">
									<div class="modal-header">
										<h4 class="modal-title">Add User</h4>
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									</div>

									<div class="modal-body">

										<c:if test="${addEmailExist != null }">
											<div class="toast" id="Toast">
												<div class="toast-header white-text bg-danger pt-2">
													<h5 class="mr-auto">Error</h5>
													<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="toast-body py-2">
													<div>Email Id already registered. Please try another Email.</div>
												</div>
											</div>
										</c:if>

										<c:if test="${addUsernameExist != null }">
											<div class="toast" id="Toast">
												<div class="toast-header white-text bg-danger pt-2">
													<h5 class="mr-auto">Error</h5>
													<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="toast-body py-2">
													<div>Username already registered. Please try another Username.</div>
												</div>
											</div>
										</c:if>

										<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>

										<s:hidden path="user_id" id="user_id" />

										<!-- Role -->
										<div class="mt-2">
											<label class="d-flex justify-content-start"> Role <span class="mandatory pl-1"> *</span></label>
											<s:select path="role" id="role" cssClass="browser-default custom-select">
												<option value="0">-- Select --</option>
												<option value="admin">Administrator</option>
												<option value="staff">Staff</option>
												<option value="student">Student</option>
											</s:select>
											<s:errors path="role" cssClass="error"></s:errors>
										</div>

										<div class="row mt-3">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="name" type="text" id="name" cssClass="form-control"></s:input>
													<label for="Name">Name<span class="mandatory pl-1"> *</span></label>
													<s:errors path="name" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="ABC"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="email" type="email" id="email" cssClass="form-control text-lowercase"></s:input>
													<s:label path="email" for="email">Email Id<span class="mandatory pl-1"> *</span> </s:label>
													<s:errors path="email" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="abc@gmail.com"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="username" type="text" id="username" cssClass="form-control"></s:input>
													<label for="username">Username<span class="mandatory pl-1"> *</span></label>
													<s:errors path="username" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="ABC"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>
										<div class="row" hidden="true">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="password" type="text" id="password" cssClass="form-control"></s:input>
													<label for="password">Password<span class="mandatory pl-1"> *</span></label>
													<s:errors path="password" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="******"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="row" hidden="true">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="privilege_provide" type="text" id="privilege_provide" cssClass="form-control"></s:input>
													<label for="privilege provide">Privilege Provide<span class="mandatory pl-1"> *</span></label>
													<s:errors path="privilege_provide" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="******"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="form-group">
											<s:checkbox path="inn" cssClass="inn" />
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
								<s:form action="EditUser" method="post" modelAttribute="signup">
									<div class="modal-header">
										<h4 class="modal-title">Edit Users</h4>
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									</div>

									<div class="modal-body">

										<c:if test="${editEmailExist != null }">
											<div class="toast" id="Toast">
												<div class="toast-header white-text bg-danger pt-2">
													<h5 class="mr-auto">Error</h5>
													<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="toast-body py-2">
													<div>Email Id already registered. Please try another Email.</div>
												</div>
											</div>
										</c:if>

										<c:if test="${editUsernameExist != null }">
											<div class="toast" id="Toast">
												<div class="toast-header white-text bg-danger pt-2">
													<h5 class="mr-auto">Error</h5>
													<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="toast-body py-2">
													<div>Username already registered. Please try another Username.</div>
												</div>
											</div>
										</c:if>

										<label
											class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>

										<s:hidden path="user_id" id="user_id" />

										<!-- Role -->
										<div class="mt-2">
											<label class="d-flex justify-content-start"> Role <span class="mandatory pl-1"> *</span></label>
											<s:select path="role" id="role" cssClass="browser-default custom-select">
												<option value="0">-- Select --</option>
												<option value="admin">Administrator</option>
												<option value="staff">Staff</option>
												<option value="student">Student</option>
											</s:select>
											<s:errors path="role" cssClass="error"></s:errors>
										</div>

										<div class="row mt-3">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="name" type="text" id="name" autofocus="autofocus" cssClass="form-control"></s:input>
													<label for="Name">Name<span class="mandatory pl-1"> *</span></label>
													<s:errors path="name" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="ABC"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="email" type="email" id="email" autofocus="autofocus" cssClass="form-control text-lowercase"></s:input>
													<s:label path="email" for="email">Email Id<span class="mandatory pl-1"> *</span> </s:label>
													<s:errors path="email" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="abc@gmail.com"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="username" type="text" id="username" autofocus="autofocus" cssClass="form-control"></s:input>
													<label for="username">Username<span class="mandatory pl-1"> *</span></label>
													<s:errors path="username" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="ABC"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="password" type="text" id="password" autofocus="autofocus" cssClass="form-control"></s:input>
													<label for="password">Password<span class="mandatory pl-1"> *</span></label>
													<s:errors path="password" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="******"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-11">
												<div class="md-form mt-0">
													<s:input path="privilege_provide" type="text" id="privilege_provide" autofocus="autofocus" cssClass="form-control"></s:input>
													<label for="privilege_provide">Privilege Provide<span class="mandatory pl-1"> *</span></label>
													<s:errors path="privilege_provide" cssClass="error"></s:errors>
												</div>
											</div>
											<div class="col-sm-1 p-0">
												<a href="#" data-toggle="tooltip" data-placement="top" title="0 or 1"><i class="fa fa-info-circle mt-4"></i></a>
											</div>
										</div>

										<div class="form-group">
											<s:checkbox path="inn" cssClass="inn" id="inn" />
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
								<form action="DeleteUser" method="post">
									<div class="modal-header">
										<h4 class="modal-title">Delete User</h4>
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									</div>
									<div class="modal-body">
										<input id="user_id" name="user_id" hidden="true" />
										<div class="md-form mt-0">
											<input id="name" autofocus="autofocus" class="form-control" readonly /> <label for="Name">Name</label>
										</div>
										<p>Are you sure you want to Deactivate this Record ?</p>
									</div>
									<div class="modal-footer">
										<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"> <input type="submit" class="btn btn-danger" value="Delete">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- col-md-12 -->
			</div>
			<!-- Row -->
		</div>
		<!-- Container Fluid -->
	</div>
	<!-- Wrapper -->
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>
	
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
		
	<c:if test="${added != null }">
		<div class="toast" id="Toast" 
			style="position: absolute; overflow: auto; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-success">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>User Created Successfully.</div>
			</div>
		</div>
	</c:if>

	<c:if test="${updated != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-warning pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>User Details are Updated Successfully.</div>
			</div>
		</div>
	</c:if>

	<c:if test="${deleted != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>User Deactivated Successfully.</div>
			</div>
		</div>
	</c:if>

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

<!-- jQuery -->
<script type="text/javascript" src="./views/js/jquery.min.js"></script>
<script type="text/javascript" src="./views/js/popper.min.js"></script>
<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./views/js/mdb.min.js"></script>
<script type="text/javascript" src="./views/js/common.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#editModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var user_id = button.data('user_id');
			var role = button.data('role');
			var name = button.data('name');
			var email = button.data('email'); 
			var username = button.data('username');
			var password = button.data('password');
			var privilege_provide = button.data('privilege_provide');
			var inn = button.data('inn');

			var modal = $(this);
			modal.find('#user_id').val(user_id);
			modal.find('#role').val(role);
			modal.find('#name').val(name);
			modal.find('#email').val(email);
			modal.find('#username').val(username);
			modal.find('#password').val(password);
			modal.find('#privilege_provide').val(privilege_provide);
			
			if(inn == 1)
				modal.find('#inn').prop('checked',true);
			else
				modal.find('#inn').prop('checked',false);
		});

		$('#deleteModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var user_id = button.data('user_id');
			var name = button.data('name'); 

			var modal = $(this);
			modal.find('#user_id').val(user_id);
			modal.find('#name').val(name);
		});
		
		$(".nav-tabs a").click(function(){
			$(this).tab('show');
		});

		$('.nav-tabs a').on('shown.bs.tab', function(event){
		    var x = $(event.target).text();         // active tab
		    var y = $(event.relatedTarget).text();  // previous tab
		});
	});
</script>
</body>
</html>