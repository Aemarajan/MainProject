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
  <title>Add Level Two - Header</title>
  
  <link rel="stylesheet" href="./views/font-awesome/css/all.css">
  <link rel="stylesheet" href="./views/css/bootstrap.min.css">
  <link rel="stylesheet" href="./views/css/mdb.min.css">
  <link rel="stylesheet" href="./views/css/style.css">
</head>
<body id="page-top">

	<jsp:include page="Header.jsp" />
<%-- 	<jsp:include page="Menubar.jsp" /> --%>
	<div id="header" class="mt-2"></div>
    
	<div class="wrapper d-flex align-items-stretch">
		
		<jsp:include page="Sidebar.jsp" />
		
    	<div class="container-fluid pl-5">
        	<div class="row mt-2 mb-2">
            	<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
            	<div class="col col-sm-5 col-md-5 col-lg-5">
              		<div class="card">
                		<div class="card-head white-text text-center py-2 ubuntu">
                  			<h4 class="d-flex justify-content-end mr-5">ADD</h4>
                  			<h4 class="d-flex justify-content-start ml-5">Level Two</h4>
                		</div>
                		
                		<div class="card-body px-lg-5 pt-0 open-sans">
                  			<!-- Form -->
                  			<s:form style="color: #757575;" action="saveLvl2" method="post" modelAttribute="levelTwo">
                  				<c:if test="${exist != null }">
									<div class="toast" id="Toast">
										<div class="toast-header white-text pt-2 bg-success">
											<h5 class="mr-auto">Error</h5>
											<button type="button" class="ml-2 mb-1 close white-text"
												data-dismiss="toast">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="toast-body py-2">
											<div>Level Two Header Already Exist. Please Enter New Header...</div>
										</div>
									</div>
								</c:if>
			                    
			                    <label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
			                    
			                    <div class="mt-2">
			                      <label class="d-flex justify-content-start">Level One <span class="mandatory pl-1"> *</span></label>
			                      <s:select path="lvl1" cssClass="browser-default custom-select" id="lvl1" />
			                      <s:errors path="lvl1" cssClass="error" />
			                    </div>
                    
			                    <!-- Header 2 -->
			                    <div class="row mt-3">
			                    	<div class="col-sm-11">
			                    		<div class="md-form mt-0">
					                      <s:input path="name" type="text"  cssClass="form-control"></s:input>
					                      <s:label path="name" for="Header Name">Header Name<span class="mandatory"> *</span></s:label>
					                      <s:errors path="name" cssClass="error"></s:errors>
					                    </div>
			                    	</div>
			                    	<div class="col-sm-1 p-0">
			                    		<a href="#" data-toggle="tooltip" data-placement="top" title="XYZ"><i class="fa fa-info-circle mt-4"></i></a>
			                    	</div>
			                    </div>
                    
			                    <div class="d-flex justify-content-start"> <label>( If this header have another level select this checkbox )</label> </div>
			                    
			                    <!-- Default checked -->
			                    <div class="d-flex justify-content-start">
			                      <div>
			                        <s:checkbox path="dd" cssClass="drop" id="dd"></s:checkbox>
			                        <s:label path="dd">Dropdown</s:label>
			                      </div>
			                    </div>
			                    
			                    <div class="row" id="ref">
			                    	<div class="col-sm-11">
			                    		<div class="md-form mt-0">
					                      <s:input path="ref" type="text" cssClass="ref form-control"></s:input>
					                      <s:label path="ref" for="Header Name">Reference <span class="mandatory"> *</span></s:label>
					                      <s:errors path="ref" cssClass="error"></s:errors>
					                    </div>
			                    	</div>
			                    	<div class="col-sm-1 p-0">
			                    		<a href="#" data-toggle="tooltip" data-placement="top" title="XYZ"><i class="fa fa-info-circle mt-4"></i></a>	
			                    	</div>
			                    </div>
			                    
			                    <div class="mt-4">
			                      <button type="submit" class="btn btn-custom waves-effect">ADD</button>
			                    </div>
                  			</s:form> 
                  			<!-- Form -->
                		</div>
                		<!-- Card Body -->
              		</div>
              		<!-- Card -->
              	</div>
              	<!-- col-md-5 -->
            <div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
          </div>
          <!-- row -->
        </div>
        <!-- container fluid -->
    </div>
    <!-- content -->
    
    <c:if test="${added != null }">
		<div class="toast" id="Toast" style="position: absolute; overflow: auto; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-success">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Level Two Header Added Successfully.</div>
			</div>
		</div>
	</c:if>

	<c:if test="${temp != null }">
		<div class="toast" id="LongToast" style="position: absolute; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-success">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text" data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>
					Level Two Header added. And add Level Three To <a class="alert-link" href="LevelThreeForm">click here</a>
				</div>
			</div>
		</div>
	</c:if>

	<jsp:include page="Footer.jsp" />
  
  	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	
<script type="text/javascript" src="./views/js/jquery.min.js"></script>
<script type="text/javascript" src="./views/js/popper.min.js"></script>
<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./views/js/mdb.min.js"></script>
<script type="text/javascript" src="./views/js/common.js"></script>  

<script type="text/javascript">
	$(document).ready(function(){
		$('#dd').click(function() {
			var check = this.checked;
			console.log(check);
			if (check == false){
				$('#ref').show();
// 	  			$('.rlab').show();
// 	  			$('.referror').show();
	  			$('.ref').attr('value','');
			}
			else{
				$('#ref').hide();
// 	  			$('.rlab').hide();
// 	  			$('.referror').hide();
	  			$('.ref').attr('value','null');
			}
		});

		var varurl = "http://localhost:8080/api/getAllLevelOneByDd";
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
