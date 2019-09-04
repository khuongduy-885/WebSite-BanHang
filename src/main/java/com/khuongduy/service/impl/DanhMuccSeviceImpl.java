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
	public List<DanhMuc> fileall() throws Exception {
		
		return danhMucDaoImpl.fileall();
	}

	public DanhMuc dsdmtheoma(int madanhmuc) throws Exception {
		
		return danhMucDaoImpl.dsdmtheoma(madanhmuc);
	}

	public boolean themdanhmuc(DanhMuc danhMuc) throws Exception {

		return danhMucDaoImpl.themdanhmuc(danhMuc);
	}

	public boolean capnhatdanhmuc(DanhMuc danhMuc) throws Exception {
	
		return danhMucDaoImpl.capnhatdanhmuc(danhMuc);
	}

	public boolean xoadanhmuc(int madanhmuc)throws Exception {
	
		return danhMucDaoImpl.xoadanhmuc(madanhmuc);
	}

}
