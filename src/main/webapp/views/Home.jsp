<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Home</title>

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
		
		<!-- Page Content  -->
		<div id="content" class="pt-2 pb-2 pl-6 pr-5">				
			<div class="mt-2">
				
				<h4>Introduction</h4>
				
				<p class="indent">
					Master of Computer Applications (MCA) focus on the design and application of information systems and provides a solid background in programming for Information Technology and covers recent applications in the area of computing field. MCA students acquire strength in principles, concepts and foundations of computer science, information technology and various applications. They would also have good programming skills, developing software applications over a wide variety of platforms. The course was designed to meet the growing demand for qualified professionals in the field of Information Technology. The MCA programme is inclined more toward Application Development and thus has more emphasis on latest programming language and tools to develop better and faster applications.
	            </p>
	            <p class="indent">
	            	As the IT and the software industry are dynamic and fast growing, MCA programme is designed keeping in view the requirements of industry. The programme aims at the understanding of the fundamentals of computing among the students so that they can compete in the present-day global situation. Students are trained in the fields of Systems Designing, Application Software Development, Computer Networks, System Administration, Web Designing and Development, Database Administration, Data Mining and Warehousing, etc., This course  covers various aspects of  Computational Theory, Programming, Algorithm Design and Optimization, Network and Database Management, Mobile Technologies etc.,
	            </p>
	            
	            <h4>Mission</h4>
	            
	            <p class="indent">
	            	To impart high quality computer education, develop their technical and problem solving skills, broaden their mental horizon and transform them into competent and talented software professionals.
	           	</p>
	           	<p class="indent">
	           		To develop the knowledge in fundamental computing principles, evolve with the recent trends in industry, devise and implement innovative systems through research and in collaboration with other stake holders.
	           	</p>
	           	<p class="indent">
	           		To serve the society and the Nation with good ethical standards and social concern.
	            </p>
	            
	            <h4>Vision</h4>
	            
	            <p class="indent">
	            	To provide world class education on computer applications for individuals to develop as technologically superior, socially conscious and nationally responsible citizens.
	            </p>
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
	<script type="text/javascript" src="./views/js/common.js"></script>
</body>
</html>