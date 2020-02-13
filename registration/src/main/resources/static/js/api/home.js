$(document).ready(function(){
//	$('select.dropdown').dropdown();
	$('.ui.dropdown').dropdown();

	// multiple dropdown
	$('.ui.fluid.dropdown')
	  .dropdown({
	    maxSelections: 2
	  });
	
	var table = $('#lecture_list').DataTable( {
        lengthChange: false,
        pageLength: 10,
        pagingType: "full_numbers",
        searching: false,
        language: {
            "paginate": {
                "first": "<<",
                "previous": "<",
                "last": ">>",
                "next": ">"
            }
        },
        ajax : {
    		type:'POST',
    		url: '/api/lecture/list',
			dataFilter: function(data) {
	        var json = jQuery.parseJSON(data);
	
	         json.data = json.object.data;
	         json.recordsFiltered = json.object.recordsTotal;
	         json.recordsTotal = json.object.recordsTotal;
	         json.draw = json.draw;
	         
	         return JSON.stringify(json);
	        }
        },
        columns: [
            { data: "no" },
            { data: "lectureName" },
            { data: "grade" },
            { data: "personnel" },
            { data: "lectureTime" },
            { data: "professor" },
            { data: "lectureRoom" },
        ],
    });
	
	$('#add_btn').click(function() {
		var lecture_name = $('input[name=lecture_name]').val();
		console.log(lecture_name);
		var grade = $('input[name=grade]').val();
		console.log(grade);
		var personnel = $('input[name=personnel]').val();
		console.log(personnel);
		var lecture_time = $('select[name=lecture_time]').val();
		console.log(lecture_time);
		var professor = $('input[name=professor]').val();
		console.log(professor);
		var lecture_room = $('select[name=lecture_room]').val();
		console.log(lecture_room);
		
		
		$.ajax({
			url: '/api/lecture/addCourse',
			method: 'POST',
			data:{
				'lecture_name' : lecture_name,
				'grade' : grade,
				'personnel' : personnel,
				'lecture_time' : lecture_time,
				'professor' : professor,
				'lecture_room' : lecture_room
			},
			traditional : true,
			success: function(result) {
				console.log(result);
			},
			complete : function() {
				
			}
		})
		
	});
	
	$('#add_course').click(function() {
		$('.ui.modal').modal('show');
	});
	 
//	$('#lecture_list').DataTable();
	
   
});