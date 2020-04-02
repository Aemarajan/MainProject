<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Update Privilege</title>

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
					<div class="card mt-4">
						<h4 class="card-head white-text text-center py-4">
							<strong>Update Privilege</strong>
						</h4>
						<div class="card-body px-lg-5 pt-0">
							<s:form action="getUserPrivilege" method="post" modelAttribute="modifyPrivilege">
								
								<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be selected</label>
										
								<div class="mt-0">
                      				<label><strong>User</strong><span class="mandatory"> *</span></label>
                    			</div>
										
								<div class="md-form mt-0">
									<s:select path="user_id" id="users" cssClass="browser-default custom-select" />
									<s:errors path="user_id" cssClass="error"/>
								</div>
								
								<!-- Sign up button -->
								<button class="btn btn-custom btn-block py-2 waves-effect z-depth-0" type="submit">Select User</button>
							</s:form>
							<!-- Form -->
						</div>
						<!-- card body -->
					</div>
					<!-- card -->
				</div>
				<!-- co-md-5 -->
				<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
			</div>
			<!-- row -->
		</div>
		<!-- container fluid -->
	</div>
	<!-- wrapper -->
	
	<c:if test="${error != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-danger">
				<h4 class="mr-auto">Error</h4>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Something went wrong in Updating the User Privilege. Try to
					update Again...</div>
			</div>
		</div>
	</c:if>
	<c:if test="${updated != null }">
		<div class="toast" id="Toast"
			style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text bg-success pt-2">
				<h4 class="mr-auto">Notification</h4>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Privilege Updated Successfully.</div>
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
	<script>
    	$(document).ready(function(){
        	$('#header').load("http://localhost:8080/header");
        	$('#Toast').toast({
				delay:5000
			});
			$('#Toast').toast('show');
    	});

    	var varurl = "http://localhost:8080/api/getUserPp1";
        var users = $('#users');
        $.ajax({
            type: 'GET',
            url: varurl,
            async: true,
            success: function(result){
                var output = "<option value='0'> -- Select -- </option>";
                for(var i in result){
                    output+="<option value=" + result[i].user_id + ">" + result[i].username + "<span> [ " + result[i].email + " ] </span>" + "</option>";
                }
                users.html(output);
            }
        });
    </script>
</body>
</html>
