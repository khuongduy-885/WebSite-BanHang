package com.khuongduy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khuongduy.dao.impl.DanhMucDaoImpl;
import com.khuongduy.entity.DanhMuc;
import com.khuongduy.sevice.DanhMucSevice;

@Service
public class DanhMuccSeviceImpl implements DanhMucSevice  {
	@Autowired
	private DanhMucDaoImpl danhMucDaoImpl;
	public List<DanhMuc> fileall() {
		
		return danhMucDaoImpl.fileall();
	}

	public DanhMuc dsdmtheoma(int madanhmuc) {
		
		return danhMucDaoImpl.dsdmtheoma(madanhmuc);
	}

	public boolean themdanhmuc(DanhMuc danhMuc) {

		return danhMucDaoImpl.themdanhmuc(danhMuc);
	}

	public boolean capnhatdanhmuc(DanhMuc danhMuc) {
	
		return danhMucDaoImpl.capnhatdanhmuc(danhMuc);
	}

	public boolean xoadanhmuc(int madanhmuc) {
	
		return danhMucDaoImpl.xoadanhmuc(madanhmuc);
	}

}
