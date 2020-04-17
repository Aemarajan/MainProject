<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Delete Level One - Header</title>
	
	<link rel="stylesheet" href="./views/font-awesome/css/all.css">
	<link rel="stylesheet" href="./views/css/bootstrap.min.css">
	<link rel="stylesheet" href="./views/css/mdb.min.css">
	<link rel="stylesheet" href="./views/css/style.css">

</head>
<body id="page-top">
	<!-- Project Starts Here -->
	<div>
		<jsp:include page="Header.jsp" />
		<jsp:include page="Menubar.jsp" />
		
		<div class="wrapper d-flex align-items-stretch">
			
			<jsp:include page="Sidebar.jsp" />
			
	    	<div class="container-fluid pl-5">
	        	<div class="row  mt-2 mb-2">
	            	<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
	            	<div class="col col-sm-5 col-md-5 col-lg-5">
	              		<div class="card">
	                		<div class="card-head white-text text-center py-2 ubuntu">
	                  			<h4 class="d-flex justify-content-end mr-5">DELETE</h4>
	                  			<h4 class="d-flex justify-content-start ml-5">Level One</h4>
	                		</div>
	              
	                		<div class="card-body px-5 pt-0 open-sans">
				               	<s:form style="color: #757575;" action="deleteLevelOne" method="post" modelAttribute="deleteLevelOne">
									<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be selected</label>
				                   	
				                   	<div class="mt-3">
				                   		<label class="d-flex justify-content-start">Level One <span class="mandatory pl-1"> *</span></label>
				                   		<s:select path="lvl1" cssClass="browser-default custom-select" id="lvl1" />
				                   		<s:errors path="lvl1" cssClass="error"></s:errors>
				                   	</div>
				                    	
				                    <div class="mt-4">
				                      	<button type="submit" class="btn btn-custom waves-effect">DELETE</button>
				                    </div>
				               	</s:form> 
				                <!-- Form -->
	                		</div>
	                		<!-- card body -->
	              		</div>
	              		<!-- card -->
	              	</div>
	              	<!-- col-md-5 -->
	            	<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
	          	</div>
	          	<!-- row -->
	        </div>
	        <!-- Container fluid -->
	    </div>
	    <!-- content -->
	    
	    <c:if test="${deleted != null }">
			<div class="toast" id="Toast"
				style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
				<div class="toast-header white-text bg-danger pt-2">
					<h5 class="mr-auto">Notification</h5>
					<button type="button" class="ml-2 mb-1 close white-text"
						data-dismiss="toast">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="toast-body py-2">
					<div>Level One Header Deleted Successfully.</div>
				</div>
			</div>
		</c:if>
	    
		<div class="">
			<jsp:include page="Footer.jsp" />
		</div>
		
		<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	</div>
	<!-- Project Ends here-->
  
 	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>  
  	
  	<script type="text/javascript">
		$(document).ready(function(){
			var varurl = "http://localhost:8080/api/getAllLevelOne";
			  var lvl1 = $('#lvl1');
			  $.ajax({
			    type: 'GET',
			    url: varurl,
			    async: true,
			    success: function(result){
			      var output = "<option value='0'> -- Select -- </option>";
			      for(var i in result){
			        output+="<option value="+result[i].lvl1_id+">"+result[i].name+"</option>";
			      }
			      lvl1.html(output);
			    }
			  });
			});
  	</script>
</body>
</html>
