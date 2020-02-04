$(document).ready(function(){
//	$('select.dropdown').dropdown();
	$('.ui.dropdown').dropdown();
	
	// multiple dropdown
	$('.ui.fluid.dropdown')
	  .dropdown({
	    maxSelections: 2
	  });
	
	$('#add_btn').click(function() {
		var a = $('input[name=lecture_name]').val();
		console.log(a);
		var a = $('input[name=grade]').val();
		console.log(a);
		var a = $('input[name=personnel]').val();
		console.log(a);
		var a = $('select[name=lecture_time]').val();
		console.log(a);
		var a = $('input[name=professor]').val();
		console.log(a);
		var a = $('select[name=lecture_room]').val();
		console.log(a);
		
		
//		$.ajax({
//			url: '/api/lecture/addCourse',
//			method: 'POST',
//			data:{
//				
//			}
//		})
		
	});
	 
//	$('#lecture_list').DataTable();
	
    var table = $('#lecture_list').DataTable( {
        lengthChange: false,
        pageLength: 5,
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
		
   
});