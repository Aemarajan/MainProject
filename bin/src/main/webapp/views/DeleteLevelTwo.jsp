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
  <title>Delete Level Two - Header</title>
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
            <div class="col col-md-3.5"></div>
            <div class="col col-md-5 mt-2 mb-2">
              <!-- Material form register -->
              <div class="card">
                
                <div class="card-head white-text text-center py-2 ubuntu">
                  <strong><h3 class="d-flex justify-content-end mr-5">DELETE</h3><h4 class="d-flex justify-content-start ml-5">Level Two</h4></strong>
                </div>
                
                <!--Card content-->
                <div class="card-body px-lg-5 pt-0 open-sans">
                  <!-- Form -->
                  <s:form style="color: #757575;" action="deleteLevelTwo" modelAttribute="deleteLevelTwo">
                  	<c:if test="${delete != null }">
						<div class="alert alert-danger alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							Header deleted successfully.
						</div>
					</c:if>
                    <label class="d-flex justify-content-start mandatory mandatory-text mt-2">* must be filled</label>
                    <div class="mt-3">
                      <s:label path="lvl1" cssClass="d-flex justify-content-start"> Level One <span class="mandatory pl-1"> *</span></s:label>
                      <s:select path="lvl1" cssClass="browser-default custom-select" id="lvl1">
                      </s:select>
                      <s:errors path="lvl1" cssClass="error"></s:errors>
                    </div>
                    <div class="mt-3">
                        <s:label path="lvl2"> Level Two <span class="mandatory pl-1"> *</span></s:label>
                        <s:select path="lvl2" cssClass="browser-default custom-select" id="lvl2">
                        </s:select>
                        <s:errors path="lvl2" cssClass="error"></s:errors>
                      </div>
                      
                    <div class="mt-4">
                        <button type="submit" class="btn btn-custom waves-effect">DELETE</button>
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
  <script type="text/javascript">
	$(document).ready(function() {
		$('#header').load("http://localhost:8080/header");
		var lvl2 = $("#lvl2");
		var varurllvl1 = "http://localhost:8080/api/getAllLevelOneByDd";
	      var lvl1 = $('#lvl1');
	      $.ajax({
	        type: 'GET',
	        url: varurllvl1,
	        async: true,
	        success: function(result){
	          var output = "<option value='0'> -- Select -- </option>";
	          for(var i in result){
	            output+="<option value="+result[i].lvl1_id+">"+result[i].name+"</option>";
	          }
	          lvl1.html(output);
	        }
	      });
		$('#lvl1').change(function() {
			$(this).find("option:selected").each(function() {
				var lvl = $(this).attr("value");
				var pre = "http://localhost:8080/api/getLvl2/";
				var varurl = pre+ lvl;
				$.ajax({
					type : 'GET',
					url : varurl,
					async : true,
					success : function(result) {
						var output = "<option selected value='0'>-- Select --</option>";
						for ( var i in result) {
							output += "<option value="+result[i].lvl2_id+">"+ result[i].name+ "</option>";
						}
						lvl2.html(output);
					}
				});
			});
		});
	});
</script>
</body>
</html>
