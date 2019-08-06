package com.khuongduy.entity;

public class DanhMuc {
	private int madanhmuc;
	private String tendanhmuc;
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public DanhMuc(int madanhmuc, String tendanhmuc) {
		super();
		this.madanhmuc = madanhmuc;
		this.tendanhmuc = tendanhmuc;
	}
	public DanhMuc() {
		super();
	}
	
}
