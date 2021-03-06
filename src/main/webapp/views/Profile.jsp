<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Profile</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
<style type="text/css">
    * {
        margin: 0;
        padding: 0;
    }

    html {
        height: 100%;
    }

    p {
        color: grey;
    }

    #heading {
        text-transform: uppercase;
        color: #4285f4;
        font-weight: normal;
    }

    #msform {
        text-align: center;
        position: relative;
        margin-top: 20px;
    }

    #msform fieldset {
        background: white;
        border: 0 none;
        border-radius: 0.5rem;
        box-sizing: border-box;
        width: 100%;
        margin: 0;
        padding-bottom: 20px;
        position: relative;
    }

    .form-card {
        text-align: left;
    }

    #msform fieldset:not(:first-of-type) {
        display: none;
    }

    #msform .action-button {
        width: 100px;
        background: #4285f4;
        font-weight: bold;
        color: white;
        border: 0 none;
        border-radius: 0px;
        cursor: pointer;
        padding: 10px 5px;
        margin: 10px 0px 10px 5px;
        float: right;
    }

    #msform .action-button:hover,
    #msform .action-button:focus {
        background-color: #311B92;
    }

    #msform .action-button-previous {
        width: 100px;
        background: #616161;
        font-weight: bold;
        color: white;
        border: 0 none;
        border-radius: 0px;
        cursor: pointer;
        padding: 10px 5px;
        margin: 10px 5px 10px 0px;
        float: right;
    }

    #msform .action-button-previous:hover,
    #msform .action-button-previous:focus {
        background-color: #000000;
    }

    .card1 {
        z-index: 0;
        border: none;
        position: relative;
    }

    .fs-title {
        font-size: 25px;
        color: #4285f4;
        margin-bottom: 15px;
        font-weight: normal;
        text-align: left;
    }

    .purple-text {
        color: #4285f4;
        font-weight: normal;
    }

    .steps {
        font-size: 25px;
        color: gray;
        margin-bottom: 10px;
        font-weight: normal;
        text-align: right;
    }

    .fieldlabels {
        color: gray;
        text-align: left;
    }

    #progressbar {
        margin-bottom: 30px;
        overflow: hidden;
        color: lightgrey;
    }

    #progressbar .active {
        color: #311B92;
    }

    #progressbar li {
        list-style-type: none;
        font-size: 15px;
        width: 25%;
        float: left;
        position: relative;
        font-weight: 400;
    }

    #progressbar li:before {
        width: 50px;
        height: 50px;
        line-height: 45px;
        display: block;
        font-size: 20px;
        color: #ffffff;
        background: lightgray;
        border-radius: 50%;
        margin: 0 auto 10px auto;
        padding: 2px;
    }

    #progressbar li:after {
        content: '';
        width: 100%;
        height: 2px;
        background: lightgray;
        position: absolute;
        left: 0;
        top: 25px;
        z-index: -1;
    }

    #progressbar li.active:before,
    #progressbar li.active:after {
        background: #4285f4;
/*         background: linear-gradient(145deg,#3498db,#8e10ad); */
    }

    .progress {
        height: 20px;
    }

    .progress-bar {
        background-color: #311B92;
    }

    .fit-image {
        width: 100%;
        object-fit: cover;
    }
</style>

</head>
<body id="page-top">

	<jsp:include page="Header.jsp" />
