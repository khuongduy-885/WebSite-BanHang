<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js sb-init" lang="vi">
<head>
<jsp:include page="common/taglibheader.jsp" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.top_menu {
	background: #05b2e9;
	margin-bottom: 10px;
}

.menu-left {
	padding-top: 3px;
	color: #FFF;
}

.top_menu ul {
	margin: 0;
	text-align: right;
}

.top_menu li {
	display: inline-block;
	padding: 3px 0 3px 10px;
}

.top_menu li a {
	color: #FFF;
}

.top_menu li a:hover {
	background-color: cornflowerblue;
	text-decoration: none;
}

.top_header {
	width: 100%;
	padding: 7px 0px;
}

.nav_main_menu {
	line-height: 52px;
	width: 100%;
	cursor: pointer;
}

.row {
	margin-right: -15px;
	margin-left: -15px;
}

.main-service>.row {
	margin: 0px -5px;
}

.main-service p {
	margin: 0;
	color: #484848;
	font-size: 12.5px;
	padding: 0px;
}

p {
	display: block;
	margin-block-start: 1em;
	margin-block-end: 1em;
	margin-inline-start: 0px;
	margin-inline-end: 0px;
	width: 167px;
}

.btn_menu_cate {
	font-size: 17px;
	border: 1px solid #e8e8e8;
	font-family: 'Roboto', sans-serif;
	height: 52px;
	-webkit-border-radius: 3px 3px 0 0;
	-moz-border-radius: 3px 3px 0 0;
	border-radius: 3px 3px 0 0;
	padding-left: 20px;
}

.fa {
	display: inline-block;
	font: normal normal normal 14px/1 FontAwesome;
	font-size: inherit;
	text-rendering: auto;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

.main-service p a {
	color: #484848;
	font-weight: bold;
}

a, a:focus, a:hover {
	text-decoration: none;
	-webkit-transition: all 0.3s ease-in-out;
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
}

.box_account {
	margin: 6px 0px;
	padding-right: 3px;
	font-family: 'Roboto', sans-serif;
}

.box_cart {
	text-align: center;
	font-family: 'Roboto', sans-serif;
	padding-left: 0px;
	padding-right: 0px;
	margin: 6px 0px;
	line-height: 37px;
}

.input-search-pc {
	width: 100%;
	min-height: 38px;
	margin: 6px 0px;
	padding-left: 15px;
	border: 1px solid #eee;
	color: #999;
}

* {
	margin: 0;
	padding: 0;
}

.btn-search-pc {
	position: absolute;
	right: 15px;
	top: 11%;
	color: #000 !important;
	width: initial !important;
	border-left: 0px !important;
	background: #05b2e9;
	height: 38px !important;
	width: 42px !important;
	text-align: center;
	color: #fff !important;
}

.box_cart a {
	font-size: 23px;
	color: #888;
	position: relative;
}

.box_account a {
	font-size: 13.5px;
	color: #484848;
	position: relative;
	padding-right: 10px;
}

.box_cart #cart-total {
	font-size: 12px;
	padding: 3px;
	background-color: #f00;
	color: #fff;
	border-radius: 4px;
	line-height: 10px;
	position: absolute;
}

.cart_st span {
	position: absolute;
	padding: 1px 5px;
	background-color: #e57368;
	font-size: 11px;
	color: #fff;
	border-radius: 50%;
}

.box_coverage {
	width: 100%;
}

