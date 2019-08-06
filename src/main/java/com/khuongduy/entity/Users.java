package com.khuongduy.entity;

import java.sql.Timestamp;




public class Users {
	
	private int mathanhvien;
	private String email;
	private String pass ;
	private String fullname ;
	private String diachi ;
	private int sdt;
	private String matkhau;
	private String hoten;
	private String phanquyen;
	
	public String getMatkhau()
	{
		return matkhau;
	}
	public void setMatkhau(String matkhau)
	{
		this.matkhau = matkhau;
	}
	public String getHoten()
	{
		return hoten;
	}
	public void setHoten(String hoten)
	{
		this.hoten = hoten;
	}
	public int getMathanhvien()
	{
		return mathanhvien;
	}
	public void setMathanhvien(int mathanhvien)
	{
		this.mathanhvien = mathanhvien;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getFullname()
	{
		return fullname;
	}
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}
	public String getDiachi()
	{
		return diachi;
	}
	public void setDiachi(String diachi)
	{
		this.diachi = diachi;
	}
	public int getSdt()
	{
		return sdt;
	}
	public void setSdt(int sdt)
	{
		this.sdt = sdt;
	}
	public String getPhanquyen()
	{
		return phanquyen;
	}
	public void setPhanquyen(String phanquyen)
	{
		this.phanquyen = phanquyen;
	}

}
