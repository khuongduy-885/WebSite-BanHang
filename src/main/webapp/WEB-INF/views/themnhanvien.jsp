<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<jsp:include page="adminheader.jsp"/>
	<dir class="container" style="background-color: white;">
		<dir class="row">
				
				<dir class="col-md-3 " >
				<h3>Them Nhân Viên</h3>
				
				<form id="formdatanhanvien" name="formdatanhanvien" onsubmit="return validate()" method="post">
				
				   <label for="role">Role</label>
				 <select name="role" class="form-control" id="role">
				    <c:forEach var="role" items="${listrole }">
				    	 <option  value="${role.idrole}">${role.namerole }</option>
				    </c:forEach>
				    </select>
				    
				     <label for="username">User Name</label>
					   <input required=”required” type="text" class="form-control" name="username" id="username" placeholder="Nhập Tên đăng Nhập">
					   
					   <label for="pass">Password</label>
					   <input type="text" class="form-control" name="pass" id="pass" placeholder="Nhập mat khau">
					   
					   <label for="nhaplaimatkhau">Nhập Lại Mật Khẩu</label> 
					   <input type="text" class="form-control" name="nhaplaimatkhau" id="nhaplaimatkhau" placeholder="Nhập lai mat khau">
					  
					  <label for="fullname">Fullname</label>
					   <input type="text" class="form-control" name="fullname" id="Fullname" placeholder="Nhập họ tên">
					  
					   <label for="email">Email</label>
					   <input type="text" class="form-control" name="email" id="email" placeholder="nhạp email">
					   
					   <label for="phonenumber">phonenumber</label>
					   <input type="text" class="form-control" name="phonenumber" id="phonenumber" placeholder="Nhập phonenumber">
					   
					  <label for="ngaynhap">Ngay Nhap</label>
					    <input type="text" class="form-control" name="ngaynhap"id="ngaynhap" placeholder="ngay nhap">
					    <input id="btnthem-nhanvien" class="submitinput" type="submit" value="Thêm Nhan Vien"/>
						</form>
						
<!-- 				    <button  id="btnthem-nhanvien" class="btn btn-info">Thêm Nhan Vien</button> -->
			
					   </dir>
					   
					   	<dir class="col-md-9 " >
					<dir style="float: right;">
						<button  id="btnxoa-nhanvien" class="btn btn-info">xoa</button>
					</dir>
					
							<table id="tablethem-nhanvien"class="table">
							
								<thead>
									<tr>
											<th>User Name  </th>
											<th> Full name </th>
											<th>Email</th>
											<th>Phone Num</th>
											<th>Ngay Nhap</th>
											<th>Role</th>
											<th><div class="checkbox">
												    <label ><input id="checkall" type="checkbox" class="checkboxnhanvien" value=""></label>
												</div>
											</th>
											<th></th>
										</tr>
								</thead>
									<tbody>
									<c:forEach var="user" items="${listuser }">
										<tr>
										<td style="width: 20%" class="username">${user.username}</td>
											<td  class="fullname" ">${user.fullname} </td>
											<td class="email">${user.email} </td>
											<td class="phonenumber">${user.phonenumber}</td>
											<td class="btn-chitiet">${user.createdate}</td>
											<td class="btn-chitiet">${user.namerole}</td>
											<td><div class="checkbox">
												    <label ><input type="checkbox" class="checkboxnhanvien" value="${user.userid}"></label>
												</div>
											</td>
										</tr>
									</c:forEach>	
									</tbody>
								</table>
						</dir>
					</dir>			
		</dir>
	<jsp:include page="adminfooter.jsp"/>