<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Modify Privilege - Final</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">	
<link rel="stylesheet" href="./views/css/animate.min.css">
<link rel="stylesheet" href="./views/css/bootnavbar.css">
<style>
body {
	font: 400 15px Lato, sans-serif;
	line-height: 1.8;
	color: #818181;
}

.unstyle {
	list-style: none;
}

.panel-heading {
	color: #fff !important;
	background-color: #4a876b !important;
	padding: 5px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 0px;
	border-top-right-radius: 15px;
	border-bottom-left-radius: 15px;
	border-bottom-right-radius: 0px;
}
</style>
</head>
<body>
	<div id="header"></div>
	<div class="container">
		<h3 class="text-center">Privilege</h3>
		<br>
		<form action="UpdatePrivilege" method="post">
			<h4>User Name :</h4>
			<input type="hidden" name="user_id" value="${user.user_id }"/><input type="text" class="form-control" value="${user.username }" style="width:250px;" disabled readonly /> <br>
			<div class="row">
				<c:forEach var="lvl1s" items="${lvl1 }">
					<div class="col-md-4">
						<ul class="unstyle">
							<c:if test="${lvl1s.dd == 1 }">
								<li class="panel-heading text-center h2">${lvl1s.name }</li>
								<ul class="ml-5">
									<c:forEach var="lvl2s" items="${lvl2 }">
										<c:if test="${lvl1s.lvl1_id == lvl2s.lvl1.lvl1_id }">
											<c:if test="${lvl2s.dd == 1 }">
												<li class="unstyle"><strong>${lvl2s.name }</strong></li>
												<ul>
													<c:forEach items="${lvl3 }" var="lvl3s">
														<c:forEach items="${menu }" var="menus">
															<c:if test="${menus.lvl3 != null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id && lvl3s.lvl3_id == menus.lvl3.lvl3_id }">
																<li class="unstyle"><input type="checkbox" value="${menus.menu_id }"
																	<c:forEach items="${pri }" var="prii">
																		<c:if test="${prii.menu_id.menu_id == menus.menu_id }"> 
																			<c:if test="${prii.inn == 1 }"> checked </c:if>  
																		</c:if>  
																	</c:forEach> name="menu_id"><label class="pl-3">${menus.lvl3.name }</label>
																</li>
															</c:if>
														</c:forEach>
													</c:forEach>
												</ul>
											</c:if>
											<c:if test="${lvl2s.dd != 1 }">
												<c:forEach items="${menu }" var="menus">
													<c:if test="${menus.lvl3 == null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
														<li class="unstyle"><input type="checkbox" value="${menus.menu_id }"
															<c:forEach items="${pri }" var="prii"> 
																<c:if test="${prii.menu_id.menu_id == menus.menu_id }"> 
																	<c:if test="${prii.inn == 1 }"> checked </c:if>  
																</c:if>  
															</c:forEach> name="menu_id"><label class="pl-3">${menus.lvl2.name }</label></li>
													</c:if>
												</c:forEach>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</c:if>
							<c:if test="${lvl1s.dd != 1 }">
								<c:forEach items="${menu }" var="menus">
									<c:if test="${menus.lvl2 == null && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
										<li class=" unstyle panel-heading text-center h2">${lvl1s.name }</li>
										<li class="unstyle ml-5"><input type="checkbox" value="${menus.menu_id }"
											<c:forEach items="${pri }" var="prii"> 
												<c:if test="${prii.menu_id.menu_id == menus.menu_id }"> 
													<c:if test="${prii.inn == 1 }"> checked </c:if>  
												</c:if>  
											</c:forEach>
											name="menu_id"> <label class="pl-3">${menus.lvl1.name }</label>
										</li>
									</c:if>
								</c:forEach>
							</c:if>
						</ul>
					</div>
					<hr />
					<br />
				</c:forEach>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-info" value="Update" />
			</div>
		</form>
		<br> <br>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="./views/js/bootnavbar.js" ></script><script>
		$(document).ready(function() {
			$('#header').load("http://localhost:8080/header");
			$('.username').change(function() {
				$(this).find("option:selected").each(function() {
					console.log($(this).attr("value"));
				});
			});
		});
	</script>
</body>
</html>