package com.khuongduy.sevice;

import java.util.List;

import com.khuongduy.entity.SanPham;

public interface SanPhamSevice {
	List<SanPham> fileall();
	List<SanPham> laydsSanPhamLimit(int sobatdau);
	List<SanPham> LayDSSanDanhMuc(int madanhmuc);
	SanPham sanphamtheoma(int masanpham);
	boolean themsanpham(SanPham sanPham);
	boolean capnhatsanpham(SanPham sanPham);
	boolean xoasanpham(int masanpham);
}
