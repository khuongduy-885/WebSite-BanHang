package com.khuongduy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.khuongduy.entity.Users;
import com.khuongduy.sevice.UsersSevice;

@Controller
public class LonginBusiness {
	@Autowired
	UsersSevice userSevice;
	
	@Autowired
	UsersSevice usersSevice;
	public Users kiemtradangnhap(String username, String pass) throws Exception {
		Users users = new Users();
		try {
			 users =usersSevice.kiemtradangnhap(username, pass);
		}catch (Exception e) {
			throw e;
		}
		return users;
	}
}
