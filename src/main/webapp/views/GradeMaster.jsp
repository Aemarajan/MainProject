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
<title>Grade Master</title>

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
									<h2>Manage <b>Grade</b></h2>
								</div>
								<div class="col-sm-6">
									<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
								</div>
							</div>
						</div>
						
						<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
						
						<c:url value="/GetGradeMaster" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
						
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Grade Word</th>
									<th>Grade Acronym</th>
									<th>Grade Point</th>
									<th>Marks Range</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="l" items="${pagedListHolder.pageList }">
									<tr>
										<td class="text-capitalize">${l.word }</td>
										<td>${l.acronym }</td>
										<td>${l.point }</td>
										<td>${l.marks_range }</td>
										<td>
											<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
											<c:if test="${l.inn != 1 }"><span><i class="fa fa-circle text-danger"></i>  In Active</span></c:if>
										</td>
										<td>
											<a href="#editModal" class="edit" data-toggle="modal" data-id="${l.id }" data-word="${l.word }" data-acronym="${l.acronym }" data-point="${l.point }" data-marks_range="${l.marks_range }" data-inn="${l.inn }" ><i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i></a>
											<a href="#deleteModal" class="delete" data-toggle="modal" data-id="${l.id }" data-word="${l.word }"><i class="fa fa-trash" data-toggle="tooltip" title="Delete"></i></a>
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
									<s:form action="SaveGradeMaster" method="post" modelAttribute="grade">
										<div class="modal-header">						
											<h4 class="modal-title">Add Grade</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											
											<c:if test="${addExistWord != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Grade Word already exist...</div>
										        		</div>
													</div>
											</c:if>
													
											<c:if test="${addExistAcronym != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Acronym already exist.</div>
										        		</div>
													</div>
											</c:if>
											
											<c:if test="${addExistPoint != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Grade Point already exist...</div>
										        		</div>
													</div>
											</c:if>
											
											<c:if test="${addExistMarksRange != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Grade's Mark Range already exist...</div>
										        		</div>
													</div>
											</c:if>
									
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id"/>					
									
											<div class="row mt-4">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="word" id="word" autofocus="autofocus" cssClass="form-control"/>
														<label for="Word">Word<span class="mandatory"> *</span></label>
														<s:errors path="word" cssClass="error"></s:errors>
													</div>									
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="Outstanding,Good..." data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>	
											</div>	
												
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="acronym" id="acronym" maxlength="6" cssClass="form-control"/>
														<label for="Acronym">Acronym<span class="mandatory"> *</span></label>
														<s:errors path="acronym" cssClass="error"></s:errors>
													</div>		
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="O,A+,A,B+,B,U,RA..." data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>
											</div>													
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="point" id="point" cssClass="form-control"/>
														<label for="point">Point<span class="mandatory"> *</span></label>
														<s:errors path="point" cssClass="error"></s:errors>
													</div>									
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="10,9.....1,0" data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>	
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="marks_range" id="marks_range" maxlength="6" cssClass="form-control"/>
														<label for="marks_range">Marks Range<span class="mandatory"> *</span></label>
														<s:errors path="marks_range" cssClass="error"></s:errors>
													</div>									
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="91-100" data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>	
											</div>
											
											<div class="form-group">
												<s:checkbox path="inn" id="inn" cssClass="inn"/>
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
									<s:form action="EditGrade" method="post" modelAttribute="grade">
										<div class="modal-header">						
											<h4 class="modal-title">Edit Grade</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
															
										<div class="modal-body">
											<c:if test="${editExistWord != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Grade Word already exist...</div>
										        		</div>
													</div>
											</c:if>
													
											<c:if test="${editExistAcronym != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Acronym already exist.</div>
										        		</div>
													</div>
											</c:if>
											
											<c:if test="${editExistPoint != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Grade Point already exist...</div>
										        		</div>
													</div>
											</c:if>
											
											<c:if test="${editExistMarksRange != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
				    										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
				      											<span aria-hidden="true">&times;</span>
														    </button>
														</div>
														<div class="toast-body py-2">
										            		<div>Grade's Mark Range already exist...</div>
										        		</div>
													</div>
											</c:if>
									
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<s:hidden path="id"/>					
											
											<div class="row mt-4">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="word" id="word" autofocus="autofocus" cssClass="form-control"/>
														<label for="Word">Word<span class="mandatory"> *</span></label>
														<s:errors path="word" cssClass="error"></s:errors>
													</div>									
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="Outstanding,Good..." data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>	
											</div>	
												
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="acronym" id="acronym" autofocus="autofocus" maxlength="1" cssClass="form-control"/>
														<label for="Acronym">Acronym<span class="mandatory"> *</span></label>
														<s:errors path="acronym" cssClass="error"></s:errors>
													</div>		
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="0,A+,A,B+,B,U,RA,S and Etc..." data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>
											</div>													
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="point" id="point" autofocus="autofocus" maxlength="2" cssClass="form-control"/>
														<label for="point">Point<span class="mandatory"> *</span></label>
														<s:errors path="point" cssClass="error"></s:errors>
													</div>									
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="10,9.....1,0" data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>	
											</div>
											
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="marks_range" id="marks_range" autofocus="autofocus" maxlength="6" cssClass="form-control"/>
														<label for="marks_range">Marks Range<span class="mandatory"> *</span></label>
														<s:errors path="marks_range" cssClass="error"></s:errors>
													</div>									
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" title="91-100" data-placement="top"><i class="fa fa-info-circle mt-4"></i></a>
												</div>	
											</div>
											
											<div class="form-group">
												<s:checkbox path="inn" id="inn" cssClass="inn"/>
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
									<form action="DeleteGrade" method="post">
										<div class="modal-header">						
											<h4 class="modal-title">Delete Grade</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">					
											<input id="id" name="id" hidden/>
											<div class="md-form mt-0">
												<input id="word" autofocus="autofocus" class="form-control text-capitalize" readonly/>
												<label>Word</label>
											</div>
											<p>Are you sure you want to deactivate these Record ?</p>
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

		<c:if test="${added != null }">
			<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
				<div class="toast-header white-text pt-2 bg-success">
					<h5 class="mr-auto">Notification</h5>
					<button type="button" class="ml-2 mb-1 close white-text"
						data-dismiss="toast">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="toast-body py-2">
					<div>Grade Details are Added Successfully.</div>
				</div>
			</div>
		</c:if>

		<c:if test="${updated != null }">
			<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width: 300px; display: block;">
				<div class="toast-header white-text bg-warning pt-2">
					<h5 class="mr-auto">Notification</h5>
					<button type="button" class="ml-2 mb-1 close white-text"
						data-dismiss="toast">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="toast-body py-2">
					<div>Grade Details are Updated Successfully.</div>
				</div>
			</div>
		</c:if>

		<c:if test="${deleted != null }">
			<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
				<div class="toast-header white-text bg-danger pt-2">
					<h5 class="mr-auto">Notification</h5>
					<button type="button" class="ml-2 mb-1 close white-text"
						data-dismiss="toast">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="toast-body py-2">
					<div>Grade Deactivated Successfully.</div>
				</div>
			</div>
		</c:if>

		<!-- Content -->
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
			var word = button.data('word');
			var acronym = button.data('acronym');
			var point = button.data('point');
			var marks_range = button.data('marks_range');
			var inn = button.data('inn');

			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#word').val(word);
			modal.find('#acronym').val(acronym);
			modal.find('#point').val(point);
			modal.find('#marks_range').val(marks_range);
			if(inn == 1)
				modal.find('#inn').prop('checked',true);
			else
				modal.find('#inn').prop('checked',false);
		});
		
		$('#deleteModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget);
			var id = button.data('id');
			var word = button.data('word');

			var modal = $(this);
			modal.find('#id').val(id);
			modal.find('#word').val(word);
		});
			
	});
</script>
</body>
</html>