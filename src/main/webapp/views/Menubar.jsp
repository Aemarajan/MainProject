<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href=".views/css/bootstrap.min.css">	
<link rel="stylesheet" href="./views/css/animate.min.css">
<link rel="stylesheet" href="./views/css/bootnavbar.css">
<link rel="stylesheet" href="./views/css/style.css">

</head>
<body>	
	<nav class="navbar navbar-expand-lg  navbar-light bg-light ubuntu py-1 mt-2" id="main_navbar">
		<a class="navbar-brand" href="home"><i class="fa fa-home"></i></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav mr-auto">
				<c:forEach var="lvl1s" items="${lvl1 }">
					<c:if test="${lvl1s.dd == 1 }">
						<li class="nav-item dropdown ml-3"><a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${lvl1s.name }</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<c:forEach var="lvl2s" items="${lvl2 }">
									<c:if test="${lvl1s.lvl1_id == lvl2s.lvl1.lvl1_id }">
										<c:if test="${lvl2s.dd == 1 }">
											<li class="nav-item dropdown mx-2"><a class="nav-link dropdown-item dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${lvl2s.name }</a>
												<ul class="dropdown-menu"  aria-labelledby="navbarDropdown1">
													<c:forEach items="${lvl3 }" var="lvl3s">
														<c:forEach items="${menu }" var="menus">
															<c:if test="${menus.lvl3 != null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id && lvl3s.lvl3_id == menus.lvl3.lvl3_id }">
																<li class="mx-2"><a class="dropdown-item" href="${menus.ref }">${lvl3s.name }</a></li>
															</c:if>
														</c:forEach>
													</c:forEach>
												</ul></li>
										</c:if>
										<c:if test="${lvl2s.dd != 1 }">
											<c:forEach items="${menu }" var="menus">
												<c:if test="${menus.lvl3 == null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
													<li><a class="dropdown-item" href="${menus.ref }">${lvl2s.name }</a></li>
												</c:if>
											</c:forEach>
										</c:if>
									</c:if>
								</c:forEach>
							</ul></li>
					</c:if>
					<c:if test="${lvl1s.dd != 1 }">
						<c:forEach items="${menu }" var="menus">
							<c:if test="${menus.lvl2 == null && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
								<li class="nav-item ml-3"><a class="nav-link" href="${menus.ref }">${lvl1s.name }</a></li>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
				
			</ul>
			<ul class="ml-auto navbar-nav">
				<li class="nav-item ml-3"><a class="nav-link" href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<!-- <ul>
		<c:forEach var="lvl1s" items="${lvl1 }">
			<c:if test="${lvl1s.dd == 1 }">
				<li>${lvl1s.name }</li>
				<ul>
					<c:forEach var="lvl2s" items="${lvl2 }">
						<c:if test="${lvl1s.lvl1_id == lvl2s.lvl1.lvl1_id }">
							<c:if test="${lvl2s.dd == 1 }">
								<li>${lvl2s.name }</li>
								<ul>
									<c:forEach items="${lvl3 }" var="lvl3s">
										<c:forEach items="${menu }" var="menus">
											<c:if
												test="${menus.lvl3 != null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id && lvl3s.lvl3_id == menus.lvl3.lvl3_id }">
												<li>${lvl3s.name },${menus.ref }</li>
											</c:if>
										</c:forEach>
									</c:forEach>
								</ul>
							</c:if>
							<c:if test="${lvl2s.dd != 1 }">
								<c:forEach items="${menu }" var="menus">
									<c:if
										test="${menus.lvl3 == null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
										<li>${lvl2s.name },${menus.ref }</li>
									</c:if>
								</c:forEach>
							</c:if>
						</c:if>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${lvl1s.dd != 1 }">
				<c:forEach items="${menu }" var="menus">
					<c:if
						test="${menus.lvl2 == null && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
						<li>${lvl1s.name },${menus.ref }</li>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
	</ul>-->

	<!-- jQuery -->
  	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
  
  	<script type="text/javascript" src="./views/js/popper.min.js"></script>
  
  	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
  
  	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
  	
    <script src="./views/js/bootnavbar.js" ></script>
    <script>
        $(function () {
            $('#main_navbar').bootnavbar();
        })
    </script>
</body>
</html>