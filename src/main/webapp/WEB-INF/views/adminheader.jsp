<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="common/taglibheader.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <script type="text/javascript"src="<c:url value="/resources/JS/dangky/dangky.js"/>"></script>
</head>
<body id="themtbody" style="background-color: darkgray">
	
	<dir id="headerchitietsp" class="container-fluid ">
		<nav class="navbar navbar-inverse none-nav">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">ADMIN</a>
		    </div>
		    <ul class="nav navbar-nav navbar-center">
		      <li class="active" id="danhmuc1"><a  href='<c:url value="/themdanhmuc" />'>Thêm Danh Muc</a></li>
		     <li id="sanpham1"><a href='<c:url value="/themsanpham"/>'>Thêm San Pham</a></li>
		     <li id="chitietsanpham1"><a href='<c:url value="/themchitietsanpham"/>'>Thêm Chi Tiet San Pham</a></li>
		      <li id="nhanvien1"><a href='<c:url value="/themnhanvien" />'>Them Nhan Vien</a></li>
		      <li id="hoadon1"><a href="#">Hoa Don</a></li>
		       <li id="khuyenmai1"><a href="#">Thêm Khuyen Mai</a></li>
		    </ul>
		    
		  </div>
		</nav>
	</dir>
	