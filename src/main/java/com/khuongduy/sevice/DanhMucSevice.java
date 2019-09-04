package com.khuongduy.sevice;

import java.util.List;

import com.khuongduy.entity.DanhMuc;


public interface DanhMucSevice {
	List<DanhMuc> fileall() throws Exception;
	DanhMuc dsdmtheoma(int madanhmuc)throws Exception;
	boolean themdanhmuc(DanhMuc danhMuc)throws Exception;
	boolean capnhatdanhmuc(DanhMuc danhMuc)throws Exception;
	boolean xoadanhmuc(int madanhmuc)throws Exception;
}
