$(document).ready(function(){
	
//	$('#lecture_list').DataTable();
	
	$.ajax({
		type:'POST',
		url: '/api/lecture/list',
//		data: {
//			id: id,
//			pw: pw
//		},
		success: function (result) {
			console.log(result);
			if(result.status == true) {
//				alert('login success');
//				location.href = result.object;
			} else {
				alert(result.message);
			}
		}
	});
	
    var table = $('#lecture_list').DataTable( {
        lengthChange: false,
        ajax : {
    		type:'POST',
    		url: '/api/lecture/list',
//    		data: {
//    			id: id,
//    			pw: pw
//    		},
    		success: function (result) {
    			console.log(result);
    			if(result.status == true) {
//    				alert('login success');
//    				location.href = result.object;
    			} else {
    				alert(result.message);
    			}
    		}
        },
        columns: [
            { data: null, render: function ( data, type, row ) {
                // Combine the first and last names into a single table field
                return data.first_name+' '+data.last_name;
            } },
            { data: "position" },
            { data: "office" },
            { data: "extn" },
            { data: "start_date" },
            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
        ],
        select: true
    } );
	
});