package com.khuongduy.entity;

public class MauSanPham {
	private int mamau;
	private String tenmau;
	public int getMamau() {
		return mamau;
	}
	public void setMamau(int mamau) {
		this.mamau = mamau;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	public MauSanPham(int mamau, String tenmau) {
		super();
		this.mamau = mamau;
		this.tenmau = tenmau;
	}
	public MauSanPham() {
		super();
	}
	
}
