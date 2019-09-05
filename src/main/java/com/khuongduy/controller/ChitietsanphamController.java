package com.khuongduy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khuongduy.entity.ChiTietSanPham;
import com.khuongduy.entity.MauSanPham;
import com.khuongduy.entity.SanPham;
import com.khuongduy.service.impl.ChiTietSanPhamSeviceImpl;
import com.khuongduy.service.impl.MauSanPhamSeviceImpl;
import com.khuongduy.service.impl.SanPhamSeviceImpl;


@Controller
public class ChitietsanphamController {
	@Autowired
	ChiTietSanPhamSeviceImpl chiTietSanPhamSeviceImpl;
	
	@Autowired
	SanPhamSeviceImpl sanPhamSeviceImpl;	
	@Autowired 
	MauSanPhamSeviceImpl mauSanPhamSeviceImpl;
	
	@RequestMapping(value="/themchitietsanpham",method=RequestMethod.GET)
	public String chitietsanpham(Model model) {
		List<ChiTietSanPham> listchitiet=chiTietSanPhamSeviceImpl.fileall();
		model.addAttribute("listchitiet", listchitiet);
		
	/*	List<SanPham> listsanpham=sanPhamSeviceImpl.fileall();
		model.addAttribute("listsanpham", listsanpham);*/
		
		
		
		return "themchitietsanpham";
	}
}	
