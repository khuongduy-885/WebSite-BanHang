package com.khuongduy.dao.impl;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.khuongduy.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

@Repository
public class RoleDaoImpl {
	
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	public List<Role> fileall() throws SQLException {
		String sql ="select idrole,namerole from role";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Role> listroles= new ArrayList<Role>() ;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Role role= new Role();
				role.setIdrole(rs.getInt("idrole"));
				role.setNamerole(rs.getString("namerole"));
					listroles.add(role);
				}
				}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
				pstmt.close();
				conn.close();
		}
		return listroles;
		
	}
}
