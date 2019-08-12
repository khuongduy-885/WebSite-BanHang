<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript"
	src="<c:url value="/resources/JS/jstemblates/login.js"/>"></script>
<style>
.mar15 {
    margin-top: 30px;
    width: 100%;
}
.container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
.log_lf {
    float: left;
    width: 100%;
    padding: 30px;
    background-color: #f8f8f8;
    margin-bottom: 30px;
}
.login h4 {
    margin-bottom: 20px;
    font-weight: 700;
    font-family: 'Roboto', sans-serif;
    text-transform: uppercase;
}
p {
    margin: 0 0 10px;
}
.login form {
    width: 100%;
    max-width: 400px;
    float: left;
    margin-bottom: 30px;
}
login .form-group {
    margin-bottom: 10px;
    float: left;
    width: 100%;
}
.form-group {
    margin-bottom: 15px;
}
.login .site-button-dark {
    margin-bottom: 30px;
    padding: 10px 25px;
    border: none;
    background-color: #ccc;
    border-radius: 5px;
    text-transform: uppercase;
    font-family: 'Roboto', sans-serif;
    color: #333;
}
.login a {
    display: inline-block;
    margin: 10px 0;
    color: #777;
}
a, a:focus, a:hover {
    text-decoration: none;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}
login label {
    width: 100%;
    float: left;
    font-weight: 400;
    color: #a7a7a7;
}
label {
    display: inline-block;
    max-width: 100%;
    margin-bottom: 10px;
    font-weight: 700;
}
.log_rgt {
    width: 100%;
    padding: 30px;
    background-color: #f8f8f8;
    margin-bottom: 30px;
}
</style>
<div class="mar15 login">
	<div class="container">
		<div class="row">
			<!-- end col-12 -->
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="log_lf">
					<h4>đăng nhập</h4>
					<p style="width: 100%;">Nếu bạn có một tài khoản, xin vui lòng đăng nhập.</p>
					<form accept-charset="UTF-8" action="" method="post">

						<div class="form-group">
							<label style="color: darkgray">E-mail</label> <input type="email" class="form-control"
								id="email" name="email" placeholder="Email">
						</div>
						<div class="form-group">
							<label style="color: darkgray">Password</label> <input type="password" name="password"
								id="pass" class="form-control" placeholder="Password">
						</div>
						<div class="form-group">
							<a href="#recover"
								onclick="showRecoverPasswordForm();return false;"
								id="RecoverPassword">Quên mật khẩu ?</a>
						</div>
					
						<div class="form-group">
								<input type="button" value="dangnhap" onclick="btnSave1()"/>
						</div>
					</form>
					<!-- <div id="recover_password" style="display: none;">
						<h3>Đặt lại mật khẩu</h3>
						<p id="intro note-reset">Chúng tôi sẽ gửi cho bạn một email để
							kích hoạt việc đặt lại mật khẩu.</p>

						<form accept-charset="UTF-8" action="/account/recover"
							id="recover_customer_password" method="post">
							<input name="FormType" type="hidden"
								value="recover_customer_password"> <input name="utf8"
								type="hidden" value="true"> <label for="email">Email<span
								id="required">*</span></label> <input style="height: 34px;" type="email"
								class="input-control" value="" title="email" name="email"
								id="email">
							<p class="action-btn">
								<input type="submit" class="button stl_btn_reg" value="Gửi">
								hoặc <a href="#"
									onclick="hideRecoverPasswordForm();return false;">Hủy</a>
							</p>
						</form>
					</div> -->
				</div>
			</div>
			<!-- end col-6 -->
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="log_rgt">
					<h4>khách hàng mới</h4>
					<p style="width: 100%;">Đăng ký tài khoản để mua hàng nhanh hơn. Theo dõi đơn đặt
						hàng, vận chuyển. Cập nhật các tin tức sự kiện và các chương trình
						giảm giá của chúng tôi.</p>
					<a href='<c:url value="/signin"/>'class="site-button-dark" id="show-form"><span>Đăng
							ký</span></a>

				</div>
			</div>
			<!-- end col-6 -->
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
