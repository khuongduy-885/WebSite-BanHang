<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="adminheader.jsp"/>
	<dir class="container" style="background-color: white;">
		<dir id="themdanhmuc" class="container-fluid ">
			<dir class="col-md-6" >
				<div class="form-group">
				    <label for="tendanhmuc">Tên Danh Mục</label>
				    	<input type="text" class="form-control" id="tendanhmuc"  placeholder="Nhap Tên Danh Mục"><br/>
				    <button class="btn btn-info " id="btnthem-danhmuc" >Thêm Danh Mục</button>
				     <button class="btn btn-info empty" id="btncapnhat-danhmuc" >Cập Nhập Danh Mục</button>
				      <button class="btn btn-info empty" id="btnthoat-danhmuc" >Thoát</button>
				  </div>
			</dir>
			
			<dir class="col-md-6" >
				<h3>Danh Sách Danh Mục</h3>
				 <button id="btnxoa-danhmuc" class="btn btn-info " style="float: right;">Xóa</button>
				<table id="tablethem-danhmuc" class="table">
				    <thead>
				      <tr>
				        <th>Tên Danh Mục</th>
				        <th><label style=" margin-top: -15px;" class="checkbox-inline">
				        	<input id="checkboxall" type="checkbox" value=""></label></th>
				      </tr>
				    </thead>
				    <tbody>
					    <c:forEach var="listdanhmuc" items="${listdanhmuc }">
					      <tr>
					      	<td>${listdanhmuc.tendanhmuc}</td>
					        <td>
					        	<label>
					        		<input class="checkboxdanhmuc" type="checkbox" value="${listdanhmuc.madanhmuc}">
					        	</label>
					        </td>
					          <td> <button class="btn btn-info btnsua-danhmuc " data-madanhmuc="${listdanhmuc.madanhmuc}" >Sưa</button></td>
					      </tr>
					       </c:forEach>
				    </tbody>
				  </table>
			</dir>
		</dir>
		
	</dir>	
		<jsp:include page="adminfooter.jsp"/>