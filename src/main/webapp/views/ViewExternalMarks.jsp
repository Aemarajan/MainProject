<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>External Marks</title>

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

		<div class="container-fluid pl-6">
			
			<c:set var="user_id" value='<%= session.getAttribute("id")%>'/>
			<c:set var="role" value='<%= session.getAttribute("role")%>'/>
			
			<div hidden="true">
				<input type="text" name="id" id="id" value='<%= session.getAttribute("id") %>'/>
			</div>

			<c:if test="${role == 'admin' }">
				
				<div class="mt-3 mb-3">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb indigo lighten-4">
							<li class="breadcrumb-item">
								<a class="black-text" href="home">Home</a>
								<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
							</li>
							<li class="breadcrumb-item active">Get Students</li>
						</ol>
					</nav>
				</div>
				
				<h4 class="text-center mt-2 mb-2 p-2 banner">External Marks</h4>
			
				<div class="container-fluid mt-2 mb-2">
					<form action="AdminViewExternalMarks" method="post">
						<div class="row mt-2">
							<div class="col col-sm-2 col-md-2 col-lg-2"></div>
							<div class="col col-sm-4 col-md-4 col-lg-4">
								<div class="mt-3">
									<label class="d-flex justify-content-start"> Batch <span class="mandatory pl-1"> *</span></label>
									<select class="browser-default custom-select" name="batch" id="batch" ></select>
								</div>
							</div>
							<div class="col col-sm-4 col-md-4 col-lg-4">
								<div class="mt-3">
									<label class="d-flex justify-content-start"> Regulation <span class="mandatory pl-1"> *</span></label>
									<select class="browser-default custom-select" name="regulation" id="regulation" ></select>
								</div>
							</div>
							<div class="col col-sm-2 col-md-2 col-lg-2"></div>
						</div>
						<!-- row -->
						
						<div class="row mt-2">
							<div class="col col-sm-1.5 col-md-1.5 col-lg-1.5"></div>
							<div class="col col-sm-3 col-md-3 col-lg-3">
								<div class="mt-3">
									<label class="d-flex justify-content-start"> Year <span class="mandatory pl-1"> *</span></label>
									<select class="browser-default custom-select" name="year" id="year" ></select>
								</div>
							</div>
							<div class="col col-sm-3 col-md-3 col-lg-3">
								<div class="mt-3">
									<label class="d-flex justify-content-start"> Semester <span class="mandatory pl-1"> *</span></label>
									<select class="browser-default custom-select" name="semester" id="semester" ></select>
								</div>
							</div>
							<div class="col col-sm-3 col-md-3 col-lg-3">
								<div class="mt-3">
									<label class="d-flex justify-content-start"> Section <span class="mandatory pl-1"> *</span></label>
									<select class="browser-default custom-select" name="section" id="section" ></select>
								</div>
							</div>
							<div class="col col-sm-1.5 col-md-1.5 col-lg-1.5"></div>
						</div>
						<!-- row -->
						
						<div class="mt-4 text-center">
							<button type="submit" class="btn btn-custom w-25 py-2 waves-effect text-center">Get Students</button>
						</div>
					</form>
				</div>		
				<!-- Container fluid -->
			</c:if>
			
			<c:if test="${role == 'staff' }">
				
				<div class="mt-3 mb-3">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb indigo lighten-4">
							<li class="breadcrumb-item">
								<a class="black-text" href="home">Home</a>
								<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
							</li>
							<li class="breadcrumb-item active">Student List</li>
						</ol>
					</nav>
				</div>
				
				<h4 class="text-center mt-2 mb-2 p-2 banner">External Marks</h4>
				
				<div class="container-fluid mt-4 mb-4">
					<table class="table table-striped">
        				<thead>
        					<tr>
        						<th>Student List</th>
        						<th></th>
        						<th></th>
        						<th>Actions</th>
        					<tr>
        				</thead>
        				<tbody id="student"></tbody>
        			</table>
				</div>		
			</c:if>
			
			<c:if test="${role == 'student' }">
				
				<div class="mt-3 mb-3">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb indigo lighten-4">
							<li class="breadcrumb-item">
								<a class="black-text" href="home">Home</a>
								<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
							</li>
							<li class="breadcrumb-item active">External Marks</li>
						</ol>
					</nav>
				</div>
			
				<h4 class="text-center mt-2 mb-2 p-2 banner">External Marks</h4>
				
				<!-- <ul class="nav nav-pills nav-justified mb-3" id="pills-tab" role="tablist">
				  <li class="nav-item" role="presentation">
				    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
				  </li>
				</ul>
				<div class="tab-content" id="pills-tabContent">
				  <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">Home</div>
				  <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">Profile</div>
				  <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">Contact</div>
				  <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">Contact</div>
				  <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">Contact</div>
				  <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">Contact</div>
				</div> -->
			
			
				<ul class="nav nav-tabs nav-justified mt-2" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="sem1-tab" data-toggle="tab" href="#sem1" role="tab" aria-controls="sem1" aria-selected="true">Semester I</a></li>
					<li class="nav-item"><a class="nav-link" id="sem2-tab" data-toggle="tab" href="#sem2" role="tab" aria-controls="sem2" aria-selected="false">Semester II</a></li>
					<li class="nav-item"><a class="nav-link" id="sem3-tab" data-toggle="tab" href="#sem3" role="tab" aria-controls="sem3" aria-selected="false">Semester III</a></li>
					<li class="nav-item"><a class="nav-link" id="sem4-tab" data-toggle="tab" href="#sem4" role="tab" aria-controls="sem4" aria-selected="false">Semester IV</a></li>
					<li class="nav-item"><a class="nav-link" id="sem5-tab" data-toggle="tab" href="#sem5" role="tab" aria-controls="sem5" aria-selected="false">Semester V</a></li>
					<li class="nav-item"><a class="nav-link" id="sem6-tab" data-toggle="tab" href="#sem6" role="tab" aria-controls="sem6" aria-selected="false">Semester VI</a></li>
				</ul>
										
				<div class="tab-content" id="myTabContent">
											
					<div class="tab-pane fade show active" id="sem1" role="tabpanel" aria-labelledby="sem1-tab">
						<div class="table-wrapper">
							<div class="row">
								<div class="col col-sm-12 col-md-12 col-lg-12">
									<table class="table table-striped table-hover">
										<thead>
											<tr><th>Subject Code</th><th>Subject Name</th><th>Grade point</th><th>Grade</th></tr>
										</thead>
										<tbody>
											<c:forEach var="sub1" items="${sem1sub }"><c:forEach var="s1" items="${sem1 }">
												<c:choose>
													<c:when test='${sub1.subject.subject_code eq "ma5161" }'>
														<tr>
															<td>MA5161</td>
															<td>Mathematical Foundation For Computer Applications</td>
															<td>${s1.ma5161.point}</td>
															<td>${s1.ma5161.acronym}</td>
														</tr>		
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5101" }'>
														<tr>
															<td>MC5101</td>
															<td>Computer Organization</td>
															<td>${s1.mc5101.point}</td>
															<td>${s1.mc5101.acronym}</td>	
														</tr>	
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5102" }'>
														<tr>
															<td>MC5102</td>
															<td>Problem Solving And Programming</td>
															<td>${s1.mc5102.point}</td>
															<td>${s1.mc5102.acronym}</td>
														</tr>		
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5103" }'>		
														<tr>
															<td>MC5103</td>
															<td>Database Management Systems</td>
															<td>${s1.mc5103.point}</td>
															<td>${s1.mc5103.acronym}</td>
														</tr>			
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5104" }'>
														<tr>
															<td>MC5104</td>
															<td>Data Structures</td>
															<td>${s1.mc5104.point}</td>
															<td>${s1.mc5104.acronym}</td>
														</tr>				
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5111" }'>		
														<tr>
															<td>MC5111</td>
															<td>Data Structures laboratory</td>
															<td>${s1.mc5111.point}</td>
															<td>${s1.mc5111.acronym}</td>
														</tr>			
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5112" }'>
														<tr>
															<td>MC5112</td>
															<td>Database Management Systems laboratory</td>
															<td>${s1.mc5112.point}</td>
															<td>${s1.mc5112.acronym}</td>
														</tr>				
													</c:when>
													<c:when test='${sub1.subject.subject_code eq "mc5113" }'>
														<tr>
															<td>MC5113</td>
															<td>Communication Skills Laboratory</td>
															<td>${s1.mc5113.point}</td>
															<td>${s1.mc5113.acronym}</td>
														</tr>				
													</c:when>
												</c:choose>
											</c:forEach></c:forEach>
										</tbody>
									</table>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- table wrapper -->
					</div>
					<!-- Tab pane 1 -->
											
					<div class="tab-pane fade" id="sem2" role="tabpanel" aria-labelledby="sem2-tab">
						<div class="table-wrapper">
							<div class="row">
								<div class="col col-sm-12 col-md-12 col-lg-12">
									<table class="table table-striped table-hover">
										<thead>
											<tr><th>Subject Code</th><th>Subject Name</th><th>Grade Point</th><th>Grade</th></tr>
										</thead>
										<tbody>
											<c:forEach var="sub2" items="${sem2sub }"><c:forEach var="s2" items="${sem2 }">
												<c:choose>
													<c:when test='${sub2.subject.subject_code eq "mc5201"}'>
														<tr>
															<td>MC5201</td>
															<td>Object Oriented Programming</td>
															<td>${s2.mc5201.point}</td>
															<td>${s2.mc5201.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5202"}'>										
														<tr>
															<td>MC5202</td>
															<td>Embedded Systems</td>
															<td>${s2.mc5202.point}</td>
															<td>${s2.mc5202.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5203"}'>
														<tr>
															<td>MC5203</td>
															<td>Software Engineering</td>
															<td>${s2.mc5203.point}</td>
															<td>${s2.mc5203.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5204"}'>
														<tr>
															<td>MC5204</td>
															<td>Operating Systems</td>
															<td>${s2.mc5204.point}</td>
															<td>${s2.mc5204.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5205"}'>
														<tr>
															<td>MC5205</td>
															<td>Computer Graphics And MultiMedia</td>
															<td>${s2.mc5205.point}</td>
															<td>${s2.mc5205.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5211"}'>
														<tr>
															<td>MC5211</td>
															<td>Object Oriented Programming laboratory</td>
															<td>${s2.mc5211.point}</td>
															<td>${s2.mc5211.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5212"}'>
														<tr>
															<td>MC5212</td>
															<td>Graphics And MultiMedia laboratory</td>
															<td>${s2.mc5212.point}</td>
															<td>${s2.mc5212.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub2.subject.subject_code eq "mc5213"}'>
														<tr>
															<td>MC5213</td>
															<td>Operating Systems And Embedded Systems Laboratory</td>
															<td>${s2.mc5213.point}</td>
															<td>${s2.mc5213.acronym}</td>
														</tr>	
													</c:when>
												</c:choose>
											</c:forEach></c:forEach>									
										</tbody>
									</table>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- table wrapper -->
					</div>
					<!-- Tab pane 2 -->
											
					<div class="tab-pane fade" id="sem3" role="tabpanel" aria-labelledby="sem3-tab">
						<div class="table-wrapper">
							<div class="row">
								<div class="col col-sm-12 col-md-12 col-lg-12">
									<table class="table table-striped table-hover">
										<thead>
											<tr><th>Subject Code</th><th>Subject Name</th><th>Grade point</th><th>Grade</th></tr>
										</thead>
										<tbody>
											<c:forEach var="sub3" items="${sem3sub }"><c:forEach var="s3" items="${sem3 }">
												<c:choose>
													<c:when test='${sub3.subject.subject_code  eq "mc5301"}'>
														<tr>
															<td>MC5301</td>
															<td>Advanced Data Structures and Algorithms</td>
															<td>${s3.mc5301.point}</td>
															<td>${s3.mc5301.acronym}</td>
														</tr>	
													</c:when>									
													<c:when test='${sub3.subject.subject_code  eq "mc5302"}'>
														<tr>
															<td>MC5302</td>
															<td>Computer Networks</td>
															<td>${s3.mc5302.point}</td>
															<td>${s3.mc5302.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub3.subject.subject_code  eq "mc5303"}'>
														<tr>
															<td>MC5303</td>
															<td>Web Programming Essentials</td>
															<td>${s3.mc5303.point}</td>
															<td>${s3.mc5303.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub3.subject.subject_code  eq "mc5304"}'>
														<tr>
															<td>MC5304</td>
															<td>Programming with Java</td>
															<td>${s3.mc5304.point}</td>
															<td>${s3.mc5304.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub3.subject.subject_code  eq "mc5305"}'>
														<tr>
															<td>MC5305</td>
															<td>Object Oriented Analysis and Design</td>
															<td>${s3.mc5305.point}</td>
															<td>${s3.mc5305.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub3.subject.subject_code  eq "mc5311"}'>
														<tr>
															<td>MC5211</td>
															<td>Data Structures and Algorithms Laboratory</td>
															<td>${s3.mc5311.point}</td>
															<td>${s3.mc5311.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub3.subject.subject_code  eq "mc5312"}'>
														<tr>
															<td>MC5312</td>
															<td>Web Programming Laboratory</td>
															<td>${s3.mc5312.point}</td>
															<td>${s3.mc5312.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub3.subject.subject_code  eq "mc5313"}'>
														<tr>
															<td>MC5313</td>
															<td>Programming with Java Laboratory</td>
															<td>${s3.mc5313.point}</td>
															<td>${s3.mc5313.acronym}</td>
														</tr>									
													</c:when>
												</c:choose>
											</c:forEach></c:forEach>
										</tbody>
									</table>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- table wrapper -->
					</div>
					<!-- Tab pane 3 -->
					
					<div class="tab-pane fade" id="sem4" role="tabpanel" aria-labelledby="sem4-tab">
						<div class="table-wrapper">
							<div class="row">
								<div class="col col-sm-12 col-md-12 col-lg-12">
									<table class="table table-striped table-hover">
										<thead>
											<tr><th>Subject Code</th><th>Subject Name</th><th>Grade Point</th><th>Grade</th></tr>
										</thead>
										<tbody>
											<c:forEach var="sub4" items="${sem4sub }"><c:forEach var="s4" items="${sem4 }"> 
												<c:choose>
													<c:when test='${sub4.subject.subject_code eq "mc5401" }'>
														<tr>
															<td>MC5401</td>
															<td>Resource Management Techniques</td>
															<td> ${s4.mc5401.point}</td>
															<td> ${s4.mc5401.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5402" }'>										
														<tr>
															<td>MC5402</td>
															<td>Mobile Computing</td>
															<td> ${s4.mc5402.point}</td>
															<td> ${s4.mc5402.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5403" }'>
														<tr>
															<td>MC5403</td>
															<td>Advanced Databases and Data Mining</td>
															<td> ${s4.mc5403.point}</td>
															<td> ${s4.mc5403.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5404" }'>
														<tr>
															<td>MC5404</td>
															<td>Web Application Development</td>
															<td> ${s4.mc5404.point}</td>
															<td> ${s4.mc5404.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5001" }'>
														<tr>
															<td>MC5001</td>
															<td>Soft Computing</td>
															<td>${s4.mc5001.point}</td>
															<td>${s4.mc5001.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5002" }'>
														<tr>
															<td>MC5002</td>
															<td>Accounting and Financial Management</td>
															<td>${s4.mc5002.point}</td>
															<td>${s4.mc5002.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5003" }'>
														<tr>
															<td>MC5003</td>
															<td>Software Project Management</td>
															<td>${s4.mc5003.point}</td>
															<td>${s4.mc5003.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5004" }'>
														<tr>
															<td>MC5004</td>
															<td>Security in computing</td>
															<td>${s4.mc5004.point}</td>
															<td>${s4.mc5004.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5005" }'>
														<tr>
															<td>MC5005</td>
															<td>Adhoc and Sensor Network</td>
															<td>${s4.mc5005.point}</td>
															<td>${s4.mc5005.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5411" }'>
														<tr>
															<td>MC5411</td>
															<td>Mobile Application Development Laboratory</td>
															<td>${s4.mc5411.point}</td>
															<td>${s4.mc5411.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5412" }'>
														<tr>
															<td>MC5412</td>
															<td>Mobile Application Development Laboratory</td>
															<td>${s4.mc5412.point}</td>
															<td>${s4.mc5412.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub4.subject.subject_code eq "mc5413" }'>
														<tr>
															<td>MC5413</td>
															<td>Technical Seminar and Report Writing</td>
															<td>${s4.mc5413.point}</td>
															<td>${s4.mc5413.acronym}</td>
														</tr>
													</c:when>
												</c:choose>
											</c:forEach></c:forEach>										
										</tbody>
									</table>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- table wrapper -->
					</div>
					<!-- Tab pane 4 -->
													
					<div class="tab-pane fade" id="sem5" role="tabpanel" aria-labelledby="sem5-tab">
						<div class="table-wrapper">
							<div class="row">
								<div class="col col-sm-12 col-md-12 col-lg-12">
									<table class="table table-striped table-hover">
										<thead>
											<tr><th>Subject Code</th><th>Subject Name</th><th>Grade Point</th><th>Grade</th></tr>
										</thead>
										<tbody>
											<c:forEach var="sub5" items="${sem5sub }"><c:forEach var="s5" items="${sem5 }"> 
												<c:choose>
													<c:when test='${sub5.subject.subject_code eq "mc5501" }'>
														<tr>
															<td>MC5501</td>
															<td>Cloud Computing</td>
															<td> ${s5.mc5501.point}</td>
															<td> ${s5.mc5501.acronym}</td>
														</tr>
													</c:when>				
													<c:when test='${sub5.subject.subject_code eq "mc5502" }'>						
														<tr>
															<td>MC5502</td>
															<td>Big Data Analytics</td>
															<td> ${s5.mc5502.point}</td>
															<td> ${s5.mc5502.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5503" }'>
														<tr>
															<td>MC5503</td>
															<td>Software Testing and Quality Assurance</td>
															<td> ${s5.mc5503.point}</td>
															<td> ${s5.mc5503.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5006" }'>
														<tr>
															<td>MC5006</td>
															<td>Professional Ethics</td>
															<td>${s5.mc5006.point}</td>
															<td>${s5.mc5006.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5007" }'>
														<tr>
															<td>MC5007</td>
															<td>Health Care Management</td>
															<td>${s5.mc5007.point}</td>
															<td>${s5.mc5007.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5008" }'>
														<tr>
															<td>MC5008</td>
															<td>Geological Information Systems</td>
															<td>${s5.mc5008.point}</td>
															<td>${s5.mc5008.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5009" }'>
														<tr>
															<td>MC5009</td>
															<td>Human Resource Management</td>
															<td>${s5.mc5009.point}</td>
															<td>${s5.mc5009.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5010" }'>
														<tr>
															<td>MC5010</td>
															<td>Internet of Things</td>
															<td>${s5.mc5010.point}</td>
															<td>${s5.mc5010.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5011" }'>
														<tr>
															<td>MC5011</td>
															<td>Semantic Web</td>
															<td>${s5.mc5011.point}</td>
															<td>${s5.mc5011.acronym}</td>
														</tr>		
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5012" }'>
														<tr>
															<td>MC5012</td>
															<td>Service Oriented Architecture</td>
															<td>${s5.mc5012.point}</td>
															<td>${s5.mc5012.acronym}</td>
														</tr>		
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5013" }'>
														<tr>
															<td>MC5013</td>
															<td>Game Programming</td>
															<td>${s5.mc5013.point}</td>
															<td>${s5.mc5013.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5014" }'>
														<tr>
															<td>MC5014</td>
															<td>Computational Intelligence</td>
															<td>${s5.mc5014.point}</td>
															<td>${s5.mc5014.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5015" }'>
														<tr>
															<td>MC5015</td>
															<td>Principles of Programming Languages</td>
															<td>${s5.mc5015.point}</td>
															<td>${s5.mc5015.acronym}</td>
														</tr>			
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5511" }'>											
														<tr>
															<td>MC5511</td>
															<td>Cloud and Big Data Laboratory</td>
															<td> ${s5.mc5511.point}</td>
															<td> ${s5.mc5511.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5512" }'>
														<tr>
															<td>MC5512</td>
															<td>Software Testing Laboratory</td>
															<td> ${s5.mc5512.point}</td>
															<td> ${s5.mc5512.acronym}</td>
														</tr>
													</c:when>
													<c:when test='${sub5.subject.subject_code eq "mc5513" }'>
														<tr>
															<td>MC5513</td>
															<td>Mini Project</td>
															<td> ${s5.mc5513.point}</td>
															<td> ${s5.mc5513.acronym}</td>
														</tr>
													</c:when>
												</c:choose>
											</c:forEach></c:forEach>										
										</tbody>
									</table>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- table wrapper -->
					</div>
					<!-- Tab pane 5 -->
					
					<div class="tab-pane fade" id="sem6" role="tabpanel" aria-labelledby="sem6-tab">
						<div class="table-wrapper">
							<div class="row">
								<div class="col col-sm-12 col-md-12 col-lg-12">
									<table class="table table-striped table-hover">
										<thead>
											<tr><th>Subject Code</th><th>Subject Name</th><th>Grade Point</th><th>Grade</th></tr>
										</thead>
										<tbody>
											<c:forEach var="sub6" items="${sem6sub }"><c:forEach var="s6" items="${sem6 }">
												<c:choose>
													<c:when test='${sub6.subject.subject_code eq "mc5611"}'>
														<tr>
															<td>MC5611</td>
															<td>Project Work</td>
															<td>${s6.mc5611.point}</td>
															<td>${s6.mc5611.acronym}</td>
														</tr>
													</c:when>
												</c:choose>
											</c:forEach></c:forEach>							
										</tbody>
									</table>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- table wrapper -->
					</div>
					<!-- Tab pane 6 -->
				</div>
				<!-- Tab Content -->										
			</c:if>
			
		</div>
		<!-- Container Fluid -->
	</div>
	
	<jsp:include page="Footer.jsp" />
		
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	
<c:if test="${viewModal != null }"> 
	<script type="text/javascript">
		$('#viewModal').modal('show');
	</script>
</c:if>
	
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){

			var batch = $('#batch');
			var urlBatch = "http://localhost:8080/api/getAllBatch";
		    $.ajax({
		    	type: 'GET',
		        url: urlBatch,
		        async: true,
		        success: function(result){
		        	var output = "<option value=''> -- Select -- </option>";
		            for(var i in result){
		            	output+="<option value=" + result[i].id + ">" + result[i].from_year + " - " + result[i].to_year + "</option>";
		            }
		            batch.html(output);
		        }
		   	});

		    var regulation = $('#regulation');
			var urlRegulation = "http://localhost:8080/api/getAllRegulation";
		    $.ajax({
		    	type: 'GET',
		        url: urlRegulation,
		        async: true,
		        success: function(result){
		        	var output = "<option value=''> -- Select -- </option>";
		            for(var i in result){
		            	output+="<option value="+result[i].id+">"+result[i].acronym+"</option>";
		            }
		            regulation.html(output);
		        }
		   	});
			
			var year = $('#year');
			var urlYear = "http://localhost:8080/api/getAllYear";
		    $.ajax({
		    	type: 'GET',
		        url: urlYear,
		        async: true,
		        success: function(result){
		        	var output = "<option value=''> -- Select -- </option>";
		            for(var i in result){
		            	output+="<option value="+result[i].id+">"+result[i].year+"</option>";
		            }
		            year.html(output);
		        }
		   	});

		    var semester = $('#semester');
			var urlSemester = "http://localhost:8080/api/getAllSemester";
		    $.ajax({
		    	type: 'GET',
		        url: urlSemester,
		        async: true,
		        success: function(result){
		        	var output = "<option value=''> -- Select -- </option>";
		            for(var i in result){
		            	output+="<option value="+result[i].id+">"+result[i].name+"</option>";
		            }
		            semester.html(output);
		        }
		   	});
		    
		    var section = $('#section');
			var urlSection = "http://localhost:8080/api/getAllSection";
		    $.ajax({
		    	type: 'GET',
		        url: urlSection,
		        async: true,
		        success: function(result){
		        	var output = "<option value=''> -- Select -- </option>";
		            for(var i in result){
		            	output+="<option value="+result[i].id+">"+result[i].name+"</option>";
		            }
		            section.html(output);
		        }
		   	});

		    var student = $('#student');
            var id = $('#id').val();
            
            var pre = "http://localhost:8080/api/getAllStudentByStaffId/";
            var varurl = pre+id;
            $.ajax({
            	type: 'GET',
                url: varurl,
                async: true,
                success:function(result){
                    //console.log(result);
                	var output = "<tr></tr>";
                    for(var i in result){
                    	output+="<tr><td class='text-capitalize'>" + result[i].student.name + "</td><td></td><td></td><td><a href='StaffViewSemMarks?user="+ result[i].student.user_id +"&name="+ result[i].student.name +"' class='view' ><i class='fa fa-eye' aria-hidden='true' data-toggle='tooltip' title='view'></i></a></td></tr>";
                    }
                    //console.log(output);
                student.html(output);
                }
           	});
		});
	</script>
</body>
</html>