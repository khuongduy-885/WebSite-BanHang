package com.khuongduy.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khuongduy.dao.UsersDao;
import com.khuongduy.dao.impl.UsersDaoImpl;
import com.khuongduy.entity.Users;
import com.khuongduy.sevice.UsersSevice;

@Service
public class UsersSeviceImpl implements UsersSevice {
	
	@Autowired
	private UsersDao usersDaoImpl;
	
	public boolean themnhanvien(Users users) throws SQLException {
		return usersDaoImpl.themnhanvien(users);
	}
	public Users kiemtradangnhap(String username, String pass) throws Exception {
		return usersDaoImpl.kiemtradangnhap(username, pass);
	}
	public List<Users> fileall() {
		return usersDaoImpl.fileall();
	}
	public Users nhanvientheoma(int userid) {
		return usersDaoImpl.nhanvientheoma(userid);
	}
	public boolean capnhatnhanvien(Users users) {
		return usersDaoImpl.capnhatnhanvien(users);
	}
	public boolean xoanhanvien(int userid) {
		return usersDaoImpl.xoanhanvien(userid);
	}

	

}
