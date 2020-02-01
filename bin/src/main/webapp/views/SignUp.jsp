<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sign Up</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="./views/css/mdb.min.css"> 
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body>
	<div>
		<div>
			<div class="bg-light text-center py-3">
				<h3>PSNA College of Engineering and Technology</h3>
			</div>
			<div class="content">
				<div class="container-fluid">
					<div class="row">

						<div class="col col-md-3.5"></div>

						<div class="col col-md-5 mt-2 mb-2">
							<!-- Material form register -->
							<div class="card">

								<h5 class="card-header info-color white-text text-center py-4">
									<strong>Sign up</strong>
								</h5>

								<!--Card content-->
								<div class="card-body px-lg-5 pt-0">
									<!-- Form -->
									<s:form style="color: #757575;" action="VerificationForm" method="post" modelAttribute="signup">

										<c:if test="${exist != null }">
											<div class="alert alert-success alert-dismissible">
												<a href="#" class="close" data-dismiss="alert"
													aria-label="close">&times;</a> <strong>Email Id already registered. Please try another email or reset your password.</strong>
											</div>
										</c:if>
										<c:if test="${msg != null }">
											<div class="alert alert-success alert-dismissible">
												<a href="#" class="close" data-dismiss="alert"
													aria-label="close">&times;</a> <strong>Account has been created successfully.</strong>
											</div>
										</c:if>
										<!-- User name -->
										<div class="md-form">
											<s:input path="username" type="text" name="username" class="form-control"></s:input>
											<s:label path="username" for="username">User name</s:label>
											<s:errors path="username" cssClass="error"></s:errors>
										</div>

										<!-- E-mail -->
										<div class="md-form mt-0">
											<s:input path="email" type="email" name="email" class="form-control"></s:input>
											<s:label path="email" for="email">E-mail</s:label>
											<s:errors path="email" cssClass="error"></s:errors>
										</div>

										<!-- Password -->
										<div class="md-form">
											<s:input path="password" type="password" name="password" class="form-control"></s:input>
											<s:label path="password" for="password">Password</s:label>
											<s:errors path="password" cssClass="error"></s:errors> 
										</div>
										
										<!-- Conform Password -->
										<div class="md-form">
											<s:input path="confirmpassword" type="password" name="password" class="form-control"></s:input>
											<s:label path="confirmpassword" for="password">Confirm Password</s:label>
											<s:errors path="confirmpassword" cssClass="error"></s:errors> 
										</div>

										<!-- Sign up button -->
										<button	class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Create account</button>

										<!-- Register -->
										<p>
											Already a member? <a href="SignIn">SignIn</a>
										</p>
									</s:form>
									<!-- Form -->
								</div>
							</div>
							<!-- Material form register -->
						</div>

						<div class="col col-md-3.5"></div>

					</div>
				</div>
			</div>
			<div>
				<jsp:include page="Footer.jsp" />
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<!-- Your custom scripts (optional) -->
	<script type="text/javascript"></script>

</body>
</html>
