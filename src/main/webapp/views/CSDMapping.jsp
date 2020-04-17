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

<title>Country Mapping</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body>

<!-- Project Start --> 

	<jsp:include page="Header.jsp" />
	
	<div id="header"></div>
	
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
									<h2>Manage <b>CSD Mapping</b></h2>
								</div>
								<div class="col-sm-6">
									<a href="#addModal" class="btn btn-info add-new px-3 py-2" data-toggle="modal"><i class="fa fa-plus-circle"></i> <span class="ml-2">Add</span></a>						
								</div>
							</div>
						</div>
						
						<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
						
						<c:url value="/CSDMapping" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
		
						
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Country</th>
									<th>State</th>
									<th>District</th>
									<th>In Use</th>
									<th>Actions</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="l" items="${pagedListHolder.pageList }">
										<tr>
											<td>${l.id }</td>
											<td>${l.country.name }</td>
											<td>${l.state.name }</td>
											<td>${l.district.name }</td>
											<td>
												<c:if test="${l.inn == 1 }"><span><i class="fa fa-circle text-success"></i>  Active</span></c:if>
												<c:if test="${l.inn == 0 }"><span><i class="fa fa-circle text-danger"></i>  Inactive</span></c:if>
											</td>
											<td>
												<a href="changeStatusInCSD?id=${l.id }" class="delete"><i class="fa fa-exchange-alt" data-toggle="tooltip" title="Change"></i></a>
											</td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
						
						<!-- Add Modal HTML -->
						<div id="addModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="SaveCSDMapping" method="post">
										<div class="modal-header">						
											<h4 class="modal-title">Add CSD Mapping</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Country <span class="mandatory pl-1"> *</span></label>
														<select class="browser-default custom-select" name="country" id="country">
														</select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> State <span class="mandatory pl-1"> *</span></label>
														<select class="browser-default custom-select" name="state" id="state">
														</select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> District <span class="mandatory pl-1"> *</span></label>
														<select class="browser-default custom-select" name="district" id="district">
														</select>
													</div>
												</div>
											</div>
											<div class="form-group">
												<input type="checkbox" name="inn" id="inn" class="inn">
												<label>In use</label>
											</div>					
										</div>
										<div class="modal-footer">
											<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
											<input type="submit" class="btn btn-info" value="Add">
										</div>
									</form>
								</div>
							</div>
						</div>
											
						<!-- Delete Modal HTML -->
						<div id="deleteModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="DeleteBatch" method="post">
										<div class="modal-header">						
											<h4 class="modal-title">Delete Batch</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">					
											<input id="id" name="id" hidden/>
											<div class="md-form mt-0">
												<input id="name" autofocus="autofocus" class="form-control" readonly/>
												<label for="Name">Name</label>
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
				<!-- col-md-12 -->
				<div class="col col-sm-1 col-md-1 col-lg-1"></div>
			</div>
			<!-- Row -->
		</div>
		<!-- Container Fluid -->
	</div>
	<!-- Wrapper -->
		<div class="">
		<jsp:include page="Footer.jsp" />
	</div>

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

		var country = $('#country');
		var urlCountry = "http://localhost:8080/api/getAllCountry";
		$.ajax({
            type: 'GET',
            url: urlCountry,
            async: true,
            success: function(result){
                var output = "<option selected disabled> -- Select -- </option>";
                for(var i in result){
                    output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                }
                country.html(output);
            }
        });

        var state = $('#state');
		var urlState = "http://localhost:8080/api/getAllState";
        $.ajax({
            type: 'GET',
            url: urlState,
            async: true,
            success: function(result){
                var output = "<option selected disabled> -- Select -- </option>";
                for(var i in result){
                    output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                }
                state.html(output);
            }
        });

        var district = $('#district');
		var urlDistrict = "http://localhost:8080/api/getAllDistrict";
        $.ajax({
            type: 'GET',
            url: urlDistrict,
            async: true,
            success: function(result){
                var output = "<option selected disabled> -- Select -- </option>";
                for(var i in result){
                    output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                }
                district.html(output);
            }
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