
function btnSave1() {
	pass = $("#pass").val();
	email = $("#email").val();
		$.ajax({
			url : "/WebBanHang/checklogin",
			type : "POST",
			data : {
				email : email,
				pass:pass,
			},
			success : function(data) {
					if (data.status ==0) {
						alert(data.success);
					}else{
						alert(data.success);
					}
				}
		})
};
