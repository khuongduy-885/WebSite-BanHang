$(document).ready(function(){
	$("#cot1").click(function(){
		alert("hello");
	});
	
	$("#btndangnhap").click(function(){
		var username=$("#username").val();
		var pass=$("#pass").val();
		$.ajax({
			url:"/testweb/api/KiemTraDangNhap",
			type:"Get",
			data:{
				username:username,
				pass:pass
			},
			success: function(value){
			if(value.username != null && value.idrole == 2 ){
				duongdanhientai=window.location.href;
				duongdan=duongdanhientai.replace("login","");
				window.location=duongdan;
				
			}else if(value.username != null && value.idrole == 1 ){
				duongdanhientai=window.location.href;
				duongdan=duongdanhientai.replace("login","themdanhmuc");
				window.location=duongdan;
			}else {
				$("#ketqua").text("sai ten dang nhap hoac mat khau !");

			}
		}
		})
		
	});
	
//	$("#btndangky").click(function(event){
//		event.preventDefault();
//		var formdata=$("#formdangky").serializeArray();
//		json={};
//		$.each(formdata,function(i,field){
//			json[field.name]=field.value;
//		});
//		console.log(json);
//		$.ajax({
//			url:"/testweb/api/dangky",
//			type:"POST",
//			data:{
//				datajson:JSON.stringify(json)
//			},
//			success: function(value){
//				if(value== true){
//					alert("khong hop le k them dk !");
//				}else{
//					alert("thanh cong !");
//					$("#btncapnhat-sanpham").addClass("empty");
//					$("#btnthoat-sanpham").addClass("empty");
//					$("#btnthem-sanpham").removeClass("empty");
//					$("#tensanpham").val("");
//					$("#giatien").val("");
//					$("#tinhtrang").val("");
//					$("#cauhinhmay").val("");
//					$("#ngaynhap").val("");
//					$("#contenchitiet").html("");
//					var chitietlor=$("#themchitiet-sanpham").clone().removeAttr("id");
//					$("#contenchitiet").append(chitietlor);
//				}
//			}
//			})
		
//	});
	
	//----------------------danhmuc
	
	$("#btnthem-danhmuc").click(function(event){
		event.preventDefault();
		var tendanhmuc=$("#tendanhmuc").val();
		$.ajax({
			url:"/testweb/api/themdanhmuc",
			type:"POST",
			data:{
				tendanhmuc:tendanhmuc
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					$("#tendanhmuc").val("");
				}
			}
			})
	});
	$("#checkboxall").change(function(){
		
		if(this.checked){
			$("#tablethem-danhmuc input").each(function(){
				$(this).attr("checked",true);
			})
		}else{
			$("#tablethem-danhmuc input").each(function(){
				$(this).attr("checked",false);
			})
		}
	});
	$("#btnxoa-danhmuc").click(function(){
		
		$("#tablethem-danhmuc input:checked").each(function(){
			var madanhmuc= $(this).val();
			var self=$(this);
			$.ajax({
				url:"/testweb/api/xoadanhmuctheoma",
				type:"Get",
				data:{
					madanhmuc:madanhmuc
				},
				success: function(value){
					self.closest("tr").remove();
				}
			})
		})
	});
	var madanhmuc="";
	$("body").on("click",".btnsua-danhmuc",function(){
		$("#btncapnhat-danhmuc").removeClass("empty");
		$("#btnthoat-danhmuc").removeClass("empty");
		$("#btnthem-danhmuc").addClass("empty");
		madanhmuc=$(this).attr("data-madanhmuc");
		$.ajax({
			url:"/testweb/api/laydanhmuctheoma",
			type:"POST",
			data:{
				madanhmuc:madanhmuc
			},
			success: function(value){
				$("#tendanhmuc").val(value.tendanhmuc);
				
				
			}
		})
	});
	$("#btnthoat-danhmuc").click(function(){
		$("#btncapnhat-danhmuc").addClass("empty");
		$("#btnthoat-danhmuc").addClass("empty");
		$("#btnthem-danhmuc").removeClass("empty");
		$("#tendanhmuc").val("");
	})
	$("#btncapnhat-danhmuc").click(function(event){
		event.preventDefault();
		var tendanhmuc=$("#tendanhmuc").val();
		madm=madanhmuc;
		$.ajax({
			url:"/testweb/api/updatedanhmuc",
			type:"POST",
			data:{
				tendanhmuc:tendanhmuc,
				madanhmuc:madm
				
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					$("#tendanhmuc").val("");
				}
			}
			})
		
	});
	//--------------------uploadfile
	var files = [];
	var hinhanh="";
	$("#hinhanh").change(function(event){
		files = event.target.files;
		hinhanh=files[0].name;
		forms = new FormData();
		forms.append("file",files[0]);
		
		$.ajax({
			url:"/testweb/api/uploadfile",
			type:"POST",
			data:forms,
			contentType: false,
			processData: false,
			enctype: "multipart/form-data",
			success: function(value){

			}
			})
	});
	