.container {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

.row {
	margin-right: -15px;
	margin-left: -15px;
}

.menu_cate_hide {
	position: absolute;
	width: 90%;
	z-index: 9999;
}

.menu_cate_list {
	border: 1px solid #e8e8e8;
	border-bottom-left-radius: 3px;
	border-bottom-right-radius: 3px;
	width: 100%;
	position: relative;
	z-index: 999;
	text-align: left;
	background-color: #fff;
	border-top: 0px;
	min-height: 434px;
	padding-top: 15px;
}

.menu_cate_list ul {
	list-style: none;
	margin-bottom: 0px;
}

ul {
	display: block;
	list-style-type: disc;
	margin-block-start: 1em;
	margin-block-end: 1em;
	margin-inline-start: 0px;
	margin-inline-end: 0px;
	padding-inline-start: 40px;
}

.menu_cate_list ul li img {
	float: left;
	margin-right: 10px;
	margin-top: 7px;
	width: 25px;
}

.menu_cate_list ul li a {
	display: block;
	font-family: 'Roboto', sans-serif;
	color: #000;
	font-size: 15px;
	line-height: 35px;
	text-decoration: none;
}

ul.sub_menu {
	position: absolute;
	left: 100%;
	min-width: 100%;
	height: auto !important;
	top: -1px;
	margin: 0px;
	background-color: #fff;
	box-shadow: 0px 1px 6px -2px;
	display: none;
}

.sub_menu li {
	display: block;
	margin: 0px;
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<dir">
		<div class="top_menu">
			<div class="container">
				<div class="col-md-7 menu-left">
					<a href="">Apple Store</a> 284 Xã Đàn - 95/208 Nguyễn Văn Cừ, Hà
					Nội - 786 Điện Biên Phủ - P.10, Q.10 Tp.HCM
				</div>
				<div class="col-md-5">
					<ul>

						<li><a href="/">Trang chủ</a></li>

						<li><a href="/bai-viet">Thủ thuật</a></li>

						<li><a href="/lien-he">Liên hệ</a></li>

						<li><a href="/apps/stream">Mạng Xã Hội</a></li>

					</ul>
				</div>
			</div>
		</div>
		<div class="top_header">
			<div class="container">
				<div class="row">
					<div class="logo_pc col-md-3">
						<a href="//www.hoangkien.com"> <img alt="Hoàng Kiên"
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/logo.png?1556003900830"
							width="100%">

						</a>
					</div>
					<div class=" col-md-6">
						<div class="form_search_pc">
							<form action="/search" method="get">
								<input type="text" placeholder="Tìm kiếm..." name="query"
									value="" maxlength="70" class="input-search-pc"> <input
									class="hidden" type="submit" value="">
								<button style="border: none;" type="submit"
									class="btn-search-pc">
									<span class="fa fa-search"></span>
								</button>
							</form>
						</div>
					</div>
					<div class="box_account col-md-2">

						<a href='<c:url value="/login"/>'> <b>Đăng nhập</b><br> <span>Tài
								khoản &amp; Đơn hàng</span> <i class="fa fa-sort-desc"></i>
						</a>

					</div>
					<div class="box_cart col-md-1">
						<a href="/cart" class="cart_st"> <span id="cart-total">0</span>
							<i class="fa fa-shopping-cart"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="box_coverage">
			<div class="container">
				<div class="row">
					<div class=" col-md-3">
						<div class="menu_cate_list  menu_cate_hide "
							style="display: none;">
							<ul class="dropdown-menua">
								<li data-submenu-id="dien-thoai"><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_1.png?1564557523038">
									<a href="/dien-thoai">Điện thoại<span
										class="fa fa-angle-right"></span></a>
									<ul class="sub_menu" id="dien-thoai">
										<div class="bg_ul">
											<li><a class="a_sub_menu" href="/iphone-xs-xs-max">iPhone
													XS/XR/XS Max</a></li>
											<li><a class="a_sub_menu" href="/iphone-x">iPhone X</a>
											</li>
											<li><a class="a_sub_menu" href="/iphone-8-plus">Iphone
													8/8 Plus</a></li>
											<li><a class="a_sub_menu" href="/iphone-7-7plus">iPhone
													7/7Plus</a></li>
											<li><a class="a_sub_menu" href="/iphone-6s-plus">iPhone
													6S/6S Plus</a></li>
											<li><a class="a_sub_menu" href="/iphone-5s">iPhone
													5SE</a></li>
										</div>
									</ul></li>
								<li><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_2.png?1564557523038">
									<a href="/may-tinh-bang">iPad and Smartwatch</a></li>
								<li data-submenu-id="linh-kien"><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_3.png?1564557523038">
									<a href="/linh-kien">Linh Kiện<span
										class="fa fa-angle-right"></span></a>
									<ul class="sub_menu" id="linh-kien">
										<div class="bg_ul">
											<li><a class="a_sub_menu" href="/pin-iphone-ipad">Pin</a>
											</li>
											<li><a class="a_sub_menu" href="/man-hinh-iphone-ipad">Màn
													hình</a></li>
										</div>
									</ul></li>
								<li><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_4.png?1564557523038">
									<a href="/bai-viet">Hướng dẫn,thủ thuật</a></li>
								<li><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_5.png?1564557523038">
									<a href="http://facebook.com/hoangkien.co">Facebook Fanpage</a></li>
								<li><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_6.png?1564557523038">
									<a href="https://www.youtube.com/hoangkienchannel">Youtube
										Chanel</a></li>
								<li><img
									src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_7.png?1564557523038">
									<a href="/tong-hop-video-nhan-biet-iphone-zin-va-dung">Video
										nhận biết iPhone Zin</a></li>
							</ul>
						</div>
					</div>
					<div class="slide_coverage col-md-9" style="display: none;">
						<div id="owl-demo-pc" class="owl-carousel owl-theme"
							style="opacity: 0; display: block;">
							<div class="owl-wrapper-outer">
								<div class="owl-wrapper"
									style="width: 600px; left: 0px; display: block;">
									<div class="owl-item" style="width: 100px;">
										<div class="item">
											<a href="http://www.hoangkien.com/dien-thoai"><img
												alt="Hoàng Kiên"
												src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/img_coverage1.jpg?1564557523038"></a>
										</div>
									</div>
									<div class="owl-item" style="width: 100px;">
										<div class="item">
											<a href="http://www.hoangkien.com/dien-thoai"><img
												alt="Hoàng Kiên"
												src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/img_coverage2.jpg?1564557523038"></a>
										</div>
									</div>
									<div class="owl-item" style="width: 100px;">
										<div class="item">
											<a href="http://www.hoangkien.com/dien-thoai"><img
												alt="Hoàng Kiên"
												src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/img_coverage3.jpg?1564557523038"></a>
										</div>
									</div>
								</div>
							</div>


							<div class="owl-controls clickable">
								<div class="owl-pagination">
									<div class="owl-page active">
										<span class=""></span>
									</div>
									<div class="owl-page">
										<span class=""></span>
									</div>
									<div class="owl-page">
										<span class=""></span>
									</div>
								</div>
								<div class="owl-buttons">
									<div class="owl-prev">prev</div>
									<div class="owl-next">next</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="nav_main_menu"
			style="webkit-box-shadow: 0 8px 6px -6px #666; -moz-box-shadow: 0 8px 6px -6px #666; box-shadow: 0 8px 6px -10px #666;">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="btn_menu_cate"
							style="padding: 0px; padding-left: 10%;">
							<span style="font-weight: bolder;"> <i class="fa fa-bars"></i>TẤT
								CẢ DANH MỤC
							</span>
						</div>
					</div>
					<div class="main_menu col-md-9">
						<div class="main-service hidden-sm hidden-xs">
							<div class="row">
								<div class="col-md-2" style="width: 167px; text-align: center;">
									<p>
										<a
											href="http://hoangkien.com/chinh-sach-bao-hanh-12-thang-1-doi-1"><i
											class="fa fa-refresh"></i> Bảo hành 1 năm 1 đổi 1</a>
									</p>
								</div>
								<div class="col-md-2" style="width: 167px; text-align: center;">
									<p>
										<a href="http://www.hoangkien.com/chinh-sach-tra-gop"><i
											class="fa fa-life-ring"></i> Hỗ trợ trả góp 0%</a>
									</p>
								</div>
								<div class="col-md-3" style="width: 167px; text-align: center;">
									<p>
										<a href="http://www.hoangkien.com/cam-ket-chat-luong"><i
											class="fa fa-check"></i> Sản phẩm chính hãng</a>
									</p>
								</div>
								<div class="col-md-2" style="width: 167px; text-align: center;">
									<p>
										<a href="http://www.hoangkien.com/phuong-thuc-van-chuyen"><i
											class="fa fa-truck"></i> Vận chuyển miễn phí</a>
									</p>
								</div>
								<div class="col-md-3 hotline"
									style="width: 167px; text-align: center;">
									<p>
										<img
											src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/icon-phone.png?1556003900830">Hotline:
										1900.988.913
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</dir>