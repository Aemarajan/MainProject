<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Change Password</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body id="page-top">

	<jsp:include page="Header.jsp" />
	<jsp:include page="Menubar.jsp" />
	
	<div class="wrapper d-flex align-items-stretch">
		
		<jsp:include page="Sidebar.jsp" />
		
		<div class="container-fluid pl-5">
			<div class="row mt-2 mb-2">
				<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
				<div class="col col-sm-5 col-md-5 col-lg-5">
					<div class="card">
						<div class="card-head white-text text-center py-4 ubuntu">
							<h4>Change Password</h4>
						</div>

						<div class="card-body px-5 pt-0 open-sans">

							<c:if test="${passwordMismatch != null }">
								<div class="toast mt-2" id="Toast">
									<div class="toast-header white-text bg-danger pt-2">
										<h5 class="mr-auto">Error</h5>
										<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="toast-body py-2">
										<div>New password and Confirm Password are doesn't Match...</div>
									</div>
								</div>
							</c:if>

							<s:form action="UpdatePassword" method="post" modelAttribute="changePassword">
								<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled </label>
								
								<s:hidden path="id" id="id" value='<%= session.getAttribute("id") %>' />

								<div class="row">
									<div class="col-sm-11 col-md-11 col-lg-11">
										<div class="md-form mt-0">
											<s:input path="new_pwd" id="new_pwd" maxlength="15" autofocus="autofocus" cssClass="form-control" />
											<s:label path="new_pwd" for="New Password">New Password<span class="mandatory"> *</span></s:label>
											<s:errors path="new_pwd" cssClass="error"></s:errors>
										</div>
									</div>
									<div class="col col-sm-1 col-md-1 col-lg-1 p-0">
										<a href="#" data-toggle="tooltip" data-placement="top" title="Abc@123"><i class="fa fa-info-circle mt-4"></i></a>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-11 col-md-11 col-lg-11">
										<div class="md-form mt-0">
											<s:input path="confirm_pwd" id="confirm_pwd" maxlength="15" cssClass="form-control" />
											<s:label path="confirm_pwd" for="Confirm Password">Confirm Password<span class="mandatory"> *</span></s:label>
											<s:errors path="confirm_pwd" cssClass="error"></s:errors>
										</div>
									</div>
									<div class="col col-sm-1 col-md-1 col-lg-1 p-0">
										<a href="#" data-toggle="tooltip" data-placement="top" title="Abc@123"><i class="fa fa-info-circle mt-4"></i></a>
									</div>
								</div>
							
								<div class="mt-4">
									<button type="submit" class="btn btn-custom waves-effect">Change</button>
								</div>
							</s:form>
							<!-- Form -->
						</div>
						<!-- Card body -->
					</div>
					<!-- Card  -->
				</div>
				<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
			</div>
			<!-- row -->
		</div>
		<!-- Container Fluid -->
	</div>
	<!-- Wrapper -->
	
	<c:if test="${updated != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-success pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Your Password has been Updated Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>
	
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>
</body>
</html>