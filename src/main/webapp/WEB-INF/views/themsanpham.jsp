<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"/>
	
	<dir class="container" style="background-color: white;">
		<dir class="row">
				
				<dir class="col-md-4 " >
				<h3>Them San Pham</h3>
					 <span id="chuachitiet"></span>
				<form id="formdatasanpham">
				    <label for="danhmucsanpham">Danh Mục</label>
				    <select name="danhmucsanpham" class="form-control" id="danhmucsanpham">
				    <c:forEach var="danhmuc" items="${danhmuc }">
				    	 <option  value="${danhmuc.getMadanhmuc() }">${danhmuc.getTendanhmuc() }</option>
				    </c:forEach>
				    </select><br/>
				    
				     <label for="tensanpham">Tên Sản Phảm</label>
					   <input type="text" class="form-control" name="tensanpham" id="tensanpham" placeholder="Nhập Tên Sản Phẩm">
					   
					   <label for="giatien">Giá Tiền</label>
					   <input type="text" class="form-control" name="giatien"id="giatien" placeholder="Nhập Giá Sản Phẩm">
					   
					   <label for="tinhtrang">Tinh Trang</label>
					  <textarea class="form-control" name="tinhtrang" id="tinhtrang" rows="3"></textarea>
					  
					   <label for="hinhanh">Hình Ảnh</label>
					   <input type="file" class="form-control" name="hinhanh" id="hinhanh" ><br/>
					   
					   <label for="cauhinhmay">Cấu Hình Máy</label>
					  <textarea class="form-control" name="cauhinhmay" id="cauhinhmay" rows="3"></textarea>
					  
					  <label for="ngaynhap">Ngay Nhap</label>
					    <input type="text" class="form-control" name="ngaynhap"id="ngaynhap" placeholder="ngay nhap"><br/>
						</form>
					   <button  id="btncapnhat-sanpham" class="btn btn-info empty">Cập nhật</button>
					   <button  id="btnthoat-sanpham" class="btn btn-info empty">Thoát</button>
					   <button  id="btnthem-sanpham" class="btn btn-info">Thêm Sản Phẩm</button>
				 
				</dir>
					<dir class="col-md-8 " >
					<dir style="float: right;">
						<button  id="btnxoa-sanpham" class="btn btn-info">xoa</button>
					</dir>
					
							<table id="tablethem-sanpham"class="table">
							
								<thead>
									<tr>
											<th>hinh anh  </th>
											<th> ten SP </th>
											<th> gia tien   </th>
											<th> tình trạng  </th>
											<th> danh muc   </th>
											<th> chi tiet SP</th>
											<th><div class="checkbox">
												    <label ><input id="checkall" type="checkbox" class="checkboxsanpham" value=""></label>
												</div>
											</th>
											<th></th>
										</tr>
								</thead>
									<tbody>
									<c:forEach var="sanpham" items="${listSphanPhams }">
										<tr>
										<td style="width: 20%">
										<img style="width: 100%;height: 132px" src='<c:url value="/resources/Image/sanpham/${sanpham.hinhanh}"/>'/>
										</td>
											<td  class="ten" data-masanpham="${sanpham.masanpham}">${sanpham.tensanpham} </td>
											<td class="gia">${sanpham.giatien}.000 vnd </td>
											<td class="tingtrang">${sanpham.tinhtrang} </td>
											<td class="danhmuc" data-madanhmuc="${sanpham.madanhmuc }">${sanpham.tendanhmuc}</td>
											<td class="btn-chitiet"><button data-ct="${sanpham.masanpham}" type="button" class="btn btn-info btnchitiet">Chi Tiet</button></td>
											<td><div class="checkbox">
												    <label ><input type="checkbox" class="checkboxsanpham" value="${sanpham.masanpham}"></label>
												</div>
											</td>
											<td><button data-sua="${sanpham.masanpham}" type="button" class="btn btn-info btnsua-sanpham">sua</button></td>
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