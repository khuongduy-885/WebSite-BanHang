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

import com.khuongduy.dao.MauSanPhamDao;
import com.khuongduy.entity.MauSanPham;
import com.khuongduy.entity.SanPham;

@Repository
public class MauSanPhamDaoImpl implements MauSanPhamDao {
	@Resource(name = "dataSource")
	private DataSource dataSource;
	public List<MauSanPham> fileall() {
		String sql="select mamau,tenmau from mausanpham";
		List<MauSanPham> listmausanpham= new ArrayList<MauSanPham>();
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					MauSanPham mausanPham= new MauSanPham();
					mausanPham.setMamau(rs.getInt("mamau"));
					mausanPham.setTenmau(rs.getString("tenmau"));
					listmausanpham.add(mausanPham);
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
			return listmausanpham;
		}
	

}
