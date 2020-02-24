<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Add Level One - Header</title>
  
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
        	<div class="row">
            	<div class="col col-md-3.5"></div>
            	<div class="col col-md-5 mt-2 mb-2">
              		<div class="card">
                		<div class="card-head white-text text-center py-2 ubuntu">
                  			<strong>
                  				<h3 class="d-flex justify-content-end mr-5">ADD</h3>
                  				<h4 class="d-flex justify-content-start ml-5">Level One</h4>
                  			</strong>
                		</div>
                
                		<div class="card-body px-lg-5 pt-0 open-sans">
                  			<!-- Form -->
                  			<s:form action="saveLvl1" modelAttribute="levelOne">
                  				<c:if test="${temp != null }">
									<div class="mt-1 alert alert-success alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Level One Header added. And add Level Two To <a class="alert-link" href="LevelTwoForm">click here</a>
									</div>
								</c:if>
								
								<c:if test="${added != null }">
									<div class="mt-1 alert alert-success alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Level One Header added successfully.
									</div>
								</c:if>
								
								<c:if test="${exist != null }">
									<div class="mt-1 alert alert-danger alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Header already exist.
									</div>
								</c:if>
                    			
                    			<label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
                    		
                    			<div class="md-form">
                      				<s:input type="text" path="name" cssClass="form-control" autofocus="autofocus" />
                      				<s:label path="name" for="Header Name">Header Name<span class="mandatory"> *</span></s:label>
                      				<s:errors path="name" cssClass="error" />
                    			</div>
                    		
                    			<div class="d-flex justify-content-start"> <label>( If this header have another level select this checkbox )</label> </div>
                    
                    			<div class="d-flex justify-content-start">
                      				<!-- Default unchecked -->
                      				<div>
                        				<s:checkbox path="dd" cssClass="drop" id="dd"></s:checkbox>
                        				<s:label path="dd">Dropdown</s:label>
                      				</div>
                    			</div>
                    			<div class="md-form">
                      				<s:input type="text" path="ref" cssClass="ref form-control" />
                      				<s:label for="Header Name" path="ref" class="rlab">Reference <span class="mandatory"> *</span></s:label>
                      				<s:errors path="ref" cssClass="error referror"></s:errors>
                    			</div>
                    			
                    			<div class="mt-4">
                      				<button type="submit" class="btn btn-custom waves-effect">ADD</button>
                    			</div>
                  			</s:form> 
                  			<!-- Form -->
                		</div>
                		<!-- Card body -->
              		</div>
              		<!-- Card  -->
            	</div>
            	<div class="col col-md-3.5"></div>
			</div>
			<!-- Row -->
        </div>
        <!-- Container Fluid -->
	</div>
	<!-- Content -->
	<div class="footer">
		<jsp:include page="Footer.jsp" />
	</div>
</div>
<!-- Project End -->

<!-- jQuery -->
<script type="text/javascript" src="./views/js/jquery.min.js"></script>
<script type="text/javascript" src="./views/js/popper.min.js"></script>
<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./views/js/mdb.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#header').load("http://localhost:8080/header");

		$('#dd').click(function() {
			var check = this.checked;
			if (check == false){
				$('.ref').show();
        		$('.rlab').show();
        		$('.referror').show();
        		$('.ref').attr('value','');
      		}
			else{
				$('.ref').hide();
        		$('.rlab').hide();
        		$('.referror').hide();
        		$('.ref').attr('value','null');
      		}
		});
	});
</script>
</body>
</html>