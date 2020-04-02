<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sign Up</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

</head>
<body>
<div>
	<jsp:include page="Header.jsp" />
	
	<div id="header"></div>
	
	<div class="wrapper d-flex align-items-stretch">
		
		<jsp:include page="Sidebar.jsp" />
		
		<div class="container-fluid pl-5">
			<div class="row mt-2 mb-2">
				<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
				<div class="col col-sm-5 col-md-5 col-lg-5">
					<div class="card">
						<h4 class="card-head white-text text-center px-lg-5 py-4 ubuntu">
							<strong>Sign up</strong>
						</h4>
						<div class="card-body px-lg-5 pt-0 open-sans">
							<!-- Form -->
							<s:form style="color: #757575;" action="VerificationForm" method="post" modelAttribute="signup">
							
								<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
								
								<!-- Role -->
								<div class="mt-3">
                                	<label class="d-flex justify-content-start"> Role <span class="mandatory pl-1"> *</span></label>
                                    <s:select path="role" id="role" class="browser-default custom-select">
										<option value="0">-- Select --</option>
										<option value="admin">Administrator</option>
										<option value="staff">Staff</option>
										<option value="student">Student</option>
									</s:select>
                                    <s:errors path="role" cssClass="error"></s:errors>
                                </div>
								
								<!-- User name -->
								<div class="md-form">
									<s:input path="name" type="text" name="name" class="form-control"></s:input>
									<label for="Name">Name<span class="mandatory pl-1"> *</span></label>
									<s:errors path="name" cssClass="error"></s:errors>
								</div>
								
								<div class="md-form mt-0">
									<s:input path="email" type="email" name="email" class="form-control text-lowercase"></s:input>
									<s:label path="email" for="email">EMail Id<span class="mandatory pl-1"> *</span></s:label>
									<s:errors path="email" cssClass="error"></s:errors>
								</div>
								
								<div class="md-form">
									<s:input path="username" type="text" name="username" class="form-control"></s:input>
									<label for="username">Username<span class="mandatory pl-1"> *</span></label>
									<s:errors path="username" cssClass="error"></s:errors>
								</div>
								
								<div class="md-form" hidden>
									<s:input path="password" type="text" name="password" class="form-control"></s:input>
									<label  for="password">Password<span class="mandatory pl-1"> *</span></label>
									<s:errors path="password" cssClass="error"></s:errors>
								</div>
								
								<!-- Sign up button -->
								<button class="btn btn-custom btn-block py-2 waves-effect z-depth-0" type="submit">Create account</button>

							</s:form>
							<!-- Form -->
						</div>
						<!-- card body -->
					</div>
					<!-- card -->
				</div>
				<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
			</div>
			<!-- row -->
		</div>
		<!-- Cantainer fluid -->
	</div>
	<!-- wrapper -->

	<c:if test="${added != null }">
		<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-success pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Account has been created successfully.</div>
			</div>
		</div>
	</c:if>

	<c:if test="${emailExist != null }">
		<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width:300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Error</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Email Id already registered. Please try another Email.</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${usernameExist != null }">
		<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width:300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Error</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Username already registered. Please try another Username.</div>
			</div>
		</div>
	</c:if>


	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>
</div>

<!-- jQuery -->
<script type="text/javascript" src="./views/js/jquery.min.js"></script>
<script type="text/javascript" src="./views/js/popper.min.js"></script>
<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./views/js/mdb.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
    	$('#header').load("http://localhost:8080/header");

    	$('#Toast').toast({
			delay:5000
		});
		$('#Toast').toast('show');
		
		$('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>
