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


import com.khuongduy.dao.SanPhamDao;
import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.SanPham;

@Repository
public class SanPhamDaoImpl implements SanPhamDao {
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	public List<SanPham> fileall() {
	String sql="select sp.masanpham,tensanpham,tinhtrang,hinhanh,giatien,cauhinhmay,ngaynhap,sp.madanhmuc,dm.tendanhmuc from sanpham sp INNER JOIN danhmuc dm on sp.madanhmuc= dm.madanhmuc ";	
	List<SanPham> listsanpham= new ArrayList<SanPham>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		conn= dataSource.getConnection();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs !=null) {
			while(rs.next()) {
				SanPham sanPham= new SanPham();
				sanPham.setMasanpham(rs.getInt("masanpham"));
				sanPham.setTensanpham(rs.getString("tensanpham"));
				sanPham.setTinhtrang(rs.getString("tinhtrang"));
				sanPham.setHinhanh(rs.getString("hinhanh"));
				sanPham.setGiatien(rs.getString("giatien"));
				sanPham.setCauhinhmay(rs.getString("cauhinhmay"));
				sanPham.setNgaynhap(rs.getString("ngaynhap"));
				sanPham.setMadanhmuc(rs.getInt("madanhmuc"));
				sanPham.setTendanhmuc(rs.getString("tendanhmuc"));
				listsanpham.add(sanPham);
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
		return listsanpham;
	}

	public List<SanPham> LayDSSanDanhMuc(int madanhmuc) {
		String sql="select masanpham,tensanpham,tinhtrang,hinhanh,giatien,cauhinhmay,ngaynhap,madanhmuc from sanpham where madanhmuc=(?)";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<SanPham> listsanpham= new ArrayList<SanPham>();
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, madanhmuc);
			rs=pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					SanPham sanPham= new SanPham();
					sanPham.setTensanpham(rs.getString("tensanpham"));
					sanPham.setTinhtrang(rs.getString("tinhtrang"));
					sanPham.setHinhanh(rs.getString("hinhanh"));
					sanPham.setGiatien(rs.getString("giatien"));
					sanPham.setCauhinhmay(rs.getString("cauhinhmay"));
					sanPham.setNgaynhap(rs.getString("ngaynhap"));
					sanPham.setMadanhmuc(rs.getInt("madanhmuc"));
					listsanpham.add(sanPham);
				}
			}
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
		return listsanpham;
	}

	public SanPham sanphamtheoma(int masanpham) {
		String sql="select masanpham,tensanpham,tinhtrang,hinhanh,giatien,cauhinhmay,ngaynhap,madanhmuc from sanpham where masanpham=(?)";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SanPham sanPham= new SanPham();
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, masanpham);
			rs=pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					sanPham.setTensanpham(rs.getString("tensanpham"));
					sanPham.setTinhtrang(rs.getString("tinhtrang"));
					sanPham.setHinhanh(rs.getString("hinhanh"));
					sanPham.setGiatien(rs.getString("giatien"));
					sanPham.setCauhinhmay(rs.getString("cauhinhmay"));
					sanPham.setNgaynhap(rs.getString("ngaynhap"));
					sanPham.setMadanhmuc(rs.getInt("madanhmuc"));
				}
			}
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
		return sanPham;
	}

	public boolean themsanpham(SanPham sanPham) {
		String sql="INSERT INTO sanpham (tensanpham,tinhtrang,hinhanh,giatien,cauhinhmay,ngaynhap,madanhmuc) VALUES (?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sanPham.getTensanpham());
			pstmt.setString(2,sanPham.getTinhtrang());
			pstmt.setString(3,sanPham.getHinhanh());
			pstmt.setString(4,sanPham.getGiatien());
			pstmt.setString(5,sanPham.getCauhinhmay());
			pstmt.setString(6,sanPham.getNgaynhap());
			pstmt.setInt(7,sanPham.getMadanhmuc());
			pstmt.executeUpdate();
			if(sanPham.getMasanpham()>0) {
				return true;
			}else {
				return false;
			}
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
	}

	public boolean capnhatsanpham(SanPham sanPham) {
		
		String sql="UPDATE sanpham SET tensanpham = ?,tinhtrang = ?,hinhanh = ?,giatien = ?,cauhinhmay = ?,ngaynhap = ?,madanhmuc = ? WHERE masanpham = ?";
		Connection conn=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sanPham.getTensanpham());
			pstmt.setString(2,sanPham.getTinhtrang());
			pstmt.setString(3,sanPham.getHinhanh());
			pstmt.setString(4,sanPham.getGiatien());
			pstmt.setString(5,sanPham.getCauhinhmay());
			pstmt.setString(6,sanPham.getNgaynhap());
			pstmt.setInt(7,sanPham.getMadanhmuc());
			pstmt.setInt(8,sanPham.getMasanpham());
			
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
	}

	public boolean xoasanpham(int masanpham) {
		
		String sql="DELETE From sanpham WHERE masanpham = ?";
		Connection conn=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,masanpham);
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
	}

	public List<SanPham> laydsSanPhamLimit(int sobatdau) {
		String sql="select masanpham,tensanpham,tinhtrang,hinhanh,giatien,cauhinhmay,ngaynhap,madanhmuc form sanpham LIMIT (?)";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<SanPham> listsanpham= new ArrayList<SanPham>();
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sobatdau);
			rs=pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					SanPham sanPham= new SanPham();
					sanPham.setTensanpham(rs.getString("tensanpham"));
					sanPham.setTinhtrang(rs.getString("tinhtrang"));
					sanPham.setHinhanh(rs.getString("hinhanh"));
					sanPham.setGiatien(rs.getString("giatien"));
					sanPham.setCauhinhmay(rs.getString("cauhinhmay"));
					sanPham.setNgaynhap(rs.getString("ngaynhap"));
					sanPham.setMadanhmuc(rs.getInt("madanhmuc"));
					listsanpham.add(sanPham);
				}
			}
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
		return listsanpham;
	}


}
