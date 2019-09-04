package com.khuongduy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.khuongduy.dao.UsersDao;
import com.khuongduy.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Resource(name = "dataSource")
	private DataSource dataSource; 
	
	public boolean themnhanvien(Users users) throws SQLException{
		String sql="INSERT INTO users (email,matkhau,hoten,diachi,sdt,ngaydangky,phanquyen) VALUES (?,?,?,?,?,sysdate(),?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int inser=0;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,users.getEmail());
			pstmt.setString(2,users.getPass());
			pstmt.setString(3,users.getFullname());
			pstmt.setString(4,users.getDiachi());
			pstmt.setInt(5,users.getSdt());
			pstmt.setString(6,users.getPhanquyen());
			inser=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				pstmt.close();
				conn.close();
		}
		if(inser != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Users kiemtradangnhap(String username, String pass) throws Exception {
		String sql="select username,idrole from users where email=(?) and pass=(?)";	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Users users= new Users();
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					
					users.setEmail(rs.getString("email"));
					users.setPass(rs.getString("pass"));
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if(pstmt !=null) {
				pstmt.close();
			}
			if(conn !=null) {
				conn.close();
			}
			if(rs !=null) {
				rs.close();
			}
		}
		return users;
	}

	/*public List<Users> fileall() {
		String sql="select u.userid,u.username,u.email,u.fullname,u.createdate,u.phonenumber,u.idrole,r.namerole from users u INNER JOIN role r on u.idrole = r.idrole";
		List<Users> listusers= new ArrayList<Users>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					Users users= new Users();
					users.setUserid(rs.getInt("userid"));
					users.setUsername(rs.getString("username"));
					users.setEmail(rs.getString("email"));
					users.setFullname(rs.getString("fullname"));
					users.setCreatedate(rs.getString("createdate"));
					users.setPhonenumber(rs.getInt("phonenumber"));
					users.setIdrole(rs.getInt("idrole"));
					users.setNamerole(rs.getString("namerole"));
					listusers.add(users);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return listusers;
	}*/

	/*public Users nhanvientheoma(int userid) {
		String sql="select u.username,u.email,u.fullname,u.createdate,u.phonenumber,u.idrole,r.namerole from users u INNER JOIN role r on u.idrole = r.idrole where u.userid=(?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Users users= new Users();
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
//					users.setUsername(rs.getString("username"));
					users.setEmail(rs.getString("email"));
					users.setFullname(rs.getString("fullname"));
					users.setCreatedate(rs.getString("createdate"));
					users.setPhonenumber(rs.getInt("phonenumber"));
//					users.setIdrole(rs.getInt("idrole"));
//					users.setNamerole(rs.getString("namerole"));
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	
		return users;
	}*/
	public List<Users> fileall()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Users nhanvientheoma(int userid)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean capnhatnhanvien(Users users)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xoanhanvien(int userid)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/*public boolean capnhatnhanvien(Users users) {
		String sql="UPDATE users SET username=(?),email=(?),fullname=(?),createdate=(?),phonenumber=(?),pass=(?),idrole=(?) where userid=(?) ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1,users.getUsername());
			pstmt.setString(2,users.getEmail());
			pstmt.setString(3,users.getFullname());
			pstmt.setString(4,users.getCreatedate());
			pstmt.setInt(5,users.getPhonenumber());
			pstmt.setString(6,users.getPass());
//			pstmt.setInt(7,users.getIdrole());
//			pstmt.setInt(8,users.getUserid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e2) {
			}
			try {
				conn.close();
			} catch (SQLException e2) {
			}
		}
		return false;
	}*/

	/*public boolean xoanhanvien(int userid) {
		String sql="DELETE From users where userid=(?) ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,userid);
			pstmt.executeUpdate();
			
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			pstmt.close();
		} catch (SQLException e2) {
		}
		try {
			conn.close();
		} catch (SQLException e2) {
		}
	}
	return false;
}*/

}
