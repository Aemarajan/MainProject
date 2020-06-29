<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sign In</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

<style type="text/css">
	.image{
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
			<div class="row mt-3 mb-3 image">
				<div class="col col-md-1"></div>
				<div class="col col-md-6"></div>
				<div class="col col-md-4">
					<div class="card mt-5 mb-5">
						<div class="card-head white-text text-center py-4 ubuntu">
							<h4>Sign in</h4>
						</div>
						<div class="card-body px-sm-5 px-md-5 px-lg-5 mt-1 open-sans">
							<s:form cssClass="login-form" style="color: #757575;" action="Login" method="post" modelAttribute="signin">

								<!-- Username -->
								<div class="row">
									<div class="col-sm-11 col-md-11 col-lg-11">
										<div class="md-form mt-0">
											<s:input path="username" id="username" autofocus="autofocus" cssClass="form-control" />
											<label for="username">Username</label>
											<s:errors path="username" cssClass="error"></s:errors>
										</div>
									</div>
									<div class="col-sm-1 col-md-1 col-lg-1 p-0 mt-0">
										<a href="#" data-toggle="tooltip" data-placement="top" title="20mcale1"><i class="fa fa-info-circle mt-4"></i></a>
									</div>
								</div>
								
								<!-- Password -->
								<div class="row">
									<div class="col-sm-11 col-md-11 col-lg-11">
										<div class="md-form mt-0">
											<s:password path="password" id="password" cssClass="form-control" />
											<label for="password">Password</label>
											<s:errors path="password" cssClass="error"></s:errors>
										</div>
									</div>
									<div class="col-sm-1 col-md-1 col-lg-1 p-0 mt-0">
										<a href="#" data-toggle="tooltip" data-placement="top" title="xxxxxxx"><i class="fa fa-info-circle mt-4"></i></a>
									</div>
								</div>
								
								<div class="d-flex justify-content-between">
									<div>
 										<input type="checkbox" onclick="showPassword()" >
										<label>Show Password</label>
									</div>
									<div>
										<!-- Forgot password -->
										<a href="#forgotModal" data-toggle="modal">Forgot password ?</a>
									</div>
								</div>
								
								<!-- Sign in button -->
								<div>
									<button	class="btn btn-custom btn-block my-3 py-2 waves-effect z-depth-0" type="submit">Sign in</button>
								</div>
							</s:form>
							<!-- Form -->
							
							<!-- Forgot Modal -->
							<div id="forgotModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<s:form action="SendOTP" method="post" modelAttribute="forgotPassword">
											<div class="modal-header">						
												<h4 class="modal-title">Reset Your Password</h4>
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											</div>
											
											<div class="modal-body">
												<c:if test="${emailError != null }">
													<div class="toast" id="Toast">
														<div class="toast-header white-text bg-danger pt-2">
															<h5 class="mr-auto">Error</h5>
															<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="toast-body py-2">
															<div>Oops! This Email ID is not registered, Please Try Again...</div>
														</div>
													</div>
												</c:if>

												<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
																	
												<div class="row">
													<div class="col col-sm-11 col-md-11 col-lg-11">
														<div class="md-form mt-0">
															<s:input path="email" id="email" autofocus="autofocus" cssClass="form-control text-lowercase"/>
															<label for="email">Email<span class="mandatory"> *</span></label>
															<s:errors path="email" cssClass="error"></s:errors>
														</div>
													</div>
													<div class="col col-sm-1 col-md-1 col-lg-1 p-0">
														<a href="#" data-toggle="tooltip" data-placement="top" title="abc@gmail.com"><i class="fa fa-info-circle mt-4"></i></a>
													</div>
												</div>					
											</div>
											<div class="modal-footer">
												<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
												<input type="submit" class="btn btn-info" value="Submit">
											</div>
										</s:form>
									</div>
								</div>
							</div>
							<!-- Forgot Password Modal -->
							
							<!-- OTP Verification Modal -->
							<div id="otpModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<s:form action="VerifyOTP" method="post" modelAttribute="otp">
											<div class="modal-header">						
												<h4 class="modal-title">OTP Verification</h4>
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											</div>
											
											<div class="modal-body">
												
												<c:if test="${otpError != null }">
													<div class="toast" id="Toast">
														<div class="toast-header white-text bg-danger pt-2">
															<h5 class="mr-auto">Error</h5>
															<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="toast-body py-2">
															<div>Invalid OTP. Please Try Again Later...</div>
														</div>
													</div>
												</c:if>
												
												<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>

												<c:if test="${email != null }">
													<p class="text-center mb-3">
														OTP has been sent to this Email ID ${email } 
													</p>
												</c:if>

												<s:hidden path="id" value="${id }"/>				
												<div class="row">
													<div class="col col-sm-11 col-md-11 col-lg-11">
														<div class="md-form mt-0">
															<s:input path="otp" id="otp" autofocus="autofocus" maxlength="6" cssClass="form-control"/>
															<label for="otp">OTP<span class="mandatory"> *</span></label>
															<s:errors path="otp" cssClass="error"></s:errors>
														</div>
													</div>
													<div class="col col-sm-1 col-md-1 col-lg-1 p-0">
														<a href="#" data-toggle="tooltip" data-placement="top" title="123456"><i class="fa fa-info-circle mt-4"></i></a>
													</div>
												</div>					
											</div>
											<div class="modal-footer">
												<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
												<input type="submit" class="btn btn-info" value="Verify">
											</div>
										</s:form>
									</div>
								</div>
							</div>
							<!-- OTP Verification Modal -->
							
							<!-- Reset Password Modal -->
							<div id="resetModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<s:form action="ResetPassword" method="post" modelAttribute="changePassword">
											<div class="modal-header">						
												<h4 class="modal-title">Reset Password</h4>
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											</div>
											
											<div class="modal-body">
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

												<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled </label>

												<s:hidden path="id" id="id" value='<%=session.getAttribute("id")%>' />

												<div class="row">
													<div class="col-sm-11 col-md-11 col-lg-11">
														<div class="md-form mt-0">
															<s:input path="new_pwd" id="new_pwd" maxlength="15" cssClass="form-control" />
															<s:label path="new_pwd" for="New Password">New Password<span class="mandatory"> *</span> </s:label>
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
															<s:label path="confirm_pwd" for="Confirm Password">Confirm Password<span class="mandatory"> *</span> </s:label>
															<s:errors path="confirm_pwd" cssClass="error"></s:errors>
														</div>
													</div>
													<div class="col col-sm-1 col-md-1 col-lg-1 p-0">
														<a href="#" data-toggle="tooltip" data-placement="top" title="Abc@123"><i class="fa fa-info-circle mt-4"></i></a>
													</div>
												</div>

												<div class="mt-4">
													<button type="submit" class="btn btn-custom waves-effect">Update</button>
												</div>
											</div>
										</s:form>
									</div>
								</div>
							</div>
							<!-- Reset Password Modal -->
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>

	<c:if test="${msg != null }">
		<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width:300px;">
			<div class="toast-header white-text bg-danger pt-2">
				<h5 class="mr-auto">Error</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Invalid Username or Password. Try Again...</div>
			</div>
		</div>
	</c:if>

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

	<c:if test="${updated != null }">
		<div class="toast" id="Toast" style="position: absolute; right: 20px; bottom: 20px; width:300px;">
			<div class="toast-header white-text bg-success pt-2">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Your Password has been Updated Successfully...</div>
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
  	<script type="text/javascript" src="./views/js/common.js"></script>
  	<script type="text/javascript">
		function showPassword() {
			var x = document.getElementById("password");
			if (x.type === "password") {
				x.type = "text";
			}else {
				x.type = "password";
			}
		}
	</script>
	
	<c:if test="${forgotModal != null }">
		<script type="text/javascript">
			$('#forgotModal').modal('show');
		</script>
	</c:if>
	
	<c:if test="${otpModal != null }">
		<script type="text/javascript">
			$('#otpModal').modal('show');
		</script>
	</c:if>
	
	<c:if test="${resetModal != null }">
		<script type="text/javascript">
			$('#resetModal').modal('show');
		</script>
	</c:if>
</body>
</html>