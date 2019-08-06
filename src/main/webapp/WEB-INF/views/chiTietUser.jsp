<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<style>
.block .block-title {
    border-bottom: 2px solid #ddd;
    color: #000;
    font-family: 'Open Sans';
    font-size: 14px;
    font-weight: bold;
    height: 30px;
    letter-spacing: 0.5px;
    margin: 0;
    text-transform: uppercase;
}
	.block {
    margin: 35px 0px;
    float: right;
    width: 100%;
}
.block-account .block-content {
    padding: 0 10px;
    background-color: #f7f7f7;
}
.block-account .block-content ul {
    margin-top: 5px;
    margin-bottom: 5px;
    list-style: none;
    margin: 0px;
    padding: 0px;
}
.sidebar .block-content li.current {
    font-weight: bold;
    color: #333;
}
.block-account .block-content li:first-child {
    border-top: none;
}
.block-account .block-content li {
    padding: 10px 0px;
    border-top: 1px #fff solid;
    border-bottom: 1px #ddd solid;
}
.block-account .block-content li a {
    cursor: pointer;
    padding: 0 12px;
    color: #777;
    transition: color 300ms ease-in-out 0s, background-color 300ms ease-in-out 0s, background-position 300ms ease-in-out 0s;
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
a {
    background-color: transparent;
}
.block .block-title span {
    border-bottom: 2px solid #7bbd42;
    display: inline-block;
    height: 30px;
    font-family: 'Roboto', sans-serif;
}
.block .block-title span {
    border-bottom: 2px solid #7bbd42;
    display: inline-block;
    height: 30px;
}
</style>
<div class="box_coverage">
	<div class="container">
			<!-- <dir id="dangnhap1-longin">
								<form >
				<input id="username" name="username" class="texinputemail"
					type="text" placeholder="Username" />
				<br />
				<input id="pass" name="pass" class="texinputpass" type="password"
					placeholder="password" />
				<br />
				<input id="btndangnhap" class="submitinput" type="submit"
					value="Dang Nhap" />
				<br />
				<br />
				<span id="ketqua" style="color: red;"></span>
			</dir> -->
			<div class="row">
				<section class="col-main col-sm-9">
					<div class="my-account">
						<div class="page-title">
							<h2>Thông tin địa chỉ</h2>
						</div>
						<div class="dashboard">
							<div class="welcome-msg">
								<strong>Xin chào, tran khuong duy!</strong>
								<p>Cập nhật thông tin tài khoản của bạn để hưởng các chính
									sách của cửa hàng vào chế độ bảo mật tốt nhất</p>
							</div>
							<div class="recent-orders">
								<div class="title-buttons" style="margin-bottom: 10px;">
									<strong>Thông tin đơn hàng</strong>
								</div>
								<div class="table-account">
									<table class="shop_table" style="width: 100%;">
										<thead>
											<tr>
												<th class="product-image">Đơn hàng</th>
												<th class="name">Thời gian</th>
												<th class="porduct-quantity">Vận chuyển</th>
												<th class="product-price">Tổng tiền</th>
												<th class="product-total">Lời nhắn</th>
											</tr>
										</thead>
										<tbody>
											<tr class="first odd">
												<td><p>Không có đơn hàng nào.</p></td>
											</tr>
										</tbody>
									</table>
								</div>
								<button
									style="float: right; margin: 10px 0px; background: #e24d85; color: #fff; padding: 10px 15px; font-weight: bold;"
									onclick="window.location.href='/account/addresses'"
									class="btn tz-view-more2 tz-view-style2" type="button">
									<span>Thông tin địa chỉ</span>
								</button>
							</div>
						</div>
					</div>
				</section>
				<aside class="col-right sidebar col-sm-3">
					<div class="block block-account">
						<div class="block-title">
							<span>Tài khoản của tôi</span>
						</div>
						<div class="block-content">
							<ul>
								<li class="current"><a>Tên tài khoản: tran khuong duy</a></li>
								<li><a style="padding: 5px 15px;" href="/account/addresses"
									class="button">Sổ địa chỉ (0)</a></li>
							</ul>
						</div>
					</div>
				</aside>
			</div>
			<!-- 		</form>  -->
		</div>
	</div>

<jsp:include page="footer.jsp" />
