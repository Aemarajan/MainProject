<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<nav class="navbar navbar-light navbar-expand-md mainmenu ubuntu py-1 mt-2">
		<a class="navbar-brand mx-2" href="home"><i class="fa fa-home"></i></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-collapse collapse" id="navbarNavDropdown">
			<ul class="navbar-nav mr-auto">
				<c:forEach var="lvl1s" items='<%= session.getAttribute("lvl1") %>'>
					<c:if test="${lvl1s.dd == 1 }">
						<li class="nav-item dropdown ml-2"><a class="nav-link" id="navbarDropdown" href="#" role="button" data-toggle="dropdown"  aria-haspopup="true" aria-expanded="false">${lvl1s.name }<i class="fa fa-sort-down ml-1" aria-hidden="true"></i></a>
							<ul class="dropdown-menu dropdown-menu-left"  style="border-top: 4px solid black;" aria-labelledby="navbarDropdown">
								<c:forEach var="lvl2s" items='<%= session.getAttribute("lvl2") %>'>
									<c:if test="${lvl1s.lvl1_id == lvl2s.lvl1.lvl1_id }">
										<c:if test="${lvl2s.dd == 1 }">
											<li class="nav-item dropdown mx-2"><a class="nav-link dropdown-item dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${lvl2s.name }</a>
												<ul class="dropdown-menu dropdown-menu-left"  style="border-left: 4px solid black;" aria-labelledby="navbarDropdown1">
													<c:forEach items='<%= session.getAttribute("lvl3") %>' var="lvl3s">
														<c:forEach items='<%= session.getAttribute("menu") %>' var="menus">
															<c:if test="${menus.lvl3 != null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id && lvl3s.lvl3_id == menus.lvl3.lvl3_id }">
																<li class=" nav-item mx-2"><a class="dropdown-item" href="${menus.ref }">${lvl3s.name }</a></li>
															</c:if>
														</c:forEach>
													</c:forEach>
												</ul></li>
										</c:if>
										<c:if test="${lvl2s.dd != 1 }">
											<c:forEach items='<%= session.getAttribute("menu") %>' var="menus">
												<c:if test="${menus.lvl3 == null && lvl2s.lvl2_id == menus.lvl2.lvl2_id && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
													<li class="nav-item mx-2"><a class="dropdown-item" href="${menus.ref }">${lvl2s.name }</a></li>
												</c:if>
											</c:forEach>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:if>
					<c:if test="${lvl1s.dd != 1 }">
						<c:forEach items='<%= session.getAttribute("menu") %>' var="menus">
							<c:if test="${menus.lvl2 == null && lvl1s.lvl1_id == menus.lvl1.lvl1_id }">
								<li class="nav-item mx-3"><a class="nav-link" href="${menus.ref }">${lvl1s.name }</a></li>
 							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
				
			</ul>
			<ul class="ml-auto navbar-nav dropdown">
				<li class="text-center text-capitalize mx-2"> Welcome <%= session.getAttribute("name") %><br> <%= session.getAttribute("role") %> </li>
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

<script type="text/javascript" src="./views/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('.dropdown-menu a.dropdown-toggle').on('click',function(e) {
			if (!$(this).next().hasClass('show')) {
				$(this).parents('.dropdown-menu').first().find('.show').removeClass("show");
			}
		
			var $subMenu = $(this).next(".dropdown-menu");
			$subMenu.toggleClass('show');
		
			$(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function(e) {
				$('.dropdown-submenu .show').removeClass("show");
			});
			return false;
		});
	});
</script>