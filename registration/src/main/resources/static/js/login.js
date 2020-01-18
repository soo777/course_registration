$(document).ready(function(){
	
	$('#btn_login').click(function() {
		
		var id = $('input[name=id]').val();
		var pw = $('input[name=pw]').val();
		
		$.ajax({
			type:'POST',
			url: '/api/user/login',
			data: {
				id: id,
				pw: pw
			},
			success: function (result) {
				console.log(result);
				if(result.status == true) {
					alert('login success');
					location.href = result.object;
				} else {
					alert(result.message);
				}
			}
		});
	})
	
});