//	-----------------------------------------	phan trang
//	$("body").on("click",".paging-iteam",function(){
//		var sotrang=$(this).text();
//		var spbatdau= (sotrang-1)*5;
//
//		$.ajax({
//			url:"/testweb/api/LaySanPhamLimit",
//			type:"Get",
//			data:{
//				spbatdau:spbatdau
//			},
//			success: function(value){
//				var tbodysanpham= $("#tablethem-sanpham").find("tbody");
//				tbodysanpham.empty();
//				tbodysanpham.append(value);
//			}
//			})
//	});
	//----------------------sanpham
	$("#checkall").change(function(){
		
		if(this.checked){
			$("#tablethem-sanpham input").each(function(){
				$(this).attr("checked",true);
			})
		}else{
			$("#tablethem-sanpham input").each(function(){
				$(this).attr("checked",false);
			})
		}
	});
	$("#btnxoa-sanpham").click(function(){
		
		$("#tablethem-sanpham input:checked").each(function(){
			var masanpham= $(this).val();
			var self=$(this);
			$.ajax({
				url:"/testweb/api/xoasanphamtheoma",
				type:"Get",
				data:{
					masanpham:masanpham
				},
				success: function(value){
					self.closest("tr").remove();
				}
			})
		})
	});
	
	$("body").on("click",".btnthem-chitiet",function(){
		$(this).remove();
		var chitietlor=$("#themchitiet-sanpham").clone().removeAttr("id");
		$("#contenchitiet").append(chitietlor);
	});
	
	$("#btnthem-sanpham").click(function(event){
		event.preventDefault();
		var formdata=$("#formdatasanpham").serializeArray();
		json={};
		$.each(formdata,function(i,field){
			json[field.name]=field.value;
		});
		json["hinhanh"]=hinhanh;
		console.log(json);
		$.ajax({
			url:"/testweb/api/themsanpham",
			type:"POST",
			data:{
				datajson:JSON.stringify(json)
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					$("#btncapnhat-sanpham").addClass("empty");
					$("#btnthoat-sanpham").addClass("empty");
					$("#btnthem-sanpham").removeClass("empty");
					$("#tensanpham").val("");
					$("#giatien").val("");
					$("#tinhtrang").val("");
					$("#cauhinhmay").val("");
					$("#ngaynhap").val("");
				}
			}
			})
		
	});
	
	$("#btnthoat-sanpham").click(function(){
		$("#btncapnhat-sanpham").addClass("empty");
		$("#btnthoat-sanpham").addClass("empty");
		$("#btnthem-sanpham").removeClass("empty");
		$("#tensanpham").val("");
		$("#giatien").val("");
		$("#tinhtrang").val("");
		$("#cauhinhmay").val("");
		$("#ngaynhap").val("");
	});
		
	var masanpham="";
	$("body").on("click",".btnsua-sanpham",function(){
		$("#btncapnhat-sanpham").removeClass("empty");
		$("#btnthoat-sanpham").removeClass("empty");
		$("#btnthem-sanpham").addClass("empty");
		masanpham=$(this).attr("data-sua");
	$.ajax({
		url:"/testweb/api/laysanphamtheoma",
		type:"POST",
		data:{
			masanpham:masanpham
		},
		success: function(value){
			$("#tensanpham").val(value.tensanpham);
			$("#giatien").val(value.giatien);
			$("#tinhtrang").val(value.tinhtrang);
			$("#cauhinhmay").val(value.cauhinhmay);
			$("#ngaynhap").val(value.ngaynhap);
//			$("#hinhanh").val(value.hinhanh);
			$("#danhmucsanpham").val(value.madanhmuc);
		}
	})
});
	$("#btncapnhat-sanpham").click(function(){
		event.preventDefault();
		
		var formdata=$("#formdatasanpham").serializeArray();
		json={};
		$.each(formdata,function(i,field){
			json[field.name]=field.value;
		});
		json["hinhanh"]=hinhanh;
		json["masanpham"]=masanpham;
		console.log(json);
		$.ajax({
			url:"/testweb/api/capnhatsanpham",
			type:"POST",
			data:{
				datajson:JSON.stringify(json)
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					$("#btncapnhat-sanpham").addClass("empty");
					$("#btnthoat-sanpham").addClass("empty");
					$("#btnthem-sanpham").removeClass("empty");
					$("#tensanpham").val("");
					$("#giatien").val("");
					$("#tinhtrang").val("");
					$("#cauhinhmay").val("");
					$("#ngaynhap").val("");
				}
			}
			})
		
	});
	//-------------------------chitietsanpham-------
	$("#btnthem-ctsanpham").click(function(){
		event.preventDefault();
		var formdata=$("#formdatactsanpham").serializeArray();
		json={};
		arraychitiet=[];
		$.each(formdata,function(i,field){
			json[field.name]=field.value;
		});
		$("#contenchitiet > .themchitiet-ctsanpham").each(function(){
			objectchitiet={};
			var masanpham= $(this).find("#masanpham").val();
			var soluong= $(this).find("#soluong").val();
			var mau= $(this).find("#mau").val();
			
			objectchitiet["masanpham"]=masanpham;
			objectchitiet["mau"]=mau;
			objectchitiet["soluong"]=soluong;
			arraychitiet.push(objectchitiet);
		});
		json["chitietsanpham"]= arraychitiet;
		console.log(json);
		$.ajax({
			url:"/testweb/api/themchitietsanpham",
			type:"POST",
			data:{
				datajson:JSON.stringify(json)
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					$("#contenchitiet").html("");
					var chitietlor=$("#themchitiet-sanpham").clone().removeAttr("id");
					$("#contenchitiet").append(chitietlor);
				}
			}
			})
		
	});

	$("#checkall").change(function(){	
		if(this.checked){
			$("#tablethem-ctsanpham input").each(function(){
				$(this).attr("checked",true);
			})
		}else{
			$("#tablethem-ctsanpham input").each(function(){
				$(this).attr("checked",false);
			})
		}
	});
	
