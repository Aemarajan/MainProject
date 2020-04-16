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
	//$("#header").load("http://localhost:8080/header");
	
// Add privilege
	var varurl = "http://localhost:8080/api/getUserPp0";
    var users = $('#users');
    $.ajax({
        type: 'GET',
        url: varurl,
        async: true,
        success: function(result){
            var output = "<option value='0'> -- Select -- </option>";
            for(var i in result){
                output+="<option value=" + result[i].user_id + ">" + result[i].name + "<span> [ " + result[i].email + " ] </span>" + "</option>";
            }
            users.html(output);
        }
    });
	
// Modify Privilege
    var varurl = "http://localhost:8080/api/getUserPp1";
    var users = $('#users');
    $.ajax({
        type: 'GET',
        url: varurl,
        async: true,
        success: function(result){
            var output = "<option value='0'> -- Select -- </option>";
            for(var i in result){
                output+="<option value=" + result[i].user_id + ">" + result[i].username + "<span> [ " + result[i].email + " ] </span>" + "</option>";
            }
            users.html(output);
        }
    });

// SignUp
    $('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var user_id = button.data('user_id');
		var role = button.data('role');
		var name = button.data('name');
		var email = button.data('email'); 
		var username = button.data('username');
		var password = button.data('password');
		var privilege_provide = button.data('privilege_provide');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#user_id').val(user_id);
		modal.find('#role').val(role);
		modal.find('#name').val(name);
		modal.find('#email').val(email);
		modal.find('#username').val(username);
		modal.find('#password').val(password);
		modal.find('#privilege_provide').val(privilege_provide);
		
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var user_id = button.data('user_id');
		var name = button.data('name'); 

		var modal = $(this);
		modal.find('#user_id').val(user_id);
		modal.find('#name').val(name);
	});
	
	$(".nav-tabs a").click(function(){
		$(this).tab('show');
	});

	$('.nav-tabs a').on('shown.bs.tab', function(event){
	    var x = $(event.target).text();         // active tab
	    var y = $(event.relatedTarget).text();  // previous tab
	});

// Add Level One
	$('#dd').click(function() {
		var check = this.checked;
		if (check == false){
			$('.ref').show();
    		$('.rlab').show();
    		$('.referror').show();
    		$('.ref').attr('value','');
  		}
		else{
			$('.ref').hide();
    		$('.rlab').hide();
    		$('.referror').hide();
    		$('.ref').attr('value','null');
  		}
	});

// Add Level Two
	$('#dd').click(function() {
		var check = this.checked;
		if (check == false){
			$('.ref').show();
  		$('.rlab').show();
  		$('.referror').show();
  		$('.ref').attr('value','');
		}
		else{
			$('.ref').hide();
  		$('.rlab').hide();
  		$('.referror').hide();
  		$('.ref').attr('value','null');
		}
	});
  var varurl = "http://localhost:8080/api/getAllLevelOneByDd";
  var lvl1 = $('#lvl1');
  $.ajax({
    type: 'GET',
    url: varurl,
    async: true,
    success: function(result){
      var output = "<option value='0'> -- Select -- </option>";
      for(var i in result){
        output+="<option value="+result[i].lvl1_id+">"+result[i].name+"</option>";
      }
      lvl1.html(output);
    }
  });

// Add Level Three

  
// Delete Level One
  var varurl = "http://localhost:8080/api/getAllLevelOne";
  var lvl1 = $('#lvl1');
  $.ajax({
    type: 'GET',
    url: varurl,
    async: true,
    success: function(result){
      var output = "<option value='0'> -- Select -- </option>";
      for(var i in result){
        output+="<option value="+result[i].lvl1_id+">"+result[i].name+"</option>";
      }
      lvl1.html(output);
    }
  });
	
// Delete Level Two
  var lvl2 = $("#lvl2");
	var varurllvl1 = "http://localhost:8080/api/getAllLevelOneByDd";
	var lvl1 = $('#lvl1');
		$.ajax({
  		type: 'GET',
  		url: varurllvl1,
  		async: true,
  		success: function(result){
    			var output = "<option value='0'> -- Select -- </option>";
    			for(var i in result){
      			output+="<option value="+result[i].lvl1_id+">"+result[i].name+"</option>";
    			}
    		lvl1.html(output);
  		}
		});

		$('#lvl1').change(function() {
		$(this).find("option:selected").each(function() {
			var lvl = $(this).attr("value");
			var pre = "http://localhost:8080/api/getLvl2/";
			var varurl = pre+ lvl;
				$.ajax({
					type : 'GET',
					url : varurl,
					async : true,
					success : function(result) {
						var output = "<option selected value='0'>-- Select --</option>";
						for ( var i in result) {
							output += "<option value="+result[i].lvl2_id+">"+ result[i].name+ "</option>";
						}
					lvl2.html(output);
					}
				});
		});
	});
	
