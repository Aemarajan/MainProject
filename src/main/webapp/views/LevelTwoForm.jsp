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
  
  <link rel="stylesheet" href="./views/css/bootstrap.min.css">
  <link rel="stylesheet" href="./views/css/mdb.min.css">
  <link rel="stylesheet" href="./views/css/style.css">
</head>
<body>
<!-- Start your project here-->  
<div>
	<jsp:include page="Header.jsp" />
  	
    <div id="header"></div>
    
	<div class="content">
    	<div class="container-fluid">
        	<div class="row mt-2 mb-2">
            	<div class="col col-md-3.5"></div>
            	<div class="col col-md-5">
              		<div class="card">
                		<div class="card-head white-text text-center py-2 ubuntu">
                  			<h4 class="d-flex justify-content-end mr-5">ADD</h4>
                  			<h5 class="d-flex justify-content-start ml-5">Level Two</h5>
                		</div>
                		
                		<div class="card-body px-lg-5 pt-0 open-sans">
                  			<!-- Form -->
                  			<s:form style="color: #757575;" action="saveLvl2" modelAttribute="levelTwo">
                  			
                  				<c:if test="${temp != null }">
									<div class="mt-2 alert alert-success alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Level Two Header added. And add Level Three To  <a class="alert-link" href="LevelThreeForm">click here</a>
									</div>
								</c:if>
								<c:if test="${added != null }">
									<div class="mt-2 alert alert-success alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Level Two Header added successfully.
									</div>
								</c:if>
								<c:if test="${exist != null }">
									<div class="mt-2 alert alert-danger alert-dismissible">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										Header Already exist.
									</div>
								</c:if>
			                    
			                    <label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
			                    
			                    <div class="mt-2">
			                      <label class="d-flex justify-content-start">Level One <span class="mandatory pl-1"> *</span></label>
			                      <s:select path="lvl1" cssClass="browser-default custom-select" id="lvl1" />
			                      <s:errors path="lvl1" cssClass="error" />
			                    </div>
                    
			                    <!-- Header 1 -->
			                    <div class="md-form">
			                      <s:input path="name" type="text"  cssClass="form-control"></s:input>
			                      <s:label path="name" for="Header Name">Header Name<span class="mandatory"> *</span></s:label>
			                      <s:errors path="name" cssClass="error"></s:errors>
			                    </div>
                    
			                    <div class="d-flex justify-content-start"> <label>( If this header have another level select this checkbox )</label> </div>
			                    
			                    <!-- Default checked -->
			                    <div class="d-flex justify-content-start">
			                      <div>
			                        <s:checkbox path="dd" cssClass="drop" id="dd"></s:checkbox>
			                        <s:label path="dd">Dropdown</s:label>
			                      </div>
			                    </div>
			                    <div class="md-form">
			                      <s:input path="ref" type="text" cssClass="ref form-control"></s:input>
			                      <s:label path="ref" for="Header Name" class="rlab">Reference <span class="mandatory"> *</span></s:label>
			                      <s:errors path="ref" cssClass="error referror"></s:errors>
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
            <div class="col col-md-3.5"></div>
          </div>
          <!-- row -->
        </div>
        <!-- container fluid -->
    </div>
    <!-- content -->
	<jsp:include page="Footer.jsp" />
</div>
<!-- End your project here-->
  
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
