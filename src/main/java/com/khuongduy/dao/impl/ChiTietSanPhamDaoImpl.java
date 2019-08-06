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

import com.khuongduy.dao.ChiTietSanPhamDao;
import com.khuongduy.entity.ChiTietSanPham;
import com.khuongduy.entity.SanPham;

@Repository
public class ChiTietSanPhamDaoImpl implements ChiTietSanPhamDao {
	
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	public List<ChiTietSanPham> fileall() {
		String sql="select ctsp.machitietsanpham,ctsp.masanpham,ctsp.soluong,ctsp.mau,sp.tensanpham from chitietsanpham ctsp, sanpham sp where sp.masanpham= ctsp.masanpham ";	
		List<ChiTietSanPham> listctsanpham= new ArrayList<ChiTietSanPham>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					ChiTietSanPham ctsanPham= new ChiTietSanPham();
					ctsanPham.setMachitietsanpham(rs.getInt("machitietsanpham"));
					ctsanPham.setMasanpham(rs.getInt("masanpham"));
					ctsanPham.setTensanpham(rs.getString("tensanpham"));
					ctsanPham.setSoluong(rs.getInt("soluong"));
					ctsanPham.setMau(rs.getString("mau"));
					listctsanpham.add(ctsanPham);
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
			return listctsanpham;
		}

	public List<ChiTietSanPham> LayDSchitietSP(int masanpham) {
		
		String sql="select ctsp.masanpham,ctsp.soluong,sp.tensanpham,ctsp.mau from chitietsanpham ctsp, sanpham sp where sp.masanpham= ctsp.masanpham and ctsp.masanpham=(?)";	
		List<ChiTietSanPham> listctsanpham= new ArrayList<ChiTietSanPham>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, masanpham);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					ChiTietSanPham ctsanPham= new ChiTietSanPham();
					ctsanPham.setMasanpham(rs.getInt("masanpham"));
					ctsanPham.setTensanpham(rs.getString("tensanpham"));
					ctsanPham.setMau(rs.getString("mau"));
					ctsanPham.setSoluong(rs.getInt("soluong"));
					listctsanpham.add(ctsanPham);
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
			return listctsanpham;
		}


	public boolean themchitietsanpham(ChiTietSanPham chitietsanpham) {
		
		String sql="INSERT INTO chitietsanpham (masanpham,soluong ,mau) VALUES (?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,chitietsanpham.getMasanpham());
			pstmt.setInt(2,chitietsanpham.getSoluong());
			pstmt.setString(3,chitietsanpham.getMau());
			
			pstmt.executeUpdate();
			if(chitietsanpham.getMachitietsanpham()>0) {
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
	public boolean capnhatchitietsanpham(ChiTietSanPham chitietsanpham) {
		String sql="UPDATE chitietsanpham SET masanpham =(?),soluong=(?) ,mau=(?) WHERE machitietsanpham = (?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,chitietsanpham.getMasanpham());
			pstmt.setInt(2,chitietsanpham.getSoluong());
			pstmt.setString(3,chitietsanpham.getMau());
			pstmt.setInt(4, chitietsanpham.getMachitietsanpham());
			
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

	public boolean xoachitietsanpham(int machitietsanpham) {
		String sql="DELETE From chitietsanpham WHERE machitietsanpham = ?";
		Connection conn=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,machitietsanpham);
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

	public ChiTietSanPham LaychitietSPtheoma(int machitietsanpham) {
		String sql="select ctsp.masanpham,ctsp.soluong,sp.tensanpham,ctsp.mau from chitietsanpham ctsp, sanpham sp where sp.masanpham= ctsp.masanpham and ctsp.machitietsanpham=(?)";	
		ChiTietSanPham ctsanpham= new ChiTietSanPham();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, machitietsanpham);
			rs=pstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					ctsanpham.setMasanpham(rs.getInt("masanpham"));
					ctsanpham.setTensanpham(rs.getString("tensanpham"));
					ctsanpham.setMau(rs.getString("mau"));
					ctsanpham.setSoluong(rs.getInt("soluong"));
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
			return ctsanpham;
		}

}
