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
        background-color: #311B92
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
        background-color: #000000
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
        color: #8e10ad;
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
        background: #311B92;
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
<body>

	<jsp:include page="Header.jsp" />

	<div id="header"></div>

	<div class="wrapper d-flex align-items-stretch">

		<jsp:include page="Sidebar.jsp" />

		<!-- Start your project here-->
		<div class="container-fluid">
			<div class="row justify-content-center">
				<div class="col-11 col-sm-9 col-md-7 col-lg-10 col-xl-9 text-center p-0 mt-3 mb-2">
					<div class="card1 px-0 pt-2 pb-0 mt-3 mb-3">
						<h2 class="ubuntu">Fill Up Your Details</h2>
						<p class="no-indent">Fill all form field to go to next step</p>
						<form id="msform">
							<input type="hidden" name="id" id="id" value="<%= session.getAttribute("id") %>" readonly />
							
							<!-- progressbar -->
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
											<h2 class="fs-title">Personal Information</h2>
										</div>
										<div class="col-5">
											<h2 class="steps">Step 1 - 4</h2>
										</div>
									</div>
									
									<label class="d-flex justify-content-end mandatory mandatory-text mr-2">* must be filled</label>
									
									<div class="row">
										<div class="col-sm-12 col-xl-4">
											<div class="md-form mt-2">
												<input type="text" id="username" class="form-control" value="<%= session.getAttribute("name") %>"> 
												<label for="username">Name<span class="mandatory pl-1"> *</span></label>
											</div>
										</div>
										<div class="col-sm-12 col-xl-4">
											<div class="md-form mt-2">
												<input type="date" id="dob" class="form-control" required>
												<label for="Dob">Date of Birth<span class="mandatory pl-1"> *</span></label>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-4 col-sm-12 col-xl-4">
											<div class="mt-2">
												<label>BloodGroup<span class="mandatory pl-1"> *</span></label> 
												<select class="browser-default custom-select" id="blood" required></select>
											</div>
										</div>
										<div class="col-4 col-sm-12 col-xl-4">
											<div class="mt-2">
												<label>Religion<span class="mandatory pl-1"> *</span></label> 
												<select class="browser-default custom-select" id="religion" required></select>
											</div>
										</div>
										<div class="col-4 col-sm-12 col-xl-4">
											<div class="mt-2">
												<label>Community<span class="mandatory pl-1">*</span></label> 
												<select class="browser-default custom-select" id="community" required></select>
											</div>
										</div>
									</div>
								</div><br> 
								
								<input type="button" name="next" class="next action-button btn btn-custom" value="Next" onclick="savePersonal();" />
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
									<h5 class="d-flex justify-content-center">Official Address</h5>
									<hr>
									<div class="form-row" style="margin-top: -20px;">
										<div class="col-6">
											<div class="md-form">
												<input type="text" id="door" class="form-control"> <label
													for="username">Door No.<span class="mandatory pl-1">
														*</span></label>
											</div>
										</div>
										<div class="col-6">
											<div class="md-form">
												<input type="text" id="line1" class="form-control">
												<label for="username">Line 1<span
													class="mandatory pl-1"> *</span></label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xl-6 col-md-12">
											<div class="md-form mt-0">
												<input type="text" id="line2" class="form-control">
												<label for="username">Line 2<span
													class="mandatory pl-1"> *</span></label>
											</div>
										</div>
										<div class="col-xl-6 col-md-12">
											<div class="md-form mt-0">
												<input type="text" id="line3" class="form-control">
												<label for="username">Line 3<span
													class="mandatory pl-1"> *</span></label>
											</div>
										</div>
									</div>
									<div class="form-row mt-0">
										<div class="col-6">
											<div class="mt-0">
												<label>Country<span class="mandatory pl-1"> *</span></label>
												<select class="browser-default custom-select" id="country">
												</select>
											</div>
										</div>
										<div class="col-6">
											<div class="mt-0">
												<label>State<span class="mandatory pl-1"> *</span></label> <select
													class="browser-default custom-select" id="state">
												</select>
											</div>
										</div>
									</div>

									<div class="form-row mt-2">
										<div class="col-6">
											<div class="mt-0">
												<label>District<span class="mandatory pl-1">
														*</span></label> <select class="browser-default custom-select"
													id="country">
												</select>
											</div>
										</div>
										<div class="col-6">
											<div class="mt-0">
												<div class="md-form">
													<input type="text" id="pin" class="form-control"
														max_length="6"> <label for="username">Pincode<span
														class="mandatory pl-1"> *</span></label>
												</div>
											</div>
										</div>
									</div>
								</div>
								<hr>
								<div class="d-flex justify-content-start">
									<input type="checkbox" name="permanent"><label>
										Same as Official Address</label>
								</div>
								<div class="form-card">
									<h5 class="d-flex justify-content-center">Permanent
										Address</h5>
									<hr>
									<div class="form-row mt-0">
										<div class="col-6">
											<div class="md-form">
												<input type="text" id="door" class="form-control"> <label
													for="username">Door No.<span class="mandatory pl-1">
														*</span></label>
											</div>
										</div>
										<div class="col-6">
											<div class="md-form">
												<input type="text" id="line1" class="form-control">
												<label for="username">Line 1<span
													class="mandatory pl-1"> *</span></label>
											</div>
										</div>
									</div>

									<div class="md-form mt-0">
										<input type="text" id="line2" class="form-control"> <label
											for="username">Line 2<span class="mandatory pl-1">
												*</span></label>
									</div>

									<div class="md-form mt-0">
										<input type="text" id="line3" class="form-control"> <label
											for="username">Line 3<span class="mandatory pl-1">
												*</span></label>
									</div>

									<div class="form-row mt-0">
										<div class="col-6">
											<div class="mt-0">
												<label>Country<span class="mandatory pl-1"> *</span></label>
												<select class="browser-default custom-select" id="country">
												</select>
											</div>
										</div>
										<div class="col-6">
											<div class="mt-0">
												<label>State<span class="mandatory pl-1"> *</span></label> <select
													class="browser-default custom-select" id="state">
												</select>
											</div>
										</div>
									</div>

									<div class="form-row mt-2">
										<div class="col-6">
											<div class="mt-0">
												<label>District<span class="mandatory pl-1">
														*</span></label> <select class="browser-default custom-select"
													id="country">
												</select>
											</div>
										</div>
										<div class="col-6">
											<div class="mt-0">
												<div class="md-form">
													<input type="text" id="pin" class="form-control"
														max_length="6"> <label for="username">Pincode<span
														class="mandatory pl-1"> *</span></label>
												</div>
											</div>
										</div>
									</div>
								</div>
								<hr>
								<input type="button" name="next" class="next action-button"
									value="Next" /> <input type="button" name="previous"
									class="previous action-button-previous" value="Previous" />
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
													<th style="width: 80px;">Course</th>
													<th style="width: 140px;">Medium</th>
													<th style="width: 140px;">Board</th>
													<th>Institution Name</th>
													<th style="width: 120px;">Year of Passing</th>
													<th style="width: 50px;">Percentage</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>SSLC</td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">Tamil</option>
															<option value="2">English</option>
													</select></td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">State Board</option>
															<option value="2">English</option>
													</select></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
												</tr>
												<tr>
													<td>HSC</td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">Tamil</option>
															<option value="2">English</option>
													</select></td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">State Board</option>
															<option value="2">English</option>
													</select></td>
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
													<th style="width: 80px;">Course</th>
													<th style="width: 100px;">Degree</th>
													<th style="width: 140px;">Specialization</th>
													<th>University</th>
													<th>Institution Name</th>
													<th style="width: 140px;">Year of Passing</th>
													<th style="width: 80px;">CGPA</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>UG</td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">B.E</option>
													</select></td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">Computer Science</option>
													</select></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
												</tr>
												<tr>
													<td>PG</td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">B.E</option>
													</select></td>
													<td><select class="browser-default custom-select"
														id="religion">
															<option value="1">Computer Science</option>
													</select></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
													<td><input type="text" class="form-control"></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<input type="button" name="next" class="next action-button"
									value="Next" /> <input type="button" name="previous"
									class="previous action-button-previous" value="Previous" />
							</fieldset>

							<fieldset>
								<div class="form-card purple-text">
									<div class="row">
										<div class="col-7">
											<h2 class="fs-title">Finish:</h2>
										</div>
										<div class="col-5">
											<h2 class="steps">Step 4 - 4</h2>
										</div>
									</div>
									<br>
									<br>
									<h2 class="text-center">
										<strong>SUCCESS !</strong>
									</h2>
									<br>
									<div class="d-flex justify-content-center">
										<i class="fa fa-check-circle fa-5x"></i>
									</div>
									<br>
									<br>
									<div class="d-flex justify-content-center">
										<h5>You Have Successfully Signed Up</h5>
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

	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript">
		function savePersonal() {
			var cal = {}

			cal["id"] = $('#id').val();
			cal["username"] = $('#username').val();
			cal["dob"] = $('#dob').val();
			cal["blood"] = $('#blood').val();
			cal["religion"] = $('#religion').val();
			cal["community"] = $('#community').val();

			console.log(cal);

			$.ajax({
				type : "POST",
				url : "http://localhost:8080/api/savePersonalJson",
				contentType : "application/json",
				data : JSON.stringify(cal),
				dataType : 'json',
				success : function(data) {
					alert("Saved Successfully");
				},
				error : function(error) {
					alert("Error");
				}
			});
		}

		$(document).ready(function() {
			$('#header').load("http://localhost:8080/header");

			var blood = $('#blood');
			$.ajax({
				type : 'GET',
				url : "http://localhost:8080/api/getAllBlood",
				async : true,
				success : function(result) {
					var output = "<option selected disabled> -- Select -- </option>";
					for ( var i in result) {
						output += "<option value="+result[i].id+">"+ result[i].name+ "</option>";
					}
					blood.html(output);
				}
			});

			var religion = $('#religion');
			$.ajax({
				type : 'GET',
				url : "http://localhost:8080/api/getAllReligion",
				async : true,
				success : function(result) {
					var output = "<option selected disabled> -- Select -- </option>";
					for ( var i in result) {
						output += "<option value="+result[i].id+">"+ result[i].name+ "</option>";
					}
					religion.html(output);
				}
			});

			var comm = $('#community');
			$.ajax({
				type : 'GET',
				url : "http://localhost:8080/api/getAllCommunity",
				async : true,
				success : function(result) {
					var output = "<option selected disabled> -- Select -- </option>";
					for ( var i in result) {
						output += "<option value="+result[i].id+">"+ result[i].acronym+ "  ["+ result[i].name+ " ]</option>";
					}
					comm.html(output);
				}
			});

			var current_fs, next_fs, previous_fs; //fieldsets
			var opacity;
			var current = 1;
			var steps = $("fieldset").length;

			setProgressBar(current);

			$(".next").click(function() {
				current_fs = $(this).parent();
				next_fs = $(this).parent().next();

				//Add Class Active
				$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

				//show the next fieldset
				next_fs.show();

				//hide the current fieldset with style
				current_fs.animate({
					opacity : 0
				}, {
					step : function(now) {
					// for making fielset appear animation
					opacity = 1 - now;
					current_fs.css({
						'display' : 'none',
						'position' : 'relative'
					});
					next_fs.css({
						'opacity' : opacity
					});
				},
				duration : 500
			});

			setProgressBar(++current);
		});

		$(".previous").click(function() {
			current_fs = $(this).parent();
			previous_fs = $(this).parent().prev();

			//Remove class active
			$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

			//show the previous fieldset
			previous_fs.show();

			//hide the current fieldset with style
			current_fs.animate({
				opacity : 0
			}, {
				step : function(now) {
				// for making fielset appear animation
				opacity = 1 - now;

				current_fs.css({
					'display' : 'none',
					'position' : 'relative'
				});
				previous_fs.css({
					'opacity' : opacity
				});
			},
			duration : 500
			});
			setProgressBar(--current);
		});

		function setProgressBar(curStep) {
			var percent = parseFloat(100 / steps) * curStep;
			percent = percent.toFixed();
			$(".progress-bar").css("width", percent + "%")
		}

		$(".submit").click(function() {
			return false;
		})

	});
	</script>
</body>
</html>