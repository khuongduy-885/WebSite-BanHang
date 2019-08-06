package com.khuongduy.sevice;

import java.util.List;

import com.khuongduy.entity.DanhMuc;


public interface DanhMucSevice {
	List<DanhMuc> fileall();
	DanhMuc dsdmtheoma(int madanhmuc);
	boolean themdanhmuc(DanhMuc danhMuc);
	boolean capnhatdanhmuc(DanhMuc danhMuc);
	boolean xoadanhmuc(int madanhmuc);
}
