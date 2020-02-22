$(document).ready(function(){
//	$('select.dropdown').dropdown();
	$('.ui.dropdown').dropdown();

	// multiple dropdown
	$('.ui.fluid.dropdown')
	  .dropdown({
	    maxSelections: 2
	  });
	
	var user_id = $('.profile').text().trim();
	
	// 시간표 DataTable
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
//	        console.log(json)
	
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
            { data: null,
            	render: function(data, row, type) {
//            		return 'add';
            		return '<button class="ui button" id="add_course">Add</button>';
            	}
            }
        ],
    });
	
	// 장바구니 DataTable
	var table2 = $('#shopping_list').DataTable( {
        lengthChange: false,
        oLanguage: {
        	sEmptyTable : 'Empty Shopping List'
        },
        pageLength: 2,
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
    		url: '/api/shopping/list',
    		data: {
    			'user_id' : user_id
    		},
			dataFilter: function(data) {
	        var json = jQuery.parseJSON(data);
	        console.log(json)
	
	         json.data = json.object.data;
	         json.recordsFiltered = json.object.recordsTotal;
	         json.recordsTotal = json.object.recordsTotal;
	         json.draw = json.draw;
	         
	         return JSON.stringify(json);
	        }
        },
        columns: [
            { data: "no" },
            { data: "lecture_name" },
            { data: "grade" },
            { data: "personnel" },
            { data: "lecture_time" },
            { data: "professor" },
            { data: "lecture_room" },
            { data: null,
            	render: function(data, row, type) {
            		return '<button class="ui button" id="delete_course">Delete</button>';
            	}
            }
        ],
    });
	
	// 강의 등록 
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
				table.ajax.reload();
			},
			complete : function() {
			}
		})
		
	});
	
	$('#add_course').click(function() {
		$('.ui.modal').modal('show');
	});
	 
	// 장바구니에 추가 
	$('#lecture_list').on( 'click', 'button', function () {
        var data = table.row( $(this).parents('tr') ).data();
//        console.log(data);
//        console.log(data.no);
        
        var user_id = $('.profile').text().trim();
//        console.log(user_id);
        
        $.ajax({
			url: '/api/shopping/addShopList',
			method: 'POST',
			data:{
				'user_id' : user_id,
				'no' : data.no
			},
			traditional : true,
			success: function(result) {
				table2.ajax.reload();
			},
			complete : function() {
			}
		});
    });
	
	// 장바구니 목록 제거 
	$('#shopping_list').on( 'click', 'button', function () {
        var data = table2.row( $(this).parents('tr') ).data();
        console.log(data);
        console.log(data.no);
        
        var user_id = $('.profile').text().trim();
        console.log(user_id);
        
        $.ajax({
			url: '/api/shopping/deleteShopList',
			method: 'POST',
			data:{
				'user_id' : user_id,
				'no' : data.no
			},
			traditional : true,
			success: function(result) {
				table2.ajax.reload();
			},
			complete : function() {
			}
		});
    });
});
