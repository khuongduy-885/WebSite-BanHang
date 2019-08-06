package com.khuongduy.entity;

public class Role {
	private int idrole;
	private String namerole;
	
	public String getNamerole() {
		return namerole;
	}
	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}
	
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	
	public Role(int idrole, String namerole) {
		super();
		this.idrole = idrole;
		this.namerole = namerole;
	}
	public Role() {
		
	}
}
