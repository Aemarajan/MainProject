
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Add Level Three - Header</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

</head>
<body id="page-top">

	<jsp:include page="Header.jsp" />
    <jsp:include page="Menubar.jsp" />
     
    <div class="wrapper d-flex align-items-stretch">
    
    	<jsp:include page="Sidebar.jsp" />
    	
    	<div class="container-fluid pl-5">
        	<div class="row mt-2 mb-2">
            	<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
                	<div class="col col-sm-5 col-md-5 col-lg-5">
                    	<div class="card">
                                
                        <div class="card-head white-text text-center py-2 ubuntu">
                        	<h4 class="d-flex justify-content-end mr-5">ADD</h4>
                        	<h4 class="d-flex justify-content-start ml-5">Level Three</h4>
                        </div>
                        
                        <div class="card-body px-lg-5 pt-0 open-sans">
                        	<!-- Form -->
                            <s:form style="color: #757575;" action="saveLvl3" method="post" modelAttribute="levelThree">
                            	
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
											<div>Level Three Header Already Exist. Please Enter New Header...</div>
										</div>
									</div>
								</c:if>
								
                                <label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
                                
                                <div class="mt-3">
                                	<label class="d-flex justify-content-start"> Level One <span class="mandatory pl-1"> *</span></label>
                                    <s:select path="lvl1" class="browser-default custom-select" id="lvl1" />
                                    <s:errors path="lvl1" cssClass="error"></s:errors>
                                </div>
                                <div class="mt-3">
                                	<label class="d-flex justify-content-start"> Level Two <span class="mandatory pl-1"> *</span></label>
                                    <s:select path="lvl2" class="browser-default custom-select" id="lvl2" />
                                    <s:errors path="lvl2" cssClass="error"></s:errors>
                                </div>
                                <div class="mt-3">
                                	<label class="d-flex justify-content-start"> Level Three <span class="mandatory pl-1"> *</span></label>
                                    <s:select path="lvl3" class="browser-default custom-select" id="lvl3" />
                                    <s:errors path="lvl3" cssClass="error"></s:errors>
                                </div>
                                <!-- Reference-->
                                <div class="md-form">
                                	<s:input type="text" path="ref" class="ref form-control"></s:input>
                                    <label for="Header Name" class="rlab">Reference <span class="mandatory"> *</span></label>
                                    <s:errors path="ref" cssClass="error"></s:errors>
                                </div>
                                <div class="mt-4">
                                	<button type="submit" class="btn btn-custom waves-effect">ADD</button>
                                </div>
                           	</s:form> 
                            <!-- Form -->
                        </div>
					</div>
                </div>
            	<div class="col col-sm-3.5 col-md-3.5 col-lg-3.5"></div>
            </div>
		</div>
	</div>
	
	<c:if test="${added != null }">
		<div class="toast" id="Toast" 
			style="position: absolute; overflow: auto; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-success">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Level Three Header Added Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<jsp:include page="Footer.jsp" /> 
    
    <a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
    
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
	  $('#dd').click(function() {
	      var check = this.checked;
	      if (check == false){
	          $('.ref').show();
	          $('.rlab').show();
	      }
	      else{
	          $('.ref').hide();
	          $('.rlab').hide();
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
	  
	  var lvl3 = $('#lvl3');
	  var lvl2 = $('#lvl2');
	  $('#lvl1').change(function(){
	      $(this).find("option:selected").each(function(){
	          var lvl = $(this).attr("value");
	          var pre = "http://localhost:8080/api/getLvl2/";
	          var varurl = pre+lvl;
	          //console.log(varurl);
	          $.ajax({
	              type: 'GET',
	              url: varurl,
	              async: true,
	              success:function(result){
	                  //console.log(result);
	                  var output = "<option value='0'>-- Select --</option>";
	                  for(var i in result){
	                      output+="<option value="+result[i].lvl2_id+">"+result[i].name+"</option>";
	                  }
	                  output+="";
	                  lvl2.html(output);
	              }
	          });
	      });
	  });
	  
	          var varurl1 = "http://localhost:8080/api/getAllLevelThree";
	          //console.log(varurl);
	          $.ajax({
	              type: 'GET',
	              url: varurl1,
	              async: true,
	              success: function(result){
	                  var output = "<option value='0'> -- Select -- </option>";
	                  for(var i in result){
	                      output+="<option value="+result[i].lvl3_id+">"+result[i].name+"</option>";
	                  }
	                  lvl3.html(output);
	              }
	          });
	  
	});
	</script>
</body>
</html>