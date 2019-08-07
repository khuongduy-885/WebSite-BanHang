<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<%-- <script type="text/javascript"
	src="<c:url value="/JS/dangky/dangky.js"/>"></script> --%>
<script type="text/javascript"
	src="<c:url value="/resources/JS/dangky/dangky.js"/>"></script>
<style>
.container {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

.mar15 {
	margin-top: 30px;
	width: 100%;
}

.register {
	padding: 30px;
	background-color: #f8f8f8;
	margin: 30px 0px;
}

.title_cart h2 {
	margin-top: 15px;
	margin-bottom: 15px;
	font-family: 'Roboto', sans-serif;
	font-size: 20px;
	text-transform: uppercase;
}

p {
	margin: 0 0 10px;
}
</style>
<div class="mar15">
	<div class="container">
		<div class="register">
			<div class="title_cart">
				<h2>đăng ký tài khoản</h2>
				<p style="width: 100%;">Nếu bạn có một tài khoản, xin vui lòng
					chuyển qua trang đăng nhập</p>
			</div>
			<div class="form_regd">
				<form accept-charset="UTF-8" action="" method="POST">
					<input name="FormType" type="hidden" value="customer_register">
					<input name="utf8" type="hidden" value="true"><input
						type="hidden" id="Token-19ed5a17b8a94a3d8114c00a6cb3be11"
						name="Token"
						value="03AOLTBLSqhUnkfSV8KdXjJQqcSGgqyZIp_XYsx8PMYxlb9_qYx6nACZSmtl156haW4nlC6wftl_MXT9RG7VySulV6nYSCRlTqDn-Wt1h5H9HdR3AkczCdxr60V7Wpf9BUuUpDsaH1TlsY-HpgSR56ip451V8UUsE88EHKvYIMM4cR9G1jXq-2TvJgv28mrYarxaqfFG8-g9-IrAS6hUmbJdJydDwV6mBSpfAorsDAqnyT_LE8dSly4PcUvkpSa1KeEJeH_9KEHLNJxDLblt6i-IeD2BJDgitYrGUvyWwlSBANSFzuBlxh9nRnrLoR_0MK_tDShrTSRRfyIcgviey0vmvTHYmBKeCUUA">
					<h2>Thông tin cá nhân</h2>
					<span id="checkfirst_name" style="color: red"></span><br> <span
						id="checkemail" style="color: red"></span><br> <span
						id="checkcreat_password" style="color: red"></span>
					<div id="datadangky">
						<div class="form-group">
							<label>Tên trước*</label> <input type="text" name="LastName"
								id="last_name" class="form-control" placeholder="Họ">
						</div>
						<div class="form-group">
							<label>Tên sau*</label> <input type="text" class="form-control"
								name="FirstName" id="first_name" placeholder="Tên">
						</div>
						<div class="form-group">
							<label>Email*</label> <input onblur="checkemail1()" type="text"
								class="form-control" name="email" id="email" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password*</label> <input
								type="password" class="form-control" onblur="checkpass()"
								name="password" id="creat_password" placeholder="Password">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password*</label> <input
								type="password" class="form-control" onblur="checkenterpass()"
								name="" id="creat_password1" placeholder="Nhập lại password">
						</div>
						<div class="checkbox">
							<label> <input type="checkbox"> Đăng kí nhận tin
								mới
							</label>
						</div>
					</div>
					<div class="form-group" id="dataxacthuc" style="display: none">
						<span id="checkxacnhanchemail" style="color: red;display: none"></span> <span id="xacnhanchemail"></span> <span id="s"></span><br>
						<a id="sendxacnhan" style="display: none" onclick="sendxacnhan()">gửi lại mã xác nhận !</a><br>
						<label>Mã xác thực*</label><input type="number"
							class="form-control" name="maxacnhan" id="maxacnhan"
							placeholder="Mã xác thực"><br>
					</div>
					<div class="form-group">
						<button id="btndangky" type="button"
							class="btn btn-default stl_btn_reg" onclick="btnSave1()">Đăng
							kí</button>
						<button id="btnxacnhan" onclick="btnxacnhan1()"
							style="display: none" type="button"
							class="btn btn-default stl_btn_reg">xác thực email</button>
						<!--  <button onclick="window.location='/WebBanHang/login'"
							style="float: right;" type="btn"
							class="btn btn-default stl_btn_reg">Quay lại</button>  -->
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
