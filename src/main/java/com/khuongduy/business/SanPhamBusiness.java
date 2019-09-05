package com.khuongduy.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.khuongduy.entity.ObjCheck;
import com.khuongduy.entity.SanPham;
import com.khuongduy.sevice.DanhMucSevice;
import com.khuongduy.sevice.SanPhamSevice;

@Controller
public class SanPhamBusiness
{
	@Autowired
	SanPhamSevice sanPhamSevice;
	
	@Autowired
	DanhMucSevice danhMuccSevice;
	public List<SanPham> fileall() throws Exception
	{
		List<SanPham> listDanhmuc= new ArrayList<SanPham>();
		try
		{
			listDanhmuc=sanPhamSevice.fileall();
					
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return listDanhmuc;

	}
	public SanPham sanphamtheoma(int masanpham) throws Exception{
		SanPham sanPham=  new SanPham(); 
		try
		{
			sanPham=sanPhamSevice.sanphamtheoma(masanpham);
					
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return sanPham;
		
	}
	public ObjCheck xoasanphamtheoma(int masanpham) throws Exception{
		ObjCheck objCheck=  new ObjCheck(); 
		boolean check=false;
		try
		{
			check=sanPhamSevice.xoasanpham(masanpham);;
			if(check) {
				objCheck.setStatus(1);
				objCheck.setSuccess("Xóa thành công !");
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("Xóa không thành công !");
			}
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
	public ObjCheck capnhatsanpham( SanPham sanPham) throws Exception{
		ObjCheck objCheck=  new ObjCheck(); 
		boolean check=false;
		try
		{
			check=sanPhamSevice.capnhatsanpham(sanPham);
			if(check) {
				objCheck.setStatus(1);
				objCheck.setSuccess("Update san pham thành công !");
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("Update san pham không thành công !");
			}
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
	public ObjCheck themsanpham( SanPham sanPham) throws Exception{
		ObjCheck objCheck=  new ObjCheck(); 
		boolean check=false;
		try
		{
			check=sanPhamSevice.themsanpham(sanPham);
			if(check) {
				objCheck.setStatus(1);
				objCheck.setSuccess("them san pham thành công !");
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("them san pham không thành công !");
			}
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}
/*	@GetMapping(path="xoasanphamtheoma",produces="plain/text; charset=UTF-8")
	 @ResponseBody
	 public String xoasanphamtheoma(@RequestParam int masanpham) {
		 
		 return "";
	 }
	 
	 @PostMapping("themsanpham")
	 @ResponseBody
	 public void themsanphamjson(@RequestParam String datajson) {
		 ObjectMapper mapper = new ObjectMapper();
		 JsonNode jsonobject;
		 try {
			 SanPham sanPham= new SanPham();
			jsonobject =mapper.readTree(datajson);
			sanPham.setMadanhmuc(jsonobject.get("danhmucsanpham").asInt());
			sanPham.setTensanpham(jsonobject.get("tensanpham").asText());
			sanPham.setGiatien(jsonobject.get("giatien").asText());
			sanPham.setTinhtrang(jsonobject.get("tinhtrang").asText());
			sanPham.setHinhanh(jsonobject.get("hinhanh").asText());
			sanPham.setCauhinhmay(jsonobject.get("cauhinhmay").asText());
			sanPham.setNgaynhap(jsonobject.get("ngaynhap").asText());
			
			sanPhamSeviceImpl.themsanpham(sanPham);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	 }
	 
	 @PostMapping("laysanphamtheoma")
	 @ResponseBody
	 public SanPham laysanphamtheoma(@RequestParam int masanpham) {
		SanPham sanPham=sanPhamSeviceImpl.sanphamtheoma(masanpham);
		sanPham.getTendanhmuc();
		sanPham.getMadanhmuc();
		sanPham.getTensanpham();
		sanPham.getHinhanh();
		sanPham.getGiatien();
		sanPham.getTinhtrang();
		sanPham.getCauhinhmay();
		sanPham.getNgaynhap();
		 return sanPham;
		 
	 }
	 
	 @PostMapping("capnhatsanpham")
	 @ResponseBody
	 public void capnhatsanphamjson(@RequestParam String datajson) {
		 ObjectMapper mapper = new ObjectMapper();
		 JsonNode jsonobject;
		 try {
			 SanPham sanPham= new SanPham();
			jsonobject =mapper.readTree(datajson);
			sanPham.setMadanhmuc(jsonobject.get("danhmucsanpham").asInt());
			sanPham.setTensanpham(jsonobject.get("tensanpham").asText());
			sanPham.setGiatien(jsonobject.get("giatien").asText());
			sanPham.setTinhtrang(jsonobject.get("tinhtrang").asText());
			sanPham.setHinhanh(jsonobject.get("hinhanh").asText());
			sanPham.setCauhinhmay(jsonobject.get("cauhinhmay").asText());
			sanPham.setNgaynhap(jsonobject.get("ngaynhap").asText());
			sanPham.setMasanpham(jsonobject.get("masanpham").asInt());
			sanPhamSeviceImpl.capnhatsanpham(sanPham);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	 }*/
}