$("#btnxoa-ctsanpham").click(function(){
		
		$("#tablethem-ctsanpham input:checked").each(function(){
			var machitietsanpham= $(this).val();
			var self=$(this);
			$.ajax({
				url:"/testweb/api/xoachitietsanpham",
				type:"Get",
				data:{
					machitietsanpham:machitietsanpham
				},
				success: function(value){
					self.closest("tr").remove();
				}
			})
		})
	});

	$("body").on("click","#btnthoat-ctsanpham",function(){
		$("#btncapnhat-ctsanpham").addClass("empty");
		$("#btnthoat-ctsanpham").addClass("empty");
		$("#btnthem-ctsanpham").removeClass("empty");
		$("#contenchitiet").html("");
		var chitietlor=$("#themchitiet-sanpham").clone().removeAttr("id");
		$("#contenchitiet").append(chitietlor);
	});
	var machitietsanpham="";
	$("body").on("click",".btnsua-ctsanpham",function(){
		$("#btncapnhat-ctsanpham").removeClass("empty");
		$("#btnthoat-ctsanpham").removeClass("empty");
		$("#btnthem-ctsanpham").addClass("empty");
		machitietsanpham=$(this).attr("data-sua");
		$.ajax({
			url:"/testweb/api/laychitietsanphamtheomact",
			type:"POST",
			data:{
				machitietsanpham:machitietsanpham
			},success: function(value){
					$("#masanpham").val(value.masanpham);
					$("#mau").val(value.mau);
					$("#soluong").val(value.soluong);
				}
		})
	});
	
	$("#btncapnhat-ctsanpham").click(function(){
		event.preventDefault();
		var formdata=$("#formdatactsanpham").serializeArray();
		json={};
		arraychitiet=[];
		$.each(formdata,function(i,field){
			json[field.name]=field.value;
		});
		$("#contenchitiet > .themchitiet-ctsanpham").each(function(){
			objectchitiet={};
			var masanpham= $(this).find("#masanpham").val();
			var soluong= $(this).find("#soluong").val();
			var mau= $(this).find("#mau").val();
			
			objectchitiet["masanpham"]=masanpham;
			objectchitiet["mau"]=mau;
			objectchitiet["soluong"]=soluong;
			arraychitiet.push(objectchitiet);
		});
		json["chitietsanpham"]= arraychitiet;
		json["machitietsanpham"]= machitietsanpham;
		console.log(json);
		$.ajax({
			url:"/testweb/api/capnhatchitietsanpham",
			type:"POST",
			data:{
				datajson:JSON.stringify(json)
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					$("#contenchitiet").html("");
					var chitietlor=$("#themchitiet-sanpham").clone().removeAttr("id");
					$("#contenchitiet").append(chitietlor);
				}
			}
			})
		
	});
	//--------------------------nhanvien------------------
	$("#btnthem-nhanvien").click(function(event){
		event.preventDefault();
		var formdata=$("#formdatanhanvien").serializeArray();
		json={};
		$.each(formdata,function(i,field){
			json[field.name]=field.value;
		});
		console.log(json);
		$.ajax({
			url:"/testweb/api/themnhanvien",
			type:"POST",
			data:{
				datajson:JSON.stringify(json)
			},
			success: function(value){
				if(value== true){
					alert("khong hop le k them dk !");
				}else{
					alert("thanh cong !");
					
				}
			}
			})
});
	$("#checkall").change(function(){	
		if(this.checked){
			$("#tablethem-nhanvien input").each(function(){
				$(this).attr("checked",true);
			})
		}else{
			$("#tablethem-nhanvien input").each(function(){
				$(this).attr("checked",false);
			})
		}
	});
$("#btnxoa-nhanvien").click(function(){
		
		$("#tablethem-nhanvien input:checked").each(function(){
			var userid= $(this).val();
			var self=$(this);
			$.ajax({
				url:"/testweb/api/xoanhanvien",
				type:"Get",
				data:{
					userid:userid
				},
				success: function(value){
					self.closest("tr").remove();
				}
			})
		})
	});
	
})	
		
		
