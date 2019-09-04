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

@Controller
public class DanhMucControllr {
	@Autowired
	DanhMucBusiness danhMucBusiness;
	
	@RequestMapping(value="/themdanhmuc",method=RequestMethod.GET)
	public String themdanhmuc(Model model) throws Exception {
		try
		{
			List danhMucs=(List) danhMucBusiness.fileall();
			model.addAttribute("listdanhmuc", danhMucs);
		} catch (Exception e)
		{
			throw e;
		}
		return "themdanhmuc";
		
	}
	@RequestMapping(value ="laydanhmuctheoma", method = RequestMethod.POST)
	 @ResponseBody
	 public DanhMuc laydanhmuctheoma(@RequestParam int madanhmuc) throws Exception {
		DanhMuc danhMuc = new DanhMuc();
		try {
		  danhMuc= danhMucBusiness.dsdmtheoma(madanhmuc);
		} catch (Exception e)
		{
			throw e;
		}
		 return danhMuc;
	 }
	/*@PostMapping("themdanhmuc")
	 @ResponseBody
	 public void themsanpham(@RequestParam String tendanhmuc ) {
		 DanhMuc danhMuc= new DanhMuc();
		 danhMuc.setTendanhmuc(tendanhmuc);
		 danhMuccSeviceImpl.themdanhmuc(danhMuc);
	 }
	@GetMapping(path="xoadanhmuctheoma",produces="plain/text; charset=UTF-8")
	 @ResponseBody
	 public String xoadanhmuctheoma(@RequestParam int madanhmuc) {
		danhMuccSeviceImpl.xoadanhmuc(madanhmuc);
		 return "";
	}
	@PostMapping("updatedanhmuc")
	 @ResponseBody
	 public DanhMuc updatedanhmuc(@RequestParam int madanhmuc,@RequestParam String tendanhmuc ) {
		 DanhMuc danhMuc = new DanhMuc();
		 danhMuc.setMadanhmuc(madanhmuc);
		 danhMuc.setTendanhmuc(tendanhmuc);
		 danhMuccSeviceImpl.capnhatdanhmuc(danhMuc);
		 return danhMuc;
	 }*/
}
