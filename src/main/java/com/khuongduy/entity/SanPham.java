package com.khuongduy.entity;

public class SanPham {
	private int masanpham;
	private String tensanpham;
	private String tinhtrang;
	private String hinhanh;
	private String giatien;
	private String cauhinhmay ;
	private String ngaynhap;
	private int madanhmuc;
	private String tendanhmuc;
	
	public SanPham(int masanpham, String tensanpham, String tinhtrang, String hinhanh, String giatien,
			String cauhinhmay, String ngaynhap, int madanhmuc, String tendanhmuc) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.tinhtrang = tinhtrang;
		this.hinhanh = hinhanh;
		this.giatien = giatien;
		this.cauhinhmay = cauhinhmay;
		this.ngaynhap = ngaynhap;
		this.madanhmuc = madanhmuc;
		this.tendanhmuc = tendanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	public String getCauhinhmay() {
		return cauhinhmay;
	}
	public void setCauhinhmay(String cauhinhmay) {
		this.cauhinhmay = cauhinhmay;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	
	public SanPham() {
		super();
	}
	
	
}
