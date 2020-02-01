<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sign In</title>
<link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
<!-- Bootstrap core CSS 
<link rel="stylesheet" href="./views/css/bootstrap.min.css">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
<style type="text/css">
	*{
		font-family: 'Ubuntu', sans-serif;
	}
	.footer{
		position:absolute;
		left:0;
		bottom:0;
		width:100%;
	}
</style>
</head>
<body>
	<div>
		<div class="bg-light text-center py-3">
			<h3>PSNA College of Engineering and Technology</h3>
		</div>
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col col-md-3.5"></div>
					<div class="col col-md-5 mt-2 mb-2">
						<div class="card">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Sign in</strong>
							</h5>
							<!--Card content-->
							<div class="card-body px-lg-5 pt-0">

								<!-- Form -->
								<s:form cssClass="login-form" style="color: #757575;" action="Login" method="post" modelAttribute="signin">
									
									<c:if test="${msg != null }">
										<div class="alert alert-danger alert-dismissible mt-2">
												<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
												<strong>Invalid email or password.</strong>
										</div>
									</c:if>
									
									<!-- Email -->
									<div class="md-form">
										<s:input path="email" id="email" autofocus="autofocus" class="form-control text-lowercase"></s:input> 
										<s:label for="email" path="email">E-mail</s:label>
										<s:errors path="email" cssClass="error"></s:errors>
									</div>

									<!-- Password -->
									<div class="md-form">
										<s:password path="password" id="password" class="form-control"></s:password> 
										<s:label path="password" for="password">Password</s:label>
										<s:errors path="password" cssClass="error"></s:errors>
									</div>

									<div class="d-flex justify-content-between">
										<div>
  											<input type="checkbox" onclick="showPassword()" >
											<label>Show Password</label>
										</div>
										<div>
											<!-- Forgot password -->
											<a href="">Forgot password?</a>
										</div>
									</div>

									<!-- Sign in button -->
									<div>
										<button	class="btn  btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>
									</div>
									<!-- Register -->
									<p>
										Not a member? <a href="SignUp">SignUp</a>
									</p>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script><!-- MDB core JavaScript -->
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<!-- Your custom scripts (optional) -->
	<script type="text/javascript">
	function showPassword() {
		  var x = document.getElementById("password");
		  if (x.type === "password") {
		    x.type = "text";
		  } else {
		    x.type = "password";
		  }
		} 
	</script>
</body>
</html>
