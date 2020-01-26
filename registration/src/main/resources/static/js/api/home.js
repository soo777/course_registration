$(document).ready(function(){
	
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
	
	
});