<%-- 	<jsp:include page="Menubar.jsp" /> --%>
	<div id="header" class="mt-2"></div>
	
	<div class="wrapper d-flex align-items-stretch">
		
		<jsp:include page="Sidebar.jsp" />
		  
		<div class="container-fluid">
		    <div class="row justify-content-center">
		        <div class="col-11 col-sm-9 col-md-7 col-lg-10 col-xl-9 text-center p-0 mt-3 mb-2">
		            <div class="card1 px-0 py-0 mt-3 mb-3">
		                <h3 id="heading">PROFILE</h3>
		                <p class="d-flex justify-content-start">Fill all Form fields to go to next step</p>
		                <form id="msform">
		                    <input type="hidden" name="id" value="<%= session.getAttribute("id") %>" id="id"/>
		                    
		                    <ul id="progressbar">
		                        <li class="active fa fa-user"><strong>Personal</strong></li>
		                        <li class="fa fa-address-book"><strong>Address</strong></li>
		                        <li class="fa fa-building"><strong>Qualification</strong></li>
		                        <li class="fa fa-check-circle"><strong>Finish</strong></li>
		                    </ul>
		
		                    <fieldset>
		                        <div class="form-card">
		                            <div class="row">
		                                <div class="col-7">
		                                    <h2 class="fs-title">Personal Information:</h2>
		                                </div>
		                                <div class="col-5">
		                                    <h2 class="steps">Step 1 - 4</h2>
		                                </div>
		                            </div>
		                            
		                          	<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
		                          	
		                            <div class="row mt-0">
		                                <div class="col-sm-12 col-xl-4">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="username" class="form-control text-capitalize" value="<%= session.getAttribute("name") %>">
		                                        <label for="username">Name<span class="mandatory pl-1"> *</span></label>
		                                    </div>        
		                                </div>
		                                <div class="col-sm-12 col-xl-4">
		                                    <div class="md-form mt-0">
		                                        <input type="date" id="dob" class="form-control" required>
		                                        <label for="Dob">Date of Birth<span class="mandatory pl-1"> *</span></label>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="row">
		                                <div class="col-4 col-sm-12 col-xl-4">
		                                    <div class="mt-3">
		                                        <label>Blood Group<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="blood" required>
		                                        </select>
		                                    </div>        
		                                </div>
		                                <div class="col-4 col-sm-12 col-xl-4">
		                                    <div class="mt-3">
		                                        <label>Religion<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="religion" required>
		                                        </select>
		                                    </div>        
		                                </div>
		                                <div class="col-4 col-sm-12 col-xl-4">
		                                    <div class="mt-3">
		                                        <label>Community<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="community" required>
		                                        </select>
		                                    </div>
		                                </div>
		                            </div>
		                        </div><br>
		                        <input type="button" name="next" class="next action-button" value="Next" onclick="savePersonal();" />
		                    </fieldset>
		
		                    <fieldset>
		                        <div class="form-card">
		                            <div class="row">
		                                <div class="col-7">
		                                    <h2 class="fs-title">Address Information:</h2>
		                                </div>
		                                <div class="col-5">
		                                    <h2 class="steps">Step 2 - 4</h2>
		                                </div>
		                            </div>
		                            <h4 class="d-flex justify-content-center">Official Address</h4><hr>
		                            <div class="row">
		                                <div class="col-xl-6 col-md-12">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="door_no" class="form-control">
		                                        <label for="username">Door No.<span class="mandatory pl-1"> *</span></label>
		                                    </div>       
		                                </div>
		                                <div class="col-xl-6 col-md-12">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="line1" class="form-control">
		                                        <label for="username">Line 1<span class="mandatory pl-1"> *</span></label>
		                                    </div>  
		                                </div>
		                            </div>
		                            <div class="row">
		                                <div class="col-xl-6 col-md-12">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="line2" class="form-control">
		                                        <label for="username">Line 2<span class="mandatory pl-1"> *</span></label>
		                                    </div>
		                                </div>
		                                <div  class="col-xl-6 col-md-12">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="line3" class="form-control">
		                                        <label for="username">Line 3<span class="mandatory pl-1"> *</span></label>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="row mt-0">
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <label>Country<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="country">
		                                        	<option> -- Select --</option>
		                                        </select>
		                                    </div>           
		                                </div>
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <label>State<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="state">
		                                        	<option> -- Select --</option>
		                                        </select>
		                                    </div>        
		                                </div>
		                            </div>
		                            
		                            <div class="row mt-2">
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <label>District<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="district">
		                                        	<option> -- Select --</option>
		                                        </select>
		                                    </div>           
		                                </div>
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <div class="md-form">
		                                            <input type="text" id="pincode" class="form-control" maxlength="6">
		                                            <label for="username">Pin code<span class="mandatory pl-1"> *</span></label>
		                                        </div>  
		                                    </div>
		                                </div>
		                            </div>
		                        </div><hr>
		                        <div class="d-flex justify-content-start">
		                            <input type="checkbox" name="permanent" id="permanent" class="mt-1"><label class="drop mt-0 pl-2"> Same as Official Address</label>
		                        </div>
		                        <div class="form-card">
		                            <h4 class="d-flex justify-content-center">Permanent Address</h4><hr>
		                            <div class="row mt-0">
		                                <div class="col-xl-6 col-md-12">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="p_door_no" class="form-control">
		                                        <label for="username">Door No.<span class="mandatory pl-1"> *</span></label>
		                                    </div>       
		                                </div>
		                                <div class="col-xl-6 col-md-12">
		                                    <div class="md-form mt-0">
		                                        <input type="text" id="p_line1" class="form-control">
		                                        <label for="username">Line 1<span class="mandatory pl-1"> *</span></label>
		                                    </div>  
		                                </div>
		                            </div>
		                            
		                            <div class="row">
		                            	<div class="col-xl-6 col-md-12">
		                            		<div class="md-form mt-0">
				                                <input type="text" id="p_line2" class="form-control">
				                                <label for="username">Line 2<span class="mandatory pl-1"> *</span></label>
				                            </div>
		                            	</div>
		                            	<div class="col-xl-6 col-md-12">
		                            		<div class="md-form mt-0">
				                                <input type="text" id="p_line3" class="form-control">
				                                <label for="username">Line 3<span class="mandatory pl-1"> *</span></label>
				                            </div>		
		                            	</div>
		                            </div>
		
		                            <div class="row mt-0">
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <label>Country<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="p_country">
		                                        	<option> -- Select --</option>
		                                        </select>
		                                    </div>           
		                                </div>
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <label>State<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="p_state">
		                                        	<option> -- Select --</option>
		                                        </select>
		                                    </div>        
		                                </div>
		                            </div>
		                            
		                            <div class="row mt-2">
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <label>District<span class="mandatory pl-1"> *</span></label>
		                                        <select class="browser-default custom-select" id="p_district">
		                                        	<option> -- Select --</option>
		                                        </select>
		                                    </div>           
		                                </div>
		                                <div class="col-6">
		                                    <div class="mt-0">
		                                        <div class="md-form">
		                                            <input type="text" id="p_pincode" class="form-control" maxlength="6">
		                                            <label for="username">Pincode<span class="mandatory pl-1"> *</span></label>
		                                        </div>  
		                                    </div>
		                                </div>
		                            </div>
		                        </div><hr>
		                        <input type="button" name="next" class="next action-button" value="Next" onclick="saveAddress();" /> 
		                        <input type="button" name="previous" class="previous action-button-previous" value="Previous" />
		                    </fieldset>
		
		                    <fieldset>
		                        <div class="form-card">
		                            <div class="row">
		                                <div class="col-7">
		                                    <h2 class="fs-title">Qualification:</h2>
		                                </div>
		                                <div class="col-5">
		                                    <h2 class="steps">Step 3 - 4</h2>
		                                </div>
		                            </div> 
		                        </div>
		                        <div class="form-card">
		                            <div>
		                                <table class="table text-center"> 
		                                    <thead class="grey lighten-2">
		                                        <tr>
		                                            <th style="width:80px;">Course</th>
		                                            <th style="width:140px;">Medium</th>
		                                            <th style="width:140px;">Board</th>
		                                            <th>Institution Name</th>
		                                            <th style="width: 120px;">Year of Passing</th>
		                                            <th style="width: 50px;">Percentage</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
		                                        <tr>
		                                            <td>SSLC</td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">Tamil</option>
		                                                    <option value="2">English</option>
		                                                </select>
		                                            </td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">State Board</option>
		                                                    <option value="2">English</option>
		                                                </select>
		                                            </td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                        </tr>
		                                        <tr>
		                                            <td>HSC</td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">Tamil</option>
		                                                    <option value="2">English</option>
		                                                </select>
		                                            </td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">State Board</option>
		                                                    <option value="2">English</option>
		                                                </select>
		                                            </td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                        </tr>
		                                    </tbody>
		                                </table>
		                            </div>                
		                        </div>
		                        <br>
		                        <div class="form-card">
		                            <div>
		                                <table class="table text-center"> 
		                                    <thead class="grey lighten-2">
		                                        <tr>
		                                            <th style="width:80px;">Course</th>
		                                            <th style="width:100px;">Degree</th>
		                                            <th style="width:140px;">Specialization</th>
		                                            <th>University</th>
		                                            <th>Institution Name</th>
		                                            <th style="width: 140px;">Year of Passing</th>
		                                            <th style="width: 80px;">CGPA</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
		                                        <tr>
		                                            <td>UG</td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">B.E</option>
		                                                </select>
		                                            </td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">Computer Science</option>
		                                                </select>
		                                            </td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                        </tr>
		                                        <tr>
		                                            <td>PG</td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">B.E</option>
		                                                </select>
		                                            </td>
		                                            <td>
		                                                <select class="browser-default custom-select" id="religion">
		                                                    <option value="1">Computer Science</option>
		                                                </select>
		                                            </td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                            <td><input type="text" class="form-control"></td>
		                                        </tr>  
		                                    </tbody>
		                                </table>
		                            </div>                
		                        </div>
		                        <input type="button" name="next" class="next action-button" value="Next" />
		                        <input type="button" name="previous" class="previous action-button-previous" value="Previous" />
		                    </fieldset>
		
		                    <fieldset>
		                        <div class="form-card">
		                            <div class="row">
		                                <div class="col-7">
		                                    <h2 class="fs-title">Finish:</h2>
		                                </div>
		                                <div class="col-5">
		                                    <h2 class="steps">Step 4 - 4</h2>
		                                </div>
		                            </div>
		                            
		                            <div class="text-center">
		                            	<h3 class="m-2 p-2"><strong>SUCCESS !</strong></h3>
			                            <i class="fa fa-check-circle fa-5x m-2 p-2"></i>
										<h4 class="m-2 p-2">You Have Successfully Signed Up</h4>
		                            </div>
		                            
		                        </div>
		                    </fieldset>
		
		                </form>
		            </div>
		        </div>
		    </div>
		</div>		
	</div>
	
	<div class="">
		<jsp:include page="Footer.jsp" />
	</div>

	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script>
	function savePersonal(){
        var cal = {}

        cal["id"] = $('#id').val();
        cal["username"] = $('#username').val();
        cal["dob"] = $('#dob').val();
        cal["blood"] = $('#blood').val();
        cal["religion"] = $('#religion').val();
        cal["community"] = $('#community').val();

        $.ajax({
            type:"POST",
            url:"http://localhost:8080/api/savePersonalJson",
            contentType:"application/json",
            data:JSON.stringify(cal),
            dataType:'json',
            success:function(data){
            },
            error:function(error){
            }
        });
    }
    function saveAddress(){
        var json = {}

        json["id"] = $('#id').val();
        json["door_no"] = $('#door_no').val();
        json["line1"] = $('#line1').val();
        json["line2"] = $('#line2').val();
        json["line3"] = $('#line3').val();
        json["country"] = $('#country').val();
        json["state"] = $('#state').val();
        json["district"] = $('#district').val();
        json["pincode"] = $('#pincode').val();
		if($('#permanent').is(":checked")){
			json["permanent"] = 1;
		}else if($('#permanent').is(":not(:checked)")){
			json["permanent"] = 0;
		}
		json["p_door_no"] = $('#p_door_no').val();
        json["p_line1"] = $('#p_line1').val();
        json["p_line2"] = $('#p_line2').val();
        json["p_line3"] = $('#p_line3').val();
        json["p_country"] = $('#p_country').val();
        json["p_state"] = $('#p_state').val();
        json["p_district"] = $('#p_district').val();
        json["p_pincode"] = $('#p_pincode').val();

        $.ajax({
            type:"POST",
            url:"http://localhost:8080/api/saveAddressJson",
            contentType:"application/json",
            data:JSON.stringify(json),
            dataType:'json',
            success:function(data){
                alert("Saved successfully");
            },
            error:function(error){
                alert("Error");
            }
        });
        
    }
		
		$(document).ready(function() {
			$('#header').load("http://localhost:8080/header");

			$('#permanent').change("click",function(){
				if($(this).is(":checked")){
					$('#p_door_no').val($('#door_no').val());
					$('#p_door_no').focus();
					$('#p_line1').val($('#line1').val());
					$('#p_line1').focus();
					$('#p_line2').val($('#line2').val());
					$('#p_line2').focus();
					$('#p_line3').val($('#line3').val());
					$('#p_line3').focus();
					$('#p_pincode').val($('#pincode').val());
					$('#p_pincode').focus();
					$('#p_country').html("<option value="+$('#country option:selected').val()+">"+$('#country option:selected').text()+"</option>");
					$('#p_district').html("<option value="+$('#district option:selected').val()+">"+$('#district option:selected').text()+"</option>");
					$('#p_state').html("<option value="+$('#state option:selected').val()+">"+$('#state option:selected').text()+"</option>");
				}
				else if($(this).is(":not(:checked)")){
					$('#p_door_no').val("");
					$('#p_line1').val("");
					$('#p_line2').val("");
					$('#p_line3').val("");
					$('#p_pincode').val("");
					$('#p_district').html("<option> -- Select --</option>");
					$('#p_state').html("<option> -- Select --</option>");
					var pcountry = $('#p_country');
		            $.ajax({
						type:'GET',
						url:"http://localhost:8080/api/getAllCountry",
						async:true,
						success:function(result){
							var output = "<option selected disabled> -- Select -- </option>";
							for(var i in result){
								output+="<option value="+result[i].id+">"+result[i].name+"  ["+result[i].acronym+"]</option>";
							}
							pcountry.html(output);
						}
		            });

		            var pstate = $('#p_state');
		            $('#p_country').change(function(){
		                $(this).find("option:selected").each(function(){
		                    var id = $(this).attr("value");
		                    var pre = "http://localhost:8080/api/getAllStateByCountryId/";
		                    var varurl = pre+id;
		                    $.ajax({
		                        type: 'GET',
		                        url: varurl,
		                        async: true,
		                        success:function(result){
		                            var output = "<option value='0'>-- Select --</option>";
		                            for(var i in result){
		                                output+="<option value="+result[i].state.id+">"+result[i].state.name+"</option>";
		                            }
		                            pstate.html(output);
		                        }
		                    });
		                });
		            });

		            var pdistrict = $('#p_district');

		            $('#p_state').change(function(){
		                $(this).find("option:selected").each(function(){
		                    var id1 = $('#p_country option:selected').val();
		                    var id = $(this).attr("value");
		                    var pre = "http://localhost:8080/api/getAllDistrictByStateId/";
		                    var varurl = pre+id1+"/"+id;
		                    $.ajax({
		                        type: 'GET',
		                        url: varurl,
		                        async: true,
		                        success:function(result){
		                            var output = "<option value='0'>-- Select --</option>";
		                            for(var i in result){
		                                output+="<option value="+result[i].district.id+">"+result[i].district.name+"</option>";
		                            }
		                            pdistrict.html(output);
		                        }
		                    });
		                });
		            });
				}
			});
			
            var blood = $('#blood');
            $.ajax({
                type:'GET',
                url:"http://localhost:8080/api/getAllBlood",
                async:true,
                success:function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                    }
                    blood.html(output);
                }
            });
            var religion = $('#religion');
            $.ajax({
                type:'GET',
                url:"http://localhost:8080/api/getAllReligion",
                async:true,
                success:function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].name+"</option>";
                    }
                    religion.html(output);
                }
            });

            var comm = $('#community');
            $.ajax({
                type:'GET',
                url:"http://localhost:8080/api/getAllCommunity",
                async:true,
                success:function(result){
                    var output = "<option selected disabled> -- Select -- </option>";
                    for(var i in result){
                        output+="<option value="+result[i].id+">"+result[i].acronym+"  [ "+ result[i].name +" ]</option>";
                    }
                    comm.html(output);
                }
            });

            var country = $('#country');
            $.ajax({
				type:'GET',
				url:"http://localhost:8080/api/getAllCountry",
				async:true,
				success:function(result){
					var output = "<option selected disabled> -- Select -- </option>";
					for(var i in result){
						output+="<option value="+result[i].id+">"+result[i].name+"  ["+result[i].acronym+"]</option>";
					}
					country.html(output);
				}
            });

            var state = $('#state');
            $('#country').change(function(){
                $(this).find("option:selected").each(function(){
                    var id = $(this).attr("value");
                    var pre = "http://localhost:8080/api/getAllStateByCountryId/";
                    var varurl = pre+id;
                    $.ajax({
                        type: 'GET',
                        url: varurl,
                        async: true,
                        success:function(result){
                            var output = "<option value='0'>-- Select --</option>";
                            for(var i in result){
                                output+="<option value="+result[i].state.id+">"+result[i].state.name+"</option>";
                            }
                            state.html(output);
                        }
                    });
                });
            });

            var district = $('#district');
            $('#state').change(function(){
                $(this).find("option:selected").each(function(){
                    var id1 = $('#country option:selected').val();
                    var id = $(this).attr("value");
                    var pre = "http://localhost:8080/api/getAllDistrictByStateId/";
                    var varurl = pre+id1+"/"+id;
                    $.ajax({
                        type: 'GET',
                        url: varurl,
                        async: true,
                        success:function(result){
                            var output = "<option value='0'>-- Select --</option>";
                            for(var i in result){
                                output+="<option value="+result[i].district.id+">"+result[i].district.name+"</option>";
                            }
                            district.html(output);
                        }
                    });
                });
            });

            var pcountry = $('#p_country');
            $.ajax({
				type:'GET',
				url:"http://localhost:8080/api/getAllCountry",
				async:true,
				success:function(result){
					var output = "<option selected disabled> -- Select -- </option>";
					for(var i in result){
						output+="<option value="+result[i].id+">"+result[i].name+"  ["+result[i].acronym+"]</option>";
					}
					pcountry.html(output);
				}
            });

            var pstate = $('#p_state');
            $('#p_country').change(function(){
                $(this).find("option:selected").each(function(){
                    var id = $(this).attr("value");
                    var pre = "http://localhost:8080/api/getAllStateByCountryId/";
                    var varurl = pre+id;
                    $.ajax({
                        type: 'GET',
                        url: varurl,
                        async: true,
                        success:function(result){
                            var output = "<option value='0'>-- Select --</option>";
                            for(var i in result){
                                output+="<option value="+result[i].state.id+">"+result[i].state.name+"</option>";
                            }
                            pstate.html(output);
                        }
                    });
                });
            });

            var pdistrict = $('#p_district');

            $('#p_state').change(function(){
                $(this).find("option:selected").each(function(){
                    var id1 = $('#p_country option:selected').val();
                    var id = $(this).attr("value");
                    var pre = "http://localhost:8080/api/getAllDistrictByStateId/";
                    var varurl = pre+id1+"/"+id;
                    $.ajax({
                        type: 'GET',
                        url: varurl,
                        async: true,
                        success:function(result){
                            var output = "<option value='0'>-- Select --</option>";
                            for(var i in result){
                                output+="<option value="+result[i].district.id+">"+result[i].district.name+"</option>";
                            }
                            pdistrict.html(output);
                        }
                    });
                });
            });
			            
			var current_fs, next_fs, previous_fs; //fieldsets
			var opacity;
			var current = 1;
			var steps = $("fieldset").length;

			setProgressBar(current);

			$(".next").click(function(){

			    current_fs = $(this).parent();
			    next_fs = $(this).parent().next();

				//Add Class Active
				$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

				//show the next fieldset
				next_fs.show();
				//hide the current fieldset with style
				current_fs.animate({opacity: 0}, {
			    	step: function(now) {
					// for making fielset appear animation
					opacity = 1 - now;

					current_fs.css({
					    'display': 'none',
			    		'position': 'relative'
					});
					next_fs.css({'opacity': opacity});
				},
				duration: 500
			});
			setProgressBar(++current);
		});

		$(".previous").click(function(){

			current_fs = $(this).parent();
			previous_fs = $(this).parent().prev();

			//Remove class active
			$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

			//show the previous fieldset
			previous_fs.show();

			//hide the current fieldset with style
			current_fs.animate({opacity: 0}, {
				step: function(now) {
					// for making fielset appear animation
					opacity = 1 - now;

					current_fs.css({
			    		'display': 'none',
			    		'position': 'relative'
					});
					previous_fs.css({'opacity': opacity});
				},
				duration: 500
			});
			setProgressBar(--current);
		});

		function setProgressBar(curStep){
			var percent = parseFloat(100 / steps) * curStep;
			percent = percent.toFixed();
			$(".progress-bar").css("width",percent+"%")
		}

		$(".submit").click(function(){
			return false;
		})
            
	});
	</script>
</body>
</html>