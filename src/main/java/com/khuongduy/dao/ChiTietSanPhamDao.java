package com.khuongduy.dao;

import java.util.List;

import com.khuongduy.entity.ChiTietSanPham;
import com.khuongduy.entity.SanPham;


public interface ChiTietSanPhamDao {
	List<ChiTietSanPham> fileall();
	List<ChiTietSanPham> LayDSchitietSP(int masanpham);
	ChiTietSanPham LaychitietSPtheoma(int machitietsanpham);
	boolean themchitietsanpham(ChiTietSanPham chitietsanpham);
	boolean capnhatchitietsanpham(ChiTietSanPham chitietsanpham);
	boolean xoachitietsanpham(int machitietsanpham);
}
