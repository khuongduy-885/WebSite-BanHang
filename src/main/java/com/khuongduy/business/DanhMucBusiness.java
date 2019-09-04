package com.khuongduy.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.khuongduy.entity.DanhMuc;
import com.khuongduy.sevice.DanhMucSevice;

@Controller
public class DanhMucBusiness
{
	@Autowired
	DanhMucSevice danhMucSevice;

	public List<DanhMuc> fileall() throws Exception
	{
		List<DanhMuc> listDanhmuc= new ArrayList<DanhMuc>();
		try
		{
			listDanhmuc=danhMucSevice.fileall();
					
		} catch (Exception e)
		{
			throw e;
		}
		return listDanhmuc;

	}
	public DanhMuc dsdmtheoma(int madanhmuc) throws Exception{
		DanhMuc danhMuc=  new DanhMuc(); 
		try
		{
			danhMuc=danhMucSevice.dsdmtheoma(madanhmuc);
					
		} catch (Exception e)
		{
			throw e;
		}
		return danhMuc;
		
	}
}
