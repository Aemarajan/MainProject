<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Forgot Password</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

<style type="text/css">
	.row{
		background-image: url('./views/Images/bg-login7.jpg');
    	background-size: cover;
      	background-repeat:   no-repeat;
      	background-position: justify;
	}
</style>
</head>
<body>

	<jsp:include page="Header.jsp" />
	<div class="content">
		<div class="container-fluid">
			<div class="row mt-3 mb-3">
				<div class="col col-md-1"></div>
				<div class="col col-md-6"></div>
				<div class="col col-md-4">
					<div class="card mt-5 mb-5">
						<div class="card-head white-text text-center py-4 ubuntu">
							<strong><h4>Reset Your Password</h4></strong>
						</div>
						<div class="card-body px-lg-5 pt-0 open-sans">
							<s:form cssClass="login-form" style="color: #757575;" action="VerificationForm" method="post" modelAttribute="forgotPassword">
								
								<c:if test="${Error != null }">
									<div class="toast" id="Toast">
										<div class="toast-header white-text bg-danger pt-2">
											<h5 class="mr-auto">Error</h5>
											<button type="button" class="ml-2 mb-1 close white-text"
												data-dismiss="toast">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="toast-body py-2">
											<div>Oops! This Email id does not registered, Try Again...</div>
										</div>
									</div>
								</c:if>
								
								<!-- Email -->
								<div class="md-form">
									<s:input path="email" id="email" autofocus="autofocus" class="form-control text-lowercase"></s:input> 
									<s:label for="email" path="email">Email<span class="mandatory"> *</span></s:label>
									<s:errors path="email" cssClass="error"></s:errors>
								</div>
								
								<!-- Sign in button -->
								<div>
									<button	class="btn btn-custom btn-block my-3 py-2 waves-effect z-depth-0" type="submit">Submit</button>
								</div>
							</s:form>
							<!-- Form -->
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>

	<c:if test="${session != null }">
		<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width:300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Oops! Your Session has been Expired. Please Sign in Again...</div>
			</div>
		</div>
	</c:if>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>

	<!-- jQuery -->
  	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
  	<script type="text/javascript" src="./views/js/popper.min.js"></script>
  	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
  
  	<script type="text/javascript">
		function showPassword() {
			var x = document.getElementById("password");
			if (x.type === "password") {
				x.type = "text";
			}else {
				x.type = "password";
			}
		}
	
		$(document).ready(function() {
			$('#Toast').toast({
				delay:10000
			});
			$('#Toast').toast('show');
	
			$('[data-toggle = "tooltip"]').tooltip();
		});
	</script>
</body>
</html>