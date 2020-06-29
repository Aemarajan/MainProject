<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		
			<div class="mt-3 mb-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb indigo lighten-4">
						<li class="breadcrumb-item">
							<a class="black-text" href="#">Home</a>
							<i class="fas fa-angle-double-right mx-2" aria-hidden="true"></i>
						</li>
						<li class="breadcrumb-item active">Add External Marks</li>
					</ol>
				</nav>
			</div>
			
			<h4 class="banner p-2 mt-2 mb-2 text-center">External Marks Entry</h4>
			
			<div hidden="true">
				<input type="text" name="id" id="id" value='<%= session.getAttribute("id") %>'/>
			</div>
			
			<label class="d-flex justify-content-end mandatory p-0 m-0">* must be selected</label>
			
			<div class="mt-0">Select Semester <span class="mandatory"> *</span></div>


			<table class="table table-striped">
				<thead></thead>
				<tbody id="semester"></tbody>
			</table>
			
			<table class="table table-striped">
				<thead></thead>
				<tbody>
					<tr>
						<td><input class="sem mt-2" type="radio" name="sem" id="sem1" value="1"/>	Sem 1</td>
						<td><input class="sem mt-2" type="radio" name="sem" id="sem2" value="2"/>	Sem 2</td>
						<td><input class="sem mt-2" type="radio" name="sem" id="sem3" value="3"/>	Sem 3</td>
						<td><input class="sem mt-2" type="radio" name="sem" id="sem4" value="4"/>	Sem 4</td>
						<td><input class="sem mt-2" type="radio" name="sem" id="sem5" value="5"/>	Sem 5</td>
						<td><input class="sem mt-2" type="radio" name="sem" id="sem6" value="6"/>	Sem 6</td>
					</tr>
				</tbody>
			</table>

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
	</div>
	
	<jsp:include page="Footer.jsp" />
		
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fa fa-angle-up"></i>
	</a>
	
	<c:if test="${added != null }">
		<div class="toast fade show" id="Toast" 
			style="position: absolute; overflow: auto; right: 20px; bottom: 20px; width: 300px;">
			<div class="toast-header white-text pt-2 bg-success">
				<h5 class="mr-auto">Notification</h5>
				<button type="button" class="ml-2 mb-1 close white-text"
					data-dismiss="toast">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body py-2">
				<div>Semester Marks Details are Added Successfully.</div>
			</div>
		</div>
	</c:if>
	
	<!-- jQuery -->
	<script type="text/javascript" src="./views/js/jquery.min.js"></script>
	<script type="text/javascript" src="./views/js/popper.min.js"></script>
	<script type="text/javascript" src="./views/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./views/js/mdb.min.js"></script>
	<script type="text/javascript" src="./views/js/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){

			var semester = $('#semester');
			var varurl = "http://localhost:8080/api/getAllSemester";
			$.ajax({
				type: 'GET',
				url: varurl,
				async: true,
				success: function(result){
					var output = "<tr>";
					for(var i in result){
						output += "<td><input class='sem mt-2' type='radio' name='sem' id='sem" + result[i].id + "' value='" + result[i].id + "'/>	" + result[i].name + "</td>"; 
					}
					output += "</tr>";
					//console.log(output);
				semester.html(output);
				}
			});

//             $('#semester').change(function(){
//                 $(this).find("option:selected").each(function(){
//                     var id = $(this).attr("value");
						
//                     var sem = $('#semester').val();
// 					var Semester = $('#semester').val(); 
					
//                     if(sem == 1){
// 						sem = "Semester1";
//                     }else if(sem == 2){
// 						sem = "Semester2";
//                     }else if(sem == 3){
// 						sem = "Semester3";
//                     }else if(sem == 4){
// 						sem = "Semester4";
//                     }else if(sem == 5){
// 						sem = "Semester5";
//                     }else if(sem == 6){
// 						sem = "Semester6";
//                     }

//                     var student = $('#student');
//                     var id = $('#id').val();
                    
//                     var pre = "http://localhost:8080/api/getAllStudentByStaffId/";
//                     var varurl = pre+id;
//                     $.ajax({
//                     	type: 'GET',
//                         url: varurl,
//                         async: true,
//                         success:function(result){
//                             //console.log(result);
//                         	var output = "<tr></tr>";
//                             for(var i in result){
//                             	output+="<tr><td class='text-capitalize'>" + result[i].student.name + "</td><td></td><td></td><td><a href='" + sem + "?user=" + result[i].student.user_id + "&sem=" + Semester + "' class='edit'><i class='fa fa-pencil-alt' data-toggle='tooltip' title='Edit'></i></a></td></tr>";
//                             }
//                             //console.log(output);
//                         student.html(output);
//                         }
//                    	});
//         		});
//             });

			$('input[type=radio][name=sem]').on('change', function() {
            	
             	var sem_int = $('input:radio[name=sem]:checked').val();
             	
             	if(sem_int == 1){
					sem_string = "Semester1";
                }else if(sem_int == 2){
                	sem_string = "Semester2";
                }else if(sem_int == 3){
                	sem_string = "Semester3";
                }else if(sem_int == 4){
                	sem_string = "Semester4";
                }else if(sem_int == 5){
                	sem_string = "Semester5";
                }else if(sem_int == 6){
                	sem_string = "Semester6";
                }else if(sem_int == 7){
                	sem_string = "Semester7";
                }else if(sem_int == 8){
                	sem_string = "Semester8";
                }
             		
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
                        	output+="<tr><td class='text-capitalize'>" + result[i].student.name + "</td><td></td><td></td><td><a href='" + sem_string + "?user=" + result[i].student.user_id + "&sem=" + sem_int + "' class='edit'><i class='fa fa-pencil-alt' data-toggle='tooltip' title='Edit'></i></a></td></tr>";
                        }
                        //console.log(output);
                    student.html(output);
                    }
            	});
			});	
		});
	</script>
</body>
</html>