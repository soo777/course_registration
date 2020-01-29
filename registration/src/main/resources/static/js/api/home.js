$(document).ready(function(){
	
//	$('#lecture_list').DataTable();
	
//	$.ajax({
//		type:'POST',
//		url: '/api/lecture/list',
//		success: function (result) {
//			console.log(result);
//			if(result.status == true) {
//			} else {
//				alert(result.message);
//			}
//		}
//	});
	
    var table = $('#lecture_list').DataTable( {
        lengthChange: false,
        ajax : {
    		type:'POST',
    		url: '/api/lecture/list',
			dataFilter: function(data) {
	        var json = jQuery.parseJSON(data);
	
	         json.data = json.object.data;
	         json.recordsFiltered = json.object.recordsTotal;
	         json.recordsTotal = json.object.recordsTotal;
	         json.draw = json.draw;
	         	
	         console.log(json);
	         
	         return JSON.stringify(json);
	        }
//    		success: function (result) {
//    			console.log(result);
//    			if(result.status == true) {
//    			} else {
//    				alert(result.message);
//    			}
//    		}
        },
//        columns: [
//            { data: null, render: function ( data, type, row ) {
//                // Combine the first and last names into a single table field
//                return data.first_name+' '+data.last_name;
//            } },
//            { data: "position" },
//            { data: "office" },
//            { data: "extn" },
//            { data: "start_date" },
//            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
//        ],
        select: true
    } );
	
});