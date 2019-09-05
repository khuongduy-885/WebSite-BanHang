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
public class DanhMucDaoImpl implements DanhMucDao
{

	@Resource(name = "dataSource")
	private DataSource dataSource;

	public List<DanhMuc> fileall() throws Exception
	{
		String query = "select madanhmuc,tendanhmuc from danhmuc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DanhMuc> danhMucs = new ArrayList<DanhMuc>();
		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while (rs.next())
				{
					DanhMuc danhMuc = new DanhMuc();
					danhMuc.setMadanhmuc(rs.getInt("madanhmuc"));
					danhMuc.setTendanhmuc(rs.getString("tendanhmuc"));
					danhMucs.add(danhMuc);
				}
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(e);
		} finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		}
		return danhMucs;

	}

	public DanhMuc dsdmtheoma(int madanhmuc) throws Exception
	{
		String query = "select madanhmuc,tendanhmuc from danhmuc where madanhmuc= (?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DanhMuc danhMuc = new DanhMuc();
		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, madanhmuc);
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while (rs.next())
				{
					danhMuc.setMadanhmuc(rs.getInt("madanhmuc"));
					danhMuc.setTendanhmuc(rs.getString("tendanhmuc"));
				}
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		}
		return danhMuc;
	}

	public boolean themdanhmuc(DanhMuc danhMuc) throws Exception
	{
		StringBuilder sql = new StringBuilder("INSERT INTO danhmuc (tendanhmuc) VALUES (?)");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check=0;
		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, danhMuc.getTendanhmuc());
			check =pstmt.executeUpdate();
			if (check != 0)
			{
				return true;
			} 
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		}
		return false;
	}

	public boolean capnhatdanhmuc(DanhMuc danhMuc) throws Exception
	{
		String sql = "UPDATE danhmuc SET tendanhmuc = ? WHERE madanhmuc = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check=0;
		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, danhMuc.getTendanhmuc());
			pstmt.setInt(2, danhMuc.getMadanhmuc());
			check = pstmt.executeUpdate();
			if(check  !=0) {
				return true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return false;
	}

	public boolean xoadanhmuc(int madanhmuc) throws Exception
	{
		String sql = "DELETE FROM danhmuc WHERE madanhmuc = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check=0;
		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, madanhmuc);
			check=pstmt.executeUpdate();
			if(check!=0) {
				return true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return false;
	}

}
