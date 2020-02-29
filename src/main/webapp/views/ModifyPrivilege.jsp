<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Modify Privilege - Final</title>

<link rel="stylesheet" href="./views/font-awesome/css/all.css">
<link rel="stylesheet" href="./views/css/bootstrap.min.css">
<link rel="stylesheet" href="./views/css/mdb.min.css">
<link rel="stylesheet" href="./views/css/style.css">

</head>
<body>
<div>
	<jsp:include page="Header.jsp" />
	
	<div id="header"></div>
	
	<div class="container-fluid">	
		<h3 class="text-center py-2">Privilege</h3>
		
		<form action="UpdatePrivilege" method="post">
			
			<div style="margin-left:40px;">
				<h5>Username</h5>
				<input type="hidden" name="user_id" value="${user.user_id }"/>
				<div class="md-form mt-0" style="width:265px;">
					<input type="text" class="form-control" value="${user.username }" readonly />
				</div>
			</div>
				
			<div class="row">
				<c:forEach var="lvl1s" items="${lvl1 }">
					<div class="col-md-3">
						<ul class="unstyle">
							<c:if test="${lvl1s.dd == 1 }">
								<li class="card-head white-text text-center h5 py-2">${lvl1s.name }</li>
								<ul>
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
																	</c:forEach> name="menu_id"><label class="pl-2">${menus.lvl3.name }</label>
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
										<li class=" unstyle card-head white-text text-center h5 py-2">${lvl1s.name }</li>
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
				<button type="submit" class="btn btn-custom w-25">Update</button>
			</div>
		</form>
	</div>
	
	<jsp:include page="Footer.jsp" />
</div>
	
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