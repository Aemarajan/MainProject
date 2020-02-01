<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Add Level One - Header</title>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="./views/css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="./views/css/mdb.min.css">
  <!-- Your custom styles (optional) -->
  <link rel="stylesheet" href="./views/css/style.css">
</head>
<body>
  <div id="header"></div>
  <!-- Start your project here-->  
  <div>
    <div class="m-2 p-auto">
      
      <div class="header"></div> 
      
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="  col col-md-3.5"></div>
            <div class="col col-md-5 mt-2 mb-2">
              <!-- Material form register -->
              <div class="card">
                
                <div class="card-head white-text text-center py-2 ubuntu">
                  <strong><h3 class="d-flex justify-content-end mr-5">ADD</h3><h4 class="d-flex justify-content-start ml-5">Level One</h4></strong>
                </div>
                
               <!--Card content-->
                <div class="card-body px-lg-5 pt-0 open-sans">
                  <!-- Form -->
                  <s:form action="saveLvl1" modelAttribute="levelOne">
                  	<c:if test="${temp != null }">
						<div class="mt-1 alert alert-success alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Level One Header added. And add Level Two To <a class="alert-link" href="LevelTwoForm">click here</a></strong>
						</div>
					</c:if>
					<c:if test="${added != null }">
						<div class="mt-1 alert alert-success alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Level One Header added successfully.</strong>
						</div>
					</c:if>
					<c:if test="${exist != null }">
						<div class="mt-1 alert alert-danger alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Header already exist.</strong>
						</div>
					</c:if>
                    <label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
                    <!-- Header 1 -->
                    <div class="md-form mt-2">
                      <s:input type="text" path="name" cssClass="form-control"></s:input>
                      <s:label path="name" for="Header Name">Header Name<span class="mandatory"> *</span></s:label>
                      <s:errors path="name" cssClass="error"></s:errors>
                    </div>
                    <div class="d-flex justify-content-start"> <label>( If this header have another level select this checkbox )</label> </div>
                    
                    <div class="d-flex justify-content-start">
                      <!-- Default unchecked -->
                      <div>
                        <s:checkbox path="dd" cssClass="drop" id="dd"></s:checkbox>
                        <s:label path="dd">Dropdown</s:label>
                      </div>
                    </div>
                    <div class="md-form mt-3">
                      <s:input type="text" path="ref" cssClass="ref form-control"></s:input>
                      <s:label for="Header Name" path="ref" class="rlab">Reference <span class="mandatory"> *</span></s:label>
                      <s:errors path="ref" cssClass="error referror"></s:errors>
                    </div>
                    <div class="mt-4">
                      <button type="submit" class="btn btn-custom waves-effect">ADD</button>
                    </div>
                  </s:form> 
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
  <!-- End your project here-->
  
  <!-- jQuery -->
  <script type="text/javascript" src="./views/js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="./views/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="./views/js/mdb.min.js"></script>
  <!-- Your custom scripts (optional) -->
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
