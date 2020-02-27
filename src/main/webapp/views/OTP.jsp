<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>OTP Verification</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

</head>
<body>
<!-- Project Start --> 
<div>
	<jsp:include page="Header.jsp" />
	
	<div id="header"></div>
	
	<div class="content">  
    	<div class="container-fluid">
        	<div class="row mt-2 mb-2">
            	<div class="col col-md-3.5"></div>
              	<div class="col col-md-5">
                	<div class="card">
						<h5 class="card-header info-color white-text text-center py-4">
                    		OTP Verification
                  		</h5>
	                  	<div class="card-body px-lg-5 pt-0">
	                    	<s:form style="color: #757575;" action="Verify" method="post" modelAttribute="otp">
		                      	<div class="md-form">
		                        	<s:input path="otp" type="text" class="form-control"></s:input>
		                        	<s:label path="otp" for="OTP">OTP</s:label>
		                        	<s:errors path="otp" cssClass="error"></s:errors>
		                        	<small class="form-text text-muted mb-4">
		                          		OTP has send to your mail id (${email })
		                        	</small>
		                      	</div>
		                      
		                      	<button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">
		                        	Verify OTP
		                      	</button>
	                    	</s:form> 
	                    	<!-- Form -->
	                  	</div>
	                  	<!-- Card Body -->
                	</div>
                	<!-- Card -->
              	</div>
              	<!-- col-md-5 -->
             	<div class="col col-md-3.5"></div>
            </div>
            <!-- row -->
        </div>
        <!-- Container fluid -->
    </div>
    <!-- content -->
    
    <div class="footer">
    	<jsp:include page="Footer.jsp" />	
    </div>
</div>
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
