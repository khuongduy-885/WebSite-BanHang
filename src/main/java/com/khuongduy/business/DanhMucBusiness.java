package com.khuongduy.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.ObjCheck;
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
	public ObjCheck xoadanhmuctheoma(int madanhmuc) throws Exception{
		ObjCheck objCheck=  new ObjCheck(); 
		boolean check=false;
		try
		{
			check=danhMucSevice.xoadanhmuc(madanhmuc);
			if(check) {
				objCheck.setStatus(1);
				objCheck.setSuccess("Xóa thành công !");
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("Xóa không thành công !");
			}
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
	public ObjCheck updatedanhmuc( DanhMuc danhMuc) throws Exception{
		ObjCheck objCheck=  new ObjCheck(); 
		boolean check=false;
		try
		{
			check=danhMucSevice.capnhatdanhmuc(danhMuc);
			if(check) {
				objCheck.setStatus(1);
				objCheck.setSuccess("Update danh mục thành công !");
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("Update danh mục không thành công !");
			}
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
	public ObjCheck insertdanhmuc( DanhMuc danhMuc) throws Exception{
		ObjCheck objCheck=  new ObjCheck(); 
		boolean check=false;
		try
		{
			check=danhMucSevice.themdanhmuc(danhMuc);
			if(check) {
				objCheck.setStatus(1);
				objCheck.setSuccess("them danh mục thành công !");
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("them danh mục không thành công !");
			}
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
}
