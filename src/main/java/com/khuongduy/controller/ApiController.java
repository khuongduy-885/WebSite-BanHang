package com.khuongduy.controller;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khuongduy.entity.ChiTietSanPham;
import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.SanPham;
import com.khuongduy.entity.Users;
import com.khuongduy.service.impl.ChiTietSanPhamSeviceImpl;
import com.khuongduy.service.impl.DanhMuccSeviceImpl;
import com.khuongduy.service.impl.SanPhamSeviceImpl;
import com.khuongduy.service.impl.UsersSeviceImpl;

@Controller
@RequestMapping("api/")
public class ApiController {
	@Autowired
	UsersSeviceImpl userSeviceImpl;
	
	@Autowired
	SanPhamSeviceImpl sanPhamSeviceImpl;
	
	@Autowired
	DanhMuccSeviceImpl danhMuccSeviceImpl;
	
	@Autowired
	ChiTietSanPhamSeviceImpl chiTietSanPhamSeviceImpl;
//	-----------------------DangNhap-------------
	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public Users KiemTraDangNhap(@RequestParam String username, @RequestParam String pass, ModelMap modelMap) {
		Users kiemtra= userSeviceImpl.kiemtradangnhap(username, pass);
		/*kiemtra.getUsername();
		kiemtra.getIdrole();*/
	return kiemtra;
	}
//	 ---------------------dangky---------------
//	@PostMapping("dangky")
//	@ResponseBody
//	public void signIn(@RequestParam String datajson) {
//		ObjectMapper mapper = new ObjectMapper();
//		 JsonNode jsonobject;
//		 try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//------------------themdanhmuc------------------
	@PostMapping("themdanhmuc")
	 @ResponseBody
	 public void themsanpham(@RequestParam String tendanhmuc ) {
		 DanhMuc danhMuc= new DanhMuc();
		 danhMuc.setTendanhmuc(tendanhmuc);
		 danhMuccSeviceImpl.themdanhmuc(danhMuc);
	 }
	
	@PostMapping("laydanhmuctheoma")
	 @ResponseBody
	 public DanhMuc laydanhmuctheoma(@RequestParam int madanhmuc) {
		 DanhMuc danhMuc= danhMuccSeviceImpl.dsdmtheoma(madanhmuc);
		 return danhMuc;
	 }
	
	@GetMapping(path="xoadanhmuctheoma",produces="plain/text; charset=UTF-8")
	 @ResponseBody
	 public String xoadanhmuctheoma(@RequestParam int madanhmuc) {
		danhMuccSeviceImpl.xoadanhmuc(madanhmuc);
		 return "";
	}
	@PostMapping("updatedanhmuc")
	 @ResponseBody
	 public DanhMuc updatedanhmuc(@RequestParam int madanhmuc,@RequestParam String tendanhmuc ) {
		 DanhMuc danhMuc = new DanhMuc();
		 danhMuc.setMadanhmuc(madanhmuc);
		 danhMuc.setTendanhmuc(tendanhmuc);
		 danhMuccSeviceImpl.capnhatdanhmuc(danhMuc);
		 return danhMuc;
	 }
//	------------------------------------------- upload file
	 @Autowired
	 ServletContext context;
	 
