package com.khuongduy.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
	private	int roleid ;
	private String rolename ;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
