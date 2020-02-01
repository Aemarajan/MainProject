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
  
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="./views/css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="./views/css/mdb.min.css">
  <link rel="stylesheet" href="./views/css/style.css">
  </head>
  <body>
    <div>
      <div class="p-auto">
        <div class="header bg-light text-center py-3">
          <h2>PSNA College of Engineering and Technology</h2>
        </div> <br>
        
        <div class="content">
          <div class="container-fluid">
            <div class="row">
              
              <div class="col col-md-3.5"></div>
              
              <div class="col col-md-5 mt-2 mb-2">
                <!-- Material form register -->
                <div class="card">

                  <h5 class="card-header info-color white-text text-center py-4">
                    <strong>OTP Verification</strong>
                  </h5>

                  <!--Card content-->
                  <div class="card-body px-lg-5 pt-0">
                    <!-- Form -->
                    <s:form style="color: #757575;" action="Verify" method="post" modelAttribute="otp">
                        
                      <!-- OTP -->
                      <div class="md-form">
                        <s:input path="otp" type="text" class="form-control"></s:input>
                        <s:label path="otp" for="OTP">OTP</s:label>
                        <s:errors path="otp" cssClass="error"></s:errors>
                        <small class="form-text text-muted mb-4">
                          OTP has send to your mail id (${email })
                        </small>
                      </div>
                      
                      <!-- Verify button -->
                      <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">
                        Verify OTP
                      </button>

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
        <div class="text-center">
        	<jsp:include page="Footer.jsp"></jsp:include>
        </div>
      </div>
    </div>
    <!-- jQuery -->
    <script type="text/javascript" src="./views/js/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="./views/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="./views/js/mdb.min.js"></script>
    <!-- Your custom scripts (optional) -->
    <script type="text/javascript"></script>

  </body>
  </html>
