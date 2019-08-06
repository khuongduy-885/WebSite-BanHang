package com.khuongduy.dto;

import java.io.Serializable;
import java.sql.Timestamp;
public class UserDTO implements Serializable {
	private int userid;
	private String username ;
	private String email;
	private String pass ;
	private String fullname ;
	private String createdate ;
	private int idrole;
	private RoleDTO roleDTO;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	public UserDTO(int userid, String username, String email, String pass, String fullname, String createdate,
			int idrole, RoleDTO roleDTO) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.fullname = fullname;
		this.createdate = createdate;
		this.idrole = idrole;
		this.roleDTO = roleDTO;
	}
	public UserDTO() {
		super();
	}
	
}
