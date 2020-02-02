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
  <title>Diploma Master </title>
  
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="css/mdb.min.css">
  <!-- Your custom styles (optional) -->
  <link rel="stylesheet" href="css/style.css">

</head>
<body>
  <!-- Start your project here-->  
  <div>
    <div class="m-2 p-auto">
      
      <jsp:include page="Header.jsp" />
	  <br>
	  
      <div id="header"></div> 
      
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            
            <div class="  col col-md-3.5"></div>
            
            <div class="col col-md-5 mt-2 mb-2">
            
              <div class="card">
                
                <div class="card-head white-text text-center py-2 ubuntu">
                  <strong><h3 class="d-flex justify-content-end mr-5">ADD</h3><h4 class="d-flex justify-content-start ml-5">Diploma Master</h4></strong>
                </div>
                
               <!--Card content-->
                <div class="card-body px-lg-5 pt-0 open-sans">
                  <!-- Form -->
                  <s:form  style="color: #757575;" action="SaveDiplomaMaster" method="post" modelAttribute="">
                    <label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
                    
                    <c:if test="${added != null }">
                      <div class="mt-1 alert alert-success alert-dismissible">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Diploma details are added successfully.</strong>
                      </div>
                    </c:if>

                    <!-- Name -->
                    <div class="md-form mt-4">
                      <s:input path="name" type="text"  id="diploma_name" class="form-control" />
                      <s:label path="name" for="Name">Diploma Course Name<span class="mandatory"> *</span></s:label>
                      <s:errors path="name" cssClass="error"></s:errors>
                    </div>

                    <!-- Specialization -->
                    <div class="md-form">
                      <s:input path="specialization" type="text"  id="Specialization" class="form-control" />
                      <s:label path="specialization" for="Specialization">Specialization<span class="mandatory"> *</span></s:label>
                      <s:errors path="specialization" cssClass="error"></s:errors>
                    </div>

                    <div class="d-flex justify-content-start">
                      <div>
                      	<s:checkbox path="inn" id="inn" cssClass="drop"/>
                        <s:label path="inn">Inuse</s:label>
                        <s:errors path="inn" cssClass="error"></s:errors>
                      </div>
                    </div>
                    
                    <div class="mt-4">
                      <button type="submit" class="btn btn-custom waves-effect">Add Diploma Course</button>
                    </div>
                  </s:form> 
                  <!-- Form -->
                </div>
              </div>
            </div>

            <div class="col col-md-3.5"></div>
          
          </div>
        </div>
      </div>
      <jsp:include page="Footer.jsp" />
    </div>
  </div>
  <!-- End your project here-->
  <!-- jQuery -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  <!-- Your custom scripts (optional) -->
  <script type="text/javascript">
    $(document).ready(function() {
      $('#header').load("http://localhost:8080/header");
    });
  </script>

</body>
</html>