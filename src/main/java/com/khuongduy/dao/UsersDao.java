package com.khuongduy.dao;

import java.sql.SQLException;
import java.util.List;

import com.khuongduy.entity.Users;

public interface UsersDao {
	Users kiemtradangnhap(String username, String pass) throws SQLException, Exception;
	List<Users> fileall();
	Users nhanvientheoma(int userid);
	boolean themnhanvien(Users users) throws SQLException;
	boolean capnhatnhanvien(Users users);
	boolean xoanhanvien(int userid);
}