// Delete Level Three
	var varurl = "http://localhost:8080/api/getAllLevelOneByDd";
        var lvl1 = $('#lvl1');
        $.ajax({
            type: 'GET',
            url: varurl,
            async: true,
            success: function(result){
                var output = "<option selected disabled> -- Select -- </option>";
                for(var i in result){
                    output+="<option value="+result[i].lvl1_id+">"+result[i].name+"</option>";
                }
                lvl1.html(output);
            }
        });
        var lvl3 = $('#lvl3');
        var lvl2 = $('#lvl2');
        $('#lvl1').change(function(){
            $(this).find("option:selected").each(function(){
                var lvl = $(this).attr("value");
                var pre = "http://localhost:8080/api/getLvl2/";
                var varurl = pre+lvl;
                //console.log(varurl);
                $.ajax({
                    type: 'GET',
                    url: varurl,
                    async: true,
                    success:function(result){
                        //console.log(result);
                        var output = "<option selected disabled>-- Select --</option>";
                        for(var i in result){
                            output+="<option value="+result[i].lvl2_id+">"+result[i].name+"</option>";
                        }
                        output+="";
                        lvl2.html(output);
                    }
                });
            });
        });
        
        $('#lvl2').change(function(){
            $(this).find("option:selected").each(function(){
                var pre = "http://localhost:8080/api/getLevelThree/";
                var lvl1v = $('#lvl1').val();
                var lvl2v = $(this).attr('value');
                var varurl1 = pre + lvl1v + "/"+lvl2v;
                $.ajax({
                    type: 'GET',
                    url: varurl1,
                    async: true,
                    success: function(result){
                        var output = "<option selected disabled> -- Select -- </option>";
                        for(var i in result){
                            output+="<option value="+result[i].lvl3.lvl3_id+">"+result[i].lvl3.name+"</option>";
                        }
                        lvl3.html(output);
                    }
                });
            });
        });
	
// Master's JavaScript Code
// Batch Master
    $('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var from = button.data('from'); 
		var to = button.data('to');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#from_year').val(from);
		modal.find('#to_year').val(to);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var from = button.data('from'); 
		var to = button.data('to');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(from+' - '+to);
	});
	
// Community Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name'); 
		var acronym = button.data('acronym');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name'); 
		var acronym = button.data('acronym');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// BloodGroup Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Country master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name'); 
		var acronym = button.data('acronym');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Degree Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var category = button.data('category');
		var name = button.data('name'); 
		var acronym = button.data('acronym');
		var inn = button.data('inn');
		
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#category').val(category);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Department Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var acronym = button.data('acronym');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// District Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var acronym = button.data('acronym');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});
	
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Grade Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var word = button.data('word');
		var acronym = button.data('acronym');
		var point = button.data('point');
		var marks_range = button.data('marks_range');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#word').val(word);
		modal.find('#acronym').val(acronym);
		modal.find('#point').val(point);
		modal.find('#marks_range').val(marks_range);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});
	
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var word = button.data('word');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#word').val(word);
	});
	
// Language Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Regulation Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name'); 
		var acronym = button.data('acronym');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});
	
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name'); 
		var to = button.data('to');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Religion Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Section Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);

	});
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name+" Section ");
	});
	
// Semester Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);

	});
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// State Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var acronym = button.data('acronym');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
		modal.find('#acronym').val(acronym);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
		
	});
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var name = button.data('name');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(name);
	});
	
// Syllabus Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var code = button.data('code'); 
		var name = button.data('name');
		var credit = button.data('credit');
		var inn = button.data('inn');

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#subject_code').val(code);
		modal.find('#subject_name').val(name);
		modal.find('#credit').val(credit);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var code = button.data('code');
		var name = button.data('name'); 

		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(code+" - "+name);
	});
	
// Year Master
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var year = button.data('year');
		var inn = button.data('inn');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#year').val(year);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);

	});
	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var year = button.data('year');
		var modal = $(this);
		modal.find('#id').val(id);
		modal.find('#name').val(year);
	});
	
// SideBar JavaScript Codes
// Experience 
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var institute_name = button.data('institute_name');
		var designation = button.data('designation');
		var from_date = button.data('from_date');
		var to_date = button.data('to_date');
		var inn = button.data('inn');

		var modal = $(this);

		modal.find('#id').val(id);
		modal.find('#institute_name').val(institute_name);
		modal.find('#designation').val(designation);
		modal.find('#from_date').val(from_date);
		modal.find('#to_date').val(to_date);
		if(inn == 1)
			modal.find('#inn').prop('checked',true);
		else
			modal.find('#inn').prop('checked',false);
	});

	$('#deleteModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var institute_name = button.data('institute_name');
		var designation = button.data('designation');

		var modal = $(this);

		modal.find('#id').val(id);
		modal.find('#institute_name').val(institute_name + '-' + designation);
	});
});