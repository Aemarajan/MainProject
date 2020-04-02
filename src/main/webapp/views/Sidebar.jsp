<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SideBar</title>
</head>
<body>

	<nav id="sidebar" class="ubuntu">
		<div class="custom-menu">
			<button type="button" id="sidebarCollapse" class="sidebar-btn">
				<i class="fa fa-bars"></i> <span class="sr-only">Toggle Menu</span>
			</button>
		</div>
		<div class="p-4 pt-2">
			<h3><a href="index.html" class="logo white-text">Report Repo</a></h3>
			<ul class="list-unstyled components mb-5">
				<li class="active"><a href="home"><i class="fa fa-home mr-2" aria-hidden="true"></i>Home</a></li>
				<li><a href="Profile"><i class="fa fa-address-book mr-2" aria-hidden="true"></i>Profile</a></li>
				<li><a href="ChangePassword"><i class="fa fa-cogs mr-2" aria-hidden="true"></i>Change Password</a></li>
				<li><a href="Gallery"><i class="fa fa-photo-video mr-2" aria-hidden="true"></i>Gallery</a></li>
				<li><a href="About"><i class="fa fa-users mr-2" aria-hidden="true"></i>About Us</a></li>
				<li><a href="Contact"><i class="fa fa-phone-alt mr-2" aria-hidden="true"></i>Contact Us</a></li>
				<li><a href="logout"><i class="fa fa-sign-out-alt mr-2" aria-hidden="true"></i>Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			"use strict";

			var fullHeight = function() {

				$('.js-fullheight').css('height', $(window).height());
				$(window).resize(function(){
					$('.js-fullheight').css('height', $(window).height());
				});

			};
			fullHeight();

			$('#sidebarCollapse').on('click', function () {
				$('#sidebar').toggleClass('active');
			});
		});
	</script>
</body>
</html>