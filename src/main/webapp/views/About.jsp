<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>About Us</title>

<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">
</head>
<body>

	<jsp:include page="Header.jsp" />

	<div id="header"></div>
	
	<div class="wrapper d-flex align-items-stretch">
		
		<jsp:include page="Sidebar.jsp" />
		
		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 p-sm-5 p-lg-5 pt-5">
            <h4 class="mb-3">About the Department</h4>

			<p class="indent">
				The PG Programme in Master of Computer Application was introduced in the year 1998. Initially, the sanctioned intake was 30. Subsequently, it was increased to 36, 60, 90 and to 120 during the academic years 1999-2000, 2000-2001, 2005-2006 and 2006-2007 respectively. Since inception the department is consistently producing very good academic performance and placement records.
			</p>
			<p class="indent"> 
				The Department is headed by Dr.PJaganathan, who has 24 years and 7 months of teaching experience. His fields of interest include Data Mining, evolutionary computation and nature inspired computation. He is supported by 18 well qualified and experienced faculty members and the faculty team consists of 8 Doctorates, 6 M.Phil., and 2 M.E. holders. The faculty members are actively involved in research work. So far, they have published around 148 research papers in various National, International conferences and journals. The faculty members have also participated in various seminars, workshops, National, International conferences and short-term training programmes. MCA Department is recognized as Research Department by Anna University Chennai from July 2012 to pursue Ph.D./ M.S programme. The Department has been accredited for 3 years by NBA (National Board of Accreditation) with effect from February 2014.
			</p>
			<p class="indent">
				The total built up area of the department including instructional, administrative and amenities area is 6974 Sq.m. Around 6 Crores has been invested towards building, amenities and other infrastructure like laboratories. Department has computer laboratories namely Software Development Lab (First Floor) with 64 systems, Programming Lab(Second Floor) with 60 systems and Microprocessor Lab(Ground Floor) with 19 kits catering to the needs of 360 students
			</p>
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
	<script>
		$(document).ready(function() {
			$('#header').load("http://localhost:8080/header");
		});
	</script>
</body>
</html>