	 @PostMapping("uploadfile")
	 @ResponseBody
	 public String uploadfile(MultipartHttpServletRequest request) {
		 String pathsavefile= context.getRealPath("/resources/Image/sanpham/");
		 Iterator<String> listname= request.getFileNames();
		 MultipartFile mpf= request.getFile(listname.next());
		 
		 File filesave= new File(pathsavefile + mpf.getOriginalFilename());
		 try {
			mpf.transferTo(filesave);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 System.out.println(pathsavefile);
		 return "true";
	 }
	 
//		------------------------------------------------------ pham trang
//		 @GetMapping(path="LaySanPhamLimit",produces="plain/text; charset=UTF-8")
//			@ResponseBody
//			 public String LaySanPhamLimit(@RequestParam int spbatdau) {
//				 String html="";
//				 List<SanPham> listsanpham= sanPhamSeviceImpl.laydsSanPhamLimit();
//				for (SanPham sanpham : listsanpham) {
//					html +="<tr>";
//					html +=	"<td style='width: 20%\'><img style='width: 100%;height: 132px'  src ='../resources/Image/sanpham/"+sanpham.getHinhanh()+"'/></td>";
//					html  +="	<td  class='ten' data-masanpham='"+sanpham.masanpham+"'>"+sanpham.tensanpham+"</td>";
//					html +="	<td class='gia'>"+sanpham.getGiatien()+".000 vnd </td>";
//					html +="	<td class='mota'>"+sanpham.getTinhtrang()+" </td>";
//					html +="	<td class='danhmuc'>"+sanpham.tendanhmuc+" </td>";
//					html +="	<td class='chitiet'><button data-id="+sanpham.getMasanpham()+" type='button' class='btn btn-info btnchitiet'>Chi Tiet</button></td>";
//					html +="<td><div class='checkbox'><label ><input type='checkbox' class='checkboxsanpham' value='"+sanpham.getMasanpham()+"'></label></div></td>";
//					html+="<td ><button data-sua="+sanpham.getMasanpham()+" type='button' class='btn btn-info btnsua-sanpham'>sua</button></td>";
//					html +="</tr>";
//					
//				}
//				 return html;
//			 }
//----------------themsanpham---------------
	 @GetMapping(path="xoasanphamtheoma",produces="plain/text; charset=UTF-8")
	 @ResponseBody
	 public String xoasanphamtheoma(@RequestParam int masanpham) {
		 sanPhamSeviceImpl.xoasanpham(masanpham);
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
		 
	 }
	 //------------------------chitietsanpham------------------
	 @PostMapping("themchitietsanpham")
	 @ResponseBody
	 public void themchitietsanpham(@RequestParam String datajson) {
		 ObjectMapper mapper = new ObjectMapper();
		 JsonNode jsonobject;
		 try {
			jsonobject =mapper.readTree(datajson);
			 JsonNode jsonchitiet= jsonobject.get("chitietsanpham");
			 List<ChiTietSanPham> listChiTiet= new ArrayList<ChiTietSanPham>();
			 for (JsonNode ojectchiTiet : jsonchitiet) {
				 ChiTietSanPham chitietsanpham= new ChiTietSanPham();
				 chitietsanpham.setMasanpham(ojectchiTiet.get("masanpham").asInt());
				 chitietsanpham.setSoluong(ojectchiTiet.get("soluong").asInt());
				 chitietsanpham.setMau(ojectchiTiet.get("mau").asText());
				 chiTietSanPhamSeviceImpl.themchitietsanpham(chitietsanpham);
			 }
			 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	 }

		 @GetMapping("xoachitietsanpham")
		 @ResponseBody
		 public void xoachitietsanpham(@RequestParam int machitietsanpham) {
			 chiTietSanPhamSeviceImpl.xoachitietsanpham(machitietsanpham);
			 
		 }
		 
		 @PostMapping("laychitietsanphamtheomact")
		 @ResponseBody
		 public ChiTietSanPham laychitietsanphamtheoma(@RequestParam int machitietsanpham) {
			 ChiTietSanPham ctsanpham = chiTietSanPhamSeviceImpl.LaychitietSPtheoma(machitietsanpham);
			 ctsanpham.getMasanpham();
			 ctsanpham.getTensanpham();
			 ctsanpham.getMau();
			 ctsanpham.getSoluong();
			 return ctsanpham;
			 
		 }
		 @PostMapping("capnhatchitietsanpham")
		 @ResponseBody
		 public void capnhatchitietsanpham( String datajson) {
			 
			 ObjectMapper mapper = new ObjectMapper();
			 JsonNode jsonobject;
			 try {
				jsonobject =mapper.readTree(datajson);
				
				 JsonNode jsonchitiet= jsonobject.get("chitietsanpham");
				 List<ChiTietSanPham> listChiTiet= new ArrayList<ChiTietSanPham>();
				 for (JsonNode ojectchiTiet : jsonchitiet) {
					 ChiTietSanPham chitietsanpham= new ChiTietSanPham();
					 chitietsanpham.setMachitietsanpham(jsonobject.get("machitietsanpham").asInt());
					 chitietsanpham.setMasanpham(ojectchiTiet.get("masanpham").asInt());
					 chitietsanpham.setSoluong(ojectchiTiet.get("soluong").asInt());
					 chitietsanpham.setMau(ojectchiTiet.get("mau").asText());
					 chiTietSanPhamSeviceImpl.capnhatchitietsanpham(chitietsanpham);
				 }
				 
			} catch (IOException e) {
				e.printStackTrace();
			} 
		 }
//---------------------------------themnhanvien--------------------
		 /*@PostMapping("themnhanvien")
		 @ResponseBody
		 public void themnhanvienjson(@RequestParam String datajson) {
			 ObjectMapper mapper = new ObjectMapper();
			 JsonNode jsonobject;
			 try {
				 
				jsonobject =mapper.readTree(datajson);
				Users users= new Users();
//				users.setUsername(jsonobject.get("username").asText());
				users.setFullname(jsonobject.get("fullname").asText());
				users.setEmail(jsonobject.get("email").asText());
				users.setPass(jsonobject.get("pass").asText());
				users.setCreatedate(jsonobject.get("ngaynhap").asText());
				users.setPhonenumber(jsonobject.get("phonenumber").asInt());
//				users.setIdrole(jsonobject.get("role").asInt());
				
				userSeviceImpl.themnhanvien(users);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		 }*/
		 @GetMapping("xoanhanvien")
		 @ResponseBody
		 public void xoanhanvien(int userid) {
			 userSeviceImpl.xoanhanvien(userid);
		 }
	}
		 
