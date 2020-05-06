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
						
						<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
						
						<!-- Add Modal HTML -->
						<div id="addModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<s:form action="SaveCSDMapping" method="post" modelAttribute="csd">
										<div class="modal-header">						
											<h4 class="modal-title">Add CSD Mapping</h4>
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										</div>
										
										<div class="modal-body">
											
											<c:if test="${addExistCSD != null }">
												<div class="toast" id="Toast">
													<div class="toast-header white-text bg-danger pt-2">
														<h5 class="mr-auto">Error</h5>
														<button type="button" class="ml-2 mb-1 close white-text"
															data-dismiss="toast">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="toast-body py-2">
														<div>This country, state and district already mapped.</div>
													</div>
												</div>
											</c:if>
											
											<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
											
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> Country <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="country" id="country">
														</s:select>
														<s:errors path="country" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> State <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="state" id="state">
														</s:select>
														<s:errors path="state" cssClass="error"></s:errors>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-12">
													<div class="mt-3">
														<label class="d-flex justify-content-start"> District <span class="mandatory pl-1"> *</span></label>
														<s:select cssClass="browser-default custom-select" path="district" id="district">
														</s:select>
														<s:errors path="district" cssClass="error"></s:errors>
													</div>
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
				<div>Country, State, District Mappings are Added Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${ati != null }">
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
				<div>Status changed (Active to Inactive)</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${ita != null }">
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
				<div>Status changed (Inactive to Active)</div>
			</div>
		</div>
	</c:if>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>

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