package com.khuongduy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khuongduy.entity.DanhMuc;
import com.khuongduy.service.impl.DanhMuccSeviceImpl;

@Controller
public class DanhMucControllr {
	@Autowired
	DanhMuccSeviceImpl danhMuccSeviceImpl;
	
	@RequestMapping(value="/themdanhmuc",method=RequestMethod.GET)
	public String themdanhmuc(Model model) {
		
		List<DanhMuc> danhMucs=danhMuccSeviceImpl.fileall();
		model.addAttribute("listdanhmuc", danhMucs);
		
		return "themdanhmuc";
		
	}
}
