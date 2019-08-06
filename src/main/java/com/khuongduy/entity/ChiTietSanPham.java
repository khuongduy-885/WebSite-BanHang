package com.khuongduy.entity;

public class ChiTietSanPham {
	private int machitietsanpham;

	private int soluong;
	private int masanpham;
	private String tensanpham;
	private String mau;

	

	public String getMau() {
		return mau;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public int getMachitietsanpham() {
		return machitietsanpham;
	}

	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public ChiTietSanPham() {
		super();
	}

	public ChiTietSanPham(int machitietsanpham, int soluong, int masanpham, String mau, String tensanpham) {
		super();
		this.machitietsanpham = machitietsanpham;
		this.soluong = soluong;
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.mau = mau;
	}

}
