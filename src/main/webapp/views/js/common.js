$(document).ready(function() {
	"use strict";
	
// Animate the scroll to top
	$(window).scroll(function() {
        if ($(this).scrollTop() > 200) {
            $('.scroll-to-top').fadeIn(500);
        } else {
            $('.scroll-to-top').fadeOut(300);
        }
    });
    
    $('.scroll-to-top').click(function(event) {
        event.preventDefault();
		$('html, body').animate({scrollTop: 0}, 300);
    });

// Toast
    $('#Toast').toast({
		delay:5000
	});
	$('#Toast').toast('show');
	
	$('#LongToast').toast({
		delay:10000
	});
	$('#LongToast').toast('show');

// Tool tip
	$('[data-toggle = "tooltip"]').tooltip();

// Default Checked In Use
	$('.inn').prop('checked',true);
	
// MenuBar
	$("#header").load("http://localhost:8080/header");
	
//Header JavaScript Codes
// Add Level One
	
// Add Level Two
	
// Add Level Three
  
// Delete Level One
  	
// Delete Level Two
  	
// Delete Level Three

// Add privilege

// Modify Privilege

//SignUp
	
// Master's JavaScript Code
// Batch Master
    	
// Community Master
	
	
// BloodGroup Master
	
	
// Country master
	
	
// Degree Master
		
// Department Master
	
	
// District Master

	
// Grade Master
		
// Language Master
	
	
// Regulation Master
	
	
// Religion Master
	
	
// Section Master
	
	
// Semester Master
	
	
// State Master
	
	
// Syllabus Master
	
	
// Year Master
	
	
// SideBar JavaScript Codes
// Experience 

});