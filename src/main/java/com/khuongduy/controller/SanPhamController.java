/**
 * 
 */
package com.khuongduy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.SanPham;
import com.khuongduy.service.impl.DanhMuccSeviceImpl;
import com.khuongduy.service.impl.SanPhamSeviceImpl;

/**
 * @author Khuong Duy
 *
 */
@Controller
public class SanPhamController {
	@Autowired
	SanPhamSeviceImpl sanPhamSeviceImpl;
	
	@Autowired
	DanhMuccSeviceImpl danhMuccSeviceImpl;
	
	@RequestMapping(value="/themsanpham",method=RequestMethod.GET)
	public String themsanpham(Model model ) {
		List<SanPham> sanPhams=sanPhamSeviceImpl.fileall();
		model.addAttribute("listSphanPhams", sanPhams);
		
		/*List<DanhMuc> danhMucs=danhMuccSeviceImpl.fileall();
		model.addAttribute("danhmuc", danhMucs);*/
		return "themsanpham";
		}
}