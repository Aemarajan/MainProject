<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
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
<title>Syllabus Master</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body id="page-top">

<!-- Project Start --> 
<div>
	<jsp:include page="Header.jsp" />
<%-- 	<jsp:include page="Menubar.jsp" /> --%>
	<div id="header" class="mt-2"></div>
		
	<div class="wrapper d-flex align-items-stretch">
	
		<jsp:include page="Sidebar.jsp" />
	  
		<div class="container-fluid pl-5">
			<div class="row mt-2 mb-2">
				<div class="col col-sm-1 col-md-1 col-lg-1"></div>
				<div class="col col-sm-10 col-md-10 col-lg-10">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6">
									<h2>Manage <b>Syllabus</b></h2>
								</div>
								<div class="col-sm-6">
									<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
								</div>
							</div>
						</div>
						
						<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
						
						<c:url value="/GetSyllabusMaster" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
						
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Subject Code</th>
									<th>Subject Name</th>
									<th>Category</th>
									<th>Contact Periods</th>
									<th>Lecture</th>
									<th>Tutorial</th>
									<th>Practical</th>
									<th>Credit</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="l" items="${pagedListHolder.pageList }">
									<tr>
										<td>${l.subject_code }</td>
										<td class="text-capitalize">${l.subject_name }</td>
										<td>${l.category }</td>
										<td>${l.contact_period }</td>
										<td>${l.lecture }</td>
										<td>${l.tutorial }</td>
										<td>${l.practical }</td>
										<td>${l.credit }</td>
										<td>
											<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
											<c:if test="${l.inn != 1 }"><span><i class="fa fa-circle text-danger"></i>  Inactive</span></c:if>
										</td>
										<td>
											<a href="#editModal" class="edit" data-toggle="modal" 
												data-id="${l.id }" 
												data-code="${l.subject_code }" 
												data-name="${l.subject_name }"
												data-category="${l.category }"
												data-contact_period="${l.contact_period }"
												data-lecture="${l.lecture }"
												data-tutorial="${l.tutorial }"
												data-practical="${l.practical }" 
												data-credit="${l.credit }" 
												data-inn="${l.inn }">
												<i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i>
											</a>
											<a href="#deleteModal" class="delete" data-toggle="modal" 
												data-id="${l.id }" 
												data-code="${l.subject_code }" 
												data-name="${l.subject_name }">
												<i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
						
						<!-- Add Modal HTML -->
						<div id="addModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="SaveSyllabus" method="post" modelAttribute="syllabus">
										<div class="modal-header">						
											<h4 class="modal-title">Add Syllabus</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											
											<c:if test="${addExistSubjectCode != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Subject Code Already Exist. Please Enter New Subject Code...</div>
													</div>
												</div>
											</c:if>
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id"/>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="subject_code" maxlength="6" autofocus="autofocus" cssClass="form-control"/>
														<label for="code">Subject Code<span class="mandatory"> *</span></label>
														<s:errors path="subject_code" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="MC5401"><i class="fa fa-info-circle mt-4"></i></a>
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="subject_name" cssClass="form-control text-capitalize"/>
														<label for="Subjectname">Subject Name<span class="mandatory"> *</span></label>
														<s:errors path="subject_name" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="Web Application Development"><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="mt-0">
												<label class="d-flex justify-content-start"> Category <span class="mandatory pl-1"> *</span></label>
												<s:select class="custom-select browser-default" path="category" id="category">
													<option value="" selected disabled>-- Select --</option>
													<option value="FC">FC</option>
													<option value="PC">PC</option>
													<option value="PE">PE</option>
													<option value="EEC">EEC</option>
												</s:select>
											</div>
											
											<div class="row mt-3">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="contact_period" id="contact_period" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="contact Periods">Contact Periods<span class="mandatory"> *</span></label>
														<s:errors path="contact_period" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="lecture" id="lecture" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="Lecture">Lecture<span class="mandatory"> *</span></label>
														<s:errors path="lecture" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="tutorial" id="tutorial" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="Tutorials">Tutorials<span class="mandatory"> *</span></label>
														<s:errors path="tutorial" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="practical" id="practical" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="Practicals">Practical<span class="mandatory"> *</span></label>
														<s:errors path="practical" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="credit" id="credit" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="credit">Credit<span class="mandatory"> *</span></label>
														<s:errors path="credit" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
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
									<s:form action="EditSyllabus" method="post" modelAttribute="syllabus">
										<div class="modal-header">						
											<h4 class="modal-title">Edit Syllabus</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
															
										<div class="modal-body">
											
											<c:if test="${editExistSubjectCode != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Subject Code Already Exist. Please Enter New Subject Code...</div>
													</div>
												</div>
											</c:if>
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id" id="id"/>					
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="subject_code" id="subject_code" maxlength="6" autofocus="autofocus" cssClass="form-control"/>
														<label for="Subject Code">Subject Code<span class="mandatory"> *</span></label>
														<s:errors path="subject_code" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="CS5207"><i class="fa fa-info-circle mt-4"></i></a>
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="subject_name" id="subject_name" autofocus="autofocus" cssClass="form-control text-capitalize"/>
														<label for="Subject name">Subject Name<span class="mandatory"> *</span></label>
														<s:errors path="subject_name" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="Android"><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="mt-0">
												<label class="d-flex justify-content-start"> Category <span class="mandatory pl-1"> *</span></label>
												<s:select class="custom-select browser-default" path="category" id="category">
													<option value="" selected disabled>-- Select --</option>
													<option value="FC">FC</option>
													<option value="PC">PC</option>
													<option value="PE">PE</option>
													<option value="EEC">EEC</option>
												</s:select>
											</div>
											
											<div class="row mt-3">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="contact_period" id="contact_period" autofocus="autofocus" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="contact Periods">Contact Periods<span class="mandatory"> *</span></label>
														<s:errors path="contact_period" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="lecture" id="lecture" autofocus="autofocus" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="Lecture">Lecture<span class="mandatory"> *</span></label>
														<s:errors path="lecture" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="tutorial" id="tutorial" autofocus="autofocus" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="Tutorials">Tutorials<span class="mandatory"> *</span></label>
														<s:errors path="tutorial" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="practical" id="practical" autofocus="autofocus" cssClass="form-control" maxlength="2" pattern="\d*"/>
														<label for="Practicals">Practical<span class="mandatory"> *</span></label>
														<s:errors path="practical" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="credit" autofocus="autofocus" maxlength="2" id="credit" pattern="\d*"  cssClass="form-control"/>
														<label for="credit">Credit<span class="mandatory"> *</span></label>
														<s:errors path="credit" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="1,2,3,4...."><i class="fa fa-info-circle mt-4"></i></a>	
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
									<form action="DeleteSyllabus" method="post">
										<div class="modal-header">						
											<h4 class="modal-title">Delete Syllabus</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">					
											<input id="id" name="id" hidden/>
											<div class="md-form mt-0">
												<input id="name" autofocus="autofocus" class="form-control" readonly/>
												<label for="Name">Subject Name and Code</label>
											</div>
											<p>Are you sure you want to Deactivate these Record ?</p>
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
				<div class="col col-sm-1 col-md-1 col-lg-1"></div>
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
				<div>Syllabus Details are Added Successfully.</div>
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
				<div>Syllabus Details are Updated Successfully.</div>
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
				<div>Syllabus Deactivated Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>
	
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
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
<script type="text/javascript" src="./views/js/common.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#editModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var code = button.data('code'); 
			var name = button.data('name');
			var category = button.data('category');
			var contact = button.data('contact_period');
			var lecture = button.data('lecture');
			var tutorial = button.data('tutorial');
			var practical = button.data('practical');
			var credit = button.data('credit');
			var inn = button.data('inn');

			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#subject_code').val(code);
			modal.find('#subject_name').val(name);
			modal.find('#category').val(category);
			modal.find('#contact_period').val(contact);
			modal.find('#lecture').val(lecture);
			modal.find('#tutorial').val(tutorial);
			modal.find('#practical').val(practical);
			modal.find('#credit').val(credit);
			if(inn == 1)
				modal.find('#inn').prop('checked',true);
			else
				modal.find('#inn').prop('checked',false);
		});

		$('#deleteModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var code = button.data('code');
			var name = button.data('name'); 

			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#name').val(code+" - "+name);
		});
	});
</script>
</body>
</html>