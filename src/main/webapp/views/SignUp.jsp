<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sign Up</title>

<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

</head>
<body class="ubuntu">
<div>
	<jsp:include page="Header.jsp" />
	
	<div id="header"></div>
	
	<div class="content">
		<div class="container-fluid">
			<div class="row mt-2 mb-2">

				<div class="col col-md-3.5"></div>
				<div class="col col-md-5">
					<div class="card">
						<h5 class="card-head white-text text-center py-4">
							<strong>Sign up</strong>
						</h5>

						<div class="card-body px-lg-5 pt-0">
							<!-- Form -->
							<s:form style="color: #757575;" action="VerificationForm" method="post" modelAttribute="signup">

								<c:if test="${exist != null }">
									<div class="mt-2 alert alert-danger alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
										<strong>Email Id already registered. Please try another email or reset your password.</strong>
									</div>
								</c:if>
								
								<c:if test="${msg != null }">
									<div class="mt-2 alert alert-success alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
										<strong>Account has been created successfully.</strong>
									</div>
								</c:if>
								
								<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
								
								<!-- User name -->
								<div class="md-form mt-0">
									<s:input path="username" type="text" name="username" class="form-control"></s:input>
									<s:label path="username" for="username">User name<span class="mandatory pl-1"> *</span></s:label>
									<s:errors path="username" cssClass="error"></s:errors>
								</div>

								<!-- E-mail -->
								<div class="md-form mt-0">
									<s:input path="email" type="email" name="email" class="form-control"></s:input>
									<s:label path="email" for="email">E-mail<span class="mandatory pl-1"> *</span></s:label>
									<s:errors path="email" cssClass="error"></s:errors>
								</div>

								<!-- Password -->
								<div class="md-form">
									<s:input path="password" type="password" name="password" class="form-control"></s:input>
									<s:label path="password" for="password">Password<span class="mandatory pl-1"> *</span></s:label>
									<s:errors path="password" cssClass="error"></s:errors>
								</div>

								<!-- Confirm Password -->
								<div class="md-form">
									<s:input path="confirmpassword" type="password" name="password" class="form-control"></s:input>
									<s:label path="confirmpassword" for="password">Confirm Password<span class="mandatory pl-1"> *</span></s:label>
									<s:errors path="confirmpassword" cssClass="error"></s:errors>
								</div>

								<!-- Sign up button -->
								<button class="btn btn-custom btn-block py-2 waves-effect z-depth-0" type="submit">Create account</button>

							</s:form>
							<!-- Form -->
						</div>
					</div>
				</div>
				<div class="col col-md-3.5"></div>
			</div>
		</div>
	</div>
	<div class="footer">
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
    });
</script>
</body>
</html>
