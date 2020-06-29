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

<title>Student Subject Mapping</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body>

<!-- Project Start --> 

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
									<h2>Student Subject Mapping</h2>
								</div>
								<div class="col-sm-6">
									<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
								</div>
							</div>
						</div>
						
						<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
						
						<c:url value="/GetStudSubMapping" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
		
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Student Name</th>
									<th>Regulation</th>
									<th>Semester</th>
									<th>Subject</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="l" items="${pagedListHolder.pageList }">
										<tr>
											<td>${l.id }</td>
											<td class="text-capitalize">${l.user.name }</td>
											<td class="text-capitalize">${l.regulation.acronym }</td>
											<td class="text-capitalize">${l.semester.name }</td>
											<td class="text-uppercase">${l.subject.subject_code }</td>
											<td>
												<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
												<c:if test="${l.inn == 0 }"><span><i class="fa fa-circle text-danger"></i>  Inactive</span></c:if>
											</td>
											<td>
												<a href="changeStatusInStudSub?id=${l.id }" class="delete"><i class="fa fa-exchange-alt" data-toggle="tooltip" title="Change"></i></a>
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
									<s:form action="SaveStudSubMapping" method="post" modelAttribute="StudSubMapping">
										<div class="modal-header">						
											<h4 class="modal-title">Add Student Subject Mapping</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											<c:if test="${exist != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>This Mapping Already Exist, Map New Combination...</div>
													</div>
												</div>
											</c:if>
											
											<c:if test="${SSMMismatch != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>This Mapping does not match with default Mapping Try valid Mapping...</div>
													</div>
												</div>
											</c:if>
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<div hidden="true">
												<input type="text" name="id" id="id" value='<%= session.getAttribute("id") %>'/>
											</div>
															
											<div class="row">
												<div class="col-12">
													<div class="mt-0">
														<label class="d-flex justify-content-start"> Student Name <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="user" id="user"/>
														<s:errors path="user" cssClass="error"/>														
													</div>
												</div>
											</div>
											
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Regulation <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="regulation" id="regulation"/>
														<s:errors path="regulation" cssClass="error"/>														
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Semester <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="semester" id="semester" />
														<s:errors path="semester" cssClass="error"/>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Subject <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="subject" id="subject" />
														<s:errors path="subject" cssClass="error"/>
													</div>
												</div>
											</div>
											<div class="form-group mt-2">
												<s:checkbox path="inn" id="inn" cssClass="inn" />
												<s:errors path="inn" cssClass="error"/>
												<label>In use</label>
											</div>					
										</div>
										<div class="modal-footer">
											<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
											<input type="submit" class="btn btn-info" value="Add">
										</div>
									</s:form>
								</div>
								<!-- Modal Content -->
							</div>
							<!-- Modal Dialog -->
						</div>
						<!-- Add Modal -->
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
	<!-- Wrapper -->

	<jsp:include page="Footer.jsp" />

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
				<div>Mapping was Made Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${active != null }">
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
				<div>Mapping Activated Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${inactive != null }">
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
				<div>Mapping Deactivated Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${addError != null }"> 
		<script type="text/javascript">
			$('#addModal').modal('show');
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
	$(document).ready(function() {

		var user = $('#user');
        var id = $('#id').val();
        
        var pre = "http://localhost:8080/api/getAllStudentByStaffId/";
        var varurl = pre+id;
        $.ajax({
        	type: 'GET',
            url: varurl,
            async: true,
            success:function(result){
                //console.log(result);
                var output = "<option value='0'> -- Select -- </option>";
                for(var i in result){
                	output+="<option class='text-capitalize' value="+result[i].student.user_id+">"+result[i].student.name +"</option>";
                }
                //console.log(output);
            user.html(output);
            }
       	});
		
		var regulation = $('#regulation');
		var urlRegulation = "http://localhost:8080/api/getAllRegulation";
		$.ajax({
            type: 'GET',
            url: urlRegulation,
            async: true,
            success: function(result){
                var output = "<option value='0'> -- Select -- </option>";
                for(var i in result){
                    output+="<option value="+result[i].id+">"+result[i].acronym+"</option>";
                }
                //console.log(output);
                regulation.html(output);
            }
        });

        var semester = $('#semester');
		var urlSemester = "http://localhost:8080/api/getAllSemester";
        $.ajax({
            type: 'GET',
            url: urlSemester,
            async: true,
            success: function(result){
                var output = "<option value='0'> -- Select -- </option>";
                for(var i in result){
                    output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                }
                //console.log(output);
                semester.html(output);
            }
        });

        var subject = $('#subject');
		var urlSubject = "http://localhost:8080/api/getAllSyllabus";
        $.ajax({
            type: 'GET',
            url: urlSubject,
            async: true,
            success: function(result){
                var output = "<option value='0'> -- Select -- </option>";
                for(var i in result){
                    output+="<option class='text-uppercase' value="+result[i].id+">"+result[i].subject_code+"</option>";
                }
                //console.log(output);
                subject.html(output);
            }
        });

        var subject = $('#subject');
        $('#semester').change(function(){
            $(this).find("option:selected").each(function(){
                var id = $(this).attr("value");
                
                var pre = "http://localhost:8080/api/getAllSubjectsBySemesterId/";
                var varurl = pre+id;
                $.ajax({
                    type: 'GET',
                    url: varurl,
                    async: true,
                    success:function(result){
                        var output = "<option value='0'>-- Select --</option>";
                        for(var i in result){
                            output+="<option class='text-uppercase' value="+result[i].subject.id+">"+result[i].subject.subject_code+"</option>";
                        }
                        subject.html(output);
                    }
                });
            });
        });
	}); 
</script>
</body>
</html>