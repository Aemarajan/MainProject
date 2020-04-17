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

<title>Level Two </title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body id="page-top">

<!-- Project Start --> 

	<jsp:include page="Header.jsp" />
	<jsp:include page="Menubar.jsp" />
	
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
									<h2>Manage <b>Level Two data</b></h2>
								</div>
								<div class="col-sm-6">						
								</div>
							</div>
						</div>
						
						<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
						
						<c:url value="/ViewLevelTwo" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
						
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Name</th>
									<th>DropDown Status</th>
									<th>Level One Reference</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="l" items="${pagedListHolder.pageList }">
									<tr>
										<td>${l.name }</td>
										<td>${l.dd }</td>
										<td>${l.lvl1.name }</td>
										<td>
											<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
											<c:if test="${l.inn != 1 }"><span><i class="fa fa-circle text-danger"></i>  Inactive</span></c:if>
										</td>
										<td>
											<a href="#editModal" class="edit" data-toggle="modal" data-lvl2_id="${l.lvl2_id }" data-name="${l.name }" data-dd="${l.dd }" data-lvl1="${l.lvl1.lvl1_id }" data-inn="${l.inn }"><i class="fa fa-pencil-alt" data-toggle="tooltip" title="Edit"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
						
						<!-- Edit Modal HTML -->
						<div id="editModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="EditLevelTwo" method="post" modelAttribute="ValidateLevelOne">
										<div class="modal-header">						
											<h4 class="modal-title">Edit Level Two Data</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
															
										<div class="modal-body">
											<c:if test="${editExist != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>Level Two Header Already Exist...</div>
													</div>
												</div>
											</c:if>
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											<s:hidden path="lvl2_id" id="lvl2_id"/>					
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="name" id="name"  autofocus="autofocus" cssClass="form-control"/>
														<label for="Name">Name<span class="mandatory"> *</span></label>
														<s:errors path="name" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="Abc"><i class="fa fa-info-circle mt-4"></i></a>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="dd" id="dd" maxlength="1" autofocus="autofocus" cssClass="form-control" readonly="true"/>
														<label for="Drop Down">Drop Down Status<span class="mandatory"> *</span></label>
														<s:errors path="dd" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="0 or 1"><i class="fa fa-info-circle mt-4"></i></a>	
												</div>
											</div>
											<div class="row">
												<div class="col-sm-11">
													<div class="md-form mt-0">
														<s:input path="lvl1" id="lvl1"  autofocus="autofocus" cssClass="form-control" readonly="true"/>
														<label for="lvl1 id">Level One Reference<span class="mandatory"> *</span></label>
														<s:errors path="lvl1" cssClass="error"></s:errors>
													</div>
												</div>
												<div class="col-sm-1 p-0">
													<a href="#" data-toggle="tooltip" data-placement="top" title="Header,Master..."><i class="fa fa-info-circle mt-4"></i></a>
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
					</div>
					<!-- Table wrapper -->
				</div>
				<!-- col-md-12 -->
				<div class="col col-sm-1 col-md-1 col-lg-1"></div>
			</div>
			<!-- Row -->
		</div>
		<!-- Container Fluid -->
	</div>
	<!-- Wrapper -->
	
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
				<div>Level Two Details are Updated Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>
	
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>

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
			var lvl2_id = button.data('lvl2_id');
			var name = button.data('name'); 
			var dd = button.data('dd'); 
			var lvl1 = button.data('lvl1');
			var inn = button.data('inn');

			var modal = $(this);
			modal.find('#lvl2_id').val(lvl2_id);
			modal.find('#name').val(name);
			modal.find('#dd').val(dd);
			modal.find('#lvl1').val(lvl1);
			if(inn == 1)
				modal.find('#inn').prop('checked',true);
			else
				modal.find('#inn').prop('checked',false);
		});
	});
</script>
</body>
</html>