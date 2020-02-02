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
  <title>Degree Master </title>

  <link rel="stylesheet" href="./views/css/bootstrap.min.css">

  <link rel="stylesheet" href="./views/css/mdb.min.css">

  <link rel="stylesheet" href="./views/css/style.css">

</head>
<body>
  <!-- Start your project here-->  
  <div>
    <div class="m-2 p-auto">
      
      

      <div class="header"></div> 
      
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            
            <div class="col col-md-3.5"></div>
            
            <div class="col col-md-5 mt-2 mb-2">
            
              <div class="card">
                
                <div class="card-head white-text text-center py-2 ubuntu">
                  <strong><h3 class="d-flex justify-content-end mr-5">ADD</h3><h4 class="d-flex justify-content-start ml-5">Degree Master</h4></strong>
                </div>
                
               <!--Card content-->
                <div class="card-body px-lg-5 pt-0 open-sans">
                  <!-- Form -->
                  <s:form style="color: #757575;" action="SaveDegreeMaster" method="post" modelAttribute="">
                    <label class="d-flex justify-content-end mandatory mandatory-text mt-2">* must be filled</label>
                    
                    <c:if test="${added != null }">
                      <div class="mt-1 alert alert-success alert-dismissible">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Degree details are added successfully.</strong>
                      </div>
                    </c:if>

                    <!-- Name -->
                    <div class="md-form mt-4">
                      <s:input path="name" type="text" id="country_name" class="form-control" />
                      <s:label path="name" for="Name">Degree Name<span class="mandatory"> *</span></s:label>
                      <s:errors path="name" cssClass="error" />
                    </div>

                    <!-- Acronym -->
                    <div class="md-form">
                      <s:input path="acronym" type="text" name="acronym" id="country_acronym" class="form-control" />
                      <s:label path="acronym" for="Acronym">Acronym<span class="mandatory"> *</span></s:label>
                      <s:errors path="acronym" cssClass="error" />
                    </div>

                    <div class="d-flex justify-content-start">
                      <div>
                      	<s:checkbox path="inn" id="inn" cssClass="drop" />
                        <s:label path="inn">Inuse</s:label>
                        <s:errors path="inn" cssClass="error" />
                      </div>
                    </div>
                    
                    <div class="mt-4">
                      <button type="submit" class="btn btn-custom waves-effect">Add Degree</button>
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
      <jsp:include page="Footer.jsp"></jsp:include>
    </div>
  </div>
  <!-- End your project here-->

  <!-- jQuery -->
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