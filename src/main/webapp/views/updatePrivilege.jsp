<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Update Privilege - 1</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">	
<link rel="stylesheet" href="./views/css/animate.min.css">
<link rel="stylesheet" href="./views/css/bootnavbar.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="./views/css/mdb.min.css">
</head>
<body>
	<div id="header"></div>
	<div>
		<div class="m-2 p-auto">
			<div class="header"></div>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col col-md-3.5"></div>
						<div class="col col-md-5 mt-2 mb-2">
							<!-- Material form register -->
							<div class="card">
								<h5 class="card-header info-color white-text text-center py-4">
									<strong>Update Privilege</strong>
								</h5>

								<!--Card content-->
								<div class="card-body px-lg-5 pt-0">
									<!-- Form -->
									<form class="text-center" style="color: #757575;" action="getUserPrivilege" method="post">
										<c:if test="${success != null }">
											<div class="alert alert-success alert-dismissible">
												<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
												<strong>Privilege Updated</strong>
											</div>
										</c:if>
										<c:if test="${error != null }">
											<div class="alert alert-success alert-dismissible">
												<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
												<strong>Update Error. Please try again.</strong>
											</div>
										</c:if>
										<div class="md-form">
											<label for="username" style="font-size: 18px;">User
												name :</label>
										</div>
										<div class="md-form" style="margin-left: 110px;">
											<select name="user_id" class="browser-default custom-select" style="width: 300px;">
												<option selected>-- Select --</option>
												<c:forEach items="${list }" var="user">
													<option value="${user.user_id }">${user.username} (${user.email })</option>
												</c:forEach>
											</select>
										</div>
										<!-- Sign up button -->
										<button
											class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0"
											type="submit">Select User</button>
									</form>
									<!-- Form -->
								</div>
							</div>
							<!-- Material form register -->
						</div>
						<div class="col col-md-3.5"></div>
					</div>
				</div>
			</div>
			<div class="footer"></div>
		</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	    <script src="./views/js/bootnavbar.js" ></script>
		<!-- MDB core JavaScript -->
		<script type="text/javascript" src="./views/js/mdb.min.js"></script>
		<!-- Your custom scripts (optional) -->
		<script type="text/javascript"></script>
		<script>
    		$(document).ready(function(){
        		$('#header').load("http://localhost:8080/header");
    		});
    </script>
</body>
</html>
