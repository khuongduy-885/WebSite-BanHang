<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"/>
	
	<dir class="container" style="background-color: white;">
		<dir class="row">
				<dir class="col-md-4 " >
					   <h3>Them Chi Tiet</h3>
					      <dir id="contenchitiet">
					     	<form id="formdatactsanpham">
					      </form>
						   	  <dir class="themchitiet-ctsanpham" >
						   	  <label for="sanpham">San Pham </label>
							    <select class="form-control" id="masanpham">
							    <c:forEach var="sanpham" items="${listsanpham}">
							    	 <option value="${sanpham.masanpham }">${sanpham.tensanpham }</option>
							    </c:forEach>
							    </select><br/>
					   	 <label for="mau"> Mau </label>
					   <input type="text" class="form-control" name="mau"id="mau" placeholder="Nhập Mau Sản Phẩm"><br/>
				   		 
				   		 <label for="soluong">Số Lượng</label>
					   <input type="text" class="form-control" name="soluong"id="soluong" placeholder="Nhập Số Lượng Sản Phẩm"><br/>
					   <button style="float: right;" id="btnthem-chitietsanpham" class="btn btn-info btnthem-chitiet">+</button><br/>
					   <span></span><br/>
					   </dir>
						 
					   </dir>
					   
					   <dir class="themchitiet-ctsanpham" id="themchitiet-sanpham">
					   		<label for="sanpham">San Pham </label>
							    <select class="form-control" id="masanpham">
							    <c:forEach var="sanpham" items="${listsanpham}">
							    	 <option value="${sanpham.masanpham }">${sanpham.tensanpham }</option>
							    </c:forEach>
							    </select><br/>
							    
						   	 <label for="mau">Mau</label>
					   <input type="text" class="form-control" name="mau"id="mau" placeholder="Nhập Mau Sản Phẩm"><br/>
					   		 
					   		 <label for="soluong">Số Lượng</label>
						   <input type="text" class="form-control" name="soluong"id="soluong" placeholder="Nhập Số Lượng Sản Phẩm"><br/>
						   <button style="float: right;" id="btnthem-chitietsanpham" class="btn btn-info btnthem-chitiet">+</button><br/>
						   <span></span><br/>	  
					    </dir>
					   <button  id="btncapnhat-ctsanpham" class="btn btn-info empty">Cập nhật</button>
					   <button  id="btnthoat-ctsanpham" class="btn btn-info empty">Thoát</button>
					   <button  id="btnthem-ctsanpham" class="btn btn-info">Thêm Chi Tiet Sản Phẩm</button>
				 
				</dir>
					<dir class="col-md-8 " >
					<dir style="float: right;">
						<button  id="btnxoa-ctsanpham" class="btn btn-info">xoa</button>
					</dir>
							<table id="tablethem-ctsanpham"class="table">
								<thead>
									<tr>
											<th>san pham  </th>
											<th> mau san pham </th>
											<th> so luong   </th>
											<th><div class="checkbox">
												    <label ><input id="checkall" type="checkbox" class="checkboxsanpham" value=""></label>
												</div>
											</th>
											<th></th>
										</tr>
								</thead>
									<tbody>
									<c:forEach var="ctsanpham" items="${listchitiet }">
										<tr>
											<td  class="tensanpham" data-masanpham="${ctsanpham.masanpham}">${ctsanpham.tensanpham} </td>
											<td class="mau">${ctsanpham.mau}</td>
											<td class="soluong" >${ctsanpham.soluong}</td>											
											<td><div class="checkbox">
												    <label ><input type="checkbox" class="checkboxctsanpham" value="${ctsanpham.machitietsanpham}"></label>
												</div>
											</td>
											<td><button data-sua="${ctsanpham.machitietsanpham}" type="button" class="btn btn-info btnsua-ctsanpham">sua</button></td>
										</tr>
									</c:forEach>	
									</tbody>
								</table>
								<ul class="pagination pagination-sm">
								 <c:forEach var = "i" begin = "1" end = "${tongsopag }">
								         <li class="paging-iteam"><a href="#">${i}</a></li>
								      </c:forEach>
									</ul>
						</dir>
					</dir>			
		</dir>
	<jsp:include page="adminfooter.jsp"/>