package com.khuongduy.dao;

import java.util.List;

import com.khuongduy.entity.DanhMuc;


public interface DanhMucDao {
	List<DanhMuc> fileall() throws Exception;
	DanhMuc dsdmtheoma(int madanhmuc)throws Exception;
	
	boolean themdanhmuc(DanhMuc danhMuc)throws Exception;
	boolean capnhatdanhmuc(DanhMuc danhMuc)throws Exception;
	boolean xoadanhmuc(int madanhmuc)throws Exception;
}
