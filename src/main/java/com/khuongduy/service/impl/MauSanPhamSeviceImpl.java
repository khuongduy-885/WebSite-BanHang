package com.khuongduy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khuongduy.dao.impl.MauSanPhamDaoImpl;
import com.khuongduy.entity.MauSanPham;
import com.khuongduy.sevice.MauSanPhamSevice;
@Service
public class MauSanPhamSeviceImpl implements MauSanPhamSevice{

		@Autowired
		private MauSanPhamDaoImpl mauSanPhamDaoImpl;
		
	public List<MauSanPham> fileall() {
		// TODO Auto-generated method stub
		return mauSanPhamDaoImpl.fileall();
	}

}
