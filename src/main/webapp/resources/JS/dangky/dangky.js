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
/*function on() {
	//document.getElementById("overlay").style.display = "none";
}

function off() {
//  document.getElementById("overlay").style.display = "none";
}*/
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
var maxn;
var s = null; // Giây
var timeout = null; // Timeout
function start()
{
    if(s===null){
    	s = parseInt(59);
    }
    if (s == -1){
    	authentic="";
    	document.getElementById('s').innerText = "";
        clearTimeout(timeout);
        return false;
    }
    document.getElementById('s').innerText = s.toString();
    timeout = setTimeout(function(){
        s--;
        start();
    }, 1000);
}

function btnSave1() {
	if ($("#first_name").val() == "") {
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
	}
	hoten = $("#last_name").val().trim() + " " + $("#first_name").val().trim();
	email = $("#email").val();
	matkhau = $("#creat_password").val();
	$("#btnxacnhan").css("display","block");
	$("#dataxacthuc").css("display","block");
	$("#btndangky").css("display","none");
	$("#datadangky").css("display","none");
	if (check == 1) {
		document.getElementById("overlay").style.display = "block";
		$.ajax({
			url : "/WebBanHang/xacthucmail",
			type : "POST",
			data : {
				email : email,
			},
			success : function(data) {
				if (data.status ==0) {
					document.getElementById("overlay").style.display = "none";
					alert(data.success);
					return;
				}else{
					authentic=data.check;
					document.getElementById("overlay").style.display = "none";
					start();
					$("#xacnhanchemail").html("<i>Mã xác thực đã được gửi đến email của bạn !</i>")
				}
			}
		})
	}
};
function sendxacnhan() {
		$.ajax({
			url : "/WebBanHang/xacthucmail",
			type : "POST",
			data : {
				email : email,
			},
			success : function(data) {
				if (data.status ==0) {
					alert(data.success);
					return;
				}else{
					start();
					authentic=data.check;
					$("#checkxacnhanchemail").css("display","none");
					$("#sendxacnhan").css("display","none");
					$("#xacnhanchemail").html("<i>Mã xác thực đã được gửi đến email của bạn !</i>");
				}
			}
		})
};
function btnxacnhan1() {
	if(authentic=="" || authentic== undefined){
		$("#xacnhanchemail").html("");
		$("#checkxacnhanchemail").css("display","block");
		$("#checkxacnhanchemail").html("<i>Mã xác thực không còn hiệu lực,click gửi lại mã để nhận mã mới !</i>");
		$("#sendxacnhan").css("display","block");
		return;
	}
	clearTimeout(timeout);
	maxn=$("#maxacnhan").val();
	$.ajax({
		url : "/WebBanHang/themthanhvien",
		type : "POST",
		data : {
			fullname :hoten,
			email:email,
			pass:matkhau,
			authentic:authentic,
		 maxn:maxn
		},
		success : function(data) {
			if (data.status ==0) {
				alert(data.success);
				return;
			}else{
				authentic=data.check;
				alert(data.success);
			}
		}
	})
}