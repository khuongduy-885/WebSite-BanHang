package com.khuongduy.dao;

import java.util.List;

import com.khuongduy.entity.SanPham;

public interface SanPhamDao {
	List<SanPham> fileall();
	List<SanPham> laydsSanPhamLimit(int sobatdau);
	List<SanPham> LayDSSanDanhMuc(int madanhmuc);
	SanPham sanphamtheoma(int masanpham);
	boolean themsanpham(SanPham sanPham);
	boolean capnhatsanpham(SanPham sanPham);
	boolean xoasanpham(int masanpham);
}
