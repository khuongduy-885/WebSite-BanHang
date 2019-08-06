package com.khuongduy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khuongduy.dao.impl.SanPhamDaoImpl;
import com.khuongduy.entity.SanPham;
import com.khuongduy.sevice.SanPhamSevice;

@Service
public class SanPhamSeviceImpl implements SanPhamSevice {
	@Autowired
	private SanPhamDaoImpl sanPhamDaoImpl;

	public List<SanPham> fileall() {
		
		return sanPhamDaoImpl.fileall();
	}

	public List<SanPham> LayDSSanDanhMuc(int madanhmuc) {
		
		return sanPhamDaoImpl.LayDSSanDanhMuc(madanhmuc);
	}

	public SanPham sanphamtheoma(int masanpham) {
		
		return sanPhamDaoImpl.sanphamtheoma(masanpham);
	}

	public boolean themsanpham(SanPham sanPham) {
		
		return sanPhamDaoImpl.themsanpham(sanPham);
	}

	public boolean capnhatsanpham(SanPham sanPham) {
		
		return sanPhamDaoImpl.capnhatsanpham(sanPham);
	}

	public boolean xoasanpham(int masanpham) {
		
		return sanPhamDaoImpl.xoasanpham(masanpham);
	}
	
	public List<SanPham> laydsSanPhamLimit(int sobatdau) {
		
		return sanPhamDaoImpl.laydsSanPhamLimit(sobatdau);
	}

}
