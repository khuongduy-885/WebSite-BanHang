package com.khuongduy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khuongduy.dao.impl.RoleDaoImpl;
import com.khuongduy.entity.Role;
import com.khuongduy.entity.Users;
import com.khuongduy.service.impl.UsersSeviceImpl;

@Controller
public class UserController {
	
	@Autowired
	RoleDaoImpl roledaoimpl;
	
	@Autowired
	UsersSeviceImpl usersSeviceImpl;

		
	@RequestMapping(value="/themnhanvien",method=RequestMethod.GET)
	public String themnhanvien(Model model) throws SQLException {
		List<Role> listrole=roledaoimpl.fileall();
		model.addAttribute("listrole", listrole);
		
		List<Users> listuser=usersSeviceImpl.fileall();
		model.addAttribute("listuser", listuser);
		
		return "themnhanvien";
		
	}
}
