package com.khuongduy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khuongduy.dao.impl.ChiTietSanPhamDaoImpl;
import com.khuongduy.entity.ChiTietSanPham;
import com.khuongduy.sevice.ChiTietSanPhamSevice;

@Service
public class ChiTietSanPhamSeviceImpl implements ChiTietSanPhamSevice{
	@Autowired
	private ChiTietSanPhamDaoImpl chiTietSanPhamDaoImpl;
	
	public List<ChiTietSanPham> fileall() {
		
		return chiTietSanPhamDaoImpl.fileall();
	}

	public List<ChiTietSanPham> LayDSchitietSP(int masanpham) {
		
		return chiTietSanPhamDaoImpl.LayDSchitietSP(masanpham);
	}

	public boolean themchitietsanpham(ChiTietSanPham chitietsanpham) {
		
		return chiTietSanPhamDaoImpl.themchitietsanpham(chitietsanpham);
	}

	public boolean capnhatchitietsanpham(ChiTietSanPham chitietsanpham) {
		
		return chiTietSanPhamDaoImpl.capnhatchitietsanpham(chitietsanpham);
	}

	public boolean xoachitietsanpham(int machitietsanpham) {
		
		return chiTietSanPhamDaoImpl.xoachitietsanpham(machitietsanpham);
	}

	public ChiTietSanPham LaychitietSPtheoma(int machitietsanpham) {


		return chiTietSanPhamDaoImpl.LaychitietSPtheoma(machitietsanpham);
	}

}
