package com.khuongduy.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khuongduy.business.DanhMucBusiness;
import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.ObjCheck;

@Controller
public class DanhMucControllr
{
	@Autowired
	DanhMucBusiness danhMucBusiness;

	@RequestMapping(value = "/themdanhmuc", method = RequestMethod.GET)
	public String themdanhmuc(Model model) throws Exception
	{
		try
		{
			List danhMucs = (List) danhMucBusiness.fileall();
			model.addAttribute("listdanhmuc", danhMucs);
		} catch (Exception e)
		{
			throw e;
		}
		return "themdanhmuc";

	}

	@RequestMapping(value = "/laydanhmuctheoma", method = RequestMethod.POST)
	@ResponseBody
	public DanhMuc laydanhmuctheoma(@RequestParam int madanhmuc) throws Exception
	{
		DanhMuc danhMuc = new DanhMuc();
		try
		{
			danhMuc = danhMucBusiness.dsdmtheoma(madanhmuc);
		} catch (Exception e)
		{
			throw e;
		}
		return danhMuc;
	}

	@RequestMapping(value = "/deletedanhmuc", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
	@ResponseBody
	public ObjCheck xoadanhmuctheoma(@RequestParam int madanhmuc) throws Exception
	{
		ObjCheck objCheck = new ObjCheck();
		try
		{
			objCheck = danhMucBusiness.xoadanhmuctheoma(madanhmuc);
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}

	@RequestMapping(value = "/updatedanhmuc", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
	@ResponseBody
	public ObjCheck updatedanhmuc(@RequestParam int madanhmuc, @RequestParam String tendanhmuc) throws Exception
	{
		ObjCheck objCheck = new ObjCheck();
		try
		{
			DanhMuc danhMuc = new DanhMuc();
			danhMuc.setMadanhmuc(madanhmuc);
			danhMuc.setTendanhmuc(tendanhmuc);
			objCheck = danhMucBusiness.updatedanhmuc(danhMuc);
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
	
	@RequestMapping(value = "/insertdanhmuc")
	@ResponseBody
	public ObjCheck insertdanhmuc(@RequestParam String tendanhmuc)
	{
		ObjCheck objCheck = new ObjCheck();
		try
		{
			DanhMuc danhMuc = new DanhMuc();
			danhMuc.setTendanhmuc(tendanhmuc);
			objCheck = danhMucBusiness.insertdanhmuc(danhMuc);
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}

}
