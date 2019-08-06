<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.box_coverage {
    width: 100%;
}
.container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
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
.bg_ul {
margin: 0px;
padding: 0px;
}
.menu_cate_list ul li {
    display: block;
    width: 100%;
    padding: 0px 15px;
    position: relative;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
}
.menu_cate_list ul li img {
    float: left;
    margin-right: 10px;
    margin-top: 7px;
    width: 25px;
}
img {
    max-width: 100%;
    vertical-align: middle;
    border: 0;
}
.menu_cate_list ul li a {
    display: block;
    font-family: 'Roboto', sans-serif;
    color: #000;
    font-size: 15px;
    line-height: 35px;
    text-decoration: none;
}
/* .menu_cate_list > ul > li> a:hover >#dien-thoai{
        display: block;
    } */
/* .menu_cate_list ul li:hover ul.sub_menu{
    background: aqua;
    display: block;
} */
.menu_cate_list ul li:hover ul.sub_menu {
 	 background: red; 
   display: block;
}
a, a:focus, a:hover {
    text-decoration: none;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}
a {
    color: #337ab7;
    text-decoration: none;
}
.menu_cate_list ul li a span {
    float: right;
    line-height: 35px;
}
.slide_coverage {
    margin: 29px 0 0 0;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
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
a.a_sub_menu {
    font-weight: normal !important;
    font-size: 14px !important;
    color: #333!important;
}

</style>
<jsp:include page="header.jsp"></jsp:include>
<div class="box_coverage">
	<div class="container">
		<div class="row">
			<div class=" col-md-3">
				<div class="menu_cate_list ">
					<ul class="dropdown-menua" style="padding: 0px;">
						<li data-submenu-id="dien-thoai"><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_1.png?1556003900830">
							<a href="/dien-thoai" class="maintainHover">Điện thoại<span
								class="fa fa-angle-right"></span></a>
							<ul class="sub_menu" id="dien-thoai"
								style="top: -1px; display: none; left: 261px; height: 241px;">
								<div class="bg_ul">
									<li><a class="a_sub_menu maintainHover"
										href="/iphone-xs-xs-max">iPhone XS/XR/XS Max</a></li>
									<li><a class="a_sub_menu maintainHover" href="/iphone-x">iPhone
											X</a></li>
									<li><a class="a_sub_menu maintainHover"
										href="/iphone-8-plus">Iphone 8/8 Plus</a></li>
									<li><a class="a_sub_menu maintainHover"
										href="/iphone-7-7plus">iPhone 7/7Plus</a></li>
									<li><a class="a_sub_menu maintainHover"
										href="/iphone-6s-plus">iPhone 6S/6S Plus</a></li>
									<li><a class="a_sub_menu maintainHover" href="/iphone-5s">iPhone
											5SE</a></li>
								</div>
							</ul></li>
						<li><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_2.png?1556003900830">
							<a href="/may-tinh-bang" class="">iPad and Smartwatch</a></li>
						<li data-submenu-id="linh-kien"><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_3.png?1556003900830">
							<a href="/linh-kien" class="">Linh Kiện<span
								class="fa fa-angle-right"></span></a>
							<ul class="sub_menu" id="linh-kien"
								style="top: -1px; display: none; left: 261px; height: 241px;">
								<div class="bg_ul">
									<li><a class="a_sub_menu" href="/pin-iphone-ipad">Pin</a>
									</li>
									<li><a class="a_sub_menu" href="/man-hinh-iphone-ipad">Màn
											hình</a></li>
								</div>
							</ul></li>
						<li><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_4.png?1556003900830">
							<a href="/bai-viet" class="">Hướng dẫn,thủ thuật</a></li>
						<li><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_5.png?1556003900830">
							<a href="http://facebook.com/hoangkien.co" class="">Facebook
								Fanpage</a></li>
						<li><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_6.png?1556003900830">
							<a href="https://www.youtube.com/hoangkienchannel" class="">Youtube
								Chanel</a></li>
						<li><img
							src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/menu_icon_7.png?1556003900830">
							<a href="/tong-hop-video-nhan-biet-iphone-zin-va-dung" class="">Video
								nhận biết iPhone Zin</a></li>
					</ul>
				</div>
			</div>
			<div class="slide_coverage col-md-9" style="display: none;">
				<div id="owl-demo-pc" class="owl-carousel owl-theme"
					style="opacity: 1; display: block;">
					<div class="owl-wrapper-outer">
						<div class="owl-wrapper"
							style="width: 5088px; left: 0px; display: block; transition: all 1000ms ease 0s; transform: translate3d(-848px, 0px, 0px);">
							<div class="owl-item" style="width: 848px;">
								<div class="item">
									<a href="http://www.hoangkien.com/dien-thoai"><img
										alt="Hoàng Kiên"
										src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/img_coverage1.jpg?1556003900830"></a>
								</div>
							</div>
							<div class="owl-item" style="width: 848px;">
								<div class="item">
									<a href="http://www.hoangkien.com/dien-thoai"><img
										alt="Hoàng Kiên"
										src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/img_coverage2.jpg?1556003900830"></a>
								</div>
							</div>
							<div class="owl-item" style="width: 848px;">
								<div class="item">
									<a href="http://www.hoangkien.com/dien-thoai"><img
										alt="Hoàng Kiên"
										src="//bizweb.dktcdn.net/100/112/815/themes/152840/assets/img_coverage3.jpg?1556003900830"></a>
								</div>
							</div>
						</div>
					</div>
					<div class="owl-controls clickable">
						<div class="owl-pagination">
							<div class="owl-page">
								<span class=""></span>
							</div>
							<div class="owl-page active">
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

<jsp:include page="footer.jsp" />
