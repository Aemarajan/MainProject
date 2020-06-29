<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Academic Mapping</title>

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
			
			<div hidden="true">
				<input type="text" name="id" id="id" value='<%= session.getAttribute("id") %>'/>
			</div>
			
			<div class="row mt-2 mb-2">	
				<div class="col col-sm-12 col-md-12 col-lg-12">

					<table class="table table-striped">
						<thead>
							<tr>
								<th>Student Name</th>
								<th></th>
								<th></th>
								<th>Actions</th>
							<tr>
						</thead>
						<tbody id="student"></tbody>
					</table>

<!-- 					<div class="row text-center mt-2"> -->
<!-- 						<div class="col col-sm-3 col-md-3 col-lg-3 mt-2"> -->
<!-- 							<label><b>Student Name</b></label> -->
<!-- 						</div> -->
<!-- 						<div class="col col-sm-3 col-md-3 col-lg-3"> -->
<%-- 							<select name="student" id="student" class="custom-select browser-default"></select> --%>
<!-- 						</div> -->
<!-- 						<div class="col col-sm-2 col-md-2 col-lg-2"></div> -->
<!-- 						<div class="col col-sm-2 col-md-2 col-lg-2"> -->
<%-- 							<a href="#addModal" class="btn btn-info add-new px-3 py-2 mt-0" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a> --%>
<!-- 						</div> -->
<!-- 						<div class="col col-sm-2 col-md-2 col-lg-2"></div> -->
<!-- 					</div> -->

					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6">
									<h2>Manage <b>Academic Mapping</b></h2>
								</div>
								<div class="col-sm-6">
															
								</div>
							</div>
						</div>		
						
						<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
						
						<c:url value="/AcademicMapping" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
						
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Student</th>
									<th>Batch</th>
									<th>Regulation</th>
									<th>Degree</th>
									<th>Department</th>
									<th>Year</th>
									<th>Semester</th>
									<th>Section</th>
									<th>Status</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="l" items="${pagedListHolder.pageList }">
									<tr>
										<td class="text-capitalize">${l.user.name }</td>
										<td>${l.batch.from_year } - ${l.batch.to_year }</td>
										<td>${l.regulation.acronym }</td>
										<td>${l.degree.acronym }</td>
										<td>${l.department.name }</td>
										<td>${l.year.year }</td>
										<td>${l.semester.name }</td>
										<td>${l.section.name }</td>
										<td>${l.status }</td>
										<td>
											<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
											<c:if test="${l.inn == 0 }"><span><i class="fa fa-circle text-danger"></i>  Inactive</span></c:if>
										</td>
										<td>
											<a href="changeStatusInACAMapping?id=${l.id }" class="delete"><i class="fa fa-exchange-alt" data-toggle="tooltip" title="Change"></i></a>
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
									<s:form action="SaveAcademicMapping" method="post" modelAttribute="Academic">
										<div class="modal-header">						
											<h4 class="modal-title">Add Academic Mapping</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											
											<c:if test="${addExist != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>This Mapping already Done, Try Another One.</div>
													</div>
												</div>
											</c:if>
											
											<c:if test="${DDSMismatch != null }">
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
											
											<div class="row">
												<div class="col-12">
													<div class="mt-0">
														<label class="d-flex justify-content-start"> Student Id <span class="mandatory pl-1"> *</span></label>
														<s:input type="text" path="user" id="user" cssClass="form-control text-capitalize" readonly="true"/>
													</div>
												</div>
											</div>
											
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Batch <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="batch" id="batch">
														</s:select>
														<s:errors path="batch" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Regulation <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="regulation" id="regulation">
														</s:select>
														<s:errors path="regulation" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Degree <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="degree" id="degree">
														</s:select>
														<s:errors path="degree" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Department <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="department" id="department">
														</s:select>
														<s:errors path="department" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Year <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="year" id="year">
														</s:select>
														<s:errors path="year" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Semester <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="semester" id="semester">
														</s:select>
														<s:errors path="semester" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Section <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="section" id="section">
														</s:select>
														<s:errors path="section" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="form-group">
												<s:checkbox path="inn" id="inn" cssClass="inn"/>
												<s:errors path="inn" cssClass="error"></s:errors>
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
											
					</div>
					<!-- Table wrapper -->
				</div>
				<!-- col-md-12 -->
        	</div>
        	<!-- row -->
        </div>
        <!-- Container Fluid -->
	</div>
	
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
				<div>Degree, Department and Section Mapping Made Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${active != null }">
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
				<div>Mapping Activated Successfully...</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${inactive != null }">
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
				<div>Mapping InActivated Successfully...</div>
			</div>
		</div>
	</c:if>
	
	<jsp:include page="Footer.jsp" />
		
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>

<c:if test="${addError != null }"> 
	<script type="text/javascript">
		$('#addModal').modal('show');
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

			var student = $('#student');
            var id = $('#id').val();
            
            var pre = "http://localhost:8080/api/getAllStudentByStaffId/";
            var varurl = pre+id;
            $.ajax({
            	type: 'GET',
                url: varurl,
                async: true,
                success:function(result){
                    //console.log(result);
                	var output = "<tr></tr>";
                    for(var i in result){
                    	output+="<tr><td class='text-capitalize'>" + result[i].student.name + "</td><td></td><td></td><td><a href='#addModal' class='edit' data-toggle='modal' data-user='" + result[i].student.user_id + "'><i class='fa fa-pencil-alt' data-toggle='tooltip' title='Edit'></i></a></td></tr>";
                    }
                    //console.log(output);
                	student.html(output);
                }
           	});

            $('#addModal').on('show.bs.modal', function (event) {
    			var button = $(event.relatedTarget);
    			var user = button.data('user'); 
    			
    			var modal = $(this);
    			modal.find('#user').val(user);
    		});

    		var degree = $('#degree');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllDegree",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].acronym+"</option>";
                    }
                    degree.html(output);
                }
            });

    		var department = $('#department');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllDepartment",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                    }
                    department.html(output);
                }
            });
            
    		var section = $('#section');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllSection",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                    }
                    section.html(output);
                }
            });

    		var batch = $('#batch');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllBatch",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].from_year+" - "+result[i].to_year+"</option>";
                    }
                    batch.html(output);
                }
            });

    		var regulation = $('#regulation');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllRegulation",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].acronym+"</option>";
                    }
                    regulation.html(output);
                }
            });

    		var year = $('#year');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllYear",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].year+"</option>";
                    }
                    year.html(output);
                }
            });

    		var semester = $('#semester');
    		$.ajax({
                type: 'GET',
                url: "http://localhost:8080/api/getAllSemester",
                async: true,
                success: function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                    }
                    semester.html(output);
                }
            });
		});
	</script>
</body>
</html>