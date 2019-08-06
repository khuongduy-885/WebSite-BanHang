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

import com.khuongduy.dao.DanhMucDao;
import com.khuongduy.entity.DanhMuc;


@Repository
public class DanhMucDaoImpl implements DanhMucDao {
  
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	public List<DanhMuc> fileall() {
		String query ="select madanhmuc,tendanhmuc from danhmuc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DanhMuc> danhMucs= new ArrayList<DanhMuc>();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					DanhMuc danhMuc= new DanhMuc();
					danhMuc.setMadanhmuc(rs.getInt("madanhmuc"));
					danhMuc.setTendanhmuc(rs.getString("tendanhmuc"));
					danhMucs.add(danhMuc);
				}
				}
			
		}  catch (Exception e) {
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
		return danhMucs;
		
	}

	public DanhMuc dsdmtheoma(int madanhmuc) {
		String query ="select madanhmuc,tendanhmuc from danhmuc where madanhmuc= (?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DanhMuc danhMuc= new DanhMuc();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,madanhmuc);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					danhMuc.setMadanhmuc(rs.getInt("madanhmuc"));
					danhMuc.setTendanhmuc(rs.getString("tendanhmuc"));
				}
				}
			
		}  catch (Exception e) {
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
		return danhMuc;
	}

	public boolean themdanhmuc(DanhMuc danhMuc) {
		StringBuilder sql =new StringBuilder( "INSERT INTO danhmuc (tendanhmuc) VALUES (?)");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,danhMuc.getTendanhmuc());
			pstmt.executeUpdate();
			
			if(danhMuc.getMadanhmuc() >0) {
				return true;
			}else {
				return false;
			}
			}  catch (Exception e) {
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
			return false;
	}

	public boolean capnhatdanhmuc(DanhMuc danhMuc) {
		String sql = "UPDATE danhmuc SET tendanhmuc = ? WHERE madanhmuc = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,danhMuc.getTendanhmuc());
			pstmt.setInt(2, danhMuc.getMadanhmuc());
			pstmt.executeUpdate();
			}  catch (Exception e) {
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
		return true;
	}

	public boolean xoadanhmuc(int madanhmuc) {
		String sql = "DELETE FROM danhmuc WHERE madanhmuc = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		DanhMuc danhMuc= new DanhMuc();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, madanhmuc);
			pstmt.executeUpdate();
			}  catch (Exception e) {
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
		return true;
	}

}
