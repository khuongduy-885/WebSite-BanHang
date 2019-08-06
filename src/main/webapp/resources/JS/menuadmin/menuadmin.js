$(document).ready(function(){

	$(".sanpham1").on("click",function(){
		$("#danhmuc1").removeClass("active");
		$(this).addClass("active");
	});
	
	$("#chitietsanpham1").click(function(){
		$(this).addClass("active");
		$("#danhmuc1").removeClass("active");
	
	});
	
	$("#nhanvien1").click(function(){
		$("#danhmuc1").removeClass("active");
		$(this).addClass("active");
	});
	
	$("#hoadon1").click(function(){
		$("#danhmuc1").removeClass("active");
		$(this).addClass("active");
	});
	
	$("#khuyenmai1").click(function(){
		$("#danhmuc1").removeClass("active");
		$(this).addClass("active");
	});
})