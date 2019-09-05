package com.khuongduy.sevice;

import java.util.List;

import com.khuongduy.entity.SanPham;

public interface SanPhamSevice {
	List<SanPham> fileall() throws Exception;
	List<SanPham> laydsSanPhamLimit(int sobatdau) throws Exception;
	List<SanPham> LayDSSanDanhMuc(int madanhmuc) throws Exception;
	SanPham sanphamtheoma(int masanpham) throws Exception;
	boolean themsanpham(SanPham sanPham) throws Exception;
	boolean capnhatsanpham(SanPham sanPham) throws Exception;
	boolean xoasanpham(int masanpham) throws Exception;
}
