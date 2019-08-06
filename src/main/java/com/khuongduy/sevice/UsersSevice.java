package com.khuongduy.sevice;

import java.sql.SQLException;
import java.util.List;

import com.khuongduy.entity.Users;

public interface UsersSevice {
	Users kiemtradangnhap(String username, String pass);
	List<Users> fileall();
	Users nhanvientheoma(int userid);
	boolean themnhanvien(Users users) throws SQLException;
	boolean capnhatnhanvien(Users users);
	boolean xoanhanvien(int userid);
}
