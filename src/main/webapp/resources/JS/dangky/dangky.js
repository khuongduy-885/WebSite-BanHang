/*function isNumberKey(evt){
	var charCode = (evt.which) ? evt.which : event.keyCode;
	  if (charCode > 31 && (charCode > 57 || charCode < 48 )){
  return false;
	  }
};*/
/*function checknumber(){
 var vnf_regex = /(09|03|05|07)+([0-9]{8})\b/g;
 var phoneno = $("#sdt").val();
 if(vnf_regex.test(phoneno) == false){
 $("#checkusernumber").text("Sdt không đúng định dạng !");
 return;
 }else{
 $("#checkusernumber").text("");
 }
 if($("#sdt").val()!="" && $("#sdt").val()!=undefined){
 $("#checkusernumber").text("");
 }
 };*/
var check = 1;
function checkemail1() {
	var email = $("#email").val();
	var at = email.indexOf("@");
	var dot = email.lastIndexOf(".");
	var space = email.indexOf(" ");
	if ((at != -1) && // có ký tự @
	(at != 0) && // ký tự @ không nằm ở vị trí đầu
	(dot != -1) && // có ký tự .
	(dot > at + 1) && (dot < email.length - 1) // phải có ký tự nằm giữa @ và .
			// cuối cùng
			&& (space == -1)) // không có khoẳng trắng
	{
		$("#checkemail").html("");
		check = 1;
	} else {
		$("#checkemail").html("<i><p> Email khong hợp lệ !</p></i>");
		check = 2;
	}
}
function checkpass() {
	var pass = $("#creat_password").val().length;
	if (pass <= 8) {
		$("#checkcreat_password").html("<i><p>Mật khẩu > 8 ký tự !</p></i>");
		$("#creat_password1").disabled = true;
		check = 2;
	} else {
		$("#checkcreat_password").html("");
		$("#creat_password1").disabled = false;
		check = 1;
	}

};
function checkenterpass() {
	var pass = $("#creat_password").val();
	var enterpass = $("#creat_password1").val();
	if (enterpass == pass) {
		$("#checkcreat_password").text("");
		check = 1;
	} else {
		$("#checkcreat_password").html(
				"<i><p>Mật khẩu Không khới nhau !</p></i>");
		check = 2;
	}

}
var hoten;
var email;
var matkhau;
var authentic;
function btnSave1() {
	/*if ($("#first_name").val() == "") {
		$("#checkfirst_name").html("<i>*Họ tên không được để trống !</i>");
		check = 2;
		return;
	}
	if ($("#email").val() == "") {
		$("#checkemail").text("*Email k duoc de trong !");
		check = 2;
		return;
	}
	if ($("#creat_password").val() == "") {
		$("#checkcreat_password").text("*Mật khẩu khong duoc de trong !");
		check = 2;
		return;
	}
	if ($("#creat_password1").val() == "") {
		$("#checkcreat_password").text("*Mật khẩu khong duoc de trong !");
		check = 2;
		return;
	}*/
	$("#btnxacnhan").css("display","block");
	$("#dataxacthuc").css("display","block");
	$("#btndangky").css("display","none");
	$("#datadangky").css("display","none");
	hoten = $("#last_name").val().trim() + " " + $("#first_name").val().trim();
	email = $("#email").val();
	matkhau = $("#creat_password").val();

	/*if (check == 1) {*/
		$.ajax({
			url : "/WebBanHang/xacthucmail",
			type : "POST",
			data : {
				email : email,
			},
			success : function(data) {
				if (data.status ==0) {
					alert(data);
					return;
				}else{
					authentic=data.check;
					$("#xacnhanchemail").html("<i>Mã xác thực đã được gửi đến email của bạn !</i>")
				}
			}
		})
//	}
};
function btnxacnhan() {
	$.ajax({
		url : "/WebBanHang/themthanhvien",
		type : "POST",
		data : {
			
		},
		success : function(data) {
			if (data === "đang ky thành công") {
				alert(data);
				window.location = "/WebBanHang/login";
			} else {
				alert(data);
				location.reload();
			}
		}
	})
}