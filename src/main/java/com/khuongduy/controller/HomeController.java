package com.khuongduy.controller;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khuongduy.dao.impl.RoleDaoImpl;
import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.Role;
import com.khuongduy.entity.Users;
import com.khuongduy.service.impl.DanhMuccSeviceImpl;
import com.khuongduy.service.impl.UsersSeviceImpl;



@Controller
public class HomeController {	
	@Autowired
	RoleDaoImpl roledaoimpl;
	@Autowired
	UsersSeviceImpl userSeviceImpl ;
	
	@Autowired
	DanhMuccSeviceImpl danhMuccSeviceImpl;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model) throws SQLException {
		
		/*List<Role> list=roledaoimpl.fileall();
		model.addAttribute("list", list);
		
		List<DanhMuc> danhMucs=danhMuccSeviceImpl.fileall();
		model.addAttribute("danhmucs", danhMucs);*/
		
		return "home";
	}